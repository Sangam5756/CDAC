class TestPoint {
	public static void main(String[] args) {
		Point2D point1 = new Point2D(1, 2);
		point1.show();
		
		Point2D point2 = new Point2D(4, 5);
		point2.show();
		
		boolean b = point1.isEqual(point2);
		String result = b ? "Same " : "Different";
		System.out.println("Point are " + result);
		System.out.println("Distance of Two Point is : "+ point1.calculateDistance(point2));
	}
}