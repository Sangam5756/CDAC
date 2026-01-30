package recursion;


class Nodes{
	int data;
	Nodes next;
	
	public Nodes(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedLists{
	
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


	
	// Display the list - iterative
    public void display() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
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
	
	public int countNegativeValues() {
		return countNegativeValues(head);
	}
	
	private int countNegativeValues(Node head) {
		if(head == null ) return 0;
		int count = countNegativeValues(head.next);
		if(head.data < 0 ) count++;
		return count;
	}
	
}

public class LinkedListNegativeValuesRecursion {
	
	public static void main(String[] args) {
        LinkedLists list = new LinkedLists();
        
        // Create list: -10 -> 20 -> 30 -> -40 -> -50 -> 60 -> null
        list.addNode(-10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(-40);
        list.addNode(-50);
        list.addNode(60);
        
        System.out.print("List Data:");
        list.display();
        
        System.out.print("Counting negative data in list : ");
        System.out.println(list.countNegativeValues());   
	}
}
