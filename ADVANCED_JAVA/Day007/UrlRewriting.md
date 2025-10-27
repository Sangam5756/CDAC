## 🧠 **Session Tracking using HttpSession + URL Rewriting — Interview Questions & Answers**

---

### **1. What is session tracking in web applications?**

**Answer:**
Session tracking is the process of maintaining the **state of a user** (client) across multiple requests in a stateless protocol like HTTP.
Since HTTP doesn’t remember previous interactions, session tracking helps identify which requests belong to the same client.

---

### **2. What is the default mechanism for session tracking in Java web apps?**

**Answer:**
By default, the web container uses a **cookie** called `JSESSIONID` to identify the client session.

---

### **3. Why do we need URL rewriting if cookies are disabled?**

**Answer:**
If the client’s browser has cookies disabled, the server won’t receive the `JSESSIONID` cookie.
So we use **URL rewriting** to embed the session ID inside the URL itself, ensuring the server can still recognize the user’s session.

---

### **4. What is URL rewriting?**

**Answer:**
URL rewriting means **appending the session ID (JSESSIONID)** to the URL so that session tracking works without cookies.
Example:

```
http://localhost:8080/app/home;jsessionid=FHSF67456HGJHD767
```

---

### **5. How does the web container (WC) use the JSESSIONID in URL rewriting?**

**Answer:**
When a request arrives:

1. WC first checks if the `JSESSIONID` is available in the cookie.
2. If not, it checks the **URL** for `jsessionid`.
3. If found, it extracts and associates it with the correct HttpSession.

---

### **6. Which APIs are used for URL rewriting in Servlets?**

**Answer:**
Servlet provides two methods in `HttpServletResponse`:

1. For links or form actions (client pull I):

   ```java
   public String encodeURL(String originalURL)
   ```

   Returns a URL with `;jsessionid=XYZ` appended.

2. For redirects (client pull II):

   ```java
   public String encodeRedirectURL(String redirectURL)
   ```

   Used when sending a redirect response.

---

### **7. What is the difference between `encodeURL()` and `encodeRedirectURL()`?**

**Answer:**

| Method                | Used For                                            | Example Use                    |
| --------------------- | --------------------------------------------------- | ------------------------------ |
| `encodeURL()`         | URLs in JSP/HTML like `<a href>` or `<form action>` | Client pull (links/buttons)    |
| `encodeRedirectURL()` | URLs in `response.sendRedirect()`                   | Server sends redirect response |

---

### **8. What happens if cookies are enabled in the browser?**

**Answer:**
If cookies are enabled, the web container **suppresses URL encoding** — it won’t append the `JSESSIONID` to the URL since it can already track the session via cookies.

---

### **9. How do you use URL rewriting in JSP with JSTL?**

**Answer:**
You can use the `<c:url>` tag, which internally calls `encodeURL()`:

```jsp
<c:url var="next" value="home.jsp" />
<a href="${next}">Home</a>
```

If cookies are disabled, this will automatically include `;jsessionid=XYZ`.

---

### **10. Can you show a practical example of URL rewriting in a servlet?**

**Answer:**

```java
@WebServlet("/one")
public class OneServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String encodedURL = resp.encodeURL("two");
        PrintWriter out = resp.getWriter();
        out.print("<a href='" + encodedURL + "'>Go to Two</a>");
    }
}
```

If cookies are off, the generated link will look like:
`/app/two;jsessionid=ABCD1234XYZ`

---

### **11. Is URL rewriting secure?**

**Answer:**
It works but has limitations:

* The session ID appears in the URL, so it can be **exposed in logs or shared links**.
* Hence, cookies are more secure and recommended.

---

### **12. What are the advantages of using URL rewriting?**

**Answer:**

* Works even when cookies are disabled.
* Simple to implement with provided servlet methods.
* Transparent to the client.

---

### **13. What are the disadvantages of URL rewriting?**

**Answer:**

* Exposes session ID in URL (security risk).
* Requires encoding every link and form manually.
* Shared URLs can leak session data.

---

### **14. How can you make a web app fully independent of cookies?**

**Answer:**
By using **HttpSession** for session management and **URL rewriting** (`encodeURL()` and `encodeRedirectURL()`) for session tracking.

---

### **15. What happens if the encoded URL does not contain a valid JSESSIONID?**

**Answer:**
The server treats the request as a **new session** and creates a new `HttpSession` with a new ID.

---

### **16. Is URL rewriting specific to Java EE?**

**Answer:**
No — the concept exists across web technologies.
But the Java EE implementation (`encodeURL`, `encodeRedirectURL`) provides built-in API-level support for it.

---

### **17. How is session tracking managed when both cookies and URL rewriting are enabled?**

**Answer:**
If both are enabled, **cookies take priority**.
URL rewriting acts only as a fallback when cookies are disabled.

---

### **18. In which situations should you prefer URL rewriting?**

**Answer:**

* When the application must work even if cookies are disabled.
* In systems requiring temporary stateless tracking.
* During educational or demonstration purposes (like servlet labs).

