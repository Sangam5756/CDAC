class Node {

	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}

}

class LinkedList{
	
	Node head;
	
	public boolean hasCycle() {
		
		Node slow = head;
		Node fast = head;
		while(null  != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return true;
		}
		return false;
	}
}

public class LinkedListCycleDemo{
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		Node ten = new Node(10);
		Node twenty = new Node(20);
		Node thirty = new Node(30);
		Node forty = new Node(40);
		Node fifty = new Node(50);
		Node sixty = new Node(60);

        // 10 → 20 → 30 → 40 → 50 → 60
	    //            ↑              ↓
	    //            ← ← ← ← ← ← ← ←

		list.head = ten;
		ten.next = twenty;
		twenty.next = thirty;
		thirty.next=forty;
		forty.next= fifty;
		fifty.next = sixty;
		sixty.next = thirty; // cycle.
		
		System.out.println("Has cycle : "+list.hasCycle());
	}
	
}
