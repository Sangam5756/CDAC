

## 🚀 **Servlet Interview Notes (All Topics + Questions + Answers)**

---

### **1. What is a Servlet?**

**Answer:**
A Servlet is a **Java class** that runs inside a **Web Container (like Tomcat)** and handles **HTTP requests and responses**. It’s the server-side component of a Java web app.

**Example:**

```java
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
   protected void doGet(HttpServletRequest req, HttpServletResponse res)
   throws IOException {
       res.getWriter().println("Hello, Servlet!");
   }
}
```

---

### **2. Servlet Lifecycle**

**Phases of a Servlet lifecycle:**

1. **Loading & Instantiation** – Container loads the servlet class.
2. **Initialization** – Calls `init()` once.
3. **Request handling** – Calls `service()` for each request.
4. **Destruction** – Calls `destroy()` before servlet is removed.

**Example:**

```java
public class MyServlet extends HttpServlet {
   public void init() { System.out.println("init() called"); }
   public void service(...) { System.out.println("service() called"); }
   public void destroy() { System.out.println("destroy() called"); }
}
```

---

### **3. Difference Between `service()`, `doGet()`, and `doPost()`**

| Method      | Called When                     | Used For                              |
| ----------- | ------------------------------- | ------------------------------------- |
| `service()` | Every request (GET, POST, etc.) | Dispatches to `doGet()` or `doPost()` |
| `doGet()`   | HTTP GET                        | Retrieve or display data              |
| `doPost()`  | HTTP POST                       | Submit data or perform updates        |

---

### **4. What is a Web Container?**

**Answer:**
The **Web Container (like Tomcat or Jetty)** manages the servlet lifecycle, handles HTTP requests, creates `request` and `response` objects, and provides services like:

* Multithreading support
* Session management
* Security
* Deployment descriptor (`web.xml`) parsing

Think of it as the **runtime environment** for Servlets.

---

### **5. Difference Between `ServletConfig` and `ServletContext`**

| Feature    | ServletConfig           | ServletContext         |
| ---------- | ----------------------- | ---------------------- |
| Scope      | One servlet             | Entire app             |
| Defined in | `<init-param>`          | `<context-param>`      |
| Purpose    | Servlet-specific config | Shared app-wide config |
| Created    | When servlet loads      | When app starts        |

---

### **6. What is `web.xml`?**

**Answer:**
Deployment descriptor — describes how components are configured in a web app.

**Example:**

```xml
<web-app>
  <servlet>
     <servlet-name>Login</servlet-name>
     <servlet-class>com.app.LoginServlet</servlet-class>
  </servlet>
  <servlet-mapping>
     <servlet-name>Login</servlet-name>
     <url-pattern>/login</url-pattern>
  </servlet-mapping>
</web-app>
```

---

### **7. Difference Between `forward()` and `sendRedirect()`**

| Feature               | `forward()`                | `sendRedirect()`         |
| --------------------- | -------------------------- | ------------------------ |
| Request Type          | Server-side                | Client-side              |
| URL change in browser | No                         | Yes                      |
| Same request object   | Yes                        | No (new request)         |
| Usage                 | Internal resource transfer | Redirect to external URL |

**Example:**

```java
// Forward
req.getRequestDispatcher("dashboard.jsp").forward(req, res);

// Redirect
res.sendRedirect("login.html");
```

---

### **8. What is a Session? How is it maintained?**

**Answer:**
A **session** tracks user data across multiple requests using a unique ID (JSESSIONID).

**Techniques for session tracking:**

1. **Cookies** (default – JSESSIONID)
2. **URL rewriting**
3. **Hidden form fields**
4. **HttpSession**

**Example:**

```java
HttpSession session = req.getSession();
session.setAttribute("user", "Ravi");
```

---

### **9. What is `HttpSession`?**

**Answer:**
`HttpSession` object allows storing user data for multiple requests.

**Example:**

```java
HttpSession session = req.getSession();
session.setAttribute("email", "abc@gmail.com");

String email = (String) session.getAttribute("email");
```

---

### **10. How are Cookies used in Servlets?**

**Answer:**
Cookies store small pieces of data on the client side.

**Example:**

```java
Cookie ck = new Cookie("username", "Ravi");
res.addCookie(ck);

Cookie[] arr = req.getCookies();
```

---

### **11. Difference Between Cookies and Sessions**

| Aspect   | Cookies        | Session                   |
| -------- | -------------- | ------------------------- |
| Storage  | Client browser | Server memory             |
| Security | Less secure    | More secure               |
| Lifetime | Set by cookie  | Till session timeout      |
| Capacity | Limited        | Larger, depends on server |

---

### **12. What is RequestDispatcher?**

**Answer:**
Used to **forward** a request or **include** content of another resource.

**Example:**

```java
RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
rd.forward(req, res); // OR rd.include(req, res);
```

---

### **13. Difference Between GenericServlet and HttpServlet**

| Feature  | GenericServlet          | HttpServlet                 |
| -------- | ----------------------- | --------------------------- |
| Protocol | Protocol-independent    | HTTP specific               |
| Methods  | `service()` only        | `doGet()`, `doPost()`, etc. |
| Usage    | Extend for any protocol | Commonly used for web apps  |

---

### **14. What are Filters in Servlets?**

**Answer:**
Filters intercept requests and responses to perform tasks like logging, authentication, or compression before/after servlet execution.

**Example:**

```java
@WebFilter("/secure/*")
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException, ServletException {
        System.out.println("Request filtered");
        chain.doFilter(req, res);
    }
}
```

---

### **15. What are Listeners in Servlets?**

**Answer:**
Listeners “listen” to events in the web app — like session creation, attribute changes, etc.

**Example:**

```java
@WebListener
public class MyListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent e) {
        System.out.println("App started!");
    }
    public void contextDestroyed(ServletContextEvent e) {
        System.out.println("App stopped!");
    }
}
```

---

### **16. What is a JSP and How Does It Relate to Servlets?**

**Answer:**

* JSP = JavaServer Pages, used for **view (presentation)**.
* JSPs are **converted into Servlets** by the container behind the scenes.
  So Servlet = Controller, JSP = View.

---

### **17. Explain the MVC Architecture in JSP–Servlets**

| Component      | Role                                        |
| -------------- | ------------------------------------------- |
| **Model**      | Business logic, DAO                         |
| **View**       | JSP pages (UI)                              |
| **Controller** | Servlets managing flow between model & view |

**Example:**
`LoginServlet` (Controller) → calls `UserDao` (Model) → forwards to `dashboard.jsp` (View)

---

### **18. How to Handle Exceptions in Servlets**

1. Using `try-catch` inside servlet.
2. Define `<error-page>` in `web.xml`.

**Example:**

```xml
<error-page>
   <error-code>404</error-code>
   <location>/error404.jsp</location>
</error-page>
```

---

### **19. What are Annotations in Servlets?**

**Answer:**
Annotations remove the need for `web.xml` mappings.

**Example:**

```java
@WebServlet(name="Hello", urlPatterns={"/hello"})
public class HelloServlet extends HttpServlet { ... }
```

---

### **20. Thread Safety in Servlets**

**Answer:**
A single servlet instance handles multiple requests via multiple threads.
So **instance variables are shared** — avoid them or synchronize access.

---

### **21. Difference Between `getRequestDispatcher()` and `sendRedirect()`**

Already covered above — remember:

* Forward = same request, faster, internal.
* Redirect = new request, slower, external.

---

### **22. Servlet Communication**

Servlets communicate using:

* `RequestDispatcher` (forward/include)
* Shared attributes in `ServletContext`
* Session attributes (`HttpSession`)

---

### **23. How to Connect Servlet with Database**

Typical 3-step pattern:

```java
Connection con = DriverManager.getConnection(url, user, pass);
PreparedStatement pst = con.prepareStatement("select * from users where email=?");
pst.setString(1, email);
ResultSet rs = pst.executeQuery();
```

Use DAO pattern to keep DB logic separate.

---

### **24. Advantages of Servlets**

* Platform independent (pure Java)
* Robust and efficient
* Secure and portable
* Reusable and maintainable
* Works seamlessly with JSPs (MVC pattern)

---

### **25. Limitations of Servlets**

* Difficult to design dynamic HTML inside Java code.
* Requires JSP for clean separation of UI and logic.
* No built-in templating.

---

### **26. Difference Between Servlet and JSP**

| Servlet                  | JSP                                    |
| ------------------------ | -------------------------------------- |
| Java code inside HTML    | HTML inside Java                       |
| Used for control logic   | Used for presentation                  |
| Compiled once, runs fast | Translated to servlet at first request |

---

### **27. How Does the Container Create Request and Response Objects?**

* On every HTTP request, the container creates:

  * `HttpServletRequest` – carries input data.
  * `HttpServletResponse` – sends output back to client.
* Once response is sent, both are destroyed.

---

### **28. What is URL Rewriting?**

Used when cookies are disabled — session ID is appended to URL:

```
http://localhost:8080/app/home;jsessionid=XYZ123
```

**Code Example:**

```java
String newURL = res.encodeURL("dashboard");
res.sendRedirect(newURL);
```

---

### **29. What is a Servlet Filter Chain?**

Multiple filters can process a request in sequence.

```
Client → Filter1 → Filter2 → Servlet → Filter2 → Filter1 → Client
```

---

### **30. Real-time Example Flow**

**Login → Dashboard → Book Appointment → Logout**

* `LoginServlet` → validates user, creates session.
* `DashboardServlet` → displays appointments.
* `AppointmentServlet` → handles booking.
* `LogoutServlet` → invalidates session.

All servlets use:

* `ServletContext` → DB connection URL.
* `ServletConfig` → servlet-specific limits.

---
