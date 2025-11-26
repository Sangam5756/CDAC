public class LinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    Node head;

    // add at head;
    public void addAtHead(int data) {
        Node newNode = new Node(data);
        // suppose head is null
        if (head == null) {
            head = newNode;
        } else {
        // if the head is not null
            // then
            newNode.next = head;
            head = newNode;
        }

    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addAtHead(1);
        list.addAtHead(23);
        list.addAtHead(231);
        list.addAtHead(24);
        list.addAtHead(25);
        list.display();

    }

}
