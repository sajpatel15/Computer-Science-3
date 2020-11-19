package SinglyLinkedList;

public class SinglyLinkedList <T extends Comparable<T>>  {
	
	private Node head;
	private int size;
	
	public SinglyLinkedList() {
		head = null;
		size =0;
	}
	
	public T head() {
		return head.value;
	}
	
	public T removeHead() {
		//if the list is empty, return null
		
		if(size == 0) {
			System.out.println("List is empty");
			return null;
		}
		
		//advance head reference
		T value = head.value;
		head = head.next;
		
		size--;
		return value;
		
	}
	
	public T removeAtIndex(int index) throws IndexOutOfBoundsException {
				
		if(size == 0) {
			System.out.println("List is empty");
			return null;
		}
		
		if(index < 0) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		
		T value = head.value;
		Node temp = head;
		
		if(index == 0) {
			removeHead();
		}
		
		for(int i = 0; temp!=null && i <  index - 1; i++) {
			
			temp = temp.next;
		}
		
		if(temp == null || temp.next == null) {
			return null;
		}
		
		Node next = temp.next.next;
		temp.next = next;
		
		value = temp.value;
		
		return value;
	}
	
	public T getMin() {
		//If the list is empty, calling the method should throw an exception
				if (head == null)
				{
					throw new IllegalStateException("List is empty. Can't remove an element from empty list");
				}

				T min = head.value;
				
				Node temp = head.next;
				
				while(temp != null) {
					if(temp.value.compareTo(min) < 0) {
						min = temp.value;
					}
					
					temp = temp.next;
				}
				
				return min;
				
				

				
	}
	
	
	
	public void insertFirst(T v) {
		//create a new node and store the value
		Node newNode = new Node(v);
		
		// point the next of head to new node
		newNode.next = head;
		
		// change the head reference to the new node
		head = newNode;
		
		//increase the size
		size++;
	}
	
	public void insertLast(T v) {
		Node newNode = new Node(v);
		
		if(head == null) {
			head = new Node(v);
			return;
		}
		
		newNode.next = null;
		
		Node last = head;
		
		while(last.next != null){
			last = last.next;
		}
		
		last.next = newNode;
		
	}
	
	public String toString() {
		String resultString = "";
		Node temp = head;
		
		while(temp != null) {
			resultString += temp + " ";
			temp = temp.next;
		}
		
		return resultString;
		
	}
	
	
	
	private class Node{
		
		private T value;
		private Node next;
		
		public Node(T v) {
			this.value = v;
			this.next = null;
		}
		
		public String toString() {
			return value.toString();
		}
		
	}

}
