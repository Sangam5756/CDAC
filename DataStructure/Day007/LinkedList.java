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


    
    public  Node  reverseLinkedList(Node head){

        // if the head is null then no need to do anything
        if(head == null || head.next==null){
            return null;
                }
        //  to just reverse the next node ok

        Node newHead= reverseLinkedList(head.next);
        
        // just point heads next to head
        head.next.next= head;
        
        // make the head next null as its tail of the linkedlist
        head.next=null; 

         return newHead;
    }
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

    public void addAtTail(int data){
        Node newNode = new Node(data);

        if(head == null)
        {
            addAtHead(data);
            return;
        }

        // so here head is not null
        Node temp =head;

        while(temp.next!=null){
                temp =temp.next;

        }

        temp.next =newNode;



    }


public void addAtIndex(int data,int index){
        Node newNode =new Node(data);
        if(head == null || index==0){
            addAtHead(data);
            return;
        }

        // now the head is not null
        // traverse till the end index just stop before the one position
        Node temp =head;
        while((index-1) > 0 && temp.next !=null)
        {
            temp=temp.next;
            index--;
        }
        // now we are at the 
        newNode.next = temp.next;
        temp.next=newNode;
    }


     

public void deleteAtHead(){
        if(head == null)
        {
            System.out.println("Linked list is empty");
            return;
        }

        // hey now suppose if we go there and the do the following
        head = head.next;

        


    }

    public void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public void deleteAtIndex(int index){
        // if head is null

            if(head == null)
        {   
            System.out.println("Linked List is null");

            return;
        }

        if(head !=null && index==0)
        {
            deleteAtHead();
            return;
        }

    
        Node temp =head;
        for(int i=0; i<index-1 && temp.next!=null;i++){
            temp=temp.next;
        }


        // now we are at index whenere next of that need to be deleted
        temp.next  = temp.next.next;
    


    }

    public void deleteAtEnd(){
        if(head == null)
        {   
            System.out.println("Head is Null");
            return;
        }

        // travel till end
        Node temp = head;

        if(temp.next ==null){
            head=null;
            return;
        }

        while(temp.next.next!=null){
            temp =temp.next;
        }

        temp.next=null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        list.addAtTail(6);
        list.addAtIndex(7,5);
        list.display(list.head);
list.deleteAtIndex(5);
        // list.deleteAtEnd();
        list.display(list.head);




    }

}
