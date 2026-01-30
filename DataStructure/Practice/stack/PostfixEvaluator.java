import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixEvaluator {

	public static void main(String[] args) {
		// infix : (5+3)*2 //postfix : 53+2*
		// infix : 8/2-3 //postfix : 82/3-
		// infix : (5*(6+2)/4) //postfix : 562+*4

		String postFix = "82/3-";
		int result = evaluateExpression(postFix);
		System.out.println("Result from evaluating postfix expression is : " + result);
	}

	public static int evaluateExpression(String postfix) {

		Deque<Integer> stack = new ArrayDeque<>();
		for (char c : postfix.toCharArray()) {
			if (Character.isDigit(c)) {
				stack.push(c - '0'); // ascii of '0' is 56-48
			} else if (isOperator(c)) {
				int second = stack.pop();
				int first = stack.pop();
				int result = calculate(first, second, c);
				stack.push(result);
			} else {
				throw new IllegalArgumentException("Invalid postfix expression....");
			}
		}

		return stack.pop();

	}

	private static int calculate(int first, int second, char c) {

		switch (c) {
		case '+':
			return first + second;
		case '-':
			return first - second;
		case '*':
			return first * second;
		case '/':
			return first / second;
		case '^':
			return (int) Math.pow(first, second);
		}
		return 0;
	}

	private static boolean isOperator(char ch) {
		return (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^');
	}
}
