
## 🧩 The Scene: Who’s Who in the Servlet World

When a servlet runs inside a web container (Tomcat, Jetty, etc.), it doesn’t live alone. It lives inside a **bigger web application**, and the container acts as the environment manager.

Two main “helper” objects give the servlet information about its environment:

1. **`ServletConfig`** – information specific to *one servlet*.
2. **`ServletContext`** – information shared by *all servlets* in the app.

---

## ⚙️ 1. ServletConfig — “Per-Servlet Configuration”

Think of `ServletConfig` as a **personal note** given to each servlet by the container.

When the servlet is first created (`init()` is called), the container passes a `ServletConfig` object to it.
This object contains initialization parameters defined in `web.xml` *only for that servlet*.

**Example:**

```xml
<servlet>
    <servlet-name>LoginServlet</servlet-name>
    <servlet-class>com.healthcare.PatientLoginServlet</servlet-class>
    <init-param>
        <param-name>maxAttempts</param-name>
        <param-value>3</param-value>
    </init-param>
</servlet>
```

**Inside the servlet:**

```java
public class PatientLoginServlet extends HttpServlet {
    private int maxAttempts;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String val = config.getInitParameter("maxAttempts");
        maxAttempts = Integer.parseInt(val);
        System.out.println("Max login attempts: " + maxAttempts);
    }
}
```

So here:

* Each servlet gets its own `ServletConfig` object.
* Used for parameters that apply only to that servlet (like limits, file paths, etc.).

---

## 🌍 2. ServletContext — “Application-Wide Context”

Now imagine a **shared bulletin board** that every servlet in your app can read and write to.
That’s `ServletContext`.

It represents the **entire web application environment** and provides:

* Common configuration values for all servlets.
* Access to web app–level resources.
* A way to share data among servlets.

**Example:**

```xml
<context-param>
   <param-name>dbURL</param-name>
   <param-value>jdbc:mysql://localhost:3306/healthcare</param-value>
</context-param>
```

**In any servlet:**

```java
public void init() {
    ServletContext ctx = getServletContext();
    String dbUrl = ctx.getInitParameter("dbURL");
    System.out.println("DB URL: " + dbUrl);
}
```

Here, all servlets can access the same database URL using the shared `ServletContext`.

---

## 🧠 3. How They Fit into the Lifecycle

When Tomcat starts:

1. It loads your web app.
2. Creates **one ServletContext** for the entire application.
3. For each servlet defined:

   * Loads the class.
   * Creates a **ServletConfig** object for it.
   * Calls `init(ServletConfig config)` on that servlet.

So, in simple order:

| Step                | Object                     | Scope                     |
| ------------------- | -------------------------- | ------------------------- |
| App starts          | **ServletContext** created | Shared among all servlets |
| Servlet loads       | **ServletConfig** created  | One per servlet           |
| Servlet initialized | `init(config)` called      | Uses both if needed       |

---

## 🔍 4. Practical Difference Summary

| Feature               | ServletConfig                         | ServletContext            |
| --------------------- | ------------------------------------- | ------------------------- |
| Scope                 | Per servlet                           | Entire web app            |
| Created by            | Container when servlet is initialized | Container when app starts |
| Purpose               | Servlet-specific config               | Shared app-level config   |
| Access                | `getServletConfig()`                  | `getServletContext()`     |
| Parameters defined in | `<init-param>`                        | `<context-param>`         |
| Example use           | File path for upload servlet          | Common DB connection URL  |

---

## 💡 Example to Tie It All Together

Imagine a hospital management system web app:

* `PatientLoginServlet` → uses `ServletConfig` for `maxAttempts`.
* `AppointmentServlet` → uses same `ServletContext` to get `dbURL`.

**web.xml**

```xml
<context-param>
   <param-name>dbURL</param-name>
   <param-value>jdbc:mysql://localhost:3306/healthcare</param-value>
</context-param>

<servlet>
   <servlet-name>LoginServlet</servlet-name>
   <servlet-class>com.healthcare.PatientLoginServlet</servlet-class>
   <init-param>
      <param-name>maxAttempts</param-name>
      <param-value>3</param-value>
   </init-param>
</servlet>
```

**Inside Servlet:**

```java
public void init(ServletConfig config) throws ServletException {
    super.init(config);

    // Servlet-specific
    int maxAttempts = Integer.parseInt(config.getInitParameter("maxAttempts"));

    // App-wide
    ServletContext ctx = config.getServletContext();
    String dbURL = ctx.getInitParameter("dbURL");
}
```

---

## 🧾 Quick Recap for Revision

* **ServletConfig** = per servlet, defined in `<init-param>`.
* **ServletContext** = shared, defined in `<context-param>`.
* **Lifecycle**: Context created first → Config created per servlet → `init()` runs.
* Both are used to pass configuration info without hardcoding values in Java.

---
