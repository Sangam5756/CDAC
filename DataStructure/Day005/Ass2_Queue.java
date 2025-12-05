public class Ass2_Queue {
    /*
     * 
     * 2.Implement Linear Queue using Array that includes operations like:
     * enqueue,dequeue,isFull,isEmpty,peek.
     * Also display the contents of the queue.
     * Enqueue and Dequeue multiple times to check the contents of the queue.
     */

    // queue is data structure which follows fifo so
    // we insert from the end and remove from the front
    // so we need the two pointer to track the front and rear to insert
    // all the operaion insertion and deleteion in qeuer happen at constant time
    // but the drawback of queuw is we cant use unused space
    // i mean when eg
    // arr size 4 has elemtn 5 ok we remove from front so front point to 0 to 1
    // index right
    // so on but the space before the front is empty
    // that what i am talking about

    int front = 0;
    int rear = -1;
    int maxSize;
    int[] arr;

    public Ass2_Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    // Add to queue
    void enqueue(int data) {
        if (isFull())
            throw new RuntimeException("queue is full");
        arr[++rear] = data;
        System.out.println(data + " inserted into queue");
    }

    // remove from the queue
    int dequeue() {
        if (isEmpty())
            throw new RuntimeException("queue is empty");

        System.out.println(front + "position of front");
        return arr[front++];
    }

    // check isFull
    boolean isFull() {
        // queue is full when rear becomes the size
        return rear == maxSize - 1;
    }

    // check isEmpty
    boolean isEmpty() {
        // checking the queue is empty means
        // after removing from queue if front goes after the rear then
        // queue is empty
        if (front > rear) {
            return true;
        }
        return false;
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
        queue.dequeue();
        queue.dequeue();

        queue.display();
        System.out.println("checking queu  isEmpty or not ------ " + queue.isEmpty());
        System.out.println("checking queu isFull or not" + queue.isFull());

    }

}
