import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

	private Deque<Integer> stack;
	private Deque<Integer> minStack;

	public MinStack() {

		stack = new ArrayDeque<>();
		minStack = new ArrayDeque<>();

	}

	public void push(int val) {

		stack.push(val);

		if (minStack.isEmpty() || val <= minStack.peek()) {
			minStack.push(val);
		} else { // to handle incorrect number of elements in min stack.
			minStack.push(minStack.peek());
		}

	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int min() {
		return minStack.peek(); // always gives min value in O(1)
	}

	public static void main(String[] args) {
		MinStack ms = new MinStack();

		System.out.println("Pushing: 5");
		ms.push(5);
		System.out.println("Current Min: " + ms.min());

		System.out.println("\nPushing: 3");
		ms.push(3);
		System.out.println("Current Min: " + ms.min());

		System.out.println("\nPushing: 7");
		ms.push(7);
		System.out.println("Current Min: " + ms.min());

		System.out.println("\nPushing: 3");
		ms.push(3);
		System.out.println("Current Min: " + ms.min());

		System.out.println("\nTop element: " + ms.top());

		System.out.println("\nPopping");
		ms.pop();
		System.out.println("Current Min: " + ms.min());

		System.out.println("\nPopping");
		ms.pop();
		System.out.println("Current Min: " + ms.min());

		System.out.println("\nPopping");
		ms.pop();
		System.out.println("Current Min: " + ms.min());

		System.out.println("\nTop element now: " + ms.top());
	}
}
