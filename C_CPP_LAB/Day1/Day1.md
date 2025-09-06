
---

# C++ Revision Notes


1. [What is C++?](#what-is-c)
2. [Features of C++](#features-of-c)
3. [First C++ Program](#first-c-program)
4. [`cin` and `cout`](#cin-and-cout)
5. [`using namespace std;`](#using-namespace-std)
6. [Tokens in C++](#tokens-variables--data-types-in-c)

   * Keywords
   * Identifiers
   * Constants
   * Strings
   * Special Symbols
   * Operators
7. [Variables & Initialization](#variables--initialization)
8. [Data Types in C++](#data-types-in-c)

   * Primitive
   * Derived
   * User-defined
   * `sizeof()` operator
9. [Variables, Literals & Constants](#c-variables-literals--constants)
10. [`main()` Function in C++](#main-function-in-c)

    * Overloading `main()`
    * Multiple `main()` functions
    * Valid signatures
    * Is `main()` mandatory?
    * Meaning of `return 0;`
    * Can `main()` be static/inline/virtual?
    * Code before/after `main()`






## What is C++?

* General-purpose, **object-oriented** programming language.
* Designed by **Bjarne Stroustrup (1979)** as an extension of C.
* Supports **imperative, OOP, and generic programming** (via templates).
* Provides **low-level access (memory, pointers)** + **high-level abstraction (classes, objects)**.

---

## Features of C++

1. **Object-Oriented** → Focus on objects, encapsulation, inheritance, polymorphism.
2. **Rich Library (STL)** → Ready-made containers (vector, map, set, etc.).
3. **Fast** → Compiled, close to hardware, used in performance-critical apps.
4. **Compiled Language** → Source → compiled → machine code (faster than interpreted).
5. **Pointer Support** → Direct memory access (unlike Java/Python).
6. **Manual Memory Management** → `new` / `delete` for dynamic allocation.

---

## First C++ Program

```cpp
#include <iostream>
using namespace std;

int main() {
    cout << "Hello World";
    return 0;
}
```

### Notes:

* `using namespace std;` → lets you avoid writing `std::cout`, `std::endl`.
* Without it:

  ```cpp
  std::cout << "Hello World" << std::endl;
  ```

---

## `cin` and `cout`

* **cout** → output stream (prints to console). Uses `<<` (insertion operator).
* **cin** → input stream (takes input). Uses `>>` (extraction operator).

Example:

```cpp
int x;
cin >> x;        // input
cout << x;       // output
```


## `using namespace std;`

* **Namespace** = a container that holds identifiers (like classes, objects, functions) to avoid naming conflicts.
* In C++, standard library features (like `cout`, `cin`, `string`, `vector`) live inside the **`std` namespace**.
* Writing `using namespace std;` lets you use them directly without `std::`.

### Example:

```cpp
#include <iostream>
using namespace std;  // allows direct use of cout, cin

int main() {
    cout << "Hello";   // works directly
}
```

Without it:

```cpp
#include <iostream>

int main() {
    std::cout << "Hello";  // must prefix with std::
}
```

⚠️ **Best practice:** In large projects, avoid `using namespace std;` (can cause conflicts). Instead, use selective usage:

```cpp
using std::cout;
using std::cin;
```

---

# Tokens, Variables & Data Types in C++

## What is a Token?

* **Smallest unit** in a C++ program.
* Types of tokens:

  1. **Keywords**
  2. **Identifiers**
  3. **Constants**
  4. **Strings**
  5. **Special symbols**
  6. **Operators**

---

### 1. Keywords

* Reserved words with special meaning.
* Cannot be used as identifiers.
* Examples: `int`, `float`, `while`, `class`, `return`, etc.

---

### 2. Identifiers

* Names for variables, functions, classes, etc.
* Rules:

  * Start with letter/underscore.
  * Case-sensitive.
  * Cannot be keyword.
  * No spaces/special chars except `_`.

✔ Valid: `student_name`, `myVariable`
❌ Invalid: `int`, `student#`, `my variable`

---

### 3. Constants

* Values that **cannot change** during execution.
* Declared with `const`.

```cpp
const double PI = 3.14159;
```

---

### 4. Strings

* Sequence of characters (text).
* Declared using `string` (needs `<string>` header).

```cpp
string name = "Sangam";
```

---

### 5. Special Symbols

* `&` → address-of
* `*` → multiplication / pointer
* `~` → bitwise NOT
* `#` → preprocessor directive
* `%` → modulus
* `|` → bitwise OR
* `^` → bitwise XOR
* `!` → logical NOT
* `' '` → char literal
* `"` \`" → string literal
* `\` → escape character

---

### 6. Operators

* **Arithmetic**: `+ - * / %`
* **Relational**: `== != > < >= <=`
* **Logical**: `&& || !`
* **Bitwise**: `& | ^ ~ << >>`
* **Assignment**: `= += -= *= /= %= ...`
* **Others**: `sizeof`, `?:`, `,`, etc.

---

## Variables & Initialization

* **Variable** = named storage for data.
* Initialization = giving it a value.

### Syntax

```cpp
datatype variable_name = value;
```

### Types

* **Static init** → value given in code.
* **Dynamic init** → value taken at runtime.

Example:

```cpp
int a = 20;   // static
int b;
cin >> b;     // dynamic
```

---

## Data Types in C++

### 1. Primitive (Built-in)

* `int` → integers (usually 4 bytes)
* `char` → characters (1 byte)
* `bool` → true/false
* `float` → single precision (4 bytes)
* `double` → double precision (8 bytes)
* `void` → no value
* `wchar_t` → wide character (2/4 bytes)

---

### 2. Derived

* **Array**, **Pointer**, **Function**, **Reference**

---

### 3. User-defined

* **Class**, **Struct**, **Union**, **Enum**, **typedef**

---

## `sizeof()` Operator

* Returns size (bytes) of a data type or variable.

```cpp
int m, x[50];
cout << sizeof(m);   // 4 (int size)
cout << sizeof(x);   // 200 (50 * 4)
```

⚠️ Size may vary by compiler/system.

# C++ Variables, Literals & Constants

## Variables

* A **variable** is a named container for storing data.

```cpp
int age = 14;  // age is a variable of type int
```

### Rules for Naming Variables
```
✔ Can use letters, digits, `_`
✔ Cannot start with a digit
✔ Cannot use keywords (`int`, `class`, etc.)
✔ Case-sensitive (`age` ≠ `Age`)
⚠ Can start with `_`, but not recommended
```
---

## Fundamental Data Types

| Data Type | Meaning              | Size (bytes) | Example                 |
| --------- | -------------------- | ------------ | ----------------------- |
| `int`     | Integer              | 2 or 4       | `int salary = 85000;`   |
| `float`   | Floating-point       | 4            | `float area = 64.74;`   |
| `double`  | Double precision FP  | 8            | `double v = 134.64534;` |
| `char`    | Character            | 1            | `char grade = 'A';`     |
| `wchar_t` | Wide character       | 2 / 4        | `wchar_t ch = L'Ω';`    |
| `bool`    | Boolean (true/false) | 1            | `bool flag = true;`     |
| `void`    | No value             | 0            | Used in functions       |

---

## Literals

* **Literal** = fixed value written directly in code.

Types:

* Integer literal → `10`, `-45`
* Floating literal → `3.14`, `-0.99`
* Char literal → `'A'`, `'z'`
* String literal → `"Hello"`
* Boolean literal → `true`, `false`

---

## Constants

* **Immutable values** (cannot change during execution).
* Declared with `const`:

```cpp
const double PI = 3.14159;
```

* Alternative: `#define PI 3.14159` (macro, old style).






## `main()` Function in C++

* **Entry point** of every C++ program.
* Program execution **always starts from `main()`**.

### Syntax:

```cpp
int main() {
    // code
    return 0;
}
```

### Key Points:

* **Return type → `int`** (returns exit status to OS).

  * `return 0;` → successful execution.
  * Non-zero values → error codes.
* **Arguments allowed:**

  * `int main()` → simplest form.
  * `int main(int argc, char* argv[])` → for command-line arguments.

    * `argc` = number of arguments.
    * `argv` = array of strings (arguments).

Example with arguments:

```cpp
int main(int argc, char* argv[]) {
    cout << "Program name: " << argv[0];
    return 0;
}
```

* **Special case:** Some compilers allow `void main()`, but **ISO C++ standard requires `int main()`**.

---

## `main()` in C++ – Interview Notes

### 1. Can `main()` be overloaded?

* **Technically Yes** → You can declare multiple `main()` functions with different parameters (like any other function).
* **But** → Only **one `main()`** serves as the program entry point.
* The linker looks for **exactly one** `int main(...)`. Others won’t be called automatically.

```cpp
#include <iostream>
using namespace std;

int main() {          // Entry point
    cout << "Default main\n";
    return 0;
}

int main(int x) {     // Overloaded, but not entry point
    cout << "Overloaded main with " << x << "\n";
    return 0;
}
```

⚠️ You’d have to call the overloaded one manually from the real `main()`.

---

### 2. Can we have **two `main()` functions**?

* **No**, not in the same program. The linker will throw **“multiple definition of `main`”** error.
* Only **one entry point** is allowed.

---

### 3. Valid signatures of `main()` (ISO C++ standard)

* `int main()`
* `int main(int argc, char* argv[])`
* `int main(int argc, char** argv)` (same as above, different syntax)

Anything else (like `void main()`) is **non-standard** but may work on some compilers (like old Turbo C++).

---

### 4. Is `main()` mandatory in C++?

* **Yes**, unless you’re writing:

  * **library code** (no main, just functions/classes).
  * **embedded systems** (startup code may call something else).
* For normal C++ applications → **mandatory**.

---

### 5. What does `return 0;` mean in `main()`?

* It returns an **exit status** to the OS.
* `0` = success, non-zero = error code.
* Equivalent: `return EXIT_SUCCESS;` or `return EXIT_FAILURE;` (from `<cstdlib>`).

---

### 6. Can `main()` be `static`, `inline`, or `virtual`?

* **No.** The standard forbids it.
* `main()` cannot be declared as:

  * `static`
  * `inline`
  * `virtual`
  * `constexpr`

---

### 7. Can constructors/destructors run before/after `main()`?

* **Yes.**
* Global/static objects are constructed **before `main()` runs**.
* Their destructors run **after `main()` ends**.

Example:

```cpp
#include <iostream>
using namespace std;

struct Test {
    Test()  { cout << "Before main\n"; }
    ~Test() { cout << "After main\n"; }
};

Test obj;  // Global object

int main() {
    cout << "Inside main\n";
    return 0;
}
```

**Output:**

```
Before main
Inside main
After main
```

