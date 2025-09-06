
---

# 🚀 C++ Exception Handling

**Exception** = a problem that occurs during the execution of a program (e.g., divide by zero, file not found, invalid input).

**Purpose:** Transfer control from the point of error to a handler, without crashing the program.

C++ provides **three main keywords**:

1. **try** – Marks a block of code to monitor for exceptions.
2. **throw** – Used to signal that an exception has occurred.
3. **catch** – Used to handle exceptions.

---

## 1️⃣ Syntax of Try/Catch

```cpp
try {
    // Protected code (may throw exception)
} catch (ExceptionType e1) {
    // Handle exception of type ExceptionType
} catch (ExceptionType e2) {
    // Handle another type of exception
} catch (...) {
    // Handle any exception (catch-all)
}
```

* Multiple `catch` blocks can be used for **different exception types**.
* The `catch(...)` block catches **any exception**.

---

## 2️⃣ Throwing Exceptions

Use `throw` when a problem occurs:

```cpp
#include <iostream>
using namespace std;

double division(int a, int b) {
    if (b == 0) {
        throw "Division by zero condition!";
    }
    return (a / b);
}

int main() {
    try {
        cout << division(10, 2) << endl;  // OK
        cout << division(5, 0) << endl;   // Throws exception
    } catch (const char* e) {
        cout << "Exception caught: " << e << endl;
    }
    return 0;
}
```

✅ Output:

```
5
Exception caught: Division by zero condition!
```

**Explanation:**

* `division(5,0)` → triggers `throw`.
* Program jumps to the **catch block**.
* Program continues safely after the catch.

---

## 3️⃣ Catching Exceptions

* `catch` takes the **type of exception** as a parameter.
* Can catch **int, float, string, or user-defined types**.
* Example:

```cpp
try {
    throw 20;
} catch (int e) {
    cout << "Integer exception: " << e << endl;
}

try {
    throw 3.14;
} catch (double e) {
    cout << "Double exception: " << e << endl;
}
```

---

## 4️⃣ Multiple Catch Blocks

```cpp
try {
    int x = -1;
    if (x == 0)
        throw 0;
    else if (x < 0)
        throw "Negative number!";
} catch (int e) {
    cout << "Integer exception: " << e << endl;
} catch (const char* e) {
    cout << "String exception: " << e << endl;
}
```

✅ Output:

```
String exception: Negative number!
```

---

## 5️⃣ Real-World Use Cases

1. **Division or arithmetic errors** (divide by zero).
2. **File operations** – file not found, permission denied.
3. **Network programming** – connection failed, timeout.
4. **Database operations** – invalid query, connection error.

In companies, **exception handling prevents crashes** and allows the program to **fail gracefully**.

---

## 6️⃣ Interview Questions

**Q1:** What is the difference between exception and error?

* **Error** → problem outside program control (e.g., memory overflow).
* **Exception** → problem that can be handled in code.

**Q2:** Can multiple exceptions be thrown in a try block?

* Yes, multiple `throw` statements are allowed.

**Q3:** What types of exceptions can C++ throw?

* Built-in types: int, float, string
* User-defined types: class objects

**Q4:** Why use exception handling instead of error codes?

* Makes code **cleaner**, **readable**, and **maintainable**.
* Centralizes error handling instead of checking return codes everywhere.

---

✅ **Key Takeaways**

* `try` → protect code that may fail
* `throw` → signal an exception
* `catch` → handle exception safely
* Exception handling = **must in real projects** for **robust and fault-tolerant code**

---
