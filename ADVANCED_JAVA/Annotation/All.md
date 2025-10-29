## ⚙️ **1. Core JPA Annotations**

### **`@Entity`**

Marks a class as a **persistent entity**.
It tells JPA/Hibernate: “This class maps to a database table.”
Example:

```java
@Entity
public class User { ... }
```

---

### **`@Table`**

Specifies the actual **table name** in the database.
If not provided, Hibernate uses the class name as the table name.
Example:

```java
@Table(name = "users")
public class User { ... }
```

---

### **`@Id`**

Marks a field as the **primary key** of the entity.
Example (in `BaseEntity`):

```java
@Id
private Long id;
```

---

### **`@GeneratedValue`**

Defines how the primary key will be generated.
`IDENTITY` means the database auto-increments it (common in MySQL).
Example:

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

---

## 🧩 **2. Column and Field-Level Customization**

### **`@Column`**

Customizes column details — name, length, nullability, uniqueness, etc.
Example:

```java
@Column(name = "first_name", length = 30, nullable = false)
private String firstName;
```

---

### **`@Enumerated`**

Tells JPA how to store enums — either as ordinal (number) or string.
Example:

```java
@Enumerated(EnumType.STRING)
private UserRole role;
```

---

### **`@Lob`**

Marks a field as a **Large Object** (BLOB or CLOB).
Used for images, large text, or binary data.
Example:

```java
@Lob
private byte[] image;
```

---

### **`@Transient`**

(Used in your commented code) — tells JPA to **ignore this field** (no DB column).
Example:

```java
@Transient
private String confirmPassword;
```

---

## 🧱 **3. Relationship Annotations**

### **`@OneToOne`**

Defines a one-to-one relationship between entities.
Example (in `Doctor`):

```java
@OneToOne
@JoinColumn(name = "user_id", nullable = false)
private User userDetails;
```

Meaning: each doctor is linked to exactly one user record.

---

### **`@ManyToOne`**

Defines a many-to-one relationship — many entities refer to one parent.
Example (in `Appointment`):

```java
@ManyToOne
@JoinColumn(name = "doctor_id", nullable = false)
private Doctor myDoctor;
```

Meaning: many appointments can belong to one doctor.

---

### **`@ManyToMany`**

Defines a many-to-many relationship — implemented using a join table.
Example (in `Patient`):

```java
@ManyToMany
@JoinTable(
    name = "patient_tests",
    joinColumns = @JoinColumn(name = "patient_id"),
    inverseJoinColumns = @JoinColumn(name = "test_id")
)
private Set<DiagnosticTest> diagnosticTests = new HashSet<>();
```

Meaning: a patient can have many tests, and a test can belong to many patients.

---

### **`@JoinColumn`**

Specifies the **foreign key column** for a relationship.
Used in both `@OneToOne` and `@ManyToOne`.
Example:

```java
@JoinColumn(name = "user_id", nullable = false)
private User userDetails;
```

---

### **`@JoinTable`**

Defines a **mapping table** in many-to-many relationships.
Example:

```java
@JoinTable(
  name = "patient_tests",
  joinColumns = @JoinColumn(name = "patient_id"),
  inverseJoinColumns = @JoinColumn(name = "test_id")
)
```

---

## 🧬 **4. Inheritance and Mapping Overrides**

### **`@MappedSuperclass`**

Used in `BaseEntity`.
Declares that the class provides **common fields** for its subclasses,
but **no table** will be created for it.
Example:

```java
@MappedSuperclass
public abstract class BaseEntity { ... }
```

---

### **`@AttributeOverride`**

Used when you inherit from a superclass and want to **rename a column** in the subclass.
Example (in `Doctor`):

```java
@AttributeOverride(name = "id", column = @Column(name = "doctor_id"))
```

This renames the inherited `id` column to `doctor_id`.

---

## ⏱️ **5. Hibernate-Specific (but Persistence-Related)**

### **`@CreationTimestamp`**

Automatically fills in the field with the timestamp when the record is created.
Example (in `BaseEntity`):

```java
@CreationTimestamp
@Column(name = "created_on")
private LocalDate createdOn;
```

---

### **`@UpdateTimestamp`**

Automatically updates the timestamp when the record changes.
Example:

```java
@UpdateTimestamp
@Column(name = "last_updated")
private LocalDateTime lastUpdated;
```

### **1. `@OneToOne`**

**Purpose:**
Defines a **one-to-one relationship** between two entities.
One entity’s record corresponds to exactly one record in another table.

**Example:**

```java
@Entity
public class User {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "profile_id")  // Foreign key column
    private UserProfile profile;
}
```

Here, each `User` has one `UserProfile`.

---

### **2. `@OneToMany`**

**Purpose:**
Defines a **one-to-many relationship** — one entity is related to many others.

**Example:**

```java
@Entity
public class Department {
    @Id
    private Long id;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
```

A single `Department` can have multiple `Employee` objects.

---

### **3. `@ManyToOne`**

**Purpose:**
Defines a **many-to-one relationship** — many entities relate to one entity.

**Example:**

```java
@Entity
public class Employee {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
```

Many employees belong to one department.

---

### **4. `@ManyToMany`**

**Purpose:**
Defines a **many-to-many relationship**, typically with a **join table**.

**Example:**

```java
@Entity
public class Student {
    @Id
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}
```

A student can take many courses, and a course can have many students.

---

### **5. `@JoinColumn`**

**Purpose:**
Specifies the **foreign key column** in a relationship.

**Example:**

```java
@OneToOne
@JoinColumn(name = "profile_id")
private UserProfile profile;
```

This tells Hibernate which column to use as the join key.

---

### **6. `@JoinTable`**

**Purpose:**
Used in **many-to-many** or sometimes **one-to-many** relationships to specify the **intermediate table**.

**Example:**

```java
@ManyToMany
@JoinTable(
    name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
)
private List<Course> courses;
```
