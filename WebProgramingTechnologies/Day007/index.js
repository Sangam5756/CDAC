// -----------------------------------------------
// Example 1: Function Hoisting and Variable Scope
// -----------------------------------------------

// function c(a){ 
//     console.log(b); // 'b' is accessed before its declaration, due to hoisting
// }

// var b = 10;
// c();  // Output: 10, because 'b' is in the outer/global scope
// console.log(a); // ReferenceError: 'a' is not defined at this point
// let a = 0; // 'let' variables are not hoisted the same way as 'var'


// -----------------------------------------------
// Example 2: Block Scope with let
// -----------------------------------------------

// let a = 100;

// {
//     let a = 10; // This 'a' is a separate variable (block-scoped)
//     console.log(a); // Output: 10
// }

// console.log(a); // Output: 100 (outer 'a' remains unchanged)


// -----------------------------------------------
// Example 3: Lexical Scope and Nested Functions
// -----------------------------------------------

// function z() {
//     var b = 900;
//     function x() {
//         var a = 7;
//         function y() {
//             // 'y' can access both 'a' and 'b' due to lexical scoping
//             console.log(a, b); // Output: 7 900
//         }
//         y();
//     }
//     x();
// }

// z();


// -----------------------------------------------
// Example 4: Closures with setTimeout
// -----------------------------------------------

// function x() {
//     var a = 7;
//     setTimeout(function () {
//         // This anonymous function forms a closure with 'a'
//         console.log(a); // Output after 3 sec: 7
//     }, 3000);
//     console.log(a); // Output immediately: 7
// }
// x();


// -----------------------------------------------
// Example 5: Common Closure Pitfall with var in Loops
// -----------------------------------------------

// function x() {
//     for (var i = 1; i <= 5; i++) {
//         // 'var' is function-scoped, so only one 'i' exists for all callbacks
//         setTimeout(function () {
//             console.log(i); // Prints 6 five times, because loop completes before timeout runs
//         }, i * 1000);
//     }
// }
// x();


// -----------------------------------------------
// Example 6: Fixing the Closure Problem using let
// -----------------------------------------------

// function x() {
//     for (let i = 1; i <= 5; i++) {
//         // 'let' creates a new 'i' for each iteration (block-scoped)
//         setTimeout(function () {
//             console.log(i); // Prints 1, 2, 3, 4, 5
//         }, i * 1000);
//     }
// }
// x();


// -----------------------------------------------
// Example 7: Simple Closure Example
// -----------------------------------------------

// var count = 0;
// function increment() {
//     count++; // Accesses and modifies outer variable
// }
// increment();
// console.log(count); // Output: 1
// // Problem: Anyone can directly change 'count' from outside — not encapsulated.


// -----------------------------------------------
// Example 8: Data Hiding using Closures
// -----------------------------------------------

// function counter() {
//     var count = 0; // Private variable (hidden inside closure)
//     function increment() {
//         count++;
//     }
//     console.log(count);
// }
// // console.log(count); // Error: count is not defined outside 'counter'


// -----------------------------------------------
// Example 9: Encapsulation Example
// -----------------------------------------------

// function counter() {
//     var count = 1;

//     // Returning inner function gives controlled access to 'count'
//     return function increment() {
//         count++;
//         console.log(count);
//     }
// }

// const inc = counter();
// inc(); // Output: 2
// inc(); // Output: 3
// // 'count' remains private — can only be modified through 'increment'


// -----------------------------------------------
// Example 10: Function Constructor for Counters (Better Practice)
// -----------------------------------------------

// function Counter() {
//     var count = 0; // Private variable

//     // Public methods exposed via 'this'
//     this.incrementCounter = function () {
//         count++;
//         console.log(count);
//     };

//     this.decrementCounter = function () {
//         count--;
//         console.log(count);
//     };
// }

// var counter1 = new Counter();
// counter1.incrementCounter(); // 1
// counter1.decrementCounter(); // 0
// // Each new Counter() instance has its own private 'count'


// -----------------------------------------------
// Example 11: Functions as First-Class Citizens
// -----------------------------------------------

// A function can accept another function as an argument
var b = function (param1) {
    console.log(param1); // Prints the function itself
};

// Passing an anonymous function as an argument
b(function () { }); // Output: function () { }

// Another way: define a function and pass it
function xyz() { }
b(xyz); // Output: function xyz() { }


// -----------------------------------------------
// Example 12: Returning a Function from a Function
// -----------------------------------------------

var b = function (param1) {
    return function () {
        console.log("Returned inner function executed");
    }
};

// b() returns a new function
console.log(b()); // Output: function () { console.log("Returned inner function executed"); }

// To execute the returned function:
b()(); // Output: "Returned inner function executed"
