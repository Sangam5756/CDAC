
# ✅ **1. Add New Book**

### **Request (POST /api/v1/books)**

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "category": "PROGRAMMING",
  "publisher": "Pearson",
  "price": 499.00
}
```

### **Sample Response (201 CREATED)**

```json
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "category": "PROGRAMMING",
  "publisher": "Pearson",
  "price": 499.0,
  "issuedTo": null
}
```

---

# ✅ **2. Add New Member**

### **Request (POST /api/v1/members)**

```json
{
  "name": "Sangam Mundhe",
  "email": "sangam@example.com",
  "password": "s3cur3Pass123",
  "membershipType": "PREMIUM",
 
}
```

### **Sample Response (201 CREATED)**

```json
{
  "id": 1,
  "name": "Sangam Mundhe",
  "email": "sangam@example.com",
  "membershipType": "PREMIUM",
  "address": "Pune, Maharashtra"
}
```

---

# ✅ **3. Issue a Book to a Member**

### **Request (PUT /api/v1/books/1/issue)**

```json
{
  "memberId": 1
}
```

### **Sample Response (200 OK)**

```json
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "category": "PROGRAMMING",
  "publisher": "Pearson",
  "price": 499.0,
  "issuedTo": {
    "id": 1,
    "name": "Sangam Mundhe",
    "membershipType": "PREMIUM"
  }
}
```

---

# ✅ **4. Return a Book**

### **Request (PUT /api/v1/books/1/return)**

```json
{
  "confirm": true
}
```

### **Sample Response (200 OK)**

```json
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "category": "PROGRAMMING",
  "publisher": "Pearson",
  "price": 499.0,
  "issuedTo": null
}
```

---

# ✅ **5. Fetch All Books by Category**

### **Request (GET /api/v1/books?category=PROGRAMMING)**

(No request body — it's a query param)

### **Sample Response (200 OK)**

```json
[
  {
    "id": 1,
    "title": "Clean Code",
    "author": "Robert C. Martin",
    "category": "PROGRAMMING",
    "publisher": "Pearson",
    "price": 499.0,
    "issuedTo": null
  },
  {
    "id": 3,
    "title": "Effective Java",
    "author": "Joshua Bloch",
    "category": "PROGRAMMING",
    "publisher": "Addison-Wesley",
    "price": 650.0,
    "issuedTo": null
  }
]
```

---

# ✅ **6. Update Book Details**

### **Request (PUT /api/v1/books/1)**

```json
{
  "category": "SCIENCE",
  "price": 520.50,
  "publisher": "Springer Publications"
}
```

### **Sample Response (200 OK)**

```json
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "category": "SCIENCE",
  "publisher": "Springer Publications",
  "price": 520.5,
  "issuedTo": null
}
```
