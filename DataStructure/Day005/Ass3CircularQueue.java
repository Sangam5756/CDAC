
/*
 * 3.Implement Circular Queue using Array that includes operations like:
 * enqueue,dequeue,isFull,isEmpty,peek.
 * Also display the contents of the queue.
 * Enqueue and Dequeue multiple times to check the contents of the circular
 * queue.
 */
public class Ass3CircularQueue {

    /*
     * circular queue is more efficient way of using queue as we can utilize the
     * free
     * space which was left behind in simple queue
     * so in ciruclar queue we use a formula to calculate the exac position of front
     * and
     * the rear
     * which is
     * front = (front+1)%maxCapacity
     * rear= (rear+1)%maxCapacity
     */
    int front = 0;
    int rear = -1;
    int maxSize;
    int count;
    int[] arr;

    public Ass3CircularQueue(int maxCapacity) {
        this.maxSize = maxCapacity;
        arr = new int[maxSize];
        count = 0;
    }

    void enqueue(int data) {
        if (isFull())
            throw new RuntimeException("queue is full");
        rear = (rear + 1) % maxSize;
        arr[rear] = data;
        count++;
        System.out.println(data + " inserted into queue");
    }

    // remove from the queue
    int dequeue() {
        if (isEmpty())
            throw new RuntimeException("queue is empty");

        front = (front + 1) % maxSize;
        count--;
        System.out.println(front + "position of front element is    " + arr[front]);
        return arr[front];
    }

    // check isFull
    boolean isFull() {
        // queue is full when rear becomes the size
        // JUST CHECK COUNTER IS EQUAL TO MAX SIZE AS WE ARE GOING TO INCREASE AT TIME
        // OF INSERTION
        // AND DELETE AT TIME OF DELETION
        return count == maxSize;
    }

    // check isEmpty
    boolean isEmpty() {
        // checking the queue is empty means
        // JUST CHECK THE COUNTER IS ZERO OR NOT
        return count == 0;
    }

    // disply elements
    void display() {

        for (int i = front; i <= rear; i++) {

            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] args) {

        Ass2_Queue queue = new Ass2_Queue(5);
        System.out.println("checking queu is empty or not ------ " + queue.isEmpty());
        System.out.println("checking queu isFull or not ------ " + queue.isFull());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("checking queu is empty or not ------ " + queue.isEmpty());
        System.out.println("checking queu isFull or not ------ " + queue.isFull());

        queue.display();
        System.out.println("removing from the queue");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(7);


        queue.display();
        System.out.println("checking queu  isEmpty or not ------ " + queue.isEmpty());
        System.out.println("checking queu isFull or not" + queue.isFull());

    }
}