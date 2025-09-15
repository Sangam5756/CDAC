import java.util.Scanner;
class Menu{
	public static void main(String[] args){
		
	Scanner sc  = new Scanner(System.in);
	int dosa =70;
	int samosa=30;
	int idli = 40;
	double total=0;
	int ch;
	do{
		System.out.println("1.Dosa");
		System.out.println("2.Samosa");
		System.out.println("3.Idli");
		System.out.println("4.Generate Bill");
		System.out.println("Enter the Choice : ");
		ch = sc.nextInt();

		switch(ch)
	{
			case 1:{
				total+=dosa;	
				break;
			}
			case 2:{
				total+=samosa;
				break;
			}
			case 3:{
				total+=idli;
				break;
			}
			case 4:{
				System.out.println("------------------------ Your Bill ------------------------------");
				System.out.println("Your Bill is : "+total);
				System.out.println("------------------------- ----------------------------------------");
				total=0;
				break;
			}
			default:{
			break;
			}

}

		}while(ch!=4);


}
}