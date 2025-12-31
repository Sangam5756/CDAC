package Practice;

public class Queue {

    // will do the queue using the stack
    int arr [] ;
    int front;
    int rear;
    int size;
    int capacity;

    public Queue(int size)
    {
        this.size =0;
        this.capacity=size;
        front =0;
        rear =-1;
        arr  = new int[size];
    }

    public void dequeue(){
        if(isEmpty()) return;
        front++;
        size--;

    }

    public void enqueue(int data){
        if(isFull()) return;
        arr[++rear] =data;
        size++;
    }

    public boolean isFull(){
        return size==capacity;
    }
    public int getFront(){
        if(isEmpty()) return -1;

        return arr[front];
    }
    
    public boolean isEmpty(){
        return size == 0;
    }

    public int getRear(){
        if(isEmpty())return -1;
        return arr[rear];
    }

    // display the queuen
    public void display(){
        if(isEmpty()) return;
        System.out.println("Display Elements of Stack");
        for(int i=front; i<=rear; i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
            Queue q = new Queue(5);
            q.enqueue(1);
            q.enqueue(2);
            q.enqueue(3);
            System.out.println(q.getRear());
            System.out.println(q.getFront());
            q.display();
            q.dequeue();
            q.display();

    }
}
