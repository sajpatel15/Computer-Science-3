package patelHomework17;

import java.util.Iterator;

public class AVLTree<E extends Comparable<E>> implements Set<E>{

	// TODO Augment Node class to have a height instance variable
	private class Node {
		private E value;
		private Node left;
		private Node right;
		private int height;

		public Node(E v) {
			value = v;
			left = null;
			right = null;
			height = 0;
		}

		public String toString() {
			return value.toString() + "(" + height + ")";
		}
	}

	private Node root;
	private int size;

	public AVLTree() {
		root = null;
		size = 0;
	}

	/*
	 * Return the new root of the tree after left rotation 
	 *            x              y 
	 *           / \            / \ 
	 *          T1  y   =>     x  T3
	 *             / \        / \  
	 *            T2 T3      T1 T2
	 */
	private Node leftRotate(Node x) {
		// TODO Perform left rotation
		
		Node y = x.right;
		Node t2 = y.left;
		y.left = x;
		x.right = t2;
		// Be sure to recalculate heights
		recalculateHeight(x);
		recalculateHeight(y);
		return y;
	}

	/*
	 * Return the new root of the tree after right rotation 
	 *             x              y 
	 *            / \            / \ 
	 *           T1  y     <=   x  T3
	 *              / \        / \   
	 *             T2 T3      T1 T2
	 */
	private Node rightRotate(Node y) {
		// TODO Perform right rotation
		Node x = y.left;
		Node t2 = x.right;
		x.right = y;
		y.left = t2;
		
		// Be sure to recalculate heights
		recalculateHeight(y);
		recalculateHeight(x);
	
		// returning the new Root
		return x;
	}

	/*
	 * Handle the "Left-Left" and "Left-Right" cases
	 * 
	 * Rebalance the tree rooted at z if (the height of the left
	 * subtree - height of the right subtree) is greater than 1.
	 * Returns the new root of the subtree after rebalancing.
	 */
	private Node rebalanceLeft(Node z) {
		// TODO 
		if(heightOfNode(z.left) - heightOfNode(z.right) > 1) {
			Node y = z.left;
			
			if(heightOfNode(y.left) >= heightOfNode(y.right)) {
				// Case left-left
				z = rightRotate(z);
			} else {
				// left-right
				z.left = leftRotate(y);
				z = rightRotate(z);
			}
		}
		
			
		return z;
	}
	
	/*
	 * Handle the "Right-Right" and "Right-Left" cases
	 * 
	 * Rebalance the tree rooted at z if (the height of the right
	 * subtree - height of the left subtree) is greater than 1.
	 * Returns the new root of the subtree after rebalancing.
	 */
	private Node rebalanceRight(Node z) {
		// TODO
		if(heightOfNode(z.right) - heightOfNode(z.left) > 1) {
			Node y = z.right;
			
			if(heightOfNode(y.right) >= heightOfNode(y.left)) {
				// Case right-right
				z = leftRotate(z);
			} else {
				// right-left
				z.right = rightRotate(y);
				z = leftRotate(z);
			}
		}
		
			
		return z;
	}

	/*
	 * heightOfNode returns the height of the given node if
	 * the node is not null. If the node is null, return -1.
	 */
	private int heightOfNode(Node n) {
		// TODO
		if(n == null) {
			return -1;
		}
		
		return n.height;
	}

	/*
	 * Determines the height of the given node by adding 1 to
	 * the larger of the heights of the two child nodes.
	 */
	private void recalculateHeight(Node n) {
		// TODO 
		n.height = 1 + Math.max(heightOfNode(n.right),heightOfNode(n.left));
	}

	/*
	 * Adds e to the tree. This add() method doesn't
	 * make use of find(). Instead, the overall
	 * structure of add() is very similar to the
	 * structure of remove(), where the tree is
	 * basically reconstructed as we recurse through
	 * the tree. Note how add() returns a Node.
	 * 
	 * Once the parent of e is found, add e as a leaf 
	 * node (as a left or right child). Then recalculate
	 * the height of the parent and rebalance the tree.
	 */
	private Node add(Node r, E v) {
		// TODO
		// Case 1: subtree at node is empty
		if(r == null) {
			size++;
			return r = new Node(v);
		}
		
		// Case 2: e already exists in the tree
		if(r.value.compareTo(v) == 0) {
			return r;
		}
		//Recursive step
		// Case 3: e should be added in left subtree
		if(r.value.compareTo(v) > 0) {
			r.left = add(r.left,v);
			recalculateHeight(r);
			r = rebalanceLeft(r);
		}
		// Case 4: e should be added in right subtree
		else {
			r.right = add(r.right,v);
			recalculateHeight(r);
			r = rebalanceRight(r);
		}	
		return r;
	}
	
	@Override
	public boolean add(E e) {
		int oldSize = size;
		this.root = add(root, e);
		return oldSize < size;
	}

	private Node remove(Node node, E target) {
		// Cases when searching for node to remove
		// Case 1: subtree rooted at node is empty, cannot remove e
		if (node == null) {
			return null;
		}
		// Case 2: value to remove is in left subtree
		else if (target.compareTo(node.value) < 0) {
			node.left = remove(node.left, target);
			// TODO
			// Recalculate late height of this node
			recalculateHeight(node);
			// Rebalance (left or right?)
			node = rebalanceRight(node);
		}
		// Case 3: value to remove is in right subtree
		else if (target.compareTo(node.value) > 0) {
			node.right = remove(node.right, target);
			// TODO
			// Recalculate height of this node
			recalculateHeight(node);
			// Rebalance (left or right?)
			node = rebalanceLeft(node);
		}
		// Case 4: node is the node to remove
		else {
			size--;
			// Cases for removing node
			// Case 1: node is an external node
			if (node.right == null && node.left == null) {
				return null;
			}
			// Case 2: node's left subtree exists
			if (node.right == null) {
				return node.left;
			}
			// Case 3: node's right subtree exists
			if (node.left == null) {
				return node.right;
			}
			// Case 4: both left and right subtrees exist
			Node pred = node.left;
			while (pred.right != null) {
				pred = pred.right;
			}
			node.value = pred.value;
			node.left = remove(node.left, pred.value);
		}

		return node;
	}

	@Override
	public boolean remove(E e) {
		int oldSize = size;
		this.root = remove(root, e);
		return oldSize > size;
	}

	@Override
	public boolean contains(E e) {
		Node node = find(root, e);
		return node != null && node.value.equals(e);
	}
	
	/*
	 * The find() helper method is now only used
	 * for implementing contains() (not add()).
	 * 
	 * The node returned by find() will be: 
	 * - null if the tree is empty 
	 * - the node where e already exists in the tree 
	 * - the parent node of where e should be in the tree
	 */
	private Node find(Node node, E target) {
		// Case 1: tree is empty
		if (node == null) {
			return null;
		}
		// Case 2: successful search
		if (node.value.equals(target)) {
			return node;
		}
		// Case 3: target is in left subtree
		if (node.value.compareTo(target) > 0 && node.left != null) {
			return find(node.left, target);
		}
		// Case 4: target is in right subtree
		if (node.value.compareTo(target) < 0 && node.right != null) {
			return find(node.right, target);
		}
		// Case 5: unsuccessful search
		// Technically this can also handle Case 2 (successful search).
		return node;
	}

	/*
	 * Perform pre-order traversal. Number of tabs added to StringBuilder before a
	 * node's value is proportional to the depth of the node.
	 */
	private void toStringHelper(StringBuilder sb, Node node, int depth) {
		if (node != null) {
			for (int i = 0; i < depth; i++) {
				sb.append("  ");
			}
			sb.append(node.value + "\n"); // preorder
			toStringHelper(sb, node.left, depth + 1);
			toStringHelper(sb, node.right, depth + 1);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		toStringHelper(sb, root, 0);
		return sb.toString();
	}

	// We will ignore these methods in order to focus
	// on the main operations AVL trees are used for.
	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public void addAll(Set<E> other) {
		
	}

	@Override
	public void retainAll(Set<E> other) {
	}

	@Override
	public void removeAll(Set<E> other) {
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
