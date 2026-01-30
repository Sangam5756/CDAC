package recursion;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {

	private static Map<Integer, Long> memo = new HashMap<>();

	public static void main(String[] args) {

		int n = 50;

		long ans = fibonacci(n);
		System.out.println(ans);
	}

	private static long fibonacci(int n) {
		if (n == 0 || n == 1)
			return n;
		else {
			if (memo.containsKey(n)) return memo.get(n);
		}
		long result = fibonacci(n - 1) + fibonacci(n - 2);
		memo.put(n, result);
		return result;
		// return fibonacci(n-1) + fibonacci(n-2);
	}
}
