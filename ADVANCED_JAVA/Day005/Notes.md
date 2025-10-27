
## 🧠 Servlet–JSP Web App Flow (Step-by-Step Notes)

---

### **1. Web Application Startup**

**Concept:**
When the web application is deployed or the server starts, the **Web Container (WC)** initializes all servlets that are configured for **eager loading** (`<load-on-startup>` in `web.xml`).

**WC Responsibilities:**

* Uses **Reflection** to load servlet classes.
* Creates an **instance** of each servlet.
* Passes a `ServletConfig` object.
* Calls the servlet’s `init()` method — initialization logic runs once in its lifetime.

**Example:**

```java
@WebServlet(urlPatterns="/authenticate", loadOnStartup=1)
public class PatientLoginServlet extends HttpServlet {
    public void init() {
        System.out.println("Login Servlet initialized");
    }
}
```

🧩 *When server starts → WC loads `PatientLoginServlet` → calls `init()`.*

---

### **2. Accessing the Application (Welcome File)**

**URL:** `http://localhost:8080/day5.1/`

* WC reads `web.xml`, finds the **welcome file** entry:

```xml
<welcome-file-list>
   <welcome-file>index.html</welcome-file>
</welcome-file-list>
```

* Sends **index.html** as the default response.

✅ **Response:** HTML content of `index.html`.

---

### **3. Opening the Login Page**

User clicks **“Patient Login”** →
**URL:** `http://localhost:8080/day5.1/login.html`

* Server sends back `login.html` containing a login form.

**Example Form:**

```html
<form method="post" action="authenticate">
  Email: <input type="text" name="email"/>
  Password: <input type="password" name="password"/>
  <input type="submit" value="Login"/>
</form>
```

✅ **Response:** Login form page.

---

### **4. Login Form Submission**

User submits form →
**POST /authenticate**

* WC checks **servlet mapping**:
  `/authenticate → PatientLoginServlet`
* WC calls `service()` → then `doPost()` of that servlet.

**Servlet Code:**

```java
protected void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {
    String email = req.getParameter("email");
    String pass = req.getParameter("password");

    if(dao.validateUser(email, pass)) {
        HttpSession session = req.getSession();
        session.setAttribute("user", email);
        res.sendRedirect("patient_dashboard");
    } else {
        req.setAttribute("error", "Invalid login!");
        req.getRequestDispatcher("patient_login.jsp").forward(req, res);
    }
}
```

✅ **Response:**

* If valid → redirect to `/patient_dashboard`.
* If invalid → show login page again with error.

---

### **5. Patient Dashboard**

**URL:** `/patient_dashboard`
**Method:** `GET`

* Browser follows redirect and sends a new request with **Cookie:**
  `JSESSIONID=AFGSDG65413XDF`
* WC maps `/patient_dashboard` → `PatientDashboardServlet`.

**Example:**

```java
protected void doGet(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {
    HttpSession session = req.getSession(false);
    if(session != null) {
        List<Appointments> list = dao.getAppointments();
        req.setAttribute("appts", list);
        req.getRequestDispatcher("dashboard.jsp").forward(req, res);
    } else {
        res.sendRedirect("login.html");
    }
}
```

✅ **Response:** JSP page listing appointments + links.

---

### **6. Booking an Appointment**

User clicks **“Book Appointment”** →
**URL:** `/book_appointment.html`

✅ **Response:** Form for booking new appointment.

**Form Example:**

```html
<form method="post" action="appointments">
  Doctor ID: <input name="doc_id" />
  Time Slot: <input name="ts" />
  <input type="submit" value="Book"/>
</form>
```

---

### **7. Form Submission (Booking Logic)**

**POST /appointments**

* WC routes to `AppointmentServlet`
* `doPost()` calls DAO to check doctor’s availability.

**Example:**

```java
protected void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {
    String docId = req.getParameter("doc_id");
    String ts = req.getParameter("ts");

    boolean booked = dao.bookAppointment(docId, ts);
    if(booked)
        res.sendRedirect("patient_dashboard");
    else {
        req.setAttribute("error", "Doctor not available");
        req.getRequestDispatcher("book_appointment.jsp").forward(req, res);
    }
}
```

✅ **Response:** Redirects to dashboard or shows error.

---

### **8. Logout**

**URL:** `/logout`
**Servlet:** `LogoutServlet`

**Code:**

```java
protected void doGet(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {
    HttpSession session = req.getSession(false);
    if(session != null)
        session.invalidate();
    res.sendRedirect("login.html");
}
```

✅ **Response:** Redirect to login page, session destroyed.

---

### **Summary Flow**

```
index.html
   ↓
login.html → POST /authenticate → PatientLoginServlet.doPost()
   ↓
sendRedirect("patient_dashboard")
   ↓
PatientDashboardServlet.doGet()
   ↓
book_appointment.html → POST /appointments
   ↓
AppointmentServlet.doPost()
   ↓
patient_dashboard (updated)
   ↓
logout → LogoutServlet → session.invalidate()
```

---

### **Key Terms Quick Recall**

| Term                               | Meaning                                     |
| ---------------------------------- | ------------------------------------------- |
| **WC (Web Container)**             | Manages servlet lifecycle & request mapping |
| **Servlet Mapping**                | URL pattern linked to servlet               |
| **sendRedirect()**                 | Client-side redirect → new request          |
| **forward()**                      | Server-side transfer → same request         |
| **Session (JSESSIONID)**           | Maintains user data between requests        |
| **DAO**                            | Data Access Object – handles DB logic       |
| **init()**                         | Runs once at servlet creation               |
| **service() / doGet() / doPost()** | Handles client requests                     |

---
