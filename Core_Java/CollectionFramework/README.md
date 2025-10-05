
# 🛒 HashMap Practice — Product Management Demo

This project demonstrates **HashMap operations in Java** using a `Product` entity.


---

## 🚀 Features Demonstrated

### 1️⃣ **Entity: Product**

* Represents a product with:

  * `id`
  * `name`
  * `price`
  * `isAvailable`
* Implements `Comparable<Product>` for **natural ordering by ID**.

### 2️⃣ **Creating and Populating the Map**

```java
HashMap<Integer, Product> products = new HashMap<>();
products.put(201, new Product(201, "mouse", 100, true));
```

Each key is a product ID, and the value is a `Product` object.

---

## 🔄 CRUD Operations

### 🧾 **Display All**

```java
products.forEach((k, v) -> System.out.println(k + " → " + v));
```

### ❌ **Remove Unavailable Products**

```java
products.entrySet().removeIf(entry -> !entry.getValue().isAvailable());
```

### ➕ **Add New Product**

```java
products.put(999, new Product(999, "newItem", 250, true));
```

### 🗑️ **Remove by Key**

```java
products.remove(201);
```

---

## 📊 Sorting

### 🧭 **Natural Order (by ID)**

Implemented via `Comparable<Product>`:

```java
@Override
public int compareTo(Product other) {
    return Integer.compare(this.id, other.id);
}
```

Sorting:

```java
List<Product> list = new ArrayList<>(products.values());
Collections.sort(list);
```

### 💰 **Sort by Price**

```java
products.values().stream()
    .sorted((p1, p2) -> Integer.compare(p1.getPrice(), p2.getPrice()))
    .forEach(System.out::println);
```

---

## 🔍 Searching

### ✅ **Using Java Streams**

```java
Optional<Product> result = products.values().stream()
    .filter(p -> p.getName().equals("mouse"))
    .findFirst();
```

### 🧠 **Handle Search Result**

```java
result.ifPresentOrElse(
    System.out::println,
    () -> System.err.println("❌ Product not found")
);
```

### 🔁 **Using Traditional Loop**

```java
for (Product p : products.values()) {
    if (p.getName().equals("mouse")) {
        System.out.println(p);
        break;
    }
}
```

---

## 🏆 Finding Max & Min

### 💸 **Highest-Priced Product**

```java
products.values().stream()
    .max(Comparator.comparingInt(Product::getPrice))
    .ifPresent(System.out::println);
```

### 💴 **Lowest-Priced Product**

```java
products.values().stream()
    .min(Comparator.comparingInt(Product::getPrice))
    .ifPresent(System.out::println);
```

---

## 🧩 Notes & Best Practices

| Concept                | Tip                                                         |
| ---------------------- | ----------------------------------------------------------- |
| `HashMap`              | Unordered — use `TreeMap` if you want sorted by keys        |
| `Comparable`           | Define natural order in the entity class                    |
| `Comparator`           | Use when sorting dynamically by other fields                |
| `Optional`             | Avoids `NullPointerException` while handling search results |
| `removeIf()`           | Clean and efficient for filtering in-place                  |
| `System.err.println()` | Useful for logging errors distinctly                        |

---

## 🧠 Summary

This mini-project demonstrates:

* ✅ Full HashMap lifecycle
* ✅ Clean functional-style Java with Streams
* ✅ Robust error handling with `Optional`
* ✅ Sorting & searching patterns you’ll use in real projects

