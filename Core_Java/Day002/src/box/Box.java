class Box {
	private double width;
	private double height;
	private double depth;
	
	Box(double w, double h, double depth){
		this.width = w;
		this.height = h;
		this.depth = depth;
	}

	void display(){
		System.out.println("The dimenstions are : " + this.width + " " + this.height + " " + this.depth);
	}
	
	void calculate(){
		System.out.println("The volume of Box is : " + this.width * this.height * this.depth);
	}
		
	boolean isEqual(Box b){
		if(this.width == b.width && this.height == b.height && this.depth == b.depth){
			return true;
		} else {
			return false;
		}
	}
}