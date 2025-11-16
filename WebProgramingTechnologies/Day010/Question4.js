// 4) Write a Node program that prints all the numbers between 1 and 100, each on a separate line. A 
// few caveats:  
// o if the number is divisible by 3, print “fizz”  
// o if the number is divisible by 5, print “buzz”  
// o if the number is divisible by both 3 and 5, print “fizzbuzz” 


for (let i = 1; i <= 100; i++) {
  let out = '';
  if (i % 3 === 0) out += 'fizz';
  if (i % 5 === 0) out += 'buzz';
  console.log(out || i);
}