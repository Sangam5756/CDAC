## **Library Management REST Application (Spring Boot + JPA + MySQL)**

A library keeps track of **Books** and **Members**.
A **Book** can be issued to *only one* Member at a time.
A **Member** can borrow *multiple* Books.

---

## **Functional Requirements**

### **1. Add new Book**

* Input: Book details
* Book must be saved in MySQL
* Response: 201 Created

### **2. Add new Member**

* Input: Member details
* Save member in DB
* Response: 201 Created

### **3. Issue a Book to a Member**

* Input: `bookId`, `memberId`
* Book should not be already issued
* Update Book → set `issuedTo = member`
* Response: 200 OK

### **4. Return a Book**

* Input: `bookId`
* Book must be currently issued
* Set `issuedTo = null`
* Response: 200 OK

### **5. Fetch all Books of a Given Category**

* Input: category name (Enum)
* Return list of books
* Response: 200 OK

### **6. Update Book Details (category, price, publisher)**

* Input: bookId + updated fields
* Response: 200 OK

---

# **Optional Bonus Requirements (for more practice)**

### **7. Fetch all Books currently issued to a specific Member**

* Input: memberId
* Response: 200 OK

### **8. Delete a Member account**

* Input: memberId
* Condition: Member must not have any active issued books
* Response:

  * 204 No Content (if deleted)
  * 400 Bad Request (if books are still issued)

### **9. Delete a Book record**

* Input: bookId
* Book must not be issued
* Response: 204 No Content

---

# **Book Attributes**

1. **ID** — Auto-generated (start from 1)
2. **Title** — Cannot be blank
3. **Author** — Cannot be blank
4. **Category** — Enum: FICTION, NONFICTION, PROGRAMMING, SCIENCE
5. **Publisher** — Cannot be blank
6. **Price** — Must be positive
7. **IssuedTo** — Foreign key to Member (nullable)

---

# **Member Attributes**

1. **ID** — Auto-generated (start from 1)
2. **Name** — Cannot be blank
3. **Email** — Cannot be blank
4. **Password** — Cannot be blank
5. **MembershipType** — Enum: REGULAR, PREMIUM
6. **Address** — Optional

---

# **Constraints & Validations**

* Title and Author cannot be blank
* Price must be greater than 0
* A Book can be issued only if its `issuedTo == null`
* A Member can have unlimited books
* No fields in Book except `issuedTo` must be nullable
* Proper error handling using Global Exception Handler
* Follow REST naming conventions
* Proper response codes must be used

  * 201 → Created
  * 404 → Not found
  * 400 → Bad request
  * 200 → OK
  * 204 → No content
  * 500 → Internal server error


oneto many  -> owning coluimn has ManyToOne and joinCOlumn
manytoOne mappe by filed in owning entiyy whose foreign keys is goind to be in another table