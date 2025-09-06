
---

# 🚀 Inheritance in C++

---

## 1️⃣ What is Inheritance?

**Inheritance** is when a **new class (child/derived class)** gets **properties and behaviors (variables and methods)** from an **existing class (parent/base class)**.

* Base class → The “parent” class
* Derived class → The “child” class

**Real-life analogy:**

```
Animal (Base Class)
 ├─ Mammal (Derived Class)
 │   ├─ Dog
 │   └─ Cat
 └─ Bird
     ├─ Sparrow
     └─ Eagle
```

**Key Idea:**
Derived classes **reuse the code** of base classes and **can add new features**.

---

## 2️⃣ Why use Inheritance?

1. **Code Reuse:** Don’t repeat code in multiple classes.
2. **Logical Hierarchy:** Models real-world relationships.
3. **Easy Maintenance:** Change code in base class → affects all derived classes.
4. **Extensibility:** Add new functionality in derived class without touching base class.

**Real-world Project Use:**

* `Employee` (Base) → `Manager`, `Developer`, `HR` (Derived)
* `Vehicle` (Base) → `Car`, `Bike`, `Truck` (Derived)

---

## 3️⃣ Types of Inheritance in C++

C++ allows different **inheritance types based on access specifiers**.

| Access Specifier | Base Class Members in Derived Class       | Example                        |
| ---------------- | ----------------------------------------- | ------------------------------ |
| **Public**       | public → public, protected → protected    | `class Car: public Vehicle`    |
| **Protected**    | public → protected, protected → protected | `class Car: protected Vehicle` |
| **Private**      | public → private, protected → private     | `class Car: private Vehicle`   |

**Key Point:** Private members of base class are **never inherited**, only accessible via **base class methods**.

---

## 4️⃣ Syntax

```cpp
class Base {
    // members
};

class Derived : access-specifier Base {
    // additional members
};
```

* `Derived` → new class
* `Base` → existing class
* `access-specifier` → public / protected / private

---

## 5️⃣ Example: Public Inheritance

```cpp
#include <iostream>
using namespace std;

class Vehicle {
public:
    int wheels;
    void start() {
        cout << "Vehicle started\n";
    }
};

class Car : public Vehicle {
public:
    string brand;
    void showBrand() {
        cout << "Brand: " << brand << endl;
    }
};

int main() {
    Car c;
    c.wheels = 4;       // inherited from Vehicle
    c.brand = "Tesla";  // Car's own attribute

    c.start();          // inherited method
    c.showBrand();      // derived class method
}
```

✅ Output:

```
Vehicle started
Brand: Tesla
```

**Takeaway:** Derived class `Car` **inherits properties** of `Vehicle`.

---

## 6️⃣ Example: Private Inheritance

```cpp
class Vehicle {
public:
    void start() {
        cout << "Vehicle started\n";
    }
};

class Car : private Vehicle {
public:
    void startCar() {
        start(); // can call base method inside derived class
    }
};

int main() {
    Car c;
    // c.start(); // ERROR! private inheritance hides base class method
    c.startCar(); // works
}
```

**Key Idea:**
Private inheritance hides base class methods from objects of derived class.

---

## 7️⃣ Constructors & Inheritance

* **Base class constructor** runs **first**, then derived class constructor.
* This ensures **base class members are initialized first**.

```cpp
class Base {
public:
    Base() { cout << "Base Constructor\n"; }
};

class Derived : public Base {
public:
    Derived() { cout << "Derived Constructor\n"; }
};

int main() {
    Derived d;  
}
```

✅ Output:

```
Base Constructor
Derived Constructor
```

**Interview Point:**
Q: Which constructor runs first in inheritance?
A: Base class constructor runs before derived class constructor.

---

## 8️⃣ Real Project Use Cases

1. **API Wrappers:**

```cpp
class APIClient { /* common methods */ };
class GitHubClient : public APIClient { /* GitHub-specific */ };
class GitLabClient : public APIClient { /* GitLab-specific */ };
```

2. **GUI Components:**

```cpp
class Widget { /* common methods */ };
class Button : public Widget { /* Button-specific */ };
class Label : public Widget { /* Label-specific */ };
```

3. **Database Models:**

```cpp
class Employee { /* common fields */ };
class Manager : public Employee { /* manager fields */ };
class Developer : public Employee { /* developer fields */ };
```

---

## 9️⃣ Interview Notes

**Q1. What is inheritance?**

* Mechanism to **reuse code** from base class in derived class.

**Q2. Types of inheritance access?**

* Public, Private, Protected

**Q3. Can private members be inherited?**

* No. Accessible via base class methods only.

**Q4. Default inheritance in C++ class?**

* Private

**Q5. Why inheritance is important in real projects?**

* Models hierarchy, reduces code repetition, easier maintenance.

**Q6. What runs first: base or derived constructor?**

* Base constructor runs first.

---

✅ **Takeaways**

* Inheritance = **code reuse + hierarchical design**
* **Access specifiers** change visibility of inherited members
* Used in **real-world projects** everywhere: API clients, GUI, database models, services
---


# 🚀 Types  Inheritance in C++ 

Inheritance allows a **derived class** to **reuse code** from a **base class**, and there are several types of inheritance in C++.

---

## 1️⃣ Single Inheritance

* **Definition:** One derived class inherits from **one base class**.
* **Syntax:**

```cpp
class Base {
public:
    void greet() { cout << "Hello from Base\n"; }
};

class Derived : public Base {
public:
    void greetDerived() { cout << "Hello from Derived\n"; }
};

int main() {
    Derived d;
    d.greet();         // Base method
    d.greetDerived();  // Derived method
}
```

**Diagram:**

```
Base
  |
Derived
```

✅ Real project use:

* `Employee` → `Manager`

---

## 2️⃣ Multiple Inheritance

* **Definition:** One derived class inherits from **more than one base class**.
* **Syntax:**

```cpp
class Base1 {
public:
    void show1() { cout << "Base1\n"; }
};

class Base2 {
public:
    void show2() { cout << "Base2\n"; }
};

class Derived : public Base1, public Base2 {
};

int main() {
    Derived d;
    d.show1();  // Base1 method
    d.show2();  // Base2 method
}
```

**Diagram:**

```
Base1    Base2
   \      /
    Derived
```

✅ Real project use:

* A class that combines **API features** from multiple sources.

⚠ **Caution:** Diamond problem may occur (see below).

---

## 3️⃣ Multilevel Inheritance

* **Definition:** A chain of inheritance, like **grandparent → parent → child**.
* **Syntax:**

```cpp
class Grandparent {
public:
    void greet() { cout << "Hello from Grandparent\n"; }
};

class Parent : public Grandparent {
public:
    void greetParent() { cout << "Hello from Parent\n"; }
};

class Child : public Parent {
public:
    void greetChild() { cout << "Hello from Child\n"; }
};

int main() {
    Child c;
    c.greet();         // Grandparent
    c.greetParent();   // Parent
    c.greetChild();    // Child
}
```

**Diagram:**

```
Grandparent
     |
   Parent
     |
   Child
```

✅ Real project use:

* `UIElement` → `Widget` → `Button`

---

## 4️⃣ Hierarchical Inheritance

* **Definition:** **Multiple derived classes inherit from the same base class**.
* **Syntax:**

```cpp
class Base {
public:
    void show() { cout << "Base\n"; }
};

class Derived1 : public Base {
public:
    void show1() { cout << "Derived1\n"; }
};

class Derived2 : public Base {
public:
    void show2() { cout << "Derived2\n"; }
};

int main() {
    Derived1 d1;
    Derived2 d2;
    d1.show();  // Base
    d2.show();  // Base
}
```

**Diagram:**

```
       Base
      /    \
Derived1   Derived2
```

✅ Real project use:

* `Employee` → `Manager`, `Developer`, `HR`

---

## 5️⃣ Hybrid Inheritance

* **Definition:** Combination of **two or more types of inheritance**.
* **Syntax:**

```cpp
class A {
public:
    void showA() { cout << "A\n"; }
};

class B : public A {
public:
    void showB() { cout << "B\n"; }
};

class C : public A {
public:
    void showC() { cout << "C\n"; }
};

class D : public B, public C {
public:
    void showD() { cout << "D\n"; }
};

int main() {
    D obj;
    // obj.showA(); // ERROR! Diamond problem
    obj.showB();
    obj.showC();
    obj.showD();
}
```

**Diagram (Diamond Problem):**

```
      A
     / \
    B   C
     \ /
      D
```

⚠ **Diamond Problem:**

* Multiple inheritance creates ambiguity when **same base class exists through multiple paths**.
* **Solution:** Use **virtual inheritance**.

```cpp
class A { public: int x; };
class B : virtual public A {};
class C : virtual public A {};
class D : public B, public C {};
```

---

## 6️⃣ Access Specifiers in Inheritance

| Inheritance Type | Public Members in Derived | Protected Members in Derived |
| ---------------- | ------------------------- | ---------------------------- |
| Public           | Public                    | Protected                    |
| Protected        | Protected                 | Protected                    |
| Private          | Private                   | Private                      |

**Example:**

```cpp
class Base {
public: int a;
protected: int b;
private: int c;
};

class Derived : public Base {
    void show() {
        cout << a << b; // OK
        // cout << c;   // ERROR! private
    }
};
```

---

## 7️⃣ Constructor & Inheritance

* **Order of Constructor Calls:**

  1. Base class constructor
  2. Derived class constructor

```cpp
class Base { public: Base() { cout << "Base\n"; } };
class Derived : public Base { public: Derived() { cout << "Derived\n"; } };

int main() { Derived d; }
```

✅ Output:

```
Base
Derived
```

* **Destructor Order:** Reverse

  * Derived → Base

---

## 8️⃣ Real Project Use Cases

* **Single Inheritance:** `Employee` → `Manager`
* **Multiple Inheritance:** `Car` inherits from `Engine` and `Wheels`
* **Multilevel:** `UIElement` → `Widget` → `Button`
* **Hierarchical:** `Employee` → `Manager`, `Developer`, `HR`
* **Hybrid:** Combines above, e.g., multiple roles in a system

---

## 9️⃣ Interview Q\&A

**Q1. What is inheritance?**

* Reuse properties/methods from a base class.

**Q2. Types of inheritance?**

* Single, Multiple, Multilevel, Hierarchical, Hybrid

**Q3. What is the diamond problem?**

* Ambiguity when the same base class is inherited multiple times.

**Q4. How to solve diamond problem?**

* Use **virtual inheritance**.

**Q5. Default access specifier for class inheritance?**

* `private`

**Q6. Order of constructor/destructor calls?**

* Constructor: Base → Derived
* Destructor: Derived → Base

---

✅ **Takeaways**

* Inheritance = **code reuse + hierarchy modeling**
* Use **virtual inheritance** to solve diamond problem
* Access specifiers change **visibility** in derived class
* Widely used in **real projects** for modeling employees, APIs, GUI components, DB entities


