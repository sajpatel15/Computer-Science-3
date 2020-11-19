import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T extends Comparable<T>> implements Iterable<T>
{
	private Node head;
	private int size;
	
	public SinglyLinkedList()
	{
		head = null;
		size = 0;
	}
	
	public T min()
	{
		if(head == null)
		{
			throw new IllegalStateException("List is empty! min is undefined");
		}
		
		T min = head.value;
		
		Node temp = head.next;
		while(temp != null)
		{
			if(temp.value.compareTo(min) < 0)
			{
				min = temp.value;
			}
			
			temp = temp.next;
		}
		
		return min;
		
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
	
	public void insertLast(T v)
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
		String resultString = "List: ";
		
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

	@Override
	public Iterator<T> iterator()
	{
		return new SLIterator();
	}
	
	
	
/***** start of Inner class */
 	private class SLIterator implements Iterator<T>
	{
		private Node current;
		private Node prev;
		
		public SLIterator()
		{
			current = null;
			prev = null;
		}

		@Override
		public boolean hasNext() 
		{
			return (size() != 0 && current == null) || (current.next != null) ;
		}

		@Override
		public T next() 
		{
			if(!hasNext())
			{
				throw new NoSuchElementException("No more elements");
			}
			
			//first node
			if(current == null)
			{	
				current = head;
				return current.value;
			}
			
			prev.next = current;
			current = current.next;
			return current.value;
		}
		
		public void remove()
		{
			if(current == prev)
			{
				throw new IllegalStateException("Cannot remove before next");
			}
			
			//First element
			if(current == head)
			{
				head = head.next;
			}
			else
			{
				prev.next = current.next; // same as prev.next = prev.next.next;
			}
			
			size--;
			current = prev;
			//Everything else
		}
	}
/****** End of inner class */

}
