package patelProject3;

public class SinglyLinkedList<T> 
{
	private Node head;
	private int size;
	
	public SinglyLinkedList()
	{
		head = null;
		size = 0;
	}
	
	
	
	
	public T head()
	{
		return head.value;
	}
	
	public T removeHead()
	{
		//If the list is empty return null
		if(size == 0)
		{
			System.out.println("list is empty");
			return null;
		}
		
		//advance head reference
		T value = head.value;
		head = head.next;
		
		size--;
		return value;
		
	}
	
	
	public void insertAtHead(T v)
	{
		//create a new node and store the value 
		Node newNode = new Node(v);
		
		//point the next of head to new node
		newNode.next = head;
		
		//Change the head reference to the new node
		head = newNode;
		
		//increase the size
		size++;
	}
	
	public int size()
	{
		return size;
	}
	
	public void insertLas(T v)
	{
		//If list is empty, make a new node the head of the list
		if(head == null)
		{
			head = new Node(v);
		}
		else
		{
			//Iterate until temp reaches the last node
			Node temp = head;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			
			Node n = new Node(v);
			temp.next = n;
		}
		size++;
	}
	public String toString()
	{
		String resultString = "";
		
		Node temp = head;
		while(temp != null)
		{
			resultString += temp + " ";
			temp = temp.next;
		}
		return resultString;
	}
	
	private class Node
	{
		private T value;
		private Node next;
		
		public Node(T v)
		{
			this.value = v;
			this.next = null;
		}
		
		public String toString()
		{
			return value.toString();
		}
	}

}
