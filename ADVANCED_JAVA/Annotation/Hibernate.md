
### ⚙️ **1. `@CreationTimestamp`**

**Meaning:** Automatically sets the field value to the current timestamp when the record is first created.
**Example:**

```java
@CreationTimestamp
private LocalDateTime createdOn;
```

**Why:** Removes the need to manually set created dates in code — Hibernate does it during `persist()`.

---

### 🕒 **2. `@UpdateTimestamp`**

**Meaning:** Automatically updates the timestamp whenever the entity is updated.
**Example:**

```java
@UpdateTimestamp
private LocalDateTime updatedOn;
```

**Why:** Keeps “last modified” times always accurate with zero manual handling.
