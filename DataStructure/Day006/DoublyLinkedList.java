
class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
    }
}

public class DoublyLinkedList {

    Node head;
    Node tail;

    // ### 1. Insert at Head
    // Add a new node with the given data at the beginning of the list. Update the
    // head pointer accordingly.
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        // first check the head is not null
        if (isEmpty()) {
            head = tail = newNode;
        } else {

            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

    }

    // 2. Insert at Tail
    // Add a new node with the given data at the end of the list. Update the tail
    // pointer accordingly.

    public void insertAtTail(int data) {

        Node newNode = new Node(data);
        // first check the dll is empty or tail is null
        if (isEmpty()) {
            // if yes then insert at the head
            insertAtHead(data);
        }

        // if its not null then just do
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

    }

    // ### 3. Insert at Position
    // Insert a new node with the given data at a specific position (0-indexed).
    // Handle edge cases for invalid positions.
    public void insertAtIndex(int data, int index) {
        Node newNode = new Node(data);
        // here also need to check the dll is empty
        if (index == 0) {
            insertAtHead(data);
            return;
        }

        // traverse just before the index
        Node curr = head;
        int i = 0;
        while (i < index - 1 && curr != null) {
            curr = curr.next;
            i++;
        }

        // here we are check because if index goes beyond the size of dll
        if (curr == null) {
            System.out.println("Index out of bounds for insertion");
            System.out.println();
            return;
        }

        // this is last i understand when we are at end then newNode doesnt have any
        // prev so i was gettting nptrE
        // so then i check if my end is tail then insert at tail
        if (curr == tail) {
            insertAtTail(data);
            return;
        }

        // now we are at just before where node to be inserted
        // so here will add the node
        Node nextNode = curr.next;

        newNode.next = curr.next;
        newNode.prev = curr;

        curr.next = newNode;
        if (newNode != null) {

            nextNode.prev = newNode;
        }

    }

    // ### 4. Delete at Head
    // Remove the first node from the list. Update the head pointer. Handle the case
    // when the list is empty.
    public void deleteAtHead() {

        // we need to check that the if dll is empty or not
        if (isEmpty()) {
            System.out.println("Dll is empty");
            return;
        }
        Node temp = head.next;
        head = temp;
        temp.prev = null;

    }

    // ### 5. Delete at Tail
    // Remove the last node from the list. Update the tail pointer. Handle the case
    // when the list is empty.
    public void deleteAtTail() {
        // as to delete check its exist
        if (isEmpty()) {
            System.out.println("DLL is Empty");
            return;
        }

        if (tail.prev == null) {
            head = null;
            tail = null;
            return;
        }

        // Node temp = tail.prev;

        // temp.next =null;
        // tail.prev=null;
        // tail =temp;
        tail = tail.prev;
        tail.next = null;

    }

    // ### 6. Delete at Position
    // Remove the node at a specific position (0-indexed). Handle edge cases for
    // invalid positions and empty list.

    public void deleteAtIndex(int index) {

        // just check the head is there
        if (isEmpty()) {
            System.out.println("DLL is EMPTY");
            return;
        }
        // if the index is 0 so delete at the head
        if (index == 0) {
            deleteAtHead();
            return;
        }

        int i = 0;
        Node curr = head;
        // now so do the traversal

        while (i < index - 1 && curr.next != null) {
            curr = curr.next;
            i++;
        }

        // we should check the next of if yes then call the function
        if (curr.next == tail) {
            deleteAtTail();
            return;
        }

        

            curr.next = curr.next.next;
            curr.next.prev = curr;

    }

    // ### 9. Forward Traversal
    // Print all elements in the list from head to tail.
    public void displayLinkedListForward() {
        if (tail == null) {
            System.out.println("DLL is EMPTY");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ### 10. Backward Traversal
    // Print all elements in the list from tail to head.
    public void displayLinkedListReverse() {
        if (isEmpty()) {
            System.out.println("DLL is EMPTY");
        }
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // ### 11. Get Size
    // Return the number of nodes in the list.
    public void size() {

        if (isEmpty()) {
            System.out.println("DLL is EMPTY");
            System.out.println("Size of the LinkedList : " + 0);

            return;
        }
        Node temp = head;
        int size = 1;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        System.out.println("Size of the LinkedList : " + size);
        System.out.println();

    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtHead(10);
        list.insertAtHead(12);
        list.insertAtHead(13);

        // insertion at the tail
        list.insertAtTail(14);
        list.insertAtTail(15);

        // now insertion at perticular index

        list.insertAtIndex(16, 13);
        list.insertAtIndex(16, 1);
        list.insertAtIndex(17, 6);

        // size of dll
        list.size();
        // deletion at head
        list.deleteAtHead();

        // delete at the tail
        list.deleteAtTail();

        System.out.println("In FORWARD ORDER");
        list.displayLinkedListForward();
        // delete at index
        list.deleteAtIndex(5);
        System.out.println();
        System.out.println();
        System.out.println("after delete");
        System.out.println("In FORWARD ORDER");
        list.displayLinkedListForward();
        System.out.println("In ReverseOrder");
        list.displayLinkedListReverse();

    }
}
