## 🌍 1. What is ServletContext (In Human Language)

Think of a **web application** like a *big apartment building*.
Inside it, every **servlet** is like a *flat* — separate, but all part of the same building.

Now, who manages the entire building?
That’s the **Web Container** (like Tomcat).
It creates one central manager object for the building, called **ServletContext**.

So:

* Each servlet has its own small config (that’s `ServletConfig`).
* But all servlets share **one common big object** (that’s `ServletContext`).

**Key idea:**
It represents the *whole web app* and lets all servlets talk to each other or share data.

**Example:**

Imagine three servlets:

1. `LoginServlet`
2. `ProfileServlet`
3. `LogoutServlet`

All these belong to one web app (say `healthcare`).
So, there’s **one ServletContext** shared among all three.

---

## ⚙️ 2. Where It Comes From

* Defined in **Jakarta EE’s** `servlet-api.jar`
* Implemented by your **Web Container** (like Tomcat in `catalina.jar`)
* Created **once** when your app starts (deploys)
* Destroyed when the app stops or server shuts down

**Lifecycle:**

1. Web app starts → WC creates one `ServletContext`.
2. Servlets can use it anytime.
3. Web app undeployed → WC destroys it.

---

## 💡 3. Use Cases of ServletContext

Let’s go one by one.

---

### (a) Global (Context) Parameters

Suppose every servlet in your app needs to connect to the same database.
Instead of hardcoding the database URL in each servlet, you define it *once* in `web.xml`.

**Example:**

```xml
<context-param>
  <param-name>dbURL</param-name>
  <param-value>jdbc:mysql://localhost:3306/healthcare</param-value>
</context-param>
```

Now any servlet can read it:

```java
ServletContext ctx = getServletContext();
String url = ctx.getInitParameter("dbURL");
System.out.println("Database URL: " + url);
```

**Output:**

```
Database URL: jdbc:mysql://localhost:3306/healthcare
```

✅ This is **read-only**, so it’s **thread-safe** (no race conditions).

**Use it for:** database URLs, email host, admin emails, etc.

---

### (b) Context-Scoped Attributes (Shared Objects)

Now imagine you want to keep a **counter** of how many users have visited your site.
That value must be shared by all servlets — perfect use case for a **context attribute**.

**Example:**

```java
ServletContext ctx = getServletContext();

synchronized(ctx) {
    Integer count = (Integer) ctx.getAttribute("visitCount");
    if (count == null) count = 0;
    ctx.setAttribute("visitCount", count + 1);
}
System.out.println("Total Visits: " + ctx.getAttribute("visitCount"));
```

👉 This `visitCount` is shared by every servlet in your app.
But you must use `synchronized` because **multiple requests** might increase it at the same time — otherwise you’ll lose counts!

**Why not synchronize the whole doPost()?**
Because it would block all other users.
Always synchronize *only the small part* that modifies shared data.

---

### (c) Server-Side Logging

`ServletContext` lets you log messages directly to the server log file.

```java
ctx.log("User login successful.");
```

These logs show up in Tomcat’s `catalina.out` or console — perfect for debugging.

**Example output in Tomcat log:**

```
INFO: User login successful.
```

This helps when you’re debugging or monitoring production behavior.

---

### (d) Request Dispatching (Server Pull)

This is one of the most important parts.

Suppose your app has two pages:

* Servlet A (does the logic)
* JSP B (displays the result)

You don’t want both to handle separate requests — instead, Servlet A does the work and *forwards* the same request to JSP B.
That’s called **Server Pull**, handled using **RequestDispatcher**.

**Example:**

```java
RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
rd.forward(request, response);
```

Now the **same request** goes to the JSP, carrying all request attributes.

If you just want to *include* another resource (like a small footer), you use `include()`:

```java
RequestDispatcher rd = request.getRequestDispatcher("footer.jsp");
rd.include(request, response);
```

**Difference:**

| Method      | Behavior                                          |
| ----------- | ------------------------------------------------- |
| `forward()` | Replaces the response completely (buffer cleared) |
| `include()` | Adds more content (buffer not cleared)            |

**MVC Example Flow:**

```
Client → LoginServlet (validates user)
       → forwards → home.jsp (displays user profile)
```

---

## 🔁 4. Client Pull vs Server Pull

Let’s compare both navigation types.

| Type            | Who initiates new request? | Example                                        | Scope needed |
| --------------- | -------------------------- | ---------------------------------------------- | ------------ |
| **Client Pull** | Browser                    | `response.sendRedirect("home.jsp")`            | Session      |
| **Server Pull** | Server                     | `RequestDispatcher.forward(request, response)` | Request      |

👉 In **Client Pull**, the browser makes a *new request* (URL changes).
In **Server Pull**, it’s *same request*, just passed internally.

---

## 🎧 5. Web Application Event Handling (Listeners)

Your web app has many “events” happening automatically:

* Requests created/destroyed
* Sessions created/destroyed
* Context created/destroyed
* Attributes added/removed

To listen for these, Java EE gives special listener interfaces.

### Example: `ServletContextListener`

```java
@WebListener
public class MyAppListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent e) {
        System.out.println("App started: loading configuration...");
    }

    public void contextDestroyed(ServletContextEvent e) {
        System.out.println("App shutting down...");
    }
}
```

When you start Tomcat, it prints:

```
App started: loading configuration...
```

When you stop it:

```
App shutting down...
```

Alternative XML config:

```xml
<listener>
  <listener-class>com.healthcare.listeners.MyAppListener</listener-class>
</listener>
```

**Common Listeners:**

* `ServletRequestListener` → reacts to request creation/destruction
* `HttpSessionListener` → reacts to session lifecycle
* `ServletContextListener` → reacts to app start/stop
* `ServletContextAttributeListener` → reacts to attributes added/removed

---

## ⚙️ 6. Thread Handling in Web Container

Tomcat doesn’t create a **new thread** for every request (that would be wasteful).
Instead, it uses a **thread pool**.

This means a fixed number of threads (say 50) handle all requests, reused again and again.

Internally, Tomcat uses Java’s **Executor Framework**:

```java
ExecutorService pool = Executors.newFixedThreadPool(10);
pool.execute(() -> handleRequest());
```

Each new client request → one thread from pool → processes → returns to pool.

**Benefits:**

* Fast response time
* No overhead of creating/destroying threads per request
* Efficient memory use

---

## 🧱 7. JSP API Hierarchy

When you write a JSP, Tomcat secretly **turns it into a Servlet**.

Here’s the class chain:

1. `jakarta.servlet.Servlet` – base interface (for all servlets)
2. `jakarta.servlet.jsp.JspPage` – adds JSP lifecycle methods:

   ```java
   jspInit();
   jspDestroy();
   ```
3. `jakarta.servlet.jsp.HttpJspPage` – adds:

   ```java
   _jspService(HttpServletRequest rq, HttpServletResponse rs)
   ```

   This is the method your JSP body becomes!
   (You must never override it manually.)

So, every JSP is just a servlet in disguise.

**Flow:**

```
JSP file → translated to .java → compiled to .class → executed as servlet
```

---

## 🔑 8. ServletConfig vs ServletContext — Quick Comparison

| Feature       | ServletConfig             | ServletContext         |
| ------------- | ------------------------- | ---------------------- |
| Scope         | One servlet               | Entire web app         |
| Created       | Per servlet               | Once per web app       |
| Defined in    | `<init-param>`            | `<context-param>`      |
| Thread safety | Read-only                 | Mutable (needs sync)   |
| Used for      | Servlet-specific settings | Shared/global settings |

**Example:**

`web.xml`:

```xml
<servlet>
  <servlet-name>LoginServlet</servlet-name>
  <servlet-class>com.healthcare.LoginServlet</servlet-class>
  <init-param>
    <param-name>maxLoginAttempts</param-name>
    <param-value>3</param-value>
  </init-param>
</servlet>
```

`LoginServlet` reads its own setting:

```java
String maxAttempts = getServletConfig().getInitParameter("maxLoginAttempts");
```

But if you want to share info across *all* servlets, use `ServletContext`.

---

## 💬 9. Common Interview Q&A (Quick Recall)

**Q. What is ServletContext?**
It’s an object representing the entire web application, allowing servlets to share data and interact with the container.

**Q. Is it thread-safe?**
No — attributes can be modified by multiple threads, so you must synchronize.

**Q. When is it created?**
When the web application starts.

**Q. Can we change context parameters at runtime?**
No. Context parameters (`context-param`) are read-only.

**Q. How many ServletContext objects exist per web app?**
Only **one** per web app.


## 🔁 **RequestDispatcher (Server Pull)**

Think of **RequestDispatcher** as a *messenger inside the server*.
When one servlet wants to *pass the request to another servlet or JSP* **without** the client knowing — that’s where RequestDispatcher comes in.

---

### 🧩 **Two Types of Navigation**

Let’s first draw the mental map:

| Type            | Description                                       | Example                             | Request Object | Client Awareness |
| --------------- | ------------------------------------------------- | ----------------------------------- | -------------- | ---------------- |
| **Client Pull** | Browser sends a **new** request                   | `response.sendRedirect("home.jsp")` | New request    | Yes              |
| **Server Pull** | Server forwards/ includes **within same request** | `RequestDispatcher.forward()`       | Same request   | No               |

---

### ⚙️ **How to Get RequestDispatcher**

There are two ways:

#### 1. From `HttpServletRequest`

```java
RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
```

This is used when forwarding **within the same web app**.

#### 2. From `ServletContext`

```java
ServletContext ctx = getServletContext();
RequestDispatcher rd = ctx.getRequestDispatcher("/WEB-INF/views/home.jsp");
```

This is used when you have a **path starting from your web app root**.

---

### 🧱 **1. Forward Example (Server Pull)**

When you “forward”, control passes to another resource — servlet, JSP, or HTML — and the current servlet **stops producing output**.

```java
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if ("admin@gmail.com".equals(email) && "123".equals(password)) {
            req.setAttribute("user", email);
            RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
            rd.forward(req, res);
        } else {
            req.setAttribute("error", "Invalid credentials!");
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, res);
        }
    }
}
```

---

### 🧩 **What Happens Internally**

1. The `login.jsp` form sends a POST request to `/login`.
2. `LoginServlet` receives it.
3. It checks credentials.
4. It **forwards** to either `dashboard.jsp` or `login.jsp`.
5. The **client never sees** these transitions — the browser URL stays `/login`.
6. The `request` and `response` objects are reused — so any attributes you set stay available.

---

### 🧱 **2. Include Example**

Use this when you want to combine outputs, like adding headers, footers, or menus.

```java
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        RequestDispatcher header = req.getRequestDispatcher("header.jsp");
        header.include(req, res);

        out.println("<h2>Welcome to your profile</h2>");

        RequestDispatcher footer = req.getRequestDispatcher("footer.jsp");
        footer.include(req, res);
    }
}
```

**Output:**
Header + Profile content + Footer → all merged into one HTML response.

**Control returns** to the servlet after `include()`, unlike `forward()`.

---

### ⚠️ **Important Differences**

| Feature             | `forward()`            | `include()`                 |
| ------------------- | ---------------------- | --------------------------- |
| Output Buffer       | Cleared before forward | Merged into same buffer     |
| Control             | Doesn’t return         | Returns to original servlet |
| Can modify headers? | Yes (before forward)   | No                          |
| Typical Use         | Navigation / MVC       | Layout composition          |

---

## 🎛 **ServletContextAttributeListener**

You can track changes in attributes stored in `ServletContext`.

Example:

```java
@WebListener
public class AppAttributeListener implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent e) {
        System.out.println("Added: " + e.getName() + " = " + e.getValue());
    }
    public void attributeRemoved(ServletContextAttributeEvent e) {
        System.out.println("Removed: " + e.getName());
    }
    public void attributeReplaced(ServletContextAttributeEvent e) {
        System.out.println("Replaced: " + e.getName());
    }
}
```

Now when any servlet does:

```java
ServletContext ctx = getServletContext();
ctx.setAttribute("userCount", 10);
```

or modifies that attribute, this listener will log it.

This is great for debugging or monitoring context-level data.

---

## 🧵 **Thread Handling in Servlet Container**

Here’s where interviews love to test your understanding.

Every request is **handled by a separate thread**, not by creating new servlet objects.

The web container:

* Creates **one instance** of each servlet.
* Reuses it for all requests.
* Handles requests using threads from a **thread pool**.

Example analogy:

* Think of Tomcat having a group of workers (threads).
* Each request is assigned to one worker.
* After finishing, the worker goes back to the pool.

So, if your servlet modifies a shared variable (like context attributes), multiple threads can access it **at the same time**, which leads to race conditions.

---

### 🧩 **Example to Show Thread Behavior**

```java
@WebServlet("/thread")
public class ThreadServlet extends HttpServlet {
    int counter = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        counter++;
        res.getWriter().println("Counter: " + counter);
    }
}
```

If 10 users hit `/thread` at the same time, you might get:

```
Counter: 1
Counter: 3
Counter: 2
Counter: 5
```

…because multiple threads are incrementing the same variable concurrently.

**Fix:** Avoid using instance variables in servlets, or synchronize them carefully.

---

## 🧾 **Recap for Interview**

1. **ServletContext** → one per web app, shared data, global configuration.
2. **Context Parameters** → defined in `web.xml`, immutable.
3. **Context Attributes** → runtime data, mutable, must be synchronized.
4. **RequestDispatcher** → forward/include resources internally.
5. **Listeners** → react to lifecycle or attribute changes.
6. **Thread Handling** → one servlet instance, multiple threads, thread pool mechanism.

