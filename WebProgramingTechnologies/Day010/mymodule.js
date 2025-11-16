// 2) Create a module by name mymodule.js  to store three functions 
// • factorial – to find factorial of a number. 
// • myprime - Check prime number 
// • printable – to display table of a number 
// display a form to accept a number from user. If number is < 5 then call factorial function 
// if the number is > 5 and < 10 then call printable function 
// otherwise call myprime


export function factorial(n) {
  if (n < 0) throw new Error("Negative factorial not supported");
  let r = 1;
  for (let i = 2; i <= n; i++) r *= i;
  return r;
}

export function myprime(n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 === 0) return false;
  for (let i = 3; i * i <= n; i += 2) {
    if (n % i === 0) return false;
  }
  return true;
}

export function printable(n, upto = 10) {
  const lines = [];
  for (let i = 1; i <= upto; i++) {
    lines.push(`${n} x ${i} = ${n * i}`);
  }
  return lines.join('\n');
}


