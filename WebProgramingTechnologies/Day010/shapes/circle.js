
export function calcArea(radius) {
  if (radius < 0) throw new Error("radius must be >= 0");
  return Math.PI * radius * radius;
}
export function calcCircumference(radius) {
  return 2 * Math.PI * radius;
}
export function calcDiameter(radius) {
  return 2 * radius;
}
