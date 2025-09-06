
---

# 🚀 C++ Revision Notes – Day 3 (Memory Management Simplified)

---

## 1. What is Memory Management?

👉 Simply: **Memory management = handling computer’s memory smartly.**

* Every program needs memory to store data (variables, arrays, objects).
* If we don’t use it properly, memory can be **wasted** or **leaked**.

📌 Think: memory is like seats in a bus 🚌. If you reserve 50 seats but only 10 people sit, 40 are wasted.

---

## 2. Why Do We Need Memory Management?

* To **save space** → don’t reserve more memory than required.
* To **use memory only when needed** → release it after use.
* To **make programs faster** → unused memory slows performance.

💡 **Company projects**:

* Big servers/apps run for weeks or months → if memory leaks, system crashes.
* Example: Banking, E-commerce → they handle millions of requests → memory must be managed perfectly.

---

## 3. Types of Memory in C++

1. **Stack** (automatic memory)

   * Used for local variables, function calls.
   * Freed automatically when function ends.
   * Example:

     ```cpp
     void fun() {
         int x = 10;  // stored on stack
     } // x is deleted automatically
     ```

2. **Heap** (manual memory)

   * Large pool of unused memory.
   * We can request memory at runtime.
   * Must **manually free** it.
   * Example:

     ```cpp
     int* p = new int;   // heap allocation
     delete p;           // must free
     ```

---

## 4. `new` and `delete`

✅ **new** → allocates memory from heap.
✅ **delete** → frees memory back to heap.

### Example: Single Variable

```cpp
int* p = new int;   // allocate memory
*p = 20;
cout << *p;         // 20
delete p;           // free memory
```

### Example: Array

```cpp
int* arr = new int[5];  // array in heap
for(int i=0; i<5; i++) arr[i] = i*2;
delete[] arr;           // free array
```

⚠️ If you forget `delete` → **memory leak**.

---

## 5. `new` vs `malloc`

| Feature           | `new` (C++) ✅      | `malloc` (C) ❌       |
| ----------------- | ------------------ | -------------------- |
| Returns           | Correct type       | `void*` (needs cast) |
| Calls constructor | ✅ Yes              | ❌ No                 |
| Error handling    | Throws `bad_alloc` | Returns `NULL`       |
| Deallocation      | `delete`           | `free()`             |
| Use in projects   | Preferred          | Legacy (rare)        |

💡 **In real projects** → always use `new/delete` or better **smart pointers**.

---

## 6. Real-World Example (Dynamic Array)

👉 Suppose user enters size at runtime:

```cpp
#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter size: ";
    cin >> n;

    int* arr = new int[n]; // runtime allocation

    for(int i=0; i<n; i++) arr[i] = i + 1;

    for(int i=0; i<n; i++) cout << arr[i] << " ";

    delete[] arr; // free memory
    return 0;
}
```

---

## 7. Interview + Real Company Notes 📝

### Fresher-level Qs:

1. What is difference between stack and heap?
2. Why do we use `new` instead of `malloc`?
3. What happens if we don’t use `delete`?

### Pro-level (Company use cases):

1. **Memory leaks**

   * Happens if you forget `delete`.
   * In long-running apps → huge problem.
   * Companies use tools like **Valgrind** to detect leaks.

2. **Dangling pointer**

   * If you delete memory but still use pointer.

   ```cpp
   int* p = new int(10);
   delete p;
   cout << *p; // ❌ undefined (dangling pointer)
   ```

3. **Smart Pointers (Modern C++)**

   * Avoid manual `delete`.
   * `unique_ptr` → owns memory, auto-deletes when out of scope.
   * `shared_ptr` → shared ownership.
   * Companies prefer this in **C++11+ projects**.

   ```cpp
   #include <memory>
   unique_ptr<int> p1(new int(42));
   cout << *p1;
   ```

---

✅ **Takeaway**:

* Use `new/delete` for dynamic memory.
* Always `delete` what you `new`.
* In real projects, prefer **smart pointers** for safety.



---
## 🚀 C++ Memory Allocation Functions (malloc, calloc, realloc, new)

---

## 🔹 1. `malloc()`

* **Purpose** → Allocate memory at runtime.
* **Syntax** → `void* malloc(size_t size);`
* **Initialization** → Memory **NOT initialized** (contains garbage values).
* **Returns** → `void*` → needs type casting in C++.
* **Example**

  ```cpp
  int* arr = (int*) malloc(10 * sizeof(int)); // 10 ints (garbage values)
  ```

⚠️ Must free using `free(arr);`

---

## 🔹 2. `calloc()`

* **Purpose** → Allocate memory at runtime **with zero initialization**.
* **Syntax** → `void* calloc(size_t num_elements, size_t element_size);`
* **Initialization** → All elements set to **0**.
* **Returns** → `void*` → needs type casting in C++.
* **Example**

  ```cpp
  int* arr = (int*) calloc(10, sizeof(int)); // 10 ints (all = 0)
  ```

⚠️ Must free using `free(arr);`

---

## 🔹 3. `realloc()`

* **Purpose** → Resize an already allocated block of memory.
* **Syntax** → `void* realloc(void* ptr, size_t new_size);`
* **Behavior** →

  * Expands or shrinks memory block.
  * May move block → **pointer can change**.
  * New memory (if expanded) → **NOT initialized**.
* **Example**

  ```cpp
  int* arr = (int*) malloc(10 * sizeof(int));
  arr = (int*) realloc(arr, 20 * sizeof(int)); // resize to 20 ints
  ```

⚠️ Must free using `free(arr);`

---

## 🔹 4. `new` (C++ only)

* **Purpose** → Allocate memory + call **constructor** (for objects).
* **Syntax** →

  ```cpp
  T* p = new T;       // single object
  T* arr = new T[n];  // array of objects
  ```
* **Initialization** → Depends on type:

  * For basic types → garbage (unless explicitly initialized).
  * For objects → constructor runs.
* **Returns** → pointer of correct type (no cast needed).
* **Example**

  ```cpp
  int* arr = new int[10];  // 10 ints
  delete[] arr;            // must delete
  ```


✅ **Takeaway**:

* Use `malloc/calloc/realloc` only in **C** legacy code.
* In **modern C++**, always prefer `new/delete`, or better → `std::vector`, `smart pointers`.
