
### 🧩 Core Spring

**spring-webmvc** → Gives you the full Spring MVC framework: DispatcherServlet, Controllers, ViewResolvers, etc.
**spring-orm** → Connects Spring with ORM tools like Hibernate; handles SessionFactory and transaction integration.

---

### 🌐 Web & JSP

**jakarta.servlet-api** → Defines Servlet interfaces used by web containers (Tomcat, Jetty). Marked as *provided* since the server already has it.
**jakarta.servlet.jsp.jstl-api** → The JSTL (JSP Standard Tag Library) API for using tags like `<c:forEach>`.
**org.glassfish.web:jakarta.servlet.jsp.jstl** → The actual implementation of those JSTL tags.


---
### 🧱 Hibernate + Database

**hibernate-core** → The main Hibernate ORM engine — manages entities, sessions, and SQL generation.
**commons-dbcp2** → Connection pooling — reuses database connections for better performance.
**mysql-connector-j** → The JDBC driver that lets Java talk to your MySQL database.
---

### 🛠 Utility / Annotation

**lombok** → Reduces boilerplate with annotations like `@Getter`, `@Setter`, `@NoArgsConstructor`.
**jakarta.annotation-api** → Provides annotation support like `@PostConstruct`, `@Resource`, etc.

---

### ⚙️ Plugins (Build Section)

**maven-compiler-plugin** → Compiles your Java code using JDK 21.
**maven-war-plugin** → Packages your project as a `.war` file (for deployment in Tomcat or any servlet container).
