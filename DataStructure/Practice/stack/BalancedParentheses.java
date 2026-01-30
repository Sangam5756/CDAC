
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Code for check if parentheses is balanced.
 *
 */
public class BalancedParentheses {

	public static void main(String[] args) {
		// [(]), ((() , ())
		String expression = "()()";
		boolean isBalanced = checkIfBalanced(expression);
		System.out.println("Is it balanced ? " + isBalanced);
	}

	public static boolean checkIfBalanced(String expression) {
		Deque<Character> stack = new ArrayDeque<>();
		for (char c : expression.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;
				char openingBracket = stack.pop();
				//Can combine all 3 together to return false.
				if (c == ')' && openingBracket != '(')
					return false;
				if (c == ']' && openingBracket != '[')
					return false;
				if (c == '}' && openingBracket != '{')
					return false;
			}
		}
		return stack.isEmpty();
	}

}
