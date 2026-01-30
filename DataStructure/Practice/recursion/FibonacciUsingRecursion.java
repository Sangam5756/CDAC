package recursion;

public class FibonacciUsingRecursion {
	
	public static void main(String[] args) {
		int  n = 6;
		for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
	}
	
	private static int fibonacci(int n) {
		if(n == 0 || n == 1) return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
