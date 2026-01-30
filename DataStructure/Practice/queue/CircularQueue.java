/**
 * Shows how to implement Circular Queue using array.
 *
 */

class CircularQueue {
    int[] array;
    int front, rear, maxSize, count;
    
    public CircularQueue(int size) {
        maxSize = size;
        array = new int[maxSize];
        front = 0;
        rear = -1;
        count = 0;  // Recommended: use count
    }
    
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % maxSize;
        array[rear] = element;
        count++;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int element = array[front];
        front = (front + 1) % maxSize;
        count--;
        return element;
    }
    
    boolean isEmpty() {
        return count == 0;
    }
    
    boolean isFull() {
        return count == maxSize;
    }

    // Display queue contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty!");
            return;
        }
        
        System.out.print("Circular Queue: ");
        int i = front;
        int currentCount = 0;
        
        while (currentCount < count) {
            System.out.print(array[i] + " ");
            i = (i + 1) % maxSize;  // Circular increment
            currentCount++;
        }
        System.out.println();
    }
}