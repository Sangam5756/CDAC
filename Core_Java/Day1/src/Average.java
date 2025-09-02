import java.util.Scanner;

public class Average{

	public static void main(String[] args){
		double a,b,c,d,e;		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the 5 double number  : ");
		a=sc.nextDouble();
		b=sc.nextDouble();
		c=sc.nextDouble();
		d=sc.nextDouble();
		e=sc.nextDouble();
		double result = (a+b+c+d+e)/5;
		System.out.println("Average of 5 double number is : "+result);
	
		sc.close();
	
}
}