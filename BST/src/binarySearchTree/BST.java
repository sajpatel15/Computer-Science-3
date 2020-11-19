package binarySearchTree;


public class BST<T extends Comparable<T>> 
{

	private Node root;
	private int size;
	
	public BST()
	{
		root = null;
		size = 0;
	}
	
	/**
	 * 
	 * @param v value to insert
	 * @return true if the value was inserted, false otherwise
	 */
	public boolean insert(T v)
	{
		int oldSize = this.size;
		root = insert(root, v);
		
		return oldSize < size;
	}
	
	public boolean contains(T v)
	{
		Node n = findNode(root, v);
		
		return n.value.equals(v);
	}
	

	/**
	 * Returns the node containing value v or the node the last node examined in the search (would be 
	 * @param r root of the subtree we are searching
	 * @param v value that we are searching for
	 * @return node containing v or last node examined in the search
	 */
	private Node findNode(Node r, T v)
	{
		if(r == null)
		{
			return null;
		}
		
		if(r.value.compareTo(v) == 0)
		{
			return r;
		}
		else if(r.value.compareTo(v) > 0 && r.left != null)
		{
			return findNode(r.left, v);
		}
		else if(r.value.compareTo(v) < 0 && r.right != null)
		{
			return findNode(r.right, v);
		}
		return r;
	}
	/**
	 * Recursive method that inserts v into tree rooted at r
	 * @param r root of subtree
	 * @param v value to insert
	 * @return root of the subtree AFTER insert is done
	 */
	private Node insert(Node r, T v)
	{
		//Base case 1: subtree is empty
		if(r == null)
		{
			size++;
			return r = new Node(v);
		}
		
		//Base case 2: value is at root of subtree
		if(r.value.compareTo(v) == 0)
		{
			return r;
		}
		
		//Recursive step
		if(r.value.compareTo(v) > 0 )
		{
			r.left = insert(r.left, v);
		}
		else
		{
			r.right = insert(r.right, v);
		}
		
		return r;
	}
	
	public void prettyPrint(StringBuilder sb, Node r, int level)
	{
		//Base case: if r = null do nothing
		if(r == null)
		{
			return;
		}
		
		//Process root (add it to sb with proper number of spaces)
		for(int i=0; i < level; i++)
		{
			sb.append("  ");
		}
		sb.append(r.value + "\n");
		
		//recursively prettyPrint left subtree and right subtree
		prettyPrint(sb, r.left, level+1);
		prettyPrint(sb, r.right, level+1);
		
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		prettyPrint(sb, root, 0);
		
		return sb.toString();
	}
	private class Node
	{
		private T value;
		private Node left;
		private Node right;
		
		public Node(T v)
		{
			this.value = v;
			this.left = null;
			this.right = null;
		}
		
		public String toString()
		{
			return this.value.toString();
		}
	}
}
