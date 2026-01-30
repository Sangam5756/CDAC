
class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class CircularLinkedList {
	Node tail;
	int size;

	public CircularLinkedList() {
		this.tail = null;
	}

	//1.Handle empty list - next point to itself
	//2. newNode.next=tail.next && set tail
	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		if (tail == null) {
			newNode.next = newNode; // circular.
			tail = newNode;
			return;
		}
		newNode.next = tail.next; // new node points to head
		tail.next = newNode; // tail points to new node
		size++;
	}

	//1.Handle empty tail ==null(point to itself and make it tail)
	//2.
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if (tail == null) {
			newNode.next = newNode;
			tail = newNode;
		} else {
			newNode.next = tail.next;
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public void insertAtPosition(int data, int position) {
		if (position < 0 || position > size) {
			throw new IndexOutOfBoundsException("Invalid position");
		}

		if (position == 0) {
			insertAtBeginning(data);
			return;
		}

		if (position == size) {
			insertAtEnd(data);
			return;
		}

		Node newNode = new Node(data);
		Node current = tail.next; // start from head

		for (int i = 0; i < position - 1; i++) {
			current = current.next;
		}

		newNode.next = current.next;
		current.next = newNode;
		size++;
	}

	//1.Empty list
	//2.
	public void printList() {
	    if (tail == null) {
	        System.out.println("List is empty");
	        return;
	    }

	    Node current = tail.next; // head
	    do {
	        System.out.print(current.data + " -> ");
	        current = current.next;
	    } while (current != tail.next);

	    System.out.println("(back to head)");
	}
	
	public void deleteFromBeginning() {
	    if (tail == null) {
	        System.out.println("List is empty");
	        return;
	    }

	    // Only one node
	    if (tail.next == tail) {
	        tail = null;
	    } else {
	        tail.next = tail.next.next; // skip the head
	    }
	    size--;
	}
	
	public void deleteFromEnd() {
	    if (tail == null) {
	        System.out.println("List is empty");
	        return;
	    }

	    // Only one node
	    if (tail.next == tail) {
	        tail = null;
	    } else {
	        Node current = tail.next; // start at head

	        // Move until current.next == tail
	        while (current.next != tail) {
	            current = current.next;
	        }

	        // current is now the node before tail
	        current.next = tail.next; // connect to head
	        tail = current;           // update tail
	    }

	    size--;
	}
	
	public void deleteFromPosition(int pos) {
	    if (pos < 0 || pos >= size) {
	        throw new IndexOutOfBoundsException("Invalid position");
	    }

	    if (pos == 0) {
	        deleteFromBeginning();
	        return;
	    }

	    Node current = tail.next; // head

	    for (int i = 0; i < pos - 1; i++) {
	        current = current.next;
	    }

	    // now current is at the node before the one to delete
	    Node toDelete = current.next;

	    // If deleting the tail
	    if (toDelete == tail) {
	        deleteFromEnd();
	        return;
	    }

	    current.next = toDelete.next;
	    size--;
	}
	
	public int search(int key) {
	    if (tail == null) return -1;

	    Node current = tail.next; // head
	    int index = 0;

	    do {
	        if (current.data == key) {
	            return index;
	        }
	        current = current.next;
	        index++;
	    } while (current != tail.next);

	    return -1; // not found
	}




}

public class CircularLinkedListDemo{
	
	public static void main(String[] args) {
	 	CircularLinkedList list = new CircularLinkedList();
	    list.insertAtBeginning(30);   // 30
	    list.insertAtEnd(40);	  // 30 -> 40
	    list.insertAtBeginning(20);   // 20 -> 30 -> 40
	    list.insertAtPosition(25, 1); // 20 -> 25 -> 30 -> 40
	    list.printList();
	 }
}
