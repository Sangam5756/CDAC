# 🛒 Product Management (Hibernate CRUD Assignment)

## 📘 Overview

This project implements **CRUD operations** on a `Product` entity using **Hibernate ORM** in Java.
It’s a console-based prototype for a future **e-commerce** backend, demonstrating clean DAO patterns, transaction handling, and use of JPQL.

---

## ⚙️ Tech Stack

* **Java 17+**
* **Hibernate ORM 6.x**
* **MySQL** (or H2 for testing)
* **Jakarta Persistence API (JPA)**
* **Maven / Eclipse IDE**

---

## 🧩 Entity Structure

**`Product`**

| Field         | Type                    | Description                                  |
| ------------- | ----------------------- | -------------------------------------------- |
| `prod_id`     | `Long` (auto increment) | Primary key                                  |
| `name`        | `String` (unique)       | Product name                                 |
| `productDesc` | `String`                | Description                                  |
| `mfd`         | `LocalDate`             | Manufacture date                             |
| `price`       | `double`                | Product price                                |
| `quantity`    | `int`                   | Available quantity                           |
| `category`    | `enum`                  | `STATIONARY`, `SHOES`, `GRAINS`, `OIL`, etc. |

---

## 🧠 Key Features

1. **Add a new product**
   Input → product details (except ID)
   Output → success message

   * DAO: `addProduct(Product p)`
   * Tester: `AddProductTester.java`

2. **Display product details by ID**
   Input → `productId`
   Output → `Product` details or error message

   * DAO: `displayProductById(int id)`

3. **Filter products by manufacture date and category**
   Input → date, category (enum)
   Output → list of matching products (id, name, price)

   * DAO: `displayProductByField(LocalDate date, Category category)`

4. **Change product price by name**
   Input → product name, new price
   Output → success message

   * DAO: `changePriceByName(String name, double price)`

5. **Apply discount (optional)**
   Input → minimum quantity, discount %
   Output → message with count of affected products

   * DAO: `addDiscount(int qty, double discount)`
   * Tester: `ApplyDiscountTester.java`
   * Example JPQL:

     ```java
     update Product u set u.price = u.price - (u.price * :discount / 100) 
     where u.quantity > :qt
     ```

---

## 🧪 Testers (Console)

| Tester Class                       | Functionality                      |
| ---------------------------------- | ---------------------------------- |
| `AddProductTester.java`            | Adds a new product                 |
| `DisplayProductByIdTester.java`    | Shows details by ID                |
| `DisplayProductByFieldTester.java` | Lists products by category/date    |
| `ChangePriceTester.java`           | Updates price by name              |
| `ApplyDiscountTester.java`         | Applies discount based on quantity |

Each tester follows this structure:

```java
try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
    ProductDao dao = new ProductDaoImpl();
    // perform operation
} catch (Exception e) {
    e.printStackTrace();
}
```

---

## 🧾 Example Input / Output

### Add Product

```
Enter product details: category, mfd(yyyy-MM-dd), name, price, prod_desc, quantity
SHOES 2024-05-12 NikeAir 4500.0 "Running Shoes" 120
Added Product: Product [id=1, name=NikeAir, price=4500.0, quantity=120, category=SHOES]
```

### Apply Discount

```
Enter minimum quantity and discount percentage:
100 10
Discount applied successfully to 3 product(s).
```

---

## 🧱 Project Structure

```
src/
 ├── com.product.entities/
 │    ├── Product.java
 │    └── Category.java
 ├── com.product.dao/
 │    ├── ProductDao.java
 │    └── ProductDaoImpl.java
 ├── com.product.utils/
 │    └── HibernateUtils.java
 └── com.product.tester/
      ├── AddProductTester.java
      ├── DisplayProductByIdTester.java
      ├── DisplayProductByFieldTester.java
      ├── ChangePriceTester.java
      └── ApplyDiscountTester.java
```

---

## 🧭 How to Run

1. Configure **MySQL** in `hibernate.cfg.xml`
   (update DB URL, username, password).
2. Run any tester class (e.g., `AddProductTester`) from your IDE.
3. Observe Hibernate logs for SQL operations.
4. Check your DB to verify CRUD actions.

---

## 💡 Notes

* Hibernate automatically manages transactions and caching.
* JPQL must be typed only for `SELECT` queries.
* For `UPDATE` / `DELETE`, always use untyped queries with `executeUpdate()`.

---

## 🚀 Future Enhancements

* Integrate with a Spring Boot REST layer.
* Add pagination and sorting.
* Implement product search and category service.
* Extend to an actual e-commerce backend.



<!-- INSERT INTO products (category, mfd, name, price, prod_desc, quantity) VALUES
('GRAINS', '2024-12-12', 'Basmati Rice', 1200.00, 'Premium long grain basmati rice', 50),
('GRAINS', '2025-01-15', 'Wheat Flour', 650.00, 'Whole wheat flour - chakki ground', 100),
('OIL', '2025-03-20', 'Sunflower Oil', 180.00, 'Refined sunflower cooking oil', 80),
('OIL', '2025-04-10', 'Mustard Oil', 210.50, 'Cold pressed mustard oil', 60),
('SHOES', '2024-11-05', 'Nike Air Zoom', 7500.00, 'Running shoes with lightweight cushioning', 15),
('SHOES', '2025-01-25', 'Adidas Ultraboost', 8900.00, 'High-performance comfort running shoes', 20),
('STATIONARY', '2024-09-12', 'Classmate Notebook', 60.00, '200 pages ruled notebook', 200),
('STATIONARY', '2025-02-18', 'Parker Pen', 550.00, 'Premium ink pen with smooth writing', 45),
('GRAINS', '2024-08-20', 'Brown Rice', 900.00, 'Organic hand-pounded brown rice', 70),
('OIL', '2025-05-10', 'Olive Oil', 1100.00, 'Extra virgin olive oil imported from Spain', 40); -->
