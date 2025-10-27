### **Web App Startup**

* When the web app is deployed, the **Web Container (WC)** starts.
* Using **reflection**, it finds all servlets marked for **eager loading** (like `PatientLoginServlet`).
* For each such servlet, it runs the life cycle steps:

  1. Load class
  2. Create instance
  3. Inject config (`ServletConfig`)
  4. Call `init()`

At this point, the servlet is ready to handle requests.

---

### **URL Sequence and Request Flow**

**1. App Entry**
`http://host:port/day5.1/`

* WC looks into `web.xml` → `welcome-file` → loads `index.html`.
* Response: HTML of the home page.

---

**2. Patient Login Page**
User clicks **"Patient Login"** link →
`http://host:port/day5.1/login.html`

* Response: Login form (HTML).

---

**3. Login Submission**
Form submitted →
`POST /authenticate`

* WC checks the **servlet mapping**: `/authenticate → PatientLoginServlet`.
* Calls `service()` → `doPost()`.
* Servlet verifies credentials and responds with a **temporary redirect** to `patient_dashboard`.

---

**4. Dashboard Access**
`GET /patient_dashboard`

* Cookie sent with request: `JSESSIONID`.
* WC maps it to `PatientDashboardServlet`.
* `doGet()` executes: retrieves patient’s appointments, sends back dashboard HTML with links.

---

**5. Book Appointment Page**
Click **“Book Appointment”** →
`GET /book_appointment.html`

* Response: Appointment booking form.

---

**6. Booking Form Submission**
`POST /appointments`

* WC routes to the corresponding servlet.
* Servlet calls DAO: checks doctor’s availability.

  * If available → creates a new appointment.
  * If not → returns error message.
* Response: redirect to `patient_dashboard`.

---

**7. Logout**
`GET /logout`

* Servlet invalidates session, removes `JSESSIONID`.
* Sends a redirect response (likely to login or home page).

---

In short:
**WC = Traffic Controller** → Maps URLs → Calls correct Servlet → Executes logic → Builds Response (HTML/Redirect).
