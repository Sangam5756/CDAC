class DoublyLinkedList{
	
	Node head;
	Node tail;
	
	class Node{
		int data;
		Node next;
		Node prev;
		
		public Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
		
	}
	
	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head=tail=newNode;
			return ;
		}
		
		newNode.next = head;
		head.prev = newNode;
		head=newNode;
	}
	
	public void insertAtTail(int data) {
		Node newNode = new Node(data);
		if(tail == null) {
			head=tail=newNode;
			return ;
		}
		
		tail.next = newNode;
		newNode.prev = tail;
		tail=newNode;
	}

	/**
	 * Handle index = head and index = tail
	 * @param index
	 * @param data
	 */
	public void insertAtIndex(int index, int data) {
		Node current = head;
		
		if(index == 0 ) {
			insertAtHead(data);
			return ;
		}
		
		for(int i = 0 ; i < index-1 && current !=null ;i++) {
			current = current.next;
		}
		
		if(current == null) {
			System.out.println("Index is out of bounds for insert at index op...");
			return;	
		}
		//tail position
		if(current == tail) {
			insertAtTail(data);
			return ;
		}
		
		Node newNode = new Node(data);
		
		newNode.next= current.next;
		newNode.prev = current;
		current.next.prev = newNode; //1st this
		current.next = newNode;		//then this
	}
	/**
	 * Check for empty and single
	 */
	public void deleteHead() {
		
		if(head == null) return;
	
		if(head == tail) {
			head=null;
			tail=null;
			return;
		}
		
		Node temp = head;
		head = temp.next;
		head.prev=null; //Don't miss
		temp.next=null;
	}
	
	/**
	 * Check for empty and single
	 * 4 l
	 */
	public void deleteTail() {
		if(tail == null) return;
		if(head == tail) {
			head = tail = null;
			return;
		}
		Node temp = tail;
		tail=tail.prev;
		tail.next=null;
		temp.prev=null;	
	}
	
	public void deleteAtIndex(int index) {
		if(index == 0 ) {
			deleteHead();
			return ;
		}
		Node current = head;
		for(int i = 0; i < index -1 && current != null;i++) {
			current= current.next;
		}
		if(current == null) {
			System.out.println("Index is invalid...");
			return;
		}
		
		Node toBeDeleted = current.next;
		if(toBeDeleted == tail) {
			deleteTail();
			return ;
		}
		
		current.next = toBeDeleted.next;
		toBeDeleted.next.prev=current;
		toBeDeleted.next = null;
		toBeDeleted.prev=null;
		
	}
	
	//Find node, set a reference to prev and next.
	public void deleteByValue(int data) {
		if(head==null) {
			return ;
		}
		if(head.data == data) {
			deleteHead();
			return;
		}
		
		Node temp = head;
		while(temp.data != data && temp !=null) {
			temp=temp.next;
		}
		if(temp == null) return;
		if(temp==tail) {
			deleteTail();
			return;
		}
		
		Node prevNode = temp.prev;
		Node nextNode = temp.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		
		temp.next=temp.prev=null;
	}
	
	public void traverseForward() {
		System.out.println("Traversing in fwd direction: ");
		Node current  = head;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
	
	
}
public class DoublyLinkedListDemo {
	
	
	public static void main(String[] args) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		
		doublyLinkedList.insertAtHead(10);
		doublyLinkedList.insertAtHead(20);
		doublyLinkedList.insertAtHead(30);
		doublyLinkedList.insertAtTail(8);
		doublyLinkedList.insertAtTail(5);
		doublyLinkedList.insertAtHead(45);
		doublyLinkedList.insertAtIndex(10,40);
		doublyLinkedList.traverseForward();
	}

}
