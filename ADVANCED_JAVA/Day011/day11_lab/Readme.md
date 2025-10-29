
## 🧾 **Hibernate Image Upload & Restore + Lombok & Annotations**

### **📘 Overview**

Today’s work focused on two main concepts:

1. Handling **images (BLOBs)** in Hibernate using file I/O.
2. Using **Lombok annotations** to reduce boilerplate code in entity classes.

---

### **1. Hibernate Image Upload**

**Goal:** Read an image from disk and store it in DB as a byte array.

```java
public String uploadImage(Long productId, String filePath)
```

**Logic:**

* Start Hibernate session + transaction.
* Find product using `session.find(Product.class, productId)`.
* Read image using:

  ```java
  byte[] data = FileUtils.readFileToByteArray(new File(filePath));
  ```
* Set `product.setImage(data)` and commit.

**Remember:**

* Use `@Lob` for the image field.
* Always commit or rollback the transaction.
* Path must be valid (use `C:/path/image.jpg` or escaped backslashes).

---

### **2. Hibernate Image Restore**

**Goal:** Retrieve image bytes from DB and save back to file.

```java
public String restoreImage(String email, String path)
```

**Logic:**

* Start session + transaction.
* Query product by email using JPQL:

  ```java
  select p from Product p where p.email = :em
  ```
* If image exists → write to file:

  ```java
  FileUtils.writeByteArrayToFile(new File(path), p.getImage());
  ```
* Commit and return message.

---

### **3. Lombok in Entity Classes**

**Why Lombok?**
Lombok removes boilerplate code like getters, setters, constructors, and `toString()` methods.

**Common Annotations:**

```java
@Data          // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder       // allows object creation using builder pattern
```

**Example:**

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodId;

    private String name;
    private String email;

    @Lob
    private byte[] image;
}
```

Lombok keeps the class clean and easy to maintain, especially when entities have many fields.

---

### **4. Key Hibernate Annotations Recap**

| Annotation                | Purpose                                            |
| ------------------------- | -------------------------------------------------- |
| `@Entity`                 | Marks class as Hibernate entity (maps to table)    |
| `@Id`                     | Marks primary key field                            |
| `@GeneratedValue`         | Auto-generates primary key values                  |
| `@Lob`                    | Marks field for large binary/text data (BLOB/CLOB) |
| `@Column`                 | Customizes column mapping (optional)               |
| `@Table(name="products")` | Maps entity to specific DB table                   |

---

### **🧠 Concepts Practiced**

* File handling with `FileUtils`
* Byte array conversion (`readFileToByteArray`, `writeByteArrayToFile`)
* Transactions (`tx.commit()` / `tx.rollback()`)
* Entity mappings and persistence lifecycle
* Lombok annotations for cleaner code

