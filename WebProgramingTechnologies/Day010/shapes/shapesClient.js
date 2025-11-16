
import * as circle from './circle.js';
import * as rect from './rectangle.js';
import * as tri from './triangle.js';

console.log('circle area r=3:', circle.calcArea(3));
console.log('circle circumference r=3:', circle.calcCircumference(3));
console.log('circle diameter r=3:', circle.calcDiameter(3));

console.log('rect area 4x5:', rect.calcArea(4,5));
console.log('rect perimeter 4x5:', rect.calcPerimeter(4,5));

console.log('triangle equilateral 3,3,3?', tri.isEquilateral(3,3,3));
console.log('triangle perimeter 3,4,5:', tri.calcPerimeter(3,4,5));
