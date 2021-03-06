package patelProject5;

import java.util.ArrayList;
import java.util.Iterator;

public class BST<T extends Comparable<T>> implements Iterable<T> {

	private Node root;
	private int size;

	public BST() {
		root = null;
		size = 0;
	}

	/**
	 * Removes value v from subtree rooted at r
	 * 
	 * @param v value to remove
	 * @param r Root of the subtree from which we are deleting r
	 * @return the root of the subtree AFTER delete is done
	 */
	private Node removeRecursive(Node r, T v) {
		// subtree is empty
		if (r == null) {
			// return the same tree (empty tree)
			return null;
		}
		// value is less than root
		if (r.value.compareTo(v) > 0) {
			// remove v from the left subtree
			r.left = removeRecursive(r.left, v);
			// Return the root of this tree after remove is done
			return r;
		}

		// Value is greater that root
		if (r.value.compareTo(v) < 0) {
			r.right = removeRecursive(r.right, v);
			return r;
		}

		// I found the value
		// Case 1: leaf
		if (r.right == null && r.left == null) {
			size--;
			return null;
		}
		// Case 2: one child
		if (r.right == null) {
			size--;
			return r.left;
		}
		if (r.left == null) {
			size--;
			return r.right;
		}
		// case 3: two children

		// Find predecessor
		Node predecessor = r.left;
		while (predecessor.right != null) {
			predecessor = predecessor.right;
		}
		r.value = predecessor.value;
		r.left = removeRecursive(r.left, predecessor.value);
		return r;
	}

	public boolean remove(T v) {
		int oldSize = size;
		this.root = removeRecursive(root, v);

		return oldSize > size;
	}

	/**
	 * 
	 * @param v value to insert
	 * @return true if the value was inserted, false otherwise
	 */
	public boolean insert(T v) {
		int oldSize = this.size;
		root = insert(root, v);

		return oldSize < size;
	}

	public boolean contains(T v) {
		Node n = findNode(root, v);

		return n != null && n.value.equals(v);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the node containing value v or the node the last node examined in the
	 * search (would be
	 * 
	 * @param r root of the subtree we are searching
	 * @param v value that we are searching for
	 * @return node containing v or last node examined in the search
	 */
	private Node findNode(Node r, T v) {
		if (r == null) {
			return null;
		}

		if (r.value.compareTo(v) == 0) {
			return r;
		} else if (r.value.compareTo(v) > 0 && r.left != null) {
			return findNode(r.left, v);
		} else if (r.value.compareTo(v) < 0 && r.right != null) {
			return findNode(r.right, v);
		}

		// Return last node examined in the search
		return r;
	}

	public T containsValue(T value) {
		if (contains(value)) {
			return value;
		} else {
			return null;
		}
	}

	/**
	 * Recursive method that inserts v into tree rooted at r
	 * 
	 * @param r root of subtree
	 * @param v value to insert
	 * @return root of the subtree AFTER insert is done
	 */
	private Node insert(Node r, T v) {
		// Base case 1: subtree is empty
		if (r == null) {
			size++;
			return r = new Node(v);
		}

		// Base case 2: value is at root of subtree
		if (r.value.compareTo(v) == 0) {
			return r;
		}

		// Recursive step
		if (r.value.compareTo(v) > 0) {
			r.left = insert(r.left, v);
		} else {
			r.right = insert(r.right, v);
		}

		return r;
	}

	public void prettyPrint(StringBuilder sb, Node r, int level) {
		// Base case: if r = null do nothing
		if (r == null) {
			return;
		}

		// Process root (add it to sb with proper number of spaces)
		for (int i = 0; i < level; i++) {
			sb.append("  ");
		}
		sb.append(r.value + "\n");

		// recursively prettyPrint left subtree and right subtree
		prettyPrint(sb, r.left, level + 1);
		prettyPrint(sb, r.right, level + 1);

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		prettyPrint(sb, root, 0);

		return sb.toString();
	}

	public void populate(Node n, ArrayList<T> list) {
		// base case returns null if node is null
		if (n == null) {
			return;
		}

		// uses in-order traversal to populate the iterator
		populate(n.left, list);

		list.add(n.value);

		populate(n.right, list);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub

		ArrayList<T> list = new ArrayList<T>();

		populate(root, list);

		return list.iterator();
	}

	private class Node {
		private T value;
		private Node left;
		private Node right;

		public Node(T v) {
			this.value = v;
			this.left = null;
			this.right = null;
		}

		public String toString() {
			return this.value.toString();
		}
	}

}
