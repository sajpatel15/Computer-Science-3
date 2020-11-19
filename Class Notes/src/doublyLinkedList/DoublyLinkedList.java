package doublyLinkedList;



public class DoublyLinkedList<T extends Comparable<T>> {
	
	private int size;
	private Node header;
	private Node trailer;
	
	public DoublyLinkedList() {
		size = 0;
		header = new Node(null);
		trailer = new Node(null);
		header.next = trailer;
		trailer.prev = header;
	}
	
	public void addFirst(T v) {
		addBetween(v, header, header.next);		
	}
	
	public void addLast(T v) {
		
		addBetween(v, trailer.prev, trailer);
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}else {
			return false;
		}
		
	}
	public T removeFirst() {
		if(isEmpty()) {
			System.out.println("Cannot remove from an empty list");
			return null;
		}
		
		return remove(header.getNext());
	}
	
	private void addBetween(T v, Node before, Node after) {
		if(v == null) {
			throw new RuntimeException("Cannot insert null value in list");
		}
		
		if(before == null || after == null) {
			throw new IllegalStateException("Cannot use null reference for before and after node");
			
		}
		
		//Insert new value between before and after
		Node newNode = new Node(v);
		newNode.next = after;
		newNode.prev = before;
		
		before.next = newNode;
		after.prev = newNode;
		size++;
		
	}
	
	public String toString() {
		String resultString = "List: ";
		Node temp = trailer.prev;
		
		while(temp != header) {
			resultString += temp + " ";
			temp = temp.prev;
		}
		
		return resultString;
		
	}
	
	public T removeBetween(Node node1, Node node2)
	{
		//check if either is null
                if (node1 ==  null || node2 == null)
                {
                 throw new IllegalArgumentException("Must have valid parameters");
                }
                //Check for an empty list
		if (header.next ==  trailer)
		{
			throw new IllegalStateException("Cannot delete from an empty list");
		}
                //check that given nodes are 1 apart
                if(node1.next.next != node2)
                {
                        throw new IllegalArgumentException("Must be 1 node apart");
                }
		T valueToReturn = null;
	        //TODO: Your code goes here
		
		node1.next = node2;
		node2.prev = node1;
		
		return valueToReturn;
	}

		public int search(T v) {
			if(v == null) {
				throw new RuntimeException("Cannot insert null value in list");
			}
			
			Node temp = header.next;
			int count = 0;
			
			while(temp != trailer) {
				if(temp.value == v) {
					return count;
				}
				
				temp = temp.next;
				count++;
			}
			
			System.out.println("Search not found");
			return 0;
		}
	
	private T remove(Node node) {
		
		Node predecessor = node.getPrev();
		Node successor = node.getNext();
		
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		
		size--;
		return node.getValue();
	}
	
//	public String toString() {
//		String resultString = "List: ";
//		Node temp = header.next;
//		
//		while(temp != trailer) {
//			resultString += temp + " ";
//			temp = temp.next;
//		}
//		
//		return resultString;
//		
//	}
	
	private class Node{
		
		private T value;
		private Node next;
		private Node prev;
		
		public Node(T v) {
			this.value =v;
			this.next = null;
			this.prev = null;
		}
		
		public Node getPrev() {
			return prev;
		}
		public Node getNext() {
			return next;
		}
		
		public void setPrev(Node p) {
			 prev = p;
		}
		
		public void setNext(Node n) {
			next = n;
		}
		public T getValue() {
			return value;
		}
		
		public String toString() {
			return value.toString();
		}
		
	}
	
	
}
