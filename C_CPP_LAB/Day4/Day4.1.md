
---

# 🔹 C++ Access Control and Inheritance

In C++, **access specifiers** (`public`, `protected`, `private`) define **who can access the members** of a class. When combined with inheritance, they determine **visibility in derived classes**.

---

## 1️⃣ Access Table

| Access Specifier | Same Class | Derived Class | Outside Class |
| ---------------- | ---------- | ------------- | ------------- |
| **public**       | Yes        | Yes           | Yes           |
| **protected**    | Yes        | Yes           | No            |
| **private**      | Yes        | No            | No            |

**Explanation:**

* `public` → open for everyone.
* `protected` → accessible **only in the class and derived classes**, hidden from outside.
* `private` → accessible **only in the class itself**, not even derived classes can access directly.

✅ **Tip for projects:** Keep members `private` if you don’t want derived classes to modify them directly. Use **getter/setter methods** to expose safe access.

---

## 2️⃣ Base Class Members Not Inherited

Derived classes **cannot directly access**:

1. Constructors, destructors, copy constructors
2. Overloaded operators of the base class
3. Friend functions of the base class

---

## 3️⃣ Types of Inheritance with Access Control

When you write `class Derived : <access> Base`, the `<access>` determines **how members of the base class appear in the derived class**.

---

### 🔹 3.1 Public Inheritance

* **Rule:**

  * Base `public` → Derived `public`
  * Base `protected` → Derived `protected`
  * Base `private` → Not accessible

**Example:**

```cpp
class Base {
public: int a;
protected: int b;
private: int c;
};

class Derived : public Base {
    void show() {
        cout << a; // OK, public remains public
        cout << b; // OK, protected remains protected
        // cout << c; // ERROR, private not accessible
    }
};
```

**Diagram:**

```
Base: a(public), b(protected), c(private)
Derived: a(public), b(protected)
```

✅ Most commonly used in **company projects**.

---

### 🔹 3.2 Protected Inheritance

* **Rule:**

  * Base `public` → Derived `protected`
  * Base `protected` → Derived `protected`
  * Base `private` → Not accessible

**Example:**

```cpp
class Derived : protected Base {
    void show() {
        cout << a; // OK, public becomes protected
        cout << b; // OK
        // cout << c; // ERROR
    }
};
```

**Diagram:**

```
Base: a(public), b(protected), c(private)
Derived: a(protected), b(protected)
```

✅ Rarely used, sometimes in **library design** to restrict external access.

---

### 🔹 3.3 Private Inheritance

* **Rule:**

  * Base `public` → Derived `private`
  * Base `protected` → Derived `private`
  * Base `private` → Not accessible

**Example:**

```cpp
class Derived : private Base {
    void show() {
        cout << a; // OK, public becomes private
        cout << b; // OK, protected becomes private
        // cout << c; // ERROR
    }
};
```

**Diagram:**

```
Base: a(public), b(protected), c(private)
Derived: a(private), b(private)
```

✅ Rarely used, usually for **implementation hiding**, like a class using another class internally without exposing it.

---

## 4️⃣ Key Takeaways

1. **Derived classes can only access `public` and `protected` members of base class.**
2. **Private members of base class are hidden**, but can be accessed via **public/protected functions** of base class.
3. **Inheritance type controls visibility:**

   * Public → use in APIs
   * Protected → restrict external access
   * Private → hide implementation
4. **Constructors, destructors, operators, friends are never inherited directly.**
5. In **real projects**, public inheritance is most common. Protected/private inheritance is used for **internal module design** or **helper classes**.

---

## 5️⃣ Interview Questions

**Q1. Can a derived class access private members of base class?**
→ No, but it can access them via public/protected member functions of base class.

**Q2. Difference between public, protected, private inheritance?**
→ Controls visibility of base class members in derived class.

**Q3. Why use protected/private inheritance?**
→ To **hide implementation details** from external classes.

**Q4. Are constructors/destructors inherited?**
→ No, they are **not inherited**, but **base class constructor is called automatically**.

---
