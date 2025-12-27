
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

public class Tree {

    Node root;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (root == null) { // 5 //10
            root = newNode;
        } else {
            Node current = root;
            Node parent = null;

            while (current != null) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            if (data < parent.data) {

                parent.left = newNode;
            } else {

                parent.right = newNode;
            }

        }

    }

    public void printTreeInorder() {
        printTreeInorder(root);
    }

    private void printTreeInorder(Node root) {
        if (root == null)
            return;
        printTreeInorder(root.left);
        System.out.print(root.data + " ");
        printTreeInorder(root.right);
    }

    public void printTreePreorder() {
        printTreePreorder(root);
    }

    private void printTreePreorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        printTreePreorder(root.left);
        printTreePreorder(root.right);
    }

    public int findSmallest() {

        return findSmallestRecursive(root);
    }

    public int findSmallest(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current.data;

    }

    public int findSmallestRecursive(Node root) {
    
        if (root == null) {
            return -1;
        } else {

            if (root.left == null) {
               return  root.data;
            }
        }

       return findSmallestRecursive(root.left);
    }

public int findMaxRecursive(){
    return findMaxRecursive(root);
}

     public int findMaxRecursive(Node root) {
    
        if (root == null) {
            return -1;
        } else {

            if (root.right == null) {
               return  root.data;
            }
        }

       return findMaxRecursive(root.right);
    }

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.addNode(50);
        tree.addNode(20);
        tree.addNode(30);
        tree.addNode(70);
        tree.addNode(40);
        tree.addNode(60);
        tree.addNode(80);

        tree.printTreeInorder();
        System.out.println("Min values");
        System.out.println(tree.findSmallest());


        System.out.println("Max Values"+tree.findMaxRecursive());

    }
}