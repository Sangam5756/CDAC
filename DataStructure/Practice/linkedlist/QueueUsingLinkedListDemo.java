class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next  = null;
	}
}

class QueueUsingLinkedList{
	Node front;
	Node rear;
	
	public void enqueue(int data) {
		Node newNode = new Node(data);
		if(front == null) {
			front = rear = newNode;
		}else {
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Cannot deque from empty queue...");
			return -1;
		}
		int data = front.data;
		front = front.next;
		
		if(front == null) {
			rear = null;
		}
		return data;
	}
	
	private boolean isEmpty() {
		return front == null;
	}
	
	public int peek() {
		return front.data;
	}
}
/**
 * Fill in the main method to enqueue,dequeue,peek on a queue.
 *
 */
public class QueueUsingLinkedListDemo {

}
