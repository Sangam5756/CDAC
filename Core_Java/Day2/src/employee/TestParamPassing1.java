class TestParamPassing1 {
	public static void main(String[] args) {
		TestParamPassing1 ref=new TestParamPassing1();
		Emp e1 = new Emp(1, "aa", 1000);
		System.out.println("orig sal bef  =" + e1.getSal());
		ref.testMe(e1.getSal(), 100);
		System.out.println("in main, after updation  =" 
		+ e1.getSal());
	}

	 void testMe(double sal, double inc) {
		
		sal += inc;
		System.out.println("in meth sal=" + sal);
	}

}
