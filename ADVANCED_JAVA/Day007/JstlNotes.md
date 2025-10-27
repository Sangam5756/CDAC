
### **1. What is JSTL?**

**Definition:**
JSTL (JavaServer Pages Standard Tag Library) is a collection of **custom tags** that simplify JSP development by eliminating the need for Java scriptlets (`<% %>`).
It allows developers to perform common tasks like iteration, conditionals, URL handling, and formatting — all using tags.

**Package:** `jakarta.servlet.jsp.jstl`
**Library JARs:** `jstl-1.2.jar` (or `jakarta.servlet.jsp.jstl-3.x.jar` for newer versions)

---

### **2. Why JSTL?**

* Reduces Java code in JSP (no scriptlets).
* Improves readability and maintainability.
* Provides **standardized** tags (portable across containers).
* Encourages **MVC separation** — logic stays in servlets, presentation in JSP.

---

### **3. JSTL Core Tags**

Imported with:

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

Now let’s break down the **important core tags** (commonly asked in interviews):

---

### **(a) `<c:set>` – Set attribute**

Used to set or create attributes in a given scope.

```jsp
<c:set var="name" value="${param.username}" scope="session"/>
```

Equivalent to:

```java
session.setAttribute("name", request.getParameter("username"));
```

Default scope = `page`

---

### **(b) `<c:remove>` – Remove attribute**

Deletes an attribute from a given scope.

```jsp
<c:remove var="name" scope="session"/>
```

Equivalent to:

```java
session.removeAttribute("name");
```

---

### **(c) `<c:forEach>` – Iteration**

Iterates over collections, arrays, or numeric ranges.

**List iteration:**

```jsp
<c:forEach var="emp" items="${sessionScope.empList}">
   ${emp.name} - ${emp.salary}<br/>
</c:forEach>
```

**Number iteration:**

```jsp
<c:forEach var="i" begin="1" end="5">
   ${i}<br/>
</c:forEach>
```

---

### **(d) `<c:if>` – Conditional execution**

Executes body only when test condition is true.

```jsp
<c:if test="${salary > 50000}">
   <p>Good Salary: ${salary}</p>
</c:if>
```

---

### **(e) `<c:choose>`, `<c:when>`, `<c:otherwise>` – Conditional branching**

Acts like `switch-case` in Java.

```jsp
<c:choose>
  <c:when test="${marks >= 90}">Excellent</c:when>
  <c:when test="${marks >= 60}">Good</c:when>
  <c:otherwise>Needs Improvement</c:otherwise>
</c:choose>
```

---

### **(f) `<c:redirect>` – Redirect to another resource**

Used for **server-side redirects** (similar to `response.sendRedirect()`).

```jsp
<c:redirect url="dashboard.jsp">
   <c:param name="user" value="${param.username}"/>
</c:redirect>
```

---

### **(g) `<c:url>` – URL Rewriting**

Used for encoding URLs (handles `jsessionid` when cookies are disabled).

```jsp
<c:url var="nextPage" value="profile.jsp" />
<a href="${nextPage}">Go to Profile</a>
```

Equivalent to:

```java
pageContext.setAttribute("nextPage", response.encodeURL("profile.jsp"));
```

---

### **4. JSTL Scopes**

`page`, `request`, `session`, `application` — same as JSP implicit objects.

---

### **5. Common Interview Questions**

**Q1:** What’s the difference between `<jsp:useBean>` and `<c:set>`?
**A:** `<jsp:useBean>` creates/locates a JavaBean, whereas `<c:set>` just sets an attribute value in a specific scope.

**Q2:** Difference between `<jsp:forward>` and `<c:redirect>`?
**A:**

* `<jsp:forward>` is **server-side** — request doesn’t change (same URL).
* `<c:redirect>` is **client-side** — browser gets new URL (visible change).

**Q3:** Why prefer JSTL over scriptlets?
**A:** It promotes cleaner, MVC-compliant JSPs and is easier to maintain.

**Q4:** Can JSTL access JavaBeans?
**A:** Yes, via EL (Expression Language). Example: `${user.name}` accesses the getter `getName()` of bean `user`.

---

### **6. Example Practical Use**

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="user" value="${sessionScope.userDetails}"/>
<c:if test="${user.role eq 'admin'}">
   <a href="adminDashboard.jsp">Admin Panel</a>
</c:if>
<c:forEach var="item" items="${sessionScope.cart}">
   ${item.name} - ${item.price}<br/>
</c:forEach>
```

---
