## **Java**

* A **programming language** where code runs **sequentially** (top → bottom) unless you use threads.
* **Statically typed** → data type is fixed at compile time.
* **Pure Object-Oriented** → everything is a class.
* Runs on JVM.

```java
int x = 10;  // fixed type
```

---

## **JavaScript**

* **Event-driven** → code executes when events happen (click, input, timer, network).
* **Dynamically typed** → type is decided at runtime.
* **Object-based**, not pure OOP → objects exist, but not everything must be an object.
* Runs inside browser or Node.js.

```js
let x = 10; // can change type later
x = "hello";
```

JavaScript’s magic happens in the browser through DOM events.

---

# ⭐ let vs var vs const — the behavior nobody forgets

JavaScript gives you 3 ways to declare variables.

Think of them like 3 personalities:

---

## ✅ **let**

Modern, safe, block-scoped.

* No duplicate declarations.
* Block scope `{}`.
* Not hoisted.

```js
let x = 10;
```

---

## 🟡 **var**

Old, loose, function-scoped.

* Duplicate allowed.
* Function or global scope.
* Hoisted (declared at top automatically).

```js
var x = 10;
var x = 20; // allowed
```

---

## 🔒 **const**

Fixed forever—must assign immediately.

* Must be initialized.
* Cannot be redeclared.
* Block scope.
* Not hoisted.

```js
const PI = 3.14;
```

---

# ⭐ Client-Side JavaScript — what it really does

### 1. **Client-side validation**

Check forms before submitting (faster & reduces server load).

### 2. **Dynamic Look & Feel**

Animations, UI changes, real-time updates.

### 3. **AJAX** (XMLHttpRequest or modern `fetch`)

Send data to server **without refreshing**.

---

### Where JavaScript runs?

| Environment               | Uses                           |
| ------------------------- | ------------------------------ |
| **Browser (client-side)** | DOM, events, UI changes        |
| **Node.js (server-side)** | APIs, databases, backend logic |

---

# ⭐ Popup Boxes (Every exam always asks these)

All belong to the **window object**.

| Method      | Use                       |
| ----------- | ------------------------- |
| `alert()`   | Message box with OK       |
| `confirm()` | OK → true, Cancel → false |
| `prompt()`  | Ask user for input        |

```js
let name = prompt("Enter name");
let ok = confirm("Are you sure?");
alert("Welcome!");
```

---

# ⭐ Output Functions

```js
document.write("Hello");
console.log("Testing");
```

* `document.write()` → shows content on the web page
* `console.log()` → for debugging only

---

# ⭐ Function Definitions in JavaScript

JavaScript is flexible — functions can be written many ways.

---

## 1. **Regular Function**

```js
function f1(x, ...arr) {
   console.log("x =", x, "rest =", arr);
}
```

* Has `arguments[]` array
* `...rest` lets you accept unlimited parameters

---

## 2. **Function Expression**

```js
const f2 = function(x,y) {
   console.log(x,y);
};
```

Useful because:

* Names can't be overwritten
* Prevent accidental overwriting

---

## 3. **Arrow Function** (`=>`)

```js
const f3 = (x, y=3, ...r) => {
   console.log("in f3", x, y, r);
};
```

Notes:

* Can have default values
* Does **NOT** have `arguments[]`
* Does **NOT** have its own `this`
* Cleaner and shorter

```js
const f4 = (x,y=45,z=4) => console.log(x, y, z);
```

---

# ⭐ Closure — the heart of JavaScript

A function that remembers **variables of its parent function** even after parent returns.

```js
function outer() {
    let x = 10;
    function inner() {
        console.log(x);
    }
    return inner;
}

const fn = outer();
fn(); // prints 10 even though outer() finished
```

Used everywhere:

* Event handlers
* Callbacks
* React hooks
* jQuery plugins

Closures keep data alive.

---

# ⭐ Self-Invoking Function (IIFE)

Runs immediately at the moment of definition.

```js
(function(x,y){
   console.log("IIFE", x, y);
})(12,13);
```

Used when:

* You want code to run once
* You want private variables
* You want to avoid global pollution

---

# ⭐ Type Conversion Functions

```js
parseInt("12");     // 12
parseFloat("12.5"); // 12.5
```

---

# ⭐ innerHTML vs value

| Tag Type                                  | Property      |
| ----------------------------------------- | ------------- |
| Content tags (div, span, p, a, h1…)       | **innerHTML** |
| Form input tags (input, textarea, select) | **value**     |

```js
document.getElementById("msg").innerHTML = "Hi";

document.getElementById("name").value = "Sangam";
```

---

# ⭐ Numeric Functions

JavaScript numbers have helpful utilities:

```js
Number.isInteger(10); // true
Math.round(4.6);      // 5
Math.floor(4.6);      // 4
Math.ceil(4.1);       // 5
Math.random();        // random number
```
