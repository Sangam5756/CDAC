class  TestParamPassing2
{
	public static void main(String[] args) {
	TestParamPassing2 ref=new TestParamPassing2();
	Emp e1=new Emp(1,"aa",1000);
	System.out.println("orig sal bef  ="+e1.getSal() );
	testMe(e1,100);
	System.out.println("in main, after updation   ="+e1.getSal());
	}
	
	 void testMe(Emp e,double inc)
	{
		e.setSal(e.getSal()+inc);
		System.out.println("in meth2 sal="+e.getSal());
	}

}
