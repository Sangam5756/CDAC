/**
 * Show how to implement Queue using an array.
 * Shows enqueue,dequeue,isFull,isEmpty,peek,display 
 */
class LinearQueue {
	
	int arr[];
	int front;
	int rear;
	int maxSize;
   
    
    public LinearQueue(int size) {
    	this.maxSize = size;
    	this.arr = new int[maxSize];
    	this.front = 0;
    	this.rear = -1;
    }
    
    public void enqueue(int element) {
    	if(isFull()) {
    		System.out.println("Queue is full, cannot add anymore...");
    		return ;
    	}
    	arr[++rear] = element;
    }
    
    public int dequeue() {
    	if(isEmpty()) {
    		System.out.println("Queue is empty, nothing to remove...");
    		return -1;
    	}
    	return arr[front++];
    }

    // Peek at front element
    public int peek() {
    	return arr[front];
    }
    
    public boolean isEmpty() {
    	return front > rear;
    }
    
    public boolean isFull() {
    	return rear == maxSize-1;
    }

    // Display queue contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
public class QueueDemo {
    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5);
        
        // Adding elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        
        queue.display();  // Output: Queue: 10 20 30 40 50
        
        // Trying to add to a full queue
        queue.enqueue(60);  // Output: Queue Overflow!
        
        // Removing elements
        queue.dequeue();  // Output: 10 removed from queue
        queue.dequeue();  // Output: 20 removed from queue
        
        queue.display();  // Output: Queue: 30 40 50
        
        // Peek at front
        System.out.println("Front element: " + queue.peek());  // Output: 30
    }
}