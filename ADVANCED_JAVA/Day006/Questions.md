## 🚀 **ServletContext — Interview Questions & Answers**

---

### **1. What is `ServletContext`?**

**Answer:**
`ServletContext` is an interface in the `jakarta.servlet` package that represents the entire web application.
It allows servlets to communicate with the web container and share information with each other.
It’s created **once per web application** when the app is deployed and destroyed when the app is undeployed or server stops.

---

### **2. What is the difference between `ServletConfig` and `ServletContext`?**

| Feature       | ServletConfig                    | ServletContext                                 |
| ------------- | -------------------------------- | ---------------------------------------------- |
| Scope         | Specific to one servlet          | Shared across entire web app                   |
| Defined in    | `<init-param>`                   | `<context-param>`                              |
| Lifetime      | Created & destroyed with servlet | Created & destroyed with web app               |
| Access        | `getServletConfig()`             | `getServletContext()`                          |
| Thread Safety | Immutable                        | Mutable (needs synchronization for attributes) |

---

### **3. How is `ServletContext` created?**

**Answer:**
The **web container** (like Tomcat) creates the `ServletContext` instance automatically when the web application is **deployed** or **started**.
It’s a single object shared by all servlets and JSPs of that web app.

---

### **4. How do you define and access context parameters?**

**Answer:**
In `web.xml`:

```xml
<context-param>
  <param-name>dbUrl</param-name>
  <param-value>jdbc:mysql://localhost:3306/healthcare</param-value>
</context-param>
```

In servlet:

```java
ServletContext ctx = getServletContext();
String url = ctx.getInitParameter("dbUrl");
```

These are **read-only configuration parameters** — useful for database URLs, email servers, etc.

---

### **5. What is the scope of a context parameter?**

**Answer:**
It is **application-wide (global)**.
All servlets and JSPs in the same web app can access the same context parameters.

---

### **6. What are context attributes?**

**Answer:**
They are **server-side objects** stored in the `ServletContext` for sharing data between multiple servlets.

Example:

```java
ctx.setAttribute("hitCount", 5);
Integer count = (Integer) ctx.getAttribute("hitCount");
```

They are **mutable**, **shared**, and hence **not thread-safe**.

---

### **7. Why are context attributes not thread-safe?**

**Answer:**
Because multiple threads (handling multiple requests) can read/write the same context attribute simultaneously, leading to race conditions.
Hence, you must synchronize on the context object:

```java
synchronized(getServletContext()) {
   // safely modify attribute
}
```

---

### **8. What is the difference between context parameters and context attributes?**

| Feature       | Context Parameter             | Context Attribute           |
| ------------- | ----------------------------- | --------------------------- |
| Defined in    | `web.xml` (`<context-param>`) | Created programmatically    |
| Type          | `String`                      | `Object`                    |
| Scope         | Read-only                     | Read/Write                  |
| Thread Safety | Thread-safe                   | Not thread-safe             |
| Use           | App configuration             | Data sharing among servlets |

---

### **9. What are common use cases of `ServletContext`?**

**Answer:**

1. Define global parameters (`context-param`)
2. Share objects between servlets (context attributes)
3. Log messages on server (`ctx.log("message")`)
4. Request dispatching (forward/include to other resources)

---

### **10. What is `RequestDispatcher`?**

**Answer:**
`RequestDispatcher` is used for **server-side navigation** (called **Server Pull**).
It allows forwarding a request from one resource to another (Servlet, JSP, or HTML) within the same request.

**Get it using:**

```java
RequestDispatcher rd = request.getRequestDispatcher("nextServlet");
```

---

### **11. What is the difference between `forward()` and `include()`?**

| Method                       | Behavior                                                                                                                    |
| ---------------------------- | --------------------------------------------------------------------------------------------------------------------------- |
| `forward(request, response)` | Transfers control completely to another resource. Response buffer cleared. Only last resource generates output.             |
| `include(request, response)` | Includes the output of another resource into the current response. Buffer not cleared. Control returns to original servlet. |

---

### **12. What is the difference between Server Pull and Client Pull?**

| Type        | Mechanism                     | Attribute Scope | Example              |
| ----------- | ----------------------------- | --------------- | -------------------- |
| Server Pull | `RequestDispatcher.forward()` | Request scope   | MVC Controller → JSP |
| Client Pull | `response.sendRedirect()`     | Session scope   | Redirect after login |

---

### **13. Is `ServletContext` thread-safe?**

**Answer:**
No.
Because multiple threads may modify shared attributes concurrently. You must synchronize when modifying or reading shared objects.

---

### **14. Can we have multiple `ServletContext` objects in a web app?**

**Answer:**
No.
There is **only one `ServletContext` per web application**.
However, in a server running multiple web apps, each app has its **own `ServletContext`**.

---

### **15. What is the `log()` method in `ServletContext`?**

**Answer:**
It is used for **server-side logging**.
Example:

```java
ctx.log("Database connection established successfully.");
```

This message is written to the server log file (like `catalina.out` in Tomcat).

---

### **16. What is `ServletContextListener`?**

**Answer:**
It’s a listener interface that allows you to perform actions when the application starts or stops.

Example:

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

---

### **17. When is the `contextInitialized()` method called?**

**Answer:**
When the web application is deployed or the server starts — before any servlet is loaded.

---

### **18. What is the use of `ServletContextEvent`?**

**Answer:**
It’s an event object passed to listener methods like `contextInitialized()` and `contextDestroyed()`.
It provides access to the `ServletContext` via:

```java
ServletContext ctx = event.getServletContext();
```

---

### **19. How does Tomcat handle multiple concurrent client requests?**

**Answer:**
Tomcat doesn’t create a new thread per request.
Instead, it uses a **thread pool** (Executor Framework) for efficient handling.

Internally:

```java
ExecutorService pool = Executors.newFixedThreadPool(50);
```

Each request runs on a thread from this pool, reused after completion.

---

### **20. Can we access `ServletContext` from JSP?**

**Answer:**
Yes.
Using implicit object `application`:

```jsp
<%= application.getInitParameter("dbUrl") %>
```

---

### **21. Can a servlet modify context parameters at runtime?**

**Answer:**
No.
`context-param` values defined in `web.xml` are **read-only** and cannot be modified at runtime.

---

### **22. What happens if two servlets modify the same context attribute at the same time?**

**Answer:**
It leads to **race conditions** and **inconsistent data**, because context attributes are shared.
Hence, modifications must be done inside a synchronized block.

---

### **23. What are real-world use cases of ServletContext attributes?**

**Answer:**

* Application-wide counters (e.g., total user visits)
* Shared connection pools
* Common configuration objects (like DAO factories)
* Caching shared data loaded at startup

---

### **24. What happens when the server shuts down?**

**Answer:**

1. `ServletContextListener.contextDestroyed()` is called.
2. The container cleans up resources.
3. The `ServletContext` instance is destroyed.

---

### **25. What is the lifecycle of `ServletContext`?**

1. **Created:** When web app is deployed.
2. **Used:** Shared across servlets for the entire app lifecycle.
3. **Destroyed:** When app is undeployed or server shuts down.
