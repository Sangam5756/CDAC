# Variables in JavaScript

**Like a toy box:** A variable is a labeled box where you keep a toy. You name the box so you can find the toy later.

Simple: `let myToy = "teddy";`
Deeper: A variable stores a value (text, number, true/false, object, etc.). JavaScript has three main ways to create variables:

* `var` — old-style. Function-scoped, hoisted (we’ll explain hoisting soon). Avoid for new code.
* `let` — block-scoped, can change value.
* `const` — block-scoped, cannot be reassigned (but objects/arrays inside can be mutated).

Examples:

```js
let age = 5;        // can change
const name = "Sam"; // cannot reassign name = "Alex" -> error
var old = true;     // function-scoped (quirky)
```

Tip: prefer `const` by default, `let` when you need to change.

# Statements, Operators, Comments, Expressions

**Like sentences and math in a storybook.**

* **Statement:** A full sentence that tells the program to do something — e.g., `let x = 3;` is a statement.
* **Expression:** A phrase that produces a value — e.g., `2 + 2` or `name.toUpperCase()` are expressions (they evaluate to a value).
* **Operators:** Tools for doing math or comparisons — `+ - * /` for math, `===` for strict equality, `&&` and `||` for logic.
* **Comments:** Notes you write for humans; the program ignores them. `// single line` or `/* multi-line */`.

Example:

```js
// This is a comment
let sum = 2 + 3;     // 2 + 3 is an expression, the whole line is a statement
if (sum === 5) {     // === is a strict equality operator
  console.log("Yep");
}
```

Deeper: Operators come in categories: arithmetic (`+ - * / %`), comparison (`> < >= <= == === != !==` — prefer `===`/`!==`), logical (`&& || !`), assignment (`=`, `+=`, `*=`), and others (bitwise, ternary `? :`). Expressions can be nested — `Math.max(1,2) + 3`.

# Control Structures

**Like choose-your-own-adventure paths.** If something is true, do this; else do that; repeat actions with loops.

Simple:

* `if / else` — pick a branch.
* `for` — do something a set number of times.
* `while` — keep doing until something changes.
* `switch` — many-choice branch.

Examples:

```js
if (hungry) {
  eat();
} else {
  play();
}

for (let i = 0; i < 3; i++) {
  console.log("hop");
}

let n = 0;
while (n < 3) {
  console.log(n);
  n++;
}
```

Deeper: Control flow creates predictable logic. Use `for...of` to iterate arrays, `for...in` for object keys (but be careful — not for arrays usually). Avoid infinite loops — they freeze your program. `break` exits loops; `continue` skips to next iteration.

# JavaScript Scopes

**Like rooms in a house where toys live.** Some toys (variables) are only in the bedroom (block), others are available throughout the whole house (function).

Simple:

* **Global scope:** things available everywhere.
* **Function scope:** visible inside the function.
* **Block scope:** visible inside `{ }` (like inside an `if` or `for`) — created by `let` and `const`.

Example:

```js
let outside = "yard";
function play() {
  let inside = "fort";
  if (true) {
    let secret = "treasure"; // block-scoped
  }
  // secret is NOT available here
}
```

Deeper: `var` is function-scoped, not block-scoped. Hoisting means declarations are moved to the top of their scope at runtime — but only the declaration, not the value. Example:

```js
console.log(a); // undefined (declaration hoisted)
var a = 5;
```

With `let`/`const`, referencing before declaration causes a ReferenceError (Temporal Dead Zone) — this helps catch bugs.

# Strings, String Methods

**Strings are word-strings — like necklaces of letters.** You can count letters, change them, glue them together.

Simple operations:

* Join: `"hello" + " " + "you"` → `"hello you"`
* Length: `"hi".length` → `2`
* Uppercase/lowercase: `.toUpperCase()`, `.toLowerCase()`
* Find pieces: `.indexOf("e")`, `.includes("ello")`
* Cut pieces: `.slice(1,4)` or `.substring(1,4)`
* Replace: `.replace("a", "o")` (first match) or use regex for all matches.

Examples:

```js
let s = "banana";
console.log(s.length);            // 6
console.log(s.toUpperCase());    // BANANA
console.log(s.includes("nan"));  // true
console.log(s.slice(1,4));       // "ana"
console.log("a" + "b");          // "ab"
```

Deeper: Strings are immutable — you can’t change a character in place. Methods return new strings. For repeated operations over large strings, be mindful of performance. There are template literals using backticks: `` `Hi ${name}` `` — great for embedding variables and multi-line strings. Regular expressions (`/pattern/`) let you search/replace powerful patterns.

# Numbers, Number Methods

**Numbers are like cookies you count and share.** You can add, subtract, and check how many.

Simple:

* Arithmetic: `+ - * / %`
* Decimal numbers (floats) and whole numbers (integers).
* Convert strings to numbers: `Number("42")`, `parseInt("42")`, `parseFloat("3.14")`.
* Check if number is finite: `Number.isFinite(x)` or `isNaN()`/`Number.isNaN()`.

Examples:

```js
let a = 2 + 3;        // 5
let b = 7 % 3;        // 1 (remainder)
let c = parseInt("12px"); // 12
let d = Number("3.5"); // 3.5
```

Deeper: JS numbers are mostly IEEE-754 doubles — that means some decimal math is imprecise: `0.1 + 0.2 === 0.30000000000000004`. For precise decimal math (money), use a big-number library or `BigInt` for very large integers: `123n` is a `BigInt`. Methods: `Math` object (e.g., `Math.round`, `Math.floor`, `Math.random()`, `Math.max`), `Number` methods like `Number.isInteger()`, and `toFixed()` to format decimals: `(1/3).toFixed(2)` → `"0.33"` (string).

# Putting it together — tiny playground

Run this in your browser console and see how the ideas work:

```js
const name = "Asha";        // variable, string
let cookies = 3;            // number
if (cookies > 2) {          // control structure
  console.log(`${name} is happy!`); // template literal + expression
} else {
  console.log(`${name} wants more cookies.`);
}

for (let i = 0; i < cookies; i++) { // loop
  console.log("Crunch");
}
```

# Sneaky pitfalls (little traps to watch out for)

* `==` vs `===`: `==` does type coercion (`'5' == 5` true). Prefer `===` (strict equality).
* Floating point math: `0.1 + 0.2` is not exactly `0.3`.
* `var` hoisting and lack of block scope can cause bugs. Prefer `let`/`const`.
* Mutating objects vs reassigning: `const obj = {a:1}; obj.a = 2;` is allowed (mutation), but `obj = {}` is not.
* Strings are immutable — methods return copies.

**Booleans, Dates, and Arrays.**

Think of this as learning how to ask *“yes or no?”*, *“when?”*, and *“what’s in this box of stuff?”* — three fundamental questions in programming and in life.

---

## 🟢 BOOLEAN VALUES

**What it is:**
Booleans are the simplest data type in JavaScript — they can only be **true** or **false**.

Think of it as a **light switch** — it’s either ON or OFF.

```js
let isHungry = true;
let isAsleep = false;
```

---

### 🧠 Boolean in Action

You use Booleans for **decisions** — like when you ask, “Should I do this or not?”

```js
if (isHungry) {
  console.log("Eat food!");
} else {
  console.log("Take a nap!");
}
```

---

### 🧩 Boolean Conversion

JavaScript automatically converts other values into `true` or `false` when needed — this is called **truthy** and **falsy** conversion.

**Falsy values (treated as false):**
`false`, `0`, `""` (empty string), `null`, `undefined`, `NaN`

Everything else is **truthy**.

Example:

```js
if ("hello") console.log("Truthy!");
if (0) console.log("Won't run!");
```

---

### 🔄 Boolean Operators

Booleans mix beautifully with **logical operators**:

```js
const sunny = true;
const warm = false;

console.log(sunny && warm); // false (AND)
console.log(sunny || warm); // true (OR)
console.log(!sunny);        // false (NOT)
```

* `&&` → true if *both* are true
* `||` → true if *either* is true
* `!` → flips the value

---

## ⏰ DATES IN JAVASCRIPT

Dates are like **time machines** — they tell when something happened, or will happen.
JavaScript stores dates as the **number of milliseconds since January 1, 1970 UTC** (the Unix epoch).

---

### 🧱 Creating Dates

```js
let now = new Date();                // current date & time
let birthday = new Date("2000-05-01"); // from a string
let custom = new Date(2025, 10, 11);   // year, month (0-based!), day
```

Be careful: months start at **0** (January) and go to 11 (December).

---

### 📅 Date Formats

You can get formatted date/time strings:

```js
console.log(now.toString());        // full date-time
console.log(now.toDateString());    // only date
console.log(now.toTimeString());    // only time
console.log(now.toISOString());     // universal ISO format
```

---

### ⚙️ Date Methods

You can **get** or **set** parts of a date:

```js
let today = new Date();

console.log(today.getFullYear()); // 2025
console.log(today.getMonth());    // 10 (November)
console.log(today.getDate());     // 11 (day of month)
console.log(today.getDay());      // 2 (0=Sunday)
console.log(today.getHours());    // 14 (2 PM)
console.log(today.getTime());     // milliseconds since 1970

today.setFullYear(2030);
console.log(today.getFullYear()); // 2030
```

---

### 🧮 Date Math

Dates are just numbers underneath, so you can do math with them:

```js
let start = new Date("2025-01-01");
let end = new Date("2025-12-31");

let difference = end - start; // milliseconds
console.log(difference / (1000 * 60 * 60 * 24)); // days difference
```

You can also use libraries like **dayjs** or **date-fns** for advanced formatting and manipulation.

---

## 📦 ARRAYS

Arrays are **boxes that hold multiple values in order** — like a toy box with labeled slots.

```js
let fruits = ["apple", "banana", "cherry"];
```

Each item has a **position (index)** — starting from **0**:

* `fruits[0]` → "apple"
* `fruits[1]` → "banana"

---

### 🧩 Creating Arrays

```js
const numbers = [1, 2, 3];
const mix = ["text", 5, true];
const empty = new Array();  // same as []
```

---

### ⚙️ Accessing & Modifying

```js
let animals = ["cat", "dog", "lion"];
animals[1] = "elephant";  // replace dog
animals.push("tiger");    // add at end
animals.unshift("cow");   // add at start
animals.pop();            // remove last
animals.shift();          // remove first
console.log(animals);
```

---

### 📚 Array Methods (the real power)

Arrays in JS come with *tons* of powerful methods. Let’s group them by type.

---

#### 🔍 Searching & Checking

```js
let fruits = ["apple", "banana", "mango"];
console.log(fruits.includes("banana")); // true
console.log(fruits.indexOf("mango"));   // 2
```

---

#### 🔄 Transforming Arrays

* **map()** — creates a new array by applying a function to each element
* **filter()** — keeps only elements that match a condition
* **reduce()** — combines elements into a single value
* **forEach()** — runs a function on each element (no return)

Example:

```js
const nums = [1, 2, 3, 4, 5];

const doubled = nums.map(n => n * 2);   // [2,4,6,8,10]
const evens = nums.filter(n => n % 2 === 0); // [2,4]
const sum = nums.reduce((acc, n) => acc + n, 0); // 15

nums.forEach(n => console.log(n)); // prints each number
```

---

#### ✂️ Cutting, Joining, and Combining

```js
let arr = [10, 20, 30, 40, 50];

console.log(arr.slice(1, 4)); // [20,30,40] (doesn't change original)
arr.splice(2, 1);             // remove 1 element at index 2
console.log(arr);             // [10,20,40,50]

let joined = arr.join("-");   // "10-20-40-50"
let combined = arr.concat([60, 70]); // [10,20,40,50,60,70]
```

---

#### 🧹 Sorting & Reversing

```js
let nums = [3, 1, 4, 2];
nums.sort();          // sorts as strings: [1,2,3,4]
nums.sort((a,b) => a - b); // correct numeric sort
nums.reverse();       // reverse order
```

---

#### 💥 Destructuring

You can unpack array items into variables:

```js
const [first, second] = ["red", "blue", "green"];
console.log(first);  // red
```

---

### 🧠 Bonus: Nested Arrays & Iteration

Arrays can hold other arrays:

```js
const matrix = [
  [1,2,3],
  [4,5,6]
];
console.log(matrix[1][2]); // 6
```

And you can loop:

```js
for (let fruit of fruits) {
  console.log(fruit);
}
```

---

## ⚡ Putting It All Together

Here’s a fun example that mixes Booleans, Dates, and Arrays:

```js
const tasks = [
  { name: "Study JS", done: false, date: new Date("2025-11-10") },
  { name: "Drink water", done: true, date: new Date("2025-11-11") },
  { name: "Sleep", done: false, date: new Date("2025-11-12") },
];

const today = new Date();

tasks.forEach(task => {
  const isToday = task.date.toDateString() === today.toDateString();
  if (isToday && !task.done) {
    console.log("Task for today:", task.name);
  }
});
```

---

## 🌟 Summary Table

| Concept       | Meaning                         | Example                     |
| ------------- | ------------------------------- | --------------------------- |
| Boolean       | true/false value                | `let isHappy = true`        |
| Truthy/Falsy  | Automatic conversion to Boolean | `if (0)` → false            |
| Date          | Object for time info            | `new Date()`                |
| Date methods  | Get/set date parts              | `getFullYear(), getDate()`  |
| Array         | Ordered list of values          | `[1, 2, 3]`                 |
| Array methods | Manipulate arrays               | `map(), filter(), reduce()` |
