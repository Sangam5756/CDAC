class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;
    int size = 0;

    public void insertAtBegin(int data) {
        // create node
        Node newNode = new Node(data);
        // check head is null or not
        if (head == null) {
            head = newNode;
        }
        // if not then newNode will head and head becomes new node
        else {
            // if it is null, new node is head
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void reverse() {

        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

    }

    public void insertAtEnd(int data) {
        // create node
        Node newNode = new Node(data);
        // check head is null or not, if not then add new node
        if (head == null) {
            head = newNode;
        } else {
            // if there are multiple data after head then, iterate until null, create new
            // node
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position > size || position < 0) {
            System.out.println("invalid index");
            return;
        }
        if (head == null || position == 0) {
            insertAtBegin(data);
            return;
        }

        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteAtStart() {
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        // one element is there
        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        // now the head is not null has more that two element
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;

    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("The size is : " + size);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtBegin(20);
        list.insertAtBegin(10);
        list.insertAtEnd(30);
        list.reverse();
        list.display();
    }
}