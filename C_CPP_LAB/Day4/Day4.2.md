
---

# 🔹 C++ Access Specifiers

Access specifiers define **who can access the members** (attributes and methods) of a class. They control **visibility and encapsulation**, which is key in OOP and real-world software design.

---

## 1️⃣ Public

* **Definition:** Members declared as `public` are accessible **from anywhere**: inside the class, derived classes, and outside the class.
* **Use Case:** Expose functions/attributes that need to be used directly by the user or other classes (like API methods).

**Example:**

```cpp
class MyClass {
public:
    int x;  // public attribute
};

int main() {
    MyClass obj;
    obj.x = 25;  // Allowed
    cout << obj.x; // Allowed
    return 0;
}
```

✅ Real-world analogy: Public members are like **buttons on a machine** – anyone can press them.

---

## 2️⃣ Private

* **Definition:** Members declared as `private` are accessible **only within the class**.
* **Use Case:** Protect sensitive data (e.g., passwords, account balances) or internal logic.
* **Access from outside:** Must use **public methods** (getter/setter) to access private members.

**Example:**

```cpp
class MyClass {
private:
    int y;  // private attribute
public:
    void setY(int val) { y = val; }
    int getY() { return y; }
};

int main() {
    MyClass obj;
    // obj.y = 50; // ❌ Not allowed
    obj.setY(50);   // ✅ Allowed via public method
    cout << obj.getY(); // ✅ Allowed
    return 0;
}
```

✅ Real-world analogy: Private members are like **internal engine parts** – hidden and protected, only accessible through controlled methods.

---

## 3️⃣ Protected

* **Definition:** Members declared as `protected` are **not accessible outside the class**, but **accessible in derived classes**.
* **Use Case:** Useful in inheritance scenarios where derived classes need access to base class attributes but outside code should not.

**Example:**

```cpp
class Base {
protected:
    int z;  // protected attribute
};

class Derived : public Base {
public:
    void setZ(int val) { z = val; } // ✅ Allowed
    int getZ() { return z; }        // ✅ Allowed
};

int main() {
    Derived obj;
    // obj.z = 10; // ❌ Not allowed
    obj.setZ(10);  // ✅ Allowed via public method
    cout << obj.getZ();
    return 0;
}
```

✅ Real-world analogy: Protected members are like **maintenance panels** – accessible to authorized technicians (derived classes), but not the general public.

---

## 4️⃣ Quick Summary Table

| Specifier     | Same Class | Derived Class | Outside Class |
| ------------- | ---------- | ------------- | ------------- |
| **public**    | Yes        | Yes           | Yes           |
| **protected** | Yes        | Yes           | No            |
| **private**   | Yes        | No            | No            |

---

## 5️⃣ Real-World / Company Usage

1. **Encapsulation:** Private + getter/setter methods → protect internal data.
2. **Inheritance:** Protected → allow derived classes to reuse attributes safely.
3. **Public APIs:** Public members → functions/attributes intended for external access.
4. **Security:** Sensitive info (passwords, keys) → always private.

---

## 6️⃣ Interview Questions

**Q1. Default access specifier in C++ class?**
→ `private`.

**Q2. Difference between private and protected?**
→ Private: inaccessible to derived classes.
→ Protected: accessible to derived classes but not outside.

**Q3. Why use access specifiers?**
→ To **control access**, **encapsulate data**, and **protect internal implementation**.

---

