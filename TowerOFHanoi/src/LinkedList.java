

public class LinkedList<E> 
{
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public LinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	public void print()
	{
		Node<E> temp = head;
		for(int i=0; i< size;i++)
		{
			System.out.print(temp.value+ " ");
			temp=temp.nextNode;
		}
	}
	
	public void insertAtTail(E v)
	{
		if(head == null)
		{
			//Step 1: create a node and set the value to v and the next to null
			Node<E> newNode = new Node<E>(v, null);
		
			//step 2: set head to point to newnode
			head = newNode;
		
			//step 3: set tail to point to newnode
			tail = newNode;
		}
		else
		{
			//step 1: create the new node and set its next to null
			Node<E> newNode = new Node<E>(v, null);
			
			//step 2: set the next of the tail to the new node
			tail.nextNode = newNode;
			
			//Step 3: set tail to the new node
			tail = newNode;
		}
	}
	
	public E first()
	{
		return head.value;
	}
	
	public E last()
	{
		return tail.value;
	}
	
	public void insertAtHead(E v)
	{
		//Case 1: list is empty
		if(head == null)
		{
			//Step 1: create a node and set the value to v and the next to null
			Node<E> newNode = new Node<E>(v, null);
		
			//step 2: set head to point to newnode
			head = newNode;
		
			//step 3: set tail to point to newnode
			tail = newNode;
		}
		else
		{
			//Step 1: create a new node put value and next is head
			Node<E> newNode = new Node<E>(v, head);
			
			//step 2: change head to point to the new node
			head = newNode;
		}
		size++;
	}
	
	public E removeHead()
	{
		//There is no meaningful way to handle an empty list so we will just return -1..
		if(isEmpty()) return null;
		
		E temp = head.value;
		head = head.nextNode;
		size--;
		return temp;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public int size()
	{
		return size;
	}
	public String toString()
	{
		Node temp = head;
		
		String result = "";
		if(temp == null)
		{
			result = "List is empty!";
		}
		while(temp != null)
		{
			result += temp.toString() + ", ";
			temp = temp.nextNode;
		}
		return result;
	}
	
	public E removeAtIndex(int index) throws IndexOutOfBoundsException {
		
		if(size == 0) {
			System.out.println("List is empty");
			return null;
		}
		
		if(index < 0) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		
		E value = head.value;
		Node temp = head;
		
		if(index == 0) {
			removeHead();
		}
		
		for(int i = 0; temp!=null && i <  index - 1; i++) {
			
			temp = temp.nextNode;
		}
		
		if(temp == null || temp.nextNode == null) {
			return null;
		}
		
		Node next = temp.nextNode.nextNode;
		temp.nextNode = next;
		
		value = (E) temp.value;
		
		return value;
	}
	
	/*
	 * Nested class Node
	 */
	private static class Node<E>
	{
		E value;
		Node nextNode;
		
		public Node(E v, Node n)
		{
			value = v;
			nextNode = n;
		}
		public String toString()
		{
			return "" + value;
		}
	}
	/*
	 * END Nested class Node
	 */
}
