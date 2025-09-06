
---

# 🔹 Virtual Functions in C++

A **virtual function** is a **member function in a base class** that you expect to **override in derived classes**.

> When you call a virtual function through a **base class pointer/reference**, C++ ensures that the **derived class version** is executed — this is **runtime polymorphism**.

---

## 1️⃣ Key Points

1. Declared using the **`virtual`** keyword in the base class.
2. Achieves **runtime (dynamic) polymorphism**.
3. Must be a **non-static member function**.
4. Can be a **friend function**.
5. Signature (parameters & return type) must be **same in base & derived class**.
6. **Virtual destructor** can exist, but **virtual constructor** cannot.

---

## 2️⃣ Syntax & Example

```cpp
#include <iostream>
using namespace std;

class Base {
public:
    virtual void print() { 
        cout << "Base class print\n"; 
    }
    
    void show() { 
        cout << "Base class show\n"; 
    }
};

class Derived : public Base {
public:
    void print() { 
        cout << "Derived class print\n"; 
    }
    
    void show() { 
        cout << "Derived class show\n"; 
    }
};

int main() {
    Base* bptr;     // Base class pointer
    Derived d;      // Derived object
    bptr = &d;      // Point to derived object

    bptr->print();  // Virtual function → Derived version called (runtime)
    bptr->show();   // Non-virtual function → Base version called (compile-time)

    return 0;
}
```

✅ Output:

```
Derived class print
Base class show
```

---

## 3️⃣ How It Works

| Function Type        | Called Version      | Binding Time      |
| -------------------- | ------------------- | ----------------- |
| Virtual (`print`)    | Derived (if exists) | Runtime (dynamic) |
| Non-virtual (`show`) | Base                | Compile-time      |

* **Pointer of base class** can point to **base or derived objects**.
* If a derived class overrides a virtual function, **that version is called at runtime**, even if the pointer is of base type.
* Non-virtual functions are **statically bound** at compile time.

---

## 4️⃣ Real-World Analogy

Think of a **Media Player app**:

```cpp
class Media {
public:
    virtual void play() { cout << "Playing generic media\n"; }
};

class Audio : public Media {
public:
    void play() { cout << "Playing audio file\n"; }
};

class Video : public Media {
public:
    void play() { cout << "Playing video file\n"; }
};
```

* `Media* m;` → points to **Audio or Video** objects.
* Calling `m->play()` **executes the correct version automatically** at runtime.
* This is exactly how **polymorphism in games, UI frameworks, and APIs** works in real company projects.

---

## 5️⃣ Important Notes

1. **Runtime Polymorphism is possible only with pointers or references** of base class type.
2. Base class pointer can point to **any derived class object**.
3. Virtual functions can **prevent slicing** of derived objects when using base class references.
4. Always use **virtual destructors** in base classes if your class is **meant for inheritance**.

```cpp
class Base {
public:
    virtual ~Base() { cout << "Base destructor\n"; }
};
```

---

## 6️⃣ Interview Questions

**Q1. What is a virtual function?**
→ A function in a base class that can be **overridden in derived class** and is resolved at **runtime**.

**Q2. Difference between virtual and non-virtual function?**

* Virtual → dynamic binding, allows derived class override
* Non-virtual → static binding, always base class version called

**Q3. Can constructors be virtual?**
→ **No**, constructors cannot be virtual. Use virtual destructors instead.

**Q4. Why use virtual destructors?**
→ To ensure **derived class destructors are called** when deleting a derived object via a base pointer. Prevents memory leaks in real projects.

---

💡 **Takeaway for Company Projects**

* Virtual functions are **core to polymorphism** in large systems.
* Used heavily in **frameworks, APIs, plugin systems, GUI, game engines**.
* Always plan **destructor hierarchy** with virtual destructors when working with polymorphic base classes.

---


## 1️⃣ Run-Time Polymorphism

**Polymorphism**: Means “many forms”.
**Run-time polymorphism** happens when **the function to be called is determined at runtime** (not compile-time).

* Achieved using **virtual functions** in C++.
* Base class pointer/reference can point to **derived objects**, and the **correct derived function** is executed.

**Example:**

```cpp
#include <iostream>
using namespace std;

class Base {
public:
    virtual void show() { cout << "Base show\n"; }
};

class Derived : public Base {
public:
    void show() { cout << "Derived show\n"; }
};

int main() {
    Base* b = new Derived();
    b->show();  // Derived's show() called → runtime polymorphism
}
```

✅ Output:

```
Derived show
```

---

## 2️⃣ Virtual Functions

* Declared using the **`virtual`** keyword.
* Allow **derived class overriding**.
* **Dynamic binding** occurs at runtime.
* Non-virtual functions are **statically bound** at compile-time.

**Key Notes:**

* Cannot be `static`.
* Prototype must be **same** in derived class.
* Use **virtual destructors** for proper cleanup.

---

## 3️⃣ Pure Virtual Functions & Abstract Classes

* A **pure virtual function** has **no body** and is declared with `= 0`.
* A class with **at least one pure virtual function** becomes an **abstract class**.
* Abstract classes **cannot be instantiated**.
* They are used to **define interfaces**.

**Example:**

```cpp
class Shape {
public:
    virtual void draw() = 0;  // pure virtual → makes Shape abstract
};

class Circle : public Shape {
public:
    void draw() { cout << "Drawing Circle\n"; }
};

int main() {
    // Shape s; → ERROR: cannot instantiate abstract class
    Shape* s = new Circle();
    s->draw();  // OK: Circle's draw() called
}
```

✅ Output:

```
Drawing Circle
```

---

## 4️⃣ RTTI (Run-Time Type Information)

* Allows **type checking of objects at runtime**.
* Available **only for classes with at least one virtual function**.

### 4a. Upcasting

* Derived → Base pointer/reference.
* **Safe**, always allowed.

### 4b. Downcasting

* Base → Derived pointer/reference.
* **Not always safe**, use `dynamic_cast` to check at runtime.

```cpp
Base* b = new Derived();
Derived* d = dynamic_cast<Derived*>(b);  // OK if b actually points to Derived
if(d) d->show();
```

* If cast fails → `dynamic_cast` returns **nullptr** for pointers.

---

## 5️⃣ Type of Casting in C++

| Cast Type          | Purpose                              |
| ------------------ | ------------------------------------ |
| `dynamic_cast`     | Runtime-checked cast (safe downcast) |
| `static_cast`      | Compile-time cast, no runtime check  |
| `const_cast`       | Remove/add constness                 |
| `reinterpret_cast` | Low-level cast, unsafe (bit-level)   |

---

## 6️⃣ Interfaces

* Achieved in C++ using **abstract classes with only pure virtual functions**.
* Example in real projects: **Database drivers, plugin systems, service APIs**.

```cpp
class IDatabase {
public:
    virtual void connect() = 0;
    virtual void query(string sql) = 0;
};
```

* Any derived class **must implement all pure virtual methods** to be instantiable.

---

## 7️⃣ Lab/Real Project Notes

1. Implement a **Shape hierarchy** using abstract classes and virtual functions.
2. Use **dynamic\_cast** to safely convert base pointers to derived types.
3. Design **interfaces** for reusable code in company projects (e.g., logging, DB access, payment gateway).
4. Ensure **virtual destructors** to prevent memory leaks in polymorphic classes.

---

## 8️⃣ Interview Questions

**Q1:** What is the difference between virtual and pure virtual function?
→ Virtual function may have a body; pure virtual function has `=0` and makes the class abstract.

**Q2:** Can we create an object of an abstract class?
→ No, but pointers/references can be used to derived objects.

**Q3:** Why use `dynamic_cast`?
→ To safely convert **base pointer to derived pointer** at runtime. Returns nullptr if invalid.

**Q4:** What is RTTI in C++?
→ Runtime Type Information; allows the **type of object to be determined at runtime** using `typeid` or `dynamic_cast`.

---

✅ **Key Takeaways**

* **Virtual functions** → runtime polymorphism
* **Pure virtual functions** → abstract classes → interfaces
* **RTTI & dynamic\_cast** → safe downcasting
* Abstract classes are widely used for **interfaces in real-world C++ projects**.

---
