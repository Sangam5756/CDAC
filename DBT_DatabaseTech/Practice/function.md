
## 🧱 1️⃣ Table Creation: `Employee` and `Department`

### Department Table

```sql
CREATE TABLE Department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(30),
    location VARCHAR(50)
);
```

**Explanation:**

* `dept_id` → unique identifier for each department (Primary Key)
* `dept_name` → department’s name (e.g., HR, IT)
* `location` → where the department is located

---

### Employee Table

```sql
CREATE TABLE Employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50) NOT NULL,
    deptno INT,
    salary DECIMAL(10,2),
    hire_date DATE,
    CONSTRAINT fk_deptno FOREIGN KEY (deptno) REFERENCES Department(dept_id)
);
```

**Explanation:**

* `emp_id` → employee unique ID (Primary Key)
* `emp_name` → cannot be null
* `deptno` → foreign key linked to `Department.dept_id`
* `salary` → uses DECIMAL for accuracy in money calculations
* `hire_date` → date of joining
* The **foreign key constraint** ensures every `deptno` in `Employee` must exist in `Department`.

📘 **Concept Learned:**

* **Foreign Key Constraint** enforces **referential integrity** between tables.
* Prevents inserting employees in non-existent departments.

---

## ⚙️ 2️⃣ Function: `getsalary()`

```sql
DELIMITER //
CREATE FUNCTION getsalary(pempno INT)
RETURNS DOUBLE(9,2)
DETERMINISTIC
BEGIN
    DECLARE empsal DOUBLE(9,2);
    SELECT salary INTO empsal FROM employee WHERE empno = pempno;
    RETURN empsal;
END;
//
DELIMITER ;
```

**Purpose:**
Returns the **salary** of an employee based on their ID.

**Explanation:**

* Takes employee ID as input.
* Queries the `salary` column from the table.
* Returns the exact salary.

✅ **Example Usage:**

```sql
SELECT getSalary(101);
```

---

## 🧮 3️⃣ Function: `getEmpExp()`

```sql
DELIMITER //
CREATE FUNCTION getEmpExp(pempno INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE exp INT;
    SELECT TIMESTAMPDIFF(YEAR, hire_date, CURDATE()) INTO exp
    FROM employee
    WHERE empno = pempno
    LIMIT 1;
    RETURN exp;
END;
//
DELIMITER ;
```

**Purpose:**
Calculates the **experience (in years)** of an employee.

**Explanation:**

* `TIMESTAMPDIFF(YEAR, hire_date, CURDATE())` → calculates difference in years between hire date and today.
* Returns the **absolute number of years worked**.

✅ **Example Usage:**

```sql
SELECT emp_name, getEmpExp(empno) AS experience FROM employee;
```

---

## 💰 4️⃣ Function: `checkisBonuseligible()`

```sql
DELIMITER //
CREATE FUNCTION checkisBonuseligible(pempno INT)
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(10);
    DECLARE esal DOUBLE(9,2);

    SELECT salary INTO esal FROM employee WHERE empno = pempno;

    IF esal > 30000 THEN
        SET result = 'YES';
    ELSE 
        SET result = 'NO';
    END IF;

    RETURN result;
END;
//
DELIMITER ;
```

**Purpose:**
Checks if the employee is **eligible for a bonus**.

**Logic:**

* If salary > 30,000 → returns `'YES'`
* Else → returns `'NO'`

✅ **Example Usage:**

```sql
SELECT emp_name, checkisBonuseligible(empno) AS Bonus_Eligibility FROM employee;
```

---

## 🏢 5️⃣ Function: `getDepartmentName()`

```sql
DELIMITER //
CREATE FUNCTION getDepartmentName(pempno INT)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    DECLARE dname VARCHAR(20);
    SELECT d.dept_name INTO dname
    FROM employee e
    JOIN department d ON e.deptno = d.dept_id
    WHERE e.empno = pempno;
    RETURN dname;
END;
//
DELIMITER ;
```

**Purpose:**
Fetches the **department name** where the employee works.

**Explanation:**

* Uses a **JOIN** between `employee` and `department`
* Finds the matching `dept_name` using employee’s `deptno`

✅ **Example Usage:**

```sql
SELECT emp_name, getDepartmentName(empno) AS Department FROM employee;
```

---

## 🧠 Summary Notes (Ready for Revision Sheet)

| Concept     | Function / Feature       | Description                  | Example                                              |
| ----------- | ------------------------ | ---------------------------- | ---------------------------------------------------- |
| Foreign Key | `fk_deptno`              | Links employee to department | `FOREIGN KEY(deptno) REFERENCES department(dept_id)` |
| Function 1  | `getSalary()`            | Returns salary by emp ID     | `SELECT getSalary(101)`                              |
| Function 2  | `getEmpExp()`            | Returns experience in years  | `SELECT getEmpExp(101)`                              |
| Function 3  | `checkisBonuseligible()` | YES/NO if salary > 30k       | `SELECT checkisBonuseligible(101)`                   |
| Function 4  | `getDepartmentName()`    | Returns department name      | `SELECT getDepartmentName(101)`                      |
