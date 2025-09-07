
---

## Important Notes

### 1. Compilation

* **Always compile all `.cpp` files**, not just `main.cpp`.
* Otherwise, you’ll get linker errors for undefined references.

### 2. Memory Management

* `new HRDepartment()` and `new FinanceDepartment()` allocate objects on the **heap**.
* You **must call `delete`** on each object to free memory.
* Forgetting to delete → **memory leak**.
* Deleting twice → **double delete**, undefined behavior (crash or corruption).
* Exceptions before cleanup → memory leaks remain.

---

### 3. Why `unique_ptr` is Better

- `std::unique_ptr<Department>` owns **exactly one heap object**.
- When it goes out of scope (e.g., `vector` destroyed), it automatically deletes the object → **RAII safety**.
- No manual `delete` → fewer bugs.
- Prevents copying → ownership is clear.
- Raw pointer = powerful but dangerous; `unique_ptr` makes ownership safe.

---

### 4. Why We Use `virtual` Functions in C++

#### Without `virtual` (compile-time binding)

```cpp
class Department {
public:
    void display() { cout << "Base Department\n"; }
};

class HRDepartment : public Department {
public:
    void display() { cout << "HR Department\n"; }
};

Department* dept = new HRDepartment();
dept->display();  // prints: Base Department ❌
```

- **Reason:** Compiler uses the pointer type (`Department*`) to resolve calls.

#### With `virtual` (runtime polymorphism)

```cpp
class Department {
public:
    virtual void display() { cout << "Base Department\n"; }
};

class HRDepartment : public Department {
public:
    void display() override { cout << "HR Department\n"; }
};

Department* dept = new HRDepartment();
dept->display();  // prints: HR Department ✅
```

- Resolved at **runtime** based on actual object type → **dynamic dispatch**.

#### Java Comparison

- In Java, non-static, non-final methods are **virtual by default**:

```java
Department dept = new HRDepartment();
dept.display(); // prints HR Department
```

- No `virtual` keyword needed.

---

### 5. Common C++ Pitfalls

#### Object Slicing

```cpp
Department* dept = new Department[3]; // array of Department objects
Department* d = new HRDepartment();
dept[0] = d; // ❌ object slicing
dept[0].display(); // only calls Department::display
```

- **Array of objects** stores only the **base part**, losing derived members.
- Polymorphism works only with **pointers or references**.

#### Correct Approach: Array of Pointers

```cpp
Department* dept[3];
dept[0] = new HRDepartment();
dept[0]->display(); // calls HRDepartment::display
delete dept[0];
```

#### Modern Approach: `unique_ptr`

```cpp
std::vector<std::unique_ptr<Department>> departments;
departments.push_back(std::make_unique<HRDepartment>());
departments[0]->display(); // polymorphic, safe
```

---

### 6. Downcasting & RTTI

```cpp
Department* dept = new HRDepartment();
auto hr = dynamic_cast<HRDepartment*>(dept);
if(hr) hr->conductInterviews();
```

- Needed when calling **derived-specific methods** not in base.
- Safer than `static_cast` because it checks the **actual object type** at runtime.
- Avoid downcasting if you can redesign the base class with **virtual methods** for common actions.

---

### 7. Interview-Friendly Takeaways

1. Object slicing occurs when storing derived objects in a base object array.
2. `virtual` is required in C++ for runtime polymorphism; in Java it’s default.
3. Always use `virtual` destructors when deleting derived objects through base pointers.
4. Prefer pointers (raw or smart) for polymorphic storage.
5. `unique_ptr` + RAII reduces memory bugs and simplifies ownership.

---

### Mnemonic

- **C++:** explicit `virtual`
- **Java:** implicit virtual

---
