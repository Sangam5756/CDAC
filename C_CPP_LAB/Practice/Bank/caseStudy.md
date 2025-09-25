
## **1. Student Marks System**

**Concepts Covered:** OOP, Inheritance, Polymorphism, Enums, Exception Handling

* Base class: `Student` → attributes: `name`, `rollNo`, `marks`
* Derived class: `GraduateStudent` → stricter grading rules
* Methods: `calculateGrade()` (virtual), `display()`
* Enum: `Subject {MATH, SCIENCE, ENGLISH}`
* Exception: `InvalidMarksException` if marks < 0 or > 100
* User Input: Add 2-3 students and display their grades

---

## **2. Hotel Management System** (Your example)

**Concepts Covered:** OOP, Inheritance, Polymorphism, Pointers, Arrays (or vector), User Input

* Base class: `Room` → attributes: `room_number`, `room_type`, `price_per_day`, `no_of_days`
* Derived class: `StandardRoom` → amenities, method `special_amenities()`
* Derived class: `DeluxeRoom` → special_service, method `special_services()`
* Override `calculate_bill()` in derived classes
* Menu: Add Standard/Deluxe room, display details, invoke special methods

---

## **3. Library Book Tracker**

**Concepts Covered:** OOP, STL (vector/map), Enums, File I/O

* Class: `Book` → attributes: `id`, `title`, `author`, `genre`
* Enum: `BookGenre {FICTION, PROGRAMMING, SCIENCE}`
* STL: store books in `vector<Book>`
* File I/O: save books to `books.txt` and load them back
* Methods: `displayInfo()`, `searchByGenre()`

---

## **4. Bank Account Management**

**Concepts Covered:** OOP, Inheritance, Polymorphism, Exception Handling, Pointers

* Base class: `Account` → `accountNo`, `balance`
* Derived class: `SavingsAccount` → interest calculation
* Derived class: `CurrentAccount` → overdraft allowed
* Exception: `InsufficientFundsException`
* Menu: Deposit, Withdraw, Display Balance

---

## **5. Small E-Commerce Cart**

**Concepts Covered:** Templates, STL, User Input

* Template class: `Product<T>` → `name`, `price`, `quantity`
* Vector of `Product<string>` or `Product<int>` for numeric products
* Template function: `getMaxPriceProduct(vector<Product<T>>)`
* Menu: Add Product, Display All, Show Most Expensive

---

## **6. Simple Quiz Game**

**Concepts Covered:** Enums, OOP, Exception Handling, User Input

* Enum: `Difficulty {EASY, MEDIUM, HARD}`
* Class: `Question` → `questionText`, `answer`, `difficulty`
* Store 3-5 questions in `vector<Question>`
* Validate user input; throw exception if invalid choice
* Method: `askQuestion()` displays question and checks answer

---