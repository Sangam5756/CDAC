### 🧾 **1. `@Getter`**

**Meaning:** Generates a getter method for each field at compile time.
**Example:**

```java
@Getter
public class User {
    private String name;
}
```

**Result:** Automatically generates:

```java
public String getName() { return name; }
```

---

### 🧾 **2. `@Setter`**

**Meaning:** Generates setter methods for all non-final fields.
**Example:**

```java
@Setter
public class User {
    private String name;
}
```

**Result:**

```java
public void setName(String name) { this.name = name; }
```

---

### 🏗️ **3. `@NoArgsConstructor`**

**Meaning:** Generates a **no-argument constructor** (empty constructor).
**Example:**

```java
@NoArgsConstructor
public class User { ... }
```

**Why:** JPA needs a public or protected no-arg constructor for entity instantiation.

---

### 🏗️ **4. `@AllArgsConstructor`**

**Meaning:** Generates a constructor with **all fields as parameters**.
**Example:**

```java
@AllArgsConstructor
public class User { ... }
```

**Result:** A full constructor with every field — handy for testing or DTOs.

---

### 🏗️ **5. `@RequiredArgsConstructor`**

**Meaning:** Generates a constructor for **final** and **@NonNull** fields only.
**Example:**

```java
@RequiredArgsConstructor
public class User {
    @NonNull private String name;
    private int age;
}
```

**Result:** Constructor will only include `name`, because it’s marked `@NonNull`.

---

### 🧠 **6. `@ToString`**

**Meaning:** Generates a `toString()` method automatically.
**Example:**

```java
@ToString(exclude = {"password"})
public class User { ... }
```

**Why:** You can exclude sensitive or recursive fields to avoid printing them.

---

### 🧩 **7. `@EqualsAndHashCode`**

**Meaning:** Generates `equals()` and `hashCode()` methods.
**Example:**

```java
@EqualsAndHashCode(of = "email")
public class User { ... }
```

**Why:** Ensures logical equality — for entities, base it on business keys like email or ID.

---

### 🧙‍♂️ **8. `@Data`**

**Meaning:** A mega-annotation — bundles `@Getter`, `@Setter`, `@RequiredArgsConstructor`, `@ToString`, and `@EqualsAndHashCode`.
**Example:**

```java
@Data
public class User {
    private String name;
    private String email;
}
```

**Why:** Simplifies most model classes — perfect for DTOs, less so for JPA entities (you often need finer control there).
