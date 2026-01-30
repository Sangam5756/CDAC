/**
 * Stack using array.
 * Shows how to implement push,pop,peek,display,isEmpty,isFull
 *
 */
class StackUsingArray{
	
	int []stackArray;
	int top;
	int maxSize;
	
	public StackUsingArray(int size) {
		stackArray = new int[size];
		top = -1;
		maxSize = size;
	}
	
	//stack.push(10);
	public void push(int data) {
		if(isFull()) {
			System.out.println("Stack is full, cannot insert anymore...");
			return ;
		}
		stackArray[++top] = data;
		System.out.println("Pushed "+ data + " into the stack");
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Cannot pop from empty stack...");
			return -1;
		}
		return stackArray[top--];
	}
	
	public int peek() {
		return stackArray[top];
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Stack is empty...Nothing to display");
			return ;
		}
		
		for(int i = 0 ; i <=top ; i++) {
			System.out.println(stackArray[i] + " ");
		}
	}
	
	private boolean isFull() {
		return top == maxSize -1;
	}
	
	private boolean isEmpty() {
		return top == -1;
	}
}


public class StackUsingArrayDemo {
	
	public static void main(String[] args) {
		StackUsingArray stackUsingArray = new  StackUsingArray(5);
		stackUsingArray.push(10);
		stackUsingArray.push(20);
		stackUsingArray.push(30);
		stackUsingArray.push(40);
		stackUsingArray.push(50);
		
		stackUsingArray.display();
		stackUsingArray.push(60);
		
		System.out.println("Popped : "+stackUsingArray.pop());
		stackUsingArray.display();
	}
}