
---

# 🚀 C++ Revision Notes – Day 2 (Functions)


1. [What is a Function?](#what-is-a-function)
2. [Create & Call a Function](#create--call-a-function)
3. [Parameters & Arguments](#parameters--arguments)
4. [Default Parameters](#default-parameters)
5. [Passing Arrays to Functions](#passing-arrays-to-functions)
6. [Interview Quick Notes](#interview-quick-notes)

---

## 1.What is a Function?

* A **block of code** that runs **only when called**.
* Helps in **code reusability** (write once, use many times).
* Can take **parameters (input)** and can return a **value**.

---

## 2. Create & Call a Function

### Syntax:

```cpp
void myFunction() {
  // code
}
```

### Example:

```cpp
#include <iostream>
using namespace std;

void myFunction() {
  cout << "I just got executed!";
}

int main() {
  myFunction();   // calling
  return 0;
}
```

✅ Output → `I just got executed!`

---

## 3. Parameters & Arguments

* **Parameter** = variable in function definition.
* **Argument** = actual value passed when calling.

### Example:

```cpp
void greet(string name) {
  cout << "Hello " << name << "!\n";
}

int main() {
  greet("Ram");   // Argument = "Ram"
  greet("Ritu");  // Argument = "Ritu"
}
```

✅ Output →

```
Hello Ram!
Hello Ritu!
```

---

## 4. Default Parameters

* If no argument is passed, default value is used.

```cpp
void myFunction(string country = "India") {
  cout << country << "\n";
}

int main() {
  myFunction("Sweden"); // Sweden
  myFunction();         // India (default)
}
```

---

## 5. Passing Arrays to Functions

```cpp
void printArray(int arr[5]) {
  for (int i = 0; i < 5; i++) {
    cout << arr[i] << " ";
  }
}

int main() {
  int nums[5] = {10, 20, 30, 40, 50};
  printArray(nums);
}
```

✅ Output → `10 20 30 40 50`

---

## 6. Interview Quick Notes

* Functions can return values → return type **not always void**.
* Functions can be **overloaded** (same name, different parameters).
* Functions can have **default arguments** (from rightmost side only).
* Arrays are always passed as **reference (pointer)**, not copied.
* Inline functions improve performance by avoiding function call overhead.

