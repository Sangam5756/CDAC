
class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class StackLinkedList {
    Node top;
    int size = 0;


    private boolean isEmpty(){
        return top == null;
    }

    public void push(int data){
        Node newNode = new Node(data);
        if(top == null){
            top = newNode;
            size++;
            return;
        }

        newNode.next = top;
        top = newNode;
        size++;
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }

        top = top.next;
        System.out.println("The element is poped: " + top.data);

    }

    public int peek(){
        return top.data;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }

        Node temp = top;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.display();
        stack.pop();
        stack.display();
        stack.peek();
    }
}