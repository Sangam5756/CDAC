### **1. What is JSTL?**

**Answer:**
JSTL stands for *JavaServer Pages Standard Tag Library*. It’s a collection of custom JSP tags used to perform common tasks like iteration, conditional checks, URL management, and internationalization without writing Java code inside JSPs.

---

### **2. Why do we use JSTL?**

**Answer:**
We use JSTL to **eliminate scriptlets** (`<% %>`) from JSPs, making pages cleaner, easier to maintain, and fully MVC-compliant. It also provides **standardized tags** supported across all Java EE servers.

---

### **3. From which Java EE version is JSTL a standard part?**

**Answer:**
JSTL became a standard part of Java EE from **version 1.5** onwards.

---

### **4. What is the JAR file required for JSTL?**

**Answer:**
The required JAR is `jstl-1.2.jar` (or newer `jakarta.servlet.jsp.jstl-3.x.jar` for Jakarta EE).
It must be placed in the project’s **`WEB-INF/lib`** or Tomcat’s **`lib`** folder.

---

### **5. How do you import JSTL into a JSP page?**

**Answer:**
By using the taglib directive:

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

Here, `c` is the prefix used for JSTL core tags.

---

### **6. What are the main types of JSTL tag libraries?**

**Answer:**

1. **Core tags** – General purpose (`<c:set>`, `<c:if>`, `<c:forEach>`, etc.)
2. **Formatting tags** – For numbers, dates, and localization
3. **SQL tags** – For database operations (not recommended in production)
4. **XML tags** – For XML parsing and transformation
5. **Function tags** – Utility functions like string operations

---

### **7. What is the use of `<c:set>` tag?**

**Answer:**
It sets or creates an attribute in a given scope.

```jsp
<c:set var="username" value="${param.user}" scope="session"/>
```

Equivalent to:

```java
session.setAttribute("username", request.getParameter("user"));
```

---

### **8. What is the default scope of `<c:set>`?**

**Answer:**
The default scope is **`page`**.

---

### **9. What is the use of `<c:remove>` tag?**

**Answer:**
It removes an attribute from a specified scope.

```jsp
<c:remove var="username" scope="session"/>
```

---

### **10. How is `<c:forEach>` used?**

**Answer:**
It’s used for iteration, like a Java `for-each` loop.

Example:

```jsp
<c:forEach var="student" items="${sessionScope.studentList}">
   ${student.name}<br/>
</c:forEach>
```

You can also use it as a numeric loop:

```jsp
<c:forEach var="i" begin="1" end="5">${i}</c:forEach>
```

---

### **11. What is the use of `<c:if>` tag?**

**Answer:**
It evaluates a boolean condition and executes the body if the condition is true.

```jsp
<c:if test="${salary > 50000}">
   High salary: ${salary}
</c:if>
```

---

### **12. What is the use of `<c:choose>`, `<c:when>`, and `<c:otherwise>`?**

**Answer:**
They work like `switch-case` in Java.

```jsp
<c:choose>
  <c:when test="${marks >= 90}">Excellent</c:when>
  <c:when test="${marks >= 60}">Good</c:when>
  <c:otherwise>Needs improvement</c:otherwise>
</c:choose>
```

---

### **13. What is the difference between `<c:if>` and `<c:choose>`?**

**Answer:**

* `<c:if>` is used for single conditional checks.
* `<c:choose>` is used when multiple conditions need to be checked (like `if-else-if` chain).

---

### **14. How is `<c:redirect>` different from `<jsp:forward>`?**

**Answer:**

* `<jsp:forward>` → **Server-side** redirect (URL in browser doesn’t change).
* `<c:redirect>` → **Client-side** redirect (browser sees new URL).

Example:

```jsp
<c:redirect url="home.jsp">
  <c:param name="id" value="101"/>
</c:redirect>
```

---

### **15. What does `<c:url>` do?**

**Answer:**
It rewrites URLs by encoding the session ID if cookies are disabled.

Example:

```jsp
<c:url var="next" value="home.jsp" />
<a href="${next}">Next</a>
```

Equivalent to:

```java
response.encodeURL("home.jsp");
```

---

### **16. What are the scopes available in JSTL?**

**Answer:**

* **page** (default)
* **request**
* **session**
* **application**

---

### **17. How can you handle conditional display based on user role in JSTL?**

**Answer:**

```jsp
<c:set var="user" value="${sessionScope.userDetails}"/>
<c:if test="${user.role eq 'admin'}">
  <a href="adminDashboard.jsp">Admin Panel</a>
</c:if>
```

---

### **18. Can JSTL work without Expression Language (EL)?**

**Answer:**
Technically yes, but in practice JSTL is almost always used **with EL** because EL makes accessing data much simpler (`${...}` syntax).

---

### **19. What is the difference between JSTL and custom tags?**

**Answer:**

* **JSTL**: Predefined standard tags (provided by Jakarta EE).
* **Custom tags**: User-defined tags written for specific application logic.

---

### **20. Is JSTL mandatory for JSP?**

**Answer:**
No, but it’s highly recommended. JSP can run with scriptlets, but JSTL provides a clean, modern, and standard approach to dynamic content generation.

---

### **21. Can JSTL tags call Java methods?**

**Answer:**
Yes, through EL, if the method is exposed via a bean getter.
Example: `${user.getName()}` calls `getName()` method of the `user` bean.

---

### **22. Can you perform loops or conditionals in JSTL without Java code?**

**Answer:**
Yes — that’s the main purpose of JSTL. You can use `<c:forEach>`, `<c:if>`, and `<c:choose>` tags for this.

---

### **23. How can you pass parameters using JSTL redirect?**

**Answer:**
Using `<c:param>` inside `<c:redirect>`.

```jsp
<c:redirect url="profile.jsp">
   <c:param name="id" value="${user.id}"/>
</c:redirect>
```

---

### **24. What happens if cookies are disabled when using `<c:redirect>` or `<c:url>`?**

**Answer:**
The session ID (`jsessionid`) is **appended to the URL** automatically for session tracking.

---

### **25. Give a real-world example using multiple JSTL tags together.**

**Answer:**

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="user" value="${sessionScope.userDetails}"/>

<h3>Welcome ${user.name}</h3>
<c:if test="${user.role eq 'admin'}">
  <a href="adminDashboard.jsp">Admin Panel</a>
</c:if>

<c:forEach var="item" items="${sessionScope.cart}">
  ${item.name} - ${item.price}<br/>
</c:forEach>

<c:choose>
  <c:when test="${empty sessionScope.cart}">Your cart is empty!</c:when>
  <c:otherwise>Proceed to checkout</c:otherwise>
</c:choose>
```
