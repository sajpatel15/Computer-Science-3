package patelLab11;
import java.util.ArrayList;
import java.util.Iterator;

public class BinaryTree<T> implements Iterable<T>{
	private int size;
	private Node root;

	public BinaryTree() {
		root = null;
		size = 0;
	}
	
	public T getRoot() {
		return root.value;
	}

	public Position<T> addRoot(T v) throws IllegalStateException {
		if (root == null) {
			root = new Node(v, null);
			size++;

			return root;
		}
		throw new IllegalStateException("Tree already has root");
	}

	private Node validatePosition(Position<T> p) throws IllegalArgumentException {
		if (p != null && p instanceof BinaryTree.Node) {
			return (Node) p;
		}

		throw new IllegalArgumentException("This is not a tree position");
	}

	public Position<T> addLeft(Position<T> p, T v) throws IllegalArgumentException, IllegalStateException {
		Node n = validatePosition(p);

		if (n.left == null) {

			n.left = new Node(v, n);
			size++;

			return n.left;
		}
		throw new IllegalStateException("Left already exists");
	}

	public Position<T> addRight(Position<T> p, T v) throws IllegalArgumentException, IllegalStateException {
		Node n = validatePosition(p);

		if (n.right == null) {
			n.right = new Node(v, n);
			size++;

			return n.right;
		}
		throw new IllegalStateException("Right already exists");
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Position<T> root() {
		return this.root;
	}

	public Position<T> left(Position<T> p) throws IllegalArgumentException {
		Node n = validatePosition(p);
		return n.left;
	}

	/**
	 * This method returns the right position of a position that is passed. Will
	 * throw exception if the position is not in a tree
	 * 
	 * @param p position passed
	 * @return right position
	 * @throws IllegalArgumentException
	 */
	public Position<T> right(Position<T> p) throws IllegalArgumentException {
		Node n = validatePosition(p);
		return n.right;
	}

	public Position<T> parent(Position<T> p) throws IllegalArgumentException {
		Node n = validatePosition(p);

		return n.parent;
	}

	/**
	 * 
	 * @param sb stringbuilder to which we add the strings
	 * @param r  root of the subtree
	 */
	private void toStringRecursive(StringBuilder sb, Node r, int level) {
		// Base case: tree is empty
		if (r == null) {
			return;
		}
		// print root value
		for (int i = 0; i < level; i++) {
			sb.append("   ");
		}
		sb.append(r.value + "\n");

		// Recursively print left subtree and right subtree
		toStringRecursive(sb, r.left, level + 1);
		toStringRecursive(sb, r.right, level + 1);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		toStringRecursive(sb, root, 0);

		return sb.toString();

	}

	public boolean isExternal(Position<T> p) {
		if (p == root()) {
			return true;
		}

		Node left = validatePosition(p);
		Node right = validatePosition(p);

		if (left.getLeft() == null && right.getRight() == null) {
			return true;
		}

		return false;
	}

	public boolean isInternal(Position<T> p) {
		if (isExternal(p)) {
			return false;
		}

		return true;
	}
	
	public T outputAncestors(Position<T> p) {
		
		Node ancestor = validatePosition(p);
	
		// base case check if its the root 
		if(ancestor.parent == null) {
			return ancestor.value;
		}
		// prints out the ancestor 
		System.out.println(ancestor.toString());
		//
		ancestor = ancestor.parent;
		return outputAncestors(parent(p));  
	}
	public int depth(Position<T> p) {
		
		Node n = validatePosition(p);
		int count = 0;
		
		while(n.parent != null) {
			count++;
			n = n.parent;
		}
		
		return count;
	}
	
	public int recursiveDepth(Position<T> p) {
		Node n = validatePosition(p);
		
		// base case 
		if(n.parent == null) {
			return 0;
		}
		
		n = n.parent;		
		return 1 + recursiveDepth(parent(p));
	}
	
	public int nodeHeight(Position<T> p) {
		
		Node n = validatePosition(p);
		
		if(n.left == null && n.right == null) {
			return 0;
		}
		
		
		return 1 + Math.max(nodeHeight(left(p)), nodeHeight(right(p)));
	}
	
	/**
	 * 
	 * @param list snapshot list
	 * @param r root of the subtree
	 */
	private void preOrderSnapshot(ArrayList<T> list, Node r){
		if(r == null) {
			return;
		}
		
		list.add(r.value);
		preOrderSnapshot(list, r.left);
		preOrderSnapshot(list, r.right);
		
		
	} 

	/**
	 * 
	 * @return a pre-Order snapshot iterator
	 */
	public Iterator<T> iterator(){
		ArrayList<T> snapshot = new ArrayList<>();
		preOrderSnapshot(snapshot, root);
		return snapshot.iterator();
	}
	private class Node implements Position<T> {
		private T value;
		private Node left;
		private Node right;
		private Node parent;

		public Node(T v, Node p) {
			this.value = v;
			this.left = null;
			this.right = null;
			this.parent = p;
		}

		@Override
		public T getValue() {

			return value;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public String toString() {
			return value.toString();
		}
	}

}
