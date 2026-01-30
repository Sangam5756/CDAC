package bst;

import java.util.ArrayDeque;
import java.util.Deque;


class BinarySearchTree{
	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	Node root;
	
	/**
	 * Another way to insert using while(1)
	 * @param data -The new data/node to insert in tree.
	 */

	public void addToTree(int data) {
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
		}else {
			Node current = root;
			while(true) {
				if(data < current.data) {
					if(current.left == null) {
						current.left = newNode;
						break;
					}else {
						current = current.left;
					}
				}else {
					if(current.right ==null) {
						current.right = newNode;
						break;	
					}else {
						current = current.right;	
					}
				}
			}
		}
	}
	
	/**
	 * Another way to insert without using while(1)
	 * Keeps track of parent since current becomes null.
	 * @param data -The new data/node to insert in tree.
	 */
	public void insertIntoTree(int data) {
		Node newNode = new Node(data);
		Node current = root;
		Node parent  = null;
		while(current != null) {
			parent = current;
			if(data < current.data) {
				current = current.left;
			}else {
				current = current.right;		
			}
		}
		if(data < parent.data) {
			parent.left = newNode;
		}else {
			parent.right = newNode;
		}	
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	
	private void inOrder(Node root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void postOrder() {
		inOrder(root);
	}
	
	
	private void postOrder(Node root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		System.out.print(root.data + " ");
		postOrder(root.right);
	}

	
	
	public void inOrderIterative() {
		
		Deque<Node> stack = new ArrayDeque<Node>(); 
		Node current = root;
		
		while(current !=null || !stack.isEmpty()) {
			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			System.out.print(current.data + " ");
			current = current.right;
		}	
	}
	
	
	public int kthSmallest(int k) {

		Deque<Node> stack = new ArrayDeque<Node>(); 
		Node current = root;
		int count = 0;
		
		while(current !=null || !stack.isEmpty()) {
			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			count++;
			if(count == k) return current.data;
			current = current.right;
		}
		return -1;
	}
	
	
	//Find minimum.
	public int findMinimum() {
		Node current = root;
		while (current.left != null) {
			current = current.left;
		}
		return current.data;
	}

	//Find maximum.
	public int findMaximum() {
		Node current = root;
		while (current.right != null) {
			current = current.right;
		}
		return current.data;
	}

	public int height() {
		return findHeight(root);
	}
	
	private int findHeight(Node root) {
		if(root == null ) return -1;
		int left = findHeight(root.left);
		int right = findHeight(root.right);
		
		return 1 + Math.max(left,right);
	}
}

public class BinarySearchTreesDemo {
	
	public static void main(String[] args) {
		
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.addToTree(50);
		binarySearchTree.addToTree(30);
		binarySearchTree.addToTree(70);
		binarySearchTree.addToTree(20);
		binarySearchTree.addToTree(40);
		binarySearchTree.addToTree(60);
		binarySearchTree.addToTree(80);
		binarySearchTree.addToTree(55);
		System.out.println("Recursive InOrder traversal of tree: ");
		binarySearchTree.inOrder();
		
		
		System.out.println("\nIterative InOrder traversal of tree: ");
		binarySearchTree.inOrderIterative();
		
		System.out.println("\nRecursive PreOrder traversal of tree: ");
		binarySearchTree.preOrder();
		
		System.out.println("\nRecursive PostOrder traversal of tree: ");
		binarySearchTree.postOrder();
		
		System.out.println("\nSmallest in the  tree: "+binarySearchTree.findMinimum());
		
		System.out.println("\nLargest in the  tree: "+binarySearchTree.findMaximum());
		
		int kthSmallest = binarySearchTree.kthSmallest(3);
		System.out.println("\n3rd smallest in the  tree: "+kthSmallest);
		
		System.out.println("\n Height of the tree is : "+ binarySearchTree.height());
	}

}
