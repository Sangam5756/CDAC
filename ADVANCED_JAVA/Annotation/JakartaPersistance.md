
### 🧩 **1. `@Entity`**

**Meaning:** Marks a class as a JPA entity — Hibernate will map it to a database table.
**Example:**

```java
@Entity
public class Product { ... }
```

**Why:** Without this, Hibernate ignores the class entirely.

---

### 🧱 **2. `@Table`**

**Meaning:** Specifies the database table name that this entity maps to.
**Example:**

```java
@Table(name = "products")
```

**Why:** By default, Hibernate uses the class name as the table name — this lets you override it.

---

### 🆔 **3. `@Id`**

**Meaning:** Defines the primary key of the entity.
**Example:**

```java
@Id
private Long id;
```

**Why:** Every entity must have one unique identifier for persistence.

---

### 🔢 **4. `@GeneratedValue`**

**Meaning:** Specifies how the primary key is generated (auto, sequence, identity, etc.).
**Example:**

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

**Why:** Lets the database handle ID generation instead of manually setting it.

---

### 💾 **5. `@Column`**

**Meaning:** Customizes mapping between a field and a column in the table.
**Example:**

```java
@Column(name = "product_name", nullable = false, length = 100)
```

**Why:** You can control column names, lengths, nullability, and unique constraints.

---

### 📦 **6. `@Lob`**

**Meaning:** Marks a field as a Large Object (BLOB or CLOB).
**Example:**

```java
@Lob
private byte[] image;
```

**Why:** Used for storing images, videos, or large text files in the DB.

---

### ⏱️ **7. `@Temporal`** *(used with `Date`/`Calendar`)*

**Meaning:** Defines the precision of date/time mapping (DATE, TIME, TIMESTAMP).
**Example:**

```java
@Temporal(TemporalType.DATE)
private Date mfd;
```

**Why:** Converts Java’s `Date` or `Calendar` into the correct SQL type.

---

### 🔗 **8. `@OneToOne`, `@OneToMany`, `@ManyToOne`, `@ManyToMany`**

**Meaning:** Define relationships between entities.
**Example:**

```java
@OneToMany(mappedBy = "product")
private List<Order> orders;
```

**Why:** Used for entity associations — Hibernate automatically handles foreign keys.

---

### 🔒 **9. `@JoinColumn`**

**Meaning:** Specifies the foreign key column name when mapping relationships.
**Example:**

```java
@JoinColumn(name = "category_id")
```

**Why:** Tells Hibernate which column links two tables.

---

### 🧮 **10. `@Enumerated`**

**Meaning:** Defines how Java enums are stored (as name or ordinal).
**Example:**

```java
@Enumerated(EnumType.STRING)
private ProductCategory category;
```

**Why:** Prevents storing enums as numbers that can break when order changes.

---

### 🧰 **11. `@Transient`**

**Meaning:** Marks a field **not to be persisted** in the database.
**Example:**

```java
@Transient
private double tempPrice;
```

**Why:** Used for fields needed only in Java logic, not in DB.

---

### 🗂️ **12. `@Embeddable`** and **`@Embedded`**

**Meaning:** Used to group reusable fields into a separate component.
**Example:**

```java
@Embeddable
public class Address { private String city; private String state; }

@Embedded
private Address address;
```

**Why:** Keeps entity classes clean by reusing value-type components.

