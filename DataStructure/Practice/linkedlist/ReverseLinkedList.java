class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    
    public LinkedList() {
        head = null;
    }
    
    // Add node at the end
    public void addNode(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    // Reverse the linked list
    // Before Reversal:
    // List: 10 ->� 20 -> 30 -> 40 -> null

    // After Reversal:
    // List: 40 -> 30 -> 20 -> 10 -> null

    public void reverse() {
        Node prev = null;           // Initialize prev
        Node current = head;        // Initialize current
        
        while (current != null) {
            // STEP 1: SAVE
            Node next = current.next;  // Save the next address BEFORE we change it
            
            // STEP 2: REVERSE
            current.next = prev;       // Point current backwards to prev
            
            // STEP 3: MOVE_PREV
            prev = current;            // Move prev to current
            
            // STEP 4: MOVE_CURR
            current = next;            // Move current to the saved next
        }
        
        // After loop: Update head to the new start
        head = prev;
    }
    
    // Display the list
    public void display() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    } 
   
}

public class ReverseLinkedList{
	 // Main method to test
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Create list: 10 → 20 → 30 → 40 → null
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        
        System.out.println("Before Reversal:");
        list.display();
        
        list.reverse();
        
        System.out.println("\nAfter Reversal:");
        list.display();
    }
}
