package recursion;

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList{
	
	Node head;
	
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


    public void reverseList() {
    	head = reverseList(head);
    }
    
	private Node reverseList(Node head) {
		//base condition
		if(head == null || head.next == null) return head;
		//Reverse rest of the list and give it to me.
		Node newHead = reverseList(head.next);
		
		//I will adjust my references now.
		head.next.next=head;
		head.next=null;
		
		return newHead;
	}
	
	// Display the list - iterative
    public void display() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }
	
	public void printList(Node head) {
	    if (head == null) {
	        return;  // Base case
	    }
	    
	    System.out.println(head.data);
	    printList(head.next);  // Recursive call
	}
	
}

public class ReverseLinkedListRecursion {
	
	public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Create list: 10 -> 20 -> 30 -> 40 -> null
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        
        System.out.println("Before Reversal:");
        list.display();
        
        list.reverseList();
        
        System.out.println("\nAfter Reversal:");
        list.display();

	}
}
