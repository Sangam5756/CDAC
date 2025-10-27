
### **1. What is ServletContext?**

**Definition:**
`ServletContext` is an **interface** in the `jakarta.servlet` package.
It represents the **web application as a whole** and acts as a communication channel between the **Web Container (WC)** and the application.

* **Specification:** Defined in `servlet-api.jar` (Jakarta EE)
* **Implementation:** Provided by server (e.g., Apache Tomcat in `catalina.jar`)
* **Created by:** Web Container (only **one instance** per web app)
* **Lifecycle:** Created when web app is deployed, destroyed when undeployed or server stops.

---

### **2. Use Cases of ServletContext**

#### (a) Global (Context) Parameters

Used to define **read-only configuration data** shared across the entire web application.

**Defined in `web.xml`:**

```xml
<context-param>
  <param-name>dbURL</param-name>
  <param-value>jdbc:mysql://localhost:3306/healthcare</param-value>
</context-param>
```

**Access in servlet:**

```java
ServletContext ctx = getServletContext();
String dbUrl = ctx.getInitParameter("dbURL");
```

* Read-only → Immutable → Thread-safe.

---

#### (b) Context-Scoped Attributes (Shared Objects)

Used to share **server-side objects** between multiple servlets or JSPs.

**APIs:**

```java
ctx.setAttribute("userCount", 100);
Object val = ctx.getAttribute("userCount");
```

* Mutable → **Not thread-safe.**
* Access must be synchronized on the context object itself:

```java
synchronized(getServletContext()) {
   Integer count = (Integer) ctx.getAttribute("userCount");
   ctx.setAttribute("userCount", count + 1);
}
```

**Avoid synchronizing entire `doGet/doPost`** — it will hurt concurrency.

---

#### (c) Server-Side Logging

```java
ctx.log("User login successful.");
```

Writes to the server log file (useful for debugging).

---

#### (d) Request Dispatching (Server Pull)

Allows navigation **within the same request** (useful in MVC pattern).

**API:**

```java
RequestDispatcher rd = request.getRequestDispatcher("nextPage");
```

**Two methods:**

1. **Forward**

   ```java
   rd.forward(request, response);
   ```

   * Clears response buffer.
   * Only the **last resource** can write output.
   * Control doesn’t return to the first servlet.

2. **Include**

   ```java
   rd.include(request, response);
   ```

   * Keeps existing buffer.
   * Control returns to the original servlet.
   * Included servlet/JSP can’t modify headers or status code.

**Typical MVC usage:**
Controller Servlet (handles logic) → forwards → JSP (renders output).

---

### **3. Client Pull vs Server Pull**

| Type        | Mechanism                    | Example                             | Attribute Scope Needed |
| ----------- | ---------------------------- | ----------------------------------- | ---------------------- |
| Client Pull | Browser sends new request    | `response.sendRedirect("page.jsp")` | **Session**            |
| Server Pull | Server forwards same request | `RequestDispatcher.forward()`       | **Request**            |

---

### **4. Web Application Event Handling (Listeners)**

Events occur when:

* Requests/sessions/context are created or destroyed.
* Attributes are added/removed/changed.

**Common Listeners:**

* `ServletRequestListener`
* `HttpSessionListener`
* `ServletContextListener`
* `ServletContextAttributeListener`

**Example:**

```java
@WebListener
public class MyAppListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent e) {
        System.out.println("App started.");
    }

    public void contextDestroyed(ServletContextEvent e) {
        System.out.println("App stopped.");
    }
}
```

**Alternative declaration:**

```xml
<listener>
  <listener-class>com.healthcare.listeners.MyAppListener</listener-class>
</listener>
```

---

### **5. Thread Handling in Web Container**

The web container handles multiple requests using a **thread pool**, not by creating a new thread per request.

**Internally uses:**
`java.util.concurrent.ExecutorService`

**Example of concept:**

```java
ExecutorService pool = Executors.newFixedThreadPool(10);
pool.execute(() -> handleRequest());
```

This improves performance by **reusing threads** and reducing overhead.

---

### **6. JSP API Hierarchy**

1. `jakarta.servlet.Servlet` – root interface.
2. `jakarta.servlet.jsp.JspPage`

   * `jspInit()`
   * `jspDestroy()`
3. `jakarta.servlet.jsp.HttpJspPage`

   * `_jspService(HttpServletRequest rq, HttpServletResponse rs)`
     (Generated automatically — **should never be overridden**.)

**Note:**
JSP → translated into `.java` file → compiled into `.class` → executed as a servlet by the container.

---

### **Quick Interview Recap**

**Q. What is ServletContext?**
It’s an object that provides information about the web application environment and enables communication between servlets and the web container.

**Q. Difference between ServletConfig and ServletContext?**

| Feature       | ServletConfig               | ServletContext                        |
| ------------- | --------------------------- | ------------------------------------- |
| Scope         | Specific to a servlet       | Shared by all servlets in the web app |
| Created by    | Web Container (per servlet) | Web Container (once per app)          |
| Parameters    | `init-param` in `web.xml`   | `context-param` in `web.xml`          |
| Thread Safety | Immutable                   | Mutable (requires synchronization)    |

**Q. Is ServletContext thread-safe?**
No, because attributes stored in it can be modified by multiple threads concurrently.

**Q. Can a servlet access ServletContext?**
Yes, by calling `getServletContext()`.

