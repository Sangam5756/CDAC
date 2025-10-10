
Here’s a clean, well-structured **README-style note** for your MySQL triggers practice. It organizes everything logically so you can use it for reference or portfolio purposes.

---

# **MySQL Triggers Practice – Employee Management**

This project demonstrates practical use of **MySQL triggers** for logging, validation, and auditing operations on an Employee database.

---

## **1. Table Structure**

### **Employee Table**

Stores employee information.

```sql
CREATE TABLE Employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50) NOT NULL,
    department VARCHAR(30),
    salary DECIMAL(10,2),
    hire_date DATE
);
```

### **Department Table**

Stores department details.

```sql
CREATE TABLE Department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(30),
    location VARCHAR(50)
);
```

---

## **2. Stored Procedure**

### **Update Employee Department**

Updates an employee’s department using a stored procedure.

```sql
DELIMITER //

CREATE PROCEDURE updateEmpDept(IN pempno INT, IN pdeptno INT)
BEGIN
    UPDATE Employee
    SET department = pdeptno
    WHERE emp_id = pempno;
END;
//

DELIMITER ;
```

---

## **3. Logging Department Changes**

### **Log Table**

```sql
CREATE TABLE deptlog (
    logid INT AUTO_INCREMENT PRIMARY KEY,
    empno INT,
    olddeptno INT,
    newdeptno INT,
    updatetime DATETIME
);
```

### **Trigger**

```sql
DELIMITER //

CREATE TRIGGER logdept
AFTER UPDATE ON Employee
FOR EACH ROW
BEGIN
    IF OLD.department <> NEW.department THEN
        INSERT INTO deptlog(empno, olddeptno, newdeptno) 
        VALUES (OLD.emp_id, OLD.department, NEW.department);
    END IF;
END;
//

DELIMITER ;
```

---

## **4. Logging Salary Updates**

### **Log Table**

```sql
CREATE TABLE logsalary (
    logid INT PRIMARY KEY AUTO_INCREMENT,
    empno INT,
    oldsal INT,
    newsal INT,
    updatetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### **Trigger**

```sql
DELIMITER //

CREATE TRIGGER logsalaryemp
AFTER UPDATE ON Employee
FOR EACH ROW
BEGIN
    IF OLD.salary <> NEW.salary THEN
        INSERT INTO logsalary(empno, oldsal, newsal)
        VALUES (OLD.emp_id, OLD.salary, NEW.salary);
    END IF;
END;
//

DELIMITER ;
```

---

## **5. Logging Deleted Employees**

### **Log Table**

```sql
CREATE TABLE logemp (
    logid INT PRIMARY KEY AUTO_INCREMENT,
    empno INT,
    empname VARCHAR(30),
    salary INT,
    hire_date DATE,
    deptno INT,
    updatetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### **Trigger**

```sql
DELIMITER //

CREATE TRIGGER logdeleteemp
BEFORE DELETE ON Employee
FOR EACH ROW
BEGIN
    INSERT INTO logemp(empno, empname, salary, hire_date, deptno)
    VALUES (OLD.emp_id, OLD.emp_name, OLD.salary, OLD.hire_date, OLD.department);
END;
//

DELIMITER ;
```

---

## **6. Insert Validation – Salary Cannot Be Negative**

### **Trigger**

```sql
DELIMITER //

CREATE TRIGGER checksal
BEFORE INSERT ON Employee
FOR EACH ROW
BEGIN
    IF NEW.salary < 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Salary cannot be negative';
    END IF;
END;
//

DELIMITER ;
```

---

## **7. Insert Validation – Department Cannot Be NULL**

### **Trigger**

```sql
DELIMITER //

CREATE TRIGGER deptnocheck
BEFORE INSERT ON Employee
FOR EACH ROW
BEGIN
    IF NEW.department IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Department cannot be null';
    END IF;
END;
//

DELIMITER ;
```

---

## **8. Testing Triggers**

### Update Department

```sql
UPDATE Employee
SET department = 4
WHERE emp_id = 2;
```

### Update Salary

```sql
UPDATE Employee
SET salary = 30000
WHERE emp_id = 5;
```

### Delete Employee

```sql
DELETE FROM Employee
WHERE emp_id = 5;
```

### Insert Invalid Data (Validation Test)

```sql
-- Should throw error
INSERT INTO Employee(emp_id, emp_name, department, salary, hire_date)
VALUES (6, 'Raj', NULL, -5000, '2025-10-10');
```

---

## **9. Summary of Triggers Practiced**

| Trigger Name   | Event         | Table    | Purpose                 |
| -------------- | ------------- | -------- | ----------------------- |
| `logdept`      | AFTER UPDATE  | Employee | Log department changes  |
| `logsalaryemp` | AFTER UPDATE  | Employee | Log salary changes      |
| `logdeleteemp` | BEFORE DELETE | Employee | Log deleted employees   |
| `checksal`     | BEFORE INSERT | Employee | Prevent negative salary |
| `deptnocheck`  | BEFORE INSERT | Employee | Prevent NULL department |

---

This README gives you a **structured overview of your triggers practice**, with tables, triggers, and testing steps — perfect for future reference or portfolio documentation.

---

I can also make a **diagram showing OLD vs NEW values flow for each trigger** so it’s easier to visualize what happens on INSERT, UPDATE, and DELETE.

Do you want me to make that diagram?
