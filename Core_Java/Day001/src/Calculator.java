import java.util.Scanner;

public class Calculator{
	public static void main(String[] args){
		
	Scanner sc = new Scanner(System.in);
	int ch;
	double n1,n2;
	
	do{
			
	System.out.println("1. Add");
	System.out.println("2. Sub ");
	System.out.println("3. divide");
	System.out.println("4. multiply");
	System.out.println("Enter your Choice : ");
	ch = sc.nextInt();
	
	switch(ch){
		case 1:{
			System.out.println("Enter the Two Number : ");
			n1 =sc.nextDouble();
			n2 =sc.nextDouble();
			System.out.println("Addition Of Two Number is : "+ (n1+n2));
			break;
		}
		case 2:{
			System.out.println("Enter the Two Number : ");
			n1 =sc.nextDouble();
			n2 =sc.nextDouble();
			System.out.println("Subtraction Of Two Number is : "+ (n1-n2));
			break;
		}
		case 3:{
			System.out.println("Enter the Two Number : ");
			n1 =sc.nextDouble();
			n2 =sc.nextDouble();
			System.out.println("Division Of Two Number is : "+ (n1/n2));
			break;
		}
		case 4:{
			System.out.println("Enter the Two Number : ");
			n1 =sc.nextDouble();
			n2 =sc.nextDouble();
			System.out.println("Multiplication Of Two Number is : "+ (n1*n2));
			break;
		}
		default:
			System.out.println("Invalid choice " );
			break;
	
	}
			

	}while(ch!=0);
	
}
}