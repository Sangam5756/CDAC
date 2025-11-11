Fantastic — now we’re entering the heart of JavaScript: **objects and functions** — the building blocks of everything.

Think of this like a LEGO world where *everything* (houses, cars, robots) is an **object**, and **functions** are the instructions that make them move, dance, or build more robots.
We’ll start with objects, then move to functions, and finally, the grand palace of **Object-Oriented Programming (OOP)** in JavaScript.

---

## 🧱 OBJECTS

### 1. What is an Object?

Imagine a **treasure chest** that can hold different kinds of items — a key, a note, a number, even another chest inside it.
In JavaScript, an object is that chest: a container for **key-value pairs**.

```js
const person = {
  name: "Asha",
  age: 5,
  hobby: "Drawing"
};
```

Here:

* `name`, `age`, and `hobby` are **keys** (also called **properties**).
* `"Asha"`, `5`, and `"Drawing"` are **values**.

Objects group related data and behavior — kind of like how a superhero has both attributes (*strength, speed*) and actions (*fly, punch*).

---

### 2. Object Definitions

You can create objects in several ways:

```js
// 1. Object literal
const car = { brand: "Tesla", model: "X" };

// 2. Using new Object()
const book = new Object();
book.title = "Harry Potter";
book.author = "J.K. Rowling";

// 3. Using a constructor function
function Dog(name) {
  this.name = name;
}
const dog1 = new Dog("Tommy");
```

Modern JavaScript prefers **object literals** — they’re simple, clean, and readable.

---

### 3. Object Properties

Properties are the data inside an object.

Access them:

```js
console.log(person.name);   // dot notation
console.log(person["age"]); // bracket notation
```

Add or update:

```js
person.city = "Delhi";   // add
person.age = 6;          // update
delete person.hobby;     // delete
```

---

### 4. Object Methods

A **method** is just a function that lives inside an object — like an ability of a superhero.

```js
const cat = {
  name: "Whiskers",
  meow: function() {
    console.log(this.name + " says meow!");
  }
};

cat.meow(); // "Whiskers says meow!"
```

Here, `this` means “the object who owns this function.”
In the example, `this.name` refers to `"Whiskers"`.

Shortcut method syntax:

```js
const cat = {
  name: "Whiskers",
  meow() {
    console.log(this.name + " says meow!");
  }
};
```

---

### 5. Object Prototypes

Now for the secret basement of all objects: the **prototype**.

Every object in JavaScript has a hidden link (its prototype) that connects it to another object, from which it can inherit properties and methods.

Think of it as a **family tree**:

* Your object can borrow abilities from its parent.
* That parent can borrow from *its* parent, and so on.

Example:

```js
function Animal(name) {
  this.name = name;
}

Animal.prototype.speak = function() {
  console.log(this.name + " makes a sound.");
};

const dog = new Animal("Buddy");
dog.speak(); // "Buddy makes a sound."
```

Here:

* `speak` lives in `Animal.prototype`.
* `dog` doesn’t have `speak` directly, but it can access it through the prototype chain.

---

## ⚙️ FUNCTIONS

### 1. Function Definitions

Functions are reusable blocks of code — like recipes or spells.

```js
function greet(name) {
  console.log("Hello, " + name);
}
```

Other ways to define:

```js
// Function expression
const greet = function(name) { ... };

// Arrow function
const greet = (name) => console.log("Hello, " + name);
```

Arrow functions don’t have their own `this` — they take it from the outer scope. Useful in callbacks.

---

### 2. Function Parameters

Parameters are placeholders in the function definition.
Arguments are the actual values you pass in.

```js
function add(a, b) {
  return a + b;
}
console.log(add(2, 3)); // 5
```

You can give default values:

```js
function greet(name = "Guest") {
  console.log("Hello " + name);
}
```

---

### 3. Function Invocation

You “invoke” (call) a function using parentheses:

```js
greet("Sangam");
```

Functions can:

* Return values (`return x + y`)
* Modify data
* Call other functions

---

### 4. Function Closures

Closures are **magical backpacks** that remember things.

If a function is created inside another function, it *remembers* the variables from where it was born — even after the parent function finishes.

Example:

```js
function outer() {
  let secret = "treasure";
  return function inner() {
    console.log(secret);
  };
}

const keep = outer();
keep(); // "treasure"
```

Why? Because `inner` *closes over* (remembers) the environment where it was created.
Closures are used in private variables, data hiding, and callbacks.

---

## 🏰 INTRODUCTION TO OBJECT-ORIENTED PROGRAMMING (OOP)

OOP is a style of programming that organizes code around **objects** and **behaviors**, rather than just functions and logic.
In JavaScript, OOP is built on prototypes, not classes — but ES6 introduced **class syntax** that feels familiar.

### Example:

```js
class Animal {
  constructor(name) {
    this.name = name;
  }

  speak() {
    console.log(this.name + " makes a sound.");
  }
}

const dog = new Animal("Tommy");
dog.speak(); // "Tommy makes a sound."
```

---

### 1. Method

A **method** is a function that belongs to an object or class.

```js
class Person {
  greet() {
    console.log("Hi!");
  }
}
```

`greet()` is a method.

---

### 2. Constructor

A **constructor** is a special method that runs when you create an object from a class — used to set up initial values.

```js
class Car {
  constructor(brand) {
    this.brand = brand;
  }
}

const c1 = new Car("BMW");
```

---

### 3. Inheritance

**Inheritance** means a child class gets properties and methods from a parent class — like kids inheriting traits from parents.

```js
class Animal {
  speak() { console.log("sound"); }
}

class Dog extends Animal {
  bark() { console.log("woof"); }
}

const d = new Dog();
d.speak(); // from parent
d.bark();  // from child
```

---

### 4. Encapsulation

Think of encapsulation as **hiding the messy stuff inside** and showing only what’s needed.

You can simulate it in JS using closures or private fields (`#name` syntax):

```js
class BankAccount {
  #balance = 0;

  deposit(amount) {
    this.#balance += amount;
  }

  getBalance() {
    return this.#balance;
  }
}
```

Now, nobody can directly change `#balance` outside the class.

---

### 5. Abstraction

Abstraction means **showing only the essentials** — hiding complex inner details.

Example:
You just call `car.start()` without knowing what engine code runs underneath.

In JavaScript, abstraction is achieved using methods and layers of logic — users only see the public interface.

---

### 6. Polymorphism

Polymorphism means **same action, different behavior** depending on the object.

```js
class Animal {
  speak() { console.log("sound"); }
}

class Cat extends Animal {
  speak() { console.log("meow"); }
}

class Dog extends Animal {
  speak() { console.log("bark"); }
}

const animals = [new Cat(), new Dog()];
animals.forEach(a => a.speak()); // "meow", "bark"
```

Different animals, same method name, different behavior.

---

## 🌟 Summary Table

| Concept       | What it Means                   | JS Example                 |
| ------------- | ------------------------------- | -------------------------- |
| Object        | Container of data and behavior  | `{name: "Asha", age: 5}`   |
| Method        | Function inside object/class    | `obj.run = () => {}`       |
| Constructor   | Builds new objects              | `new Car("BMW")`           |
| Prototype     | Blueprint objects inherit from  | `Dog.prototype`            |
| Closure       | Function remembers its scope    | `function outer(){...}`    |
| Inheritance   | Share traits across classes     | `class Dog extends Animal` |
| Encapsulation | Hide internal data              | `#balance` private field   |
| Abstraction   | Simplify complexity             | `car.start()`              |
| Polymorphism  | Same method, different behavior | `animal.speak()`           |

