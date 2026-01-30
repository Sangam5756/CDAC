package recursion;

/**
 * Shows examples of recursion - sum of elements in array,count down & 
 * reverse a string.
 *
 */
public class Main
{
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		System.out.println("Iterative Sum : "+sumIterative(arr,5));
		System.out.println("Helper Sum : "+sumIterativeHelper(arr,5));
		//System.out.println("Reverse : "+ reverse("ajay"));
		//countdown(5);
	}
	
	public static void countdown(int n) {
		if( n == 0) {
			System.out.println("Done...");
			return ;
		}
		
		System.out.println(n);
		countdown(n-1);
	}
	
	public static String reverse(String s) {
		if(null != s && s.length() <= 1  ) return s; //base case
		return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
	}
	
	
	
	
	
	
	
	public static int sumIterative(int arr[], int size){
	    int totalSum = 0;
	    for(int i = 0 ; i < size ; i++){
	        totalSum = totalSum+arr[i];
	    }
	    return totalSum;
	}
	
	//Pass smaller subset/version of the data to function above
	//Like Handle 1 file, pass the rest.
	public static int sumIterativeHelper(int arr[], int size){
	    
	    if(size == 0) return 0;
	    int lastOne = arr[size-1]; //1
	    int rest = sumIterative(arr,size-1); //14
	    return lastOne + rest; //15
	}
    
}