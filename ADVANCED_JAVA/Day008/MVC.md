### **1. MVC – Model View Controller**

**What it is:**
MVC is a **design pattern** that separates an application into **three logical layers**:

* **Model:** business logic + data (e.g., Java classes, DAO layer, database).
* **View:** presentation layer (e.g., JSP pages).
* **Controller:** request handler and coordinator (e.g., Servlet).

**Why use MVC:**

* **Separation of concerns** – code for logic, UI, and navigation stays separate.
* **Easier maintenance** – each layer can evolve independently.
* **Reusability** – same model can be reused by multiple views (e.g., web + mobile).

**Custom Implementation Example (Healthcare Case Study):**
Let’s say we’re building a **Healthcare Patient Appointment System**.

**Flow:**

1. **PatientLogin.jsp** → User submits login form.
2. **PatientLoginServlet (Controller)** → receives request, validates credentials via DAO (`PatientDaoImpl` → DB).
3. On success: adds patient object to session → forwards to **patient_dashboard.jsp** (View).
4. On failure: sets error message in request → forwards back to login JSP.

This creates a clear split:

* **Model:** `Patient`, `PatientDaoImpl`
* **View:** `patient_login.jsp`, `patient_dashboard.jsp`
* **Controller:** `PatientLoginServlet`

---

### **2. page vs pageContext vs pageScope**

| Term            | Type               | Scope | Description                                                                      |
| --------------- | ------------------ | ----- | -------------------------------------------------------------------------------- |
| **page**        | Implicit object    | Page  | Refers to the current JSP page instance (like `this` in Java).                   |
| **pageContext** | Implicit object    | Page  | Gives access to all JSP implicit objects + page-level attributes.                |
| **pageScope**   | EL implicit object | Page  | Used in EL to access page-level attributes (set via `pageContext.setAttribute`). |

Example:

```jsp
<%
pageContext.setAttribute("x", 50);
%>
${pageScope.x} → 50
```

---

### **3. JSP Scripting Elements**

1. **Declarations** – define variables/methods once per servlet.

   ```jsp
   <%! int counter = 0; %>
   ```
2. **Scriptlets** – raw Java code inside service method.

   ```jsp
   <% counter++; %>
   ```
3. **Expressions** – short output statements.

   ```jsp
   <%= counter %>
   ```

---

### **4. JSP Implicit Objects (available in Scriptlets & Expressions)**

`request`, `response`, `session`, `application`, `out`, `config`, `pageContext`, `page`, `exception`

---

### **5. EL (Expression Language) Implicit Objects (${...})**

| Object                                                          | Represents          |
| --------------------------------------------------------------- | ------------------- |
| `pageScope`, `requestScope`, `sessionScope`, `applicationScope` | Attribute maps      |
| `param`, `paramValues`                                          | Request parameters  |
| `header`, `headerValues`                                        | Request headers     |
| `cookie`                                                        | Cookies             |
| `initParam`                                                     | Context init params |
| `pageContext`                                                   | PageContext object  |

---

### **6. Cookie Value (EL)**

To print cookie named `"abc"`:

```jsp
${cookie.abc.value}
```

---

### **7. Session Timeout (EL)**

```jsp
${pageContext.session.maxInactiveInterval} → 1800
```

(Default 30 min)

---

### **8. Setting and Accessing Session Attributes**

Scriptlet:

```jsp
<%
session.setAttribute("user_info", customer);
%>
```

EL Access:

```jsp
${sessionScope.user_info}
```

→ Renders the `customer` object’s `toString()` or property values (e.g., `${sessionScope.user_info.name}`)

---

### **9. Getting Session ID**

```jsp
${pageContext.session.id}
```

→ Outputs something like `DSAJKFHDJ567657KJKJHKJ`.

---

### **10. Request Parameter Access**

```jsp
${param.product_id}
```

Equivalent to:

```java
request.getParameter("product_id");
```

---

### **11. Invalidating Session**

**Correct Options:** ✅ 1 and 4

```jsp
<% session.invalidate(); %>      // Scriptlet ✅  
${pageContext.session.invalidate()}  // EL call ✅
```

---

### **12. URL Rewriting with HttpSession**

**Problem:**
If browser disables cookies → `JSESSIONID` is not sent → session tracking fails.

**Solution:**
Embed session ID in URL.

**Servlet API Methods (HttpServletResponse):**

* `encodeURL(String url)` → encodes URL with session ID (used in links/buttons).
* `encodeRedirectURL(String url)` → encodes URL for redirects.

**Example:**

```java
String encoded = response.encodeURL("details.jsp");
out.print("<a href='" + encoded + "'>Details</a>");
```

**Example Output:**
`http://localhost:8080/day8.1/details.jsp;jsessionid=1B4BF07AB97205DF02CF7BE5800D72D3`

**Security Issue:**
Session ID visible in URL → session fixation / hijacking risk.

**Best Practice:**
Use **HTTPS** along with URL rewriting → encrypts URL data end-to-end.