// 1) Create a user defined local module calc.js that exposes the following functions: add(a,b), 
// subtract(a,b), multiply(a,b), divide(a,b), square(a), sum(a,b,c...)




export function add(a, b) { return a + b; }
export function subtract(a, b) { return a - b; }
export function multiply(a, b) { return a * b; }
export function divide(a, b) {
  if (b === 0) throw new Error("Division by zero");
  return a / b;
}
export function square(a) { return a * a; }
export function sum(...args) { return args.reduce((s, v) => s + v, 0); }
