
---

# 🔹Getters And Setters Accessing Private Members in C++ (Encapsulation)

In C++, **private members** of a class **cannot be accessed directly** from outside the class. To allow controlled access, we use **getter** and **setter** methods.

---

## 1️⃣ Example: Employee Salary

```cpp
#include <iostream>
using namespace std;

class Employee {
private:
    int salary;  // Private attribute

public:
    // Setter method: sets the salary
    void setSalary(int s) {
        salary = s;
    }

    // Getter method: retrieves the salary
    int getSalary() {
        return salary;
    }
};

int main() {
    Employee emp;
    emp.setSalary(50000);         // Set salary using setter
    cout << emp.getSalary();      // Get salary using getter
    return 0;
}
```

✅ Output:

```
50000
```

---

## 2️⃣ How It Works

1. **Private attribute:** `salary` cannot be accessed directly (`emp.salary = 50000;` ❌ forbidden).
2. **Setter method:** `setSalary()` allows controlled assignment to `salary`.
3. **Getter method:** `getSalary()` allows controlled retrieval of `salary`.
4. **Inside main():** We create an object `emp` and use **setter/getter** methods to interact with the private attribute.

---

## 3️⃣ Why Use Encapsulation?

Encapsulation = **hiding the internal state** of a class and exposing it through controlled methods.

**Benefits:**

1. **Data Security:** Private data cannot be changed accidentally from outside.
2. **Controlled Access:** You can add validation inside setters.

```cpp
void setSalary(int s) {
    if (s >= 0) salary = s; // Only allow positive salaries
}
```

3. **Maintenance Friendly:** Internal implementation can change without affecting external code.
4. **Real-World Use:**

   * **Banking apps:** Account balance is private, accessed only via deposit/withdraw functions.
   * **Inventory systems:** Product quantity is private, updated only via stock management methods.

---

## 4️⃣ Interview Notes

**Q1. Why declare members private in a class?**
→ To **protect internal data** and provide controlled access via public methods.

**Q2. Difference between public, private, protected?**

* Public → accessible everywhere
* Private → accessible only inside the class
* Protected → accessible in class + derived classes

**Q3. Can we provide only getter or setter?**
→ Yes! You can provide only a getter for **read-only data**, or only a setter for **write-only data**.

---

💡 **Tip for real projects:**
Always keep attributes **private** and expose **methods for controlled access**. This prevents accidental modifications and ensures **data integrity**.

