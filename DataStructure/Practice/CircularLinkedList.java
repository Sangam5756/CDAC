package Practice;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {

    Node head;

    public void insertAtHead(int data) {

        // if the head is null
        // then make new Node as head and make it point to the self
        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            return;

        }

        // now if the head is not null and will see how to insert at the head without
        // that
        Node temp = head;

        // we need to travel the ll till we find the head ok
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            insertAtHead(data);
            return;
        }

        // now if the list is not empty;

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;

        }
        // now we are at the end
        temp.next = newNode;
        newNode.next = head;

    }

    public void insertAtIndex(int data, int index) {
        Node newNode = new Node(data);
        if (index < 0) {
            System.out.println("Enter the valid positive index");
            return;
        }

        if (index == 0) {
            insertAtHead(data);
            return;
        }

        if (head == null) {
            System.out.println("Exceed the Index");
            return;
        }

        // now till at end we need to travel
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {

            if (temp.next == head) {
                System.err.println("Cant find the index excedd the size");
                return;
            }
            temp = temp.next;

        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    // deletion operation
    public void deleteAtBeginning() {

        // first check its null
        if (head == null) {
            System.out.println("Likedlist is Empty");
            return;
        }
        if(head.next == head){
            head =null;
            return;
        }

        // now we have head so now wee need one thingthat see our tail is pointing to
        // head
        // if we just posint head = head.next then weill lose the last node
        // first go to end find the point make it point to head.next then move head to
        // head.next
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        Node curr = head;
        temp.next = curr.next;
        head = curr.next;

    }

    public void deleteAtEnd() {

        // go till end and just before the pointer of the make it null and point temp
        // prev direct to head

        if (head == null) {
            System.out.println("LinkedLIst is Empty");
            return;
        }
        if (head.next == head) {
            head = null;
            return;

        }
        // now the ll is not empty;
        Node temp = head;
        Node prev = null;
        while (temp.next != head) {
            prev = temp;
            temp = temp.next;
        }
        // now we are at the end while temo is point to head;
        // so now wanna make prev point to head and
        // remove the link of temp to head

        prev.next = temp.next;
        temp.next = null;

    }

    public void deleteAtIndex(int index) {

        if (isEmpty())
            return;

        if (index == 0) {
            deleteAtBeginning();
            return;
        }

        if (head.next == head) {
            deleteAtBeginning();
            return;
        }


        // now we are needn to travel
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            if(temp.next ==head)
{
    return;
}
            temp = temp.next;
        }

        // now we are just before the index
       
        temp.next = temp.next.next;

    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {

        if (head == null) {
            System.out.println("Linkedlist is Empty");

            return;
        }

        // now
        Node temp = head;
        do {
            System.out.print(temp.data + "->");
            temp = temp.next;
        } while (temp != head);

        System.out.println("null");

    }

    public static void main(String[] args) {

        CircularLinkedList list = new CircularLinkedList();

        list.insertAtHead(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        // list.insertAtTail(4);
        list.display();
        // list.insertAtIndex(15, 3);
        list.deleteAtIndex(1);
        list.deleteAtIndex(0);
        list.deleteAtIndex(0);


  
        // list.deleteAtBeginning();
        // list.deleteAtEnd();
        // list.deleteAtEnd();
        // list.deleteAtEnd();

        list.display();
    }
}
