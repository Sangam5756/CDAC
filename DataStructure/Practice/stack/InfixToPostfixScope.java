import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Converts a given infix expression to postfix.
 *
 */
public class InfixToPostfixScope {
	public static void main(String[] args) {

		String infix = "A+B*C-D/E^F";
		String postfix = infixToPostfix(infix);
		System.out.println("Postfix is " + postfix);
	}

	private static String infixToPostfix(String infix) {

		Deque<Character> stack = new ArrayDeque<>();
		StringBuilder output = new StringBuilder();

		// Currently does not handle right associative for ^

		for (char c : infix.toCharArray()) {
			if (c == ' ')
				continue;

			if (Character.isLetterOrDigit(c)) {
				output.append(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					output.append(stack.pop());
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && stack.peek() != '(' && precedence(c) <= precedence(stack.peek())) {
					output.append(stack.pop());
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			output.append(stack.pop());
		}

		return output.toString();
	}

	private static int precedence(char c) {
		return switch (c) {
		case '^' -> 3;
		case '/', '*' -> 2;
		case '+', '-' -> 1;
		default -> throw new IllegalArgumentException("Invaid character...");
		};
	}

}
