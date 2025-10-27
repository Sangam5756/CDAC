### 🧠 **JSP (Java Server Pages) – Core Summary**

**Definition:**
JSP is a *dynamic web page* technology that allows embedding Java code inside HTML. It’s a *presentation-layer component* managed by the **Web Container (WC)** (also known as the *JSP/Servlet container*).

**Purpose:**
Used for generating **dynamic content (HTML output)** while separating:

* **Presentation Logic (UI)** → JSP
* **Business Logic (Processing/Data)** → JavaBeans or Custom Tags

> In modern full-stack apps, JSP is mostly replaced by frontend frameworks (React, Angular, etc.), but still common in legacy enterprise systems.

---

### ⚙️ **JSP Lifecycle (Managed by WC)**

1. **Translation:** JSP → Java servlet (`test_jsp.java`)
2. **Compilation:** Compiled into `.class` (servlet class)
3. **Loading & Instantiation**
4. **Initialization:** `jspInit()` called once
5. **Request Handling:** `_jspService()` per client request
6. **Destruction:** `jspDestroy()` before unloading

For subsequent requests → only `_jspService()` runs.

---

### 🧩 **JSP API Hierarchy**

```
Servlet (jakarta.servlet)
  ↳ JspPage (jspInit(), jspDestroy())
     ↳ HttpJspPage (_jspService(req,res))
```

---

### 🪄 **JSP Implicit Objects**

| Object        | Type                | Purpose                            |
| ------------- | ------------------- | ---------------------------------- |
| `request`     | HttpServletRequest  | Client request                     |
| `response`    | HttpServletResponse | Response                           |
| `out`         | JspWriter           | Output stream                      |
| `config`      | ServletConfig       | Init parameters                    |
| `session`     | HttpSession         | Session tracking                   |
| `application` | ServletContext      | App-wide data                      |
| `pageContext` | PageContext         | Accessor to other implicit objects |
| `page`        | Object              | This JSP instance                  |
| `exception`   | Throwable           | Available only in error pages      |

---

### ✍️ **Scripting Elements**

1. **Scriptlet:** `<% Java code %>` → goes inside `_jspService()`
2. **Expression:** `<%= expression %>` → evaluated and printed
3. **Declaration:** `<%! code %>` → creates fields/methods at class level

> Avoid scriptlets; use EL (Expression Language) or JSTL instead.

---

### 💡 **Expression Language (EL)**

Syntax: `${expression}`
Used for accessing attributes/params without Java code.

| EL Object                                                       | What it Represents   |
| --------------------------------------------------------------- | -------------------- |
| `param`                                                         | Request parameters   |
| `pageScope`, `requestScope`, `sessionScope`, `applicationScope` | Scoped attributes    |
| `cookie`                                                        | Cookies              |
| `initParam`                                                     | Context init params  |
| `pageContext`                                                   | PageContext instance |

Example:

```jsp
${param.username}             // request.getParameter("username")
${sessionScope.user.email}    // session.getAttribute("user").getEmail()
${pageContext.request.contextPath} // request.getContextPath()
```

---

### 📜 **JSP Directives**

Syntax: `<%@ directive attribute="value" %>`

1. **Page Directive:** Page-level settings
   Example:

   ```jsp
   <%@ page import="java.util.*" contentType="text/html" session="true" %>
   ```

   Common attributes:

   * `import`
   * `session`
   * `errorPage`
   * `isErrorPage`
   * `isThreadSafe`

2. **Include Directive:**
   Includes file at *translation time*.

   ```jsp
   <%@ include file="header.jsp" %>
   ```

---

### 🧱 **JSP Standard Actions**

Tags interpreted by the JSP engine at runtime.
Examples:

```jsp
<jsp:include page="two.jsp" />
<jsp:forward page="next.jsp" />
<jsp:param name="id" value="123" />
```

---

### ☕ **Using JavaBeans in JSP**

Encapsulates business logic and client state.

**Steps:**

1. **Declare Bean**

   ```jsp
   <jsp:useBean id="user" class="beans.UserBean" scope="session" />
   ```
2. **Set Properties**

   ```jsp
   <jsp:setProperty name="user" property="email" param="email" />
   <jsp:setProperty name="user" property="*" />
   ```
3. **Get Properties**

   ```jsp
   <jsp:getProperty name="user" property="email" />
   ```

   or EL: `${sessionScope.user.email}`

---

### 🧩 **JSTL (JSP Standard Tag Library)**

Provides reusable tags (no Java code in JSP):

* Core tags (`<c:if>`, `<c:forEach>`, `<c:set>`, etc.)
* Formatting, SQL, XML, and function tags.

Import with:

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

---

### 🧠 **Interview Must-Know Points**

* JSP is translated into a **servlet** at runtime.
* `_jspService()` handles each request; do not override it.
* **`jspInit()`** and **`jspDestroy()`** → for resource setup/cleanup.
* **EL** simplifies reading request/session/application data.
* **JSP directives vs. actions:** directives = translation-time; actions = runtime.
* **JSTL** is preferred over scriptlets for logic.

