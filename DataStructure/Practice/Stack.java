package Practice;

public class Stack {

    int arr[];
    int size;
    int top;

    public Stack(int n) {
        arr = new int[n];
        top = -1;
        size = n;
    }

    public void push(int data) {
        if(isFull()){
            return;
        }
        arr[++top] = data;
    }

    public int pop() {
        if(isEmpty()){
            return -1;
        }
        return arr[top--];

    }

    public int peek() {
        if(isEmpty())return -1;
        return arr[top];
    }

    public boolean isEmpty() {
        return(top == -1);
    }

    public boolean isFull() {
            return top == size;
    }

    public void printStack(){
        if(isEmpty()){
            return;
        }
        for(int i=0; i<=top;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
            Stack st  = new Stack(5);
            System.out.println(st.pop());
            System.out.println(st.peek());
            st.push(1);
            st.push(2);
            st.push(4);
            System.out.println(st.peek());
            System.out.println(st.pop());
            System.out.println(st.pop());
            System.out.println(st.pop());
            st.printStack();
    }

}
