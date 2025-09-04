class Point2D {
	private int x;
	private int y;
	
	Point2D(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	String show(){
		return "point's x is " + this.x + " & y is " +  this.y + "co-ords";
	}
	
	boolean isEqual(Point2D point){
		if(this.x == point.x && this.y == point.y){
			return true;
		} else {
			return false;
		}
	}
	
	double calculateDistance (Point2D p){
		double c1 = Math.pow((p.x - this.x),2);
		double c2 = Math.pow((p.y - this.y),2);
		double c3 = Math.sqrt(c1+c2);
		return c3;
	}
	
}