
---

# 🚀 C++ Templates: Generic Programming

**Templates** allow you to write **generic code**, independent of the data type. They are the foundation of **generic programming** in C++.

There are two main types of templates:

1. **Function Templates**
2. **Class Templates**

---

## 1️⃣ Function Templates

**Function templates** let you write a **single function** that works for **different data types**.

**Example:** Add two numbers of any type (int, float, double):

```cpp
#include <iostream>
using namespace std;

// Function template
template<class T>
T add(T &a, T &b) {
    T result = a + b;
    return result;
}

int main() {
    int i = 2, j = 3;
    float m = 2.3, n = 1.2;

    cout << "Addition of i and j: " << add(i, j) << endl;
    cout << "Addition of m and n: " << add(m, n) << endl;

    return 0;
}
```

✅ Output:

```
Addition of i and j: 5
Addition of m and n: 3.5
```

**Explanation:**

* `template<class T>` → T is a placeholder type.
* `add()` works with any type (int, float, double, etc.).
* Compiler automatically **generates the appropriate version** of `add()`.

**Real-world use:**

* Sorting algorithms (like quicksort) for different data types.
* Generic math or utility functions in company projects.

---

## 2️⃣ Class Templates

**Class templates** let you write a **generic class** that works with **any data type**.

**Syntax:**

```cpp
template<class T>
class ClassName {
    T var1, var2;
    void method();
};
```

**Example:** Generic class to add two numbers:

```cpp
#include <iostream>
using namespace std;

template<class T>
class A {
public:
    T num1 = 5;
    T num2 = 6;

    void add() {
        cout << "Addition of num1 and num2: " << num1 + num2 << endl;
    }
};

int main() {
    A<int> d;   // Instantiate class with int
    d.add();

    A<float> f; // Instantiate class with float
    f.num1 = 2.5; f.num2 = 3.5;
    f.add();

    return 0;
}
```

✅ Output:

```
Addition of num1 and num2: 11
Addition of num1 and num2: 6
```

**Explanation:**

* `template<class T>` → T is a placeholder for the data type.
* When you create `A<int>` → T becomes `int`.
* When you create `A<float>` → T becomes `float`.
* Works **without rewriting the class** for every data type.

**Real-world use:**

* Generic **containers** like `std::vector`, `std::stack`, `std::map`.
* Generic **utility classes** in frameworks and libraries.

---

## 3️⃣ Advantages of Templates

1. **Code Reusability:** Write once, use for any type.
2. **Type Safety:** Unlike void pointers in C, templates are **type-safe**.
3. **Efficiency:** Compiler generates the exact code for each type → **no runtime overhead**.
4. **Real-world Use:** STL (Standard Template Library) in C++ is **entirely template-based**.

---

## 4️⃣ Interview Questions

**Q1:** What is the difference between function template and class template?

* Function template → single generic function.
* Class template → generic class with attributes/methods.

**Q2:** Can a template have multiple types?

* Yes, e.g., `template<class T1, class T2> class A { ... };`

**Q3:** Difference between template and polymorphism?

* Templates → **compile-time generic programming**
* Polymorphism → **runtime behavior change**

**Q4:** Why STL is template-based?

* Because it allows **type-independent containers and algorithms**.

---

✅ **Key Takeaways**

* Templates = foundation of generic programming.
* Function templates = reusable generic functions.
* Class templates = reusable generic classes.
* STL and real-world C++ frameworks rely heavily on **templates**.

---

