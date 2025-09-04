public class TestBox {
	public static void main(String[] args){
		Box b1 = new Box(1, 2, 3);
		b1.display();
		// b1++; Cannot assign uninary operator to Reference variable
		
		
		Box b2=b1;
		b1=new Box(3,4,5);
		//any objects marked for garbage collection ? how many : 0 
		
		Box b3=b1;
		b2=new Box(4,5,6);
		//any objects marked for garbage collection ? how many : 1
		
		
		b2.display();
		boolean b = b1.isEqual(b2);
		String result = b ? "Same Dimension" : "Different Dimension";
		System.out.println("Box has " + result);
		
		b2.calculate();
	}
}