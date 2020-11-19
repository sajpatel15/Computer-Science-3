import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E extends Comparable<E>> implements Iterable<E>{
	private class Node {
		private E value;
		private Node prev;
		private Node next;
		
		public Node(E value, Node prev, Node next) {
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private Node header;
	private Node trailer;
	private int size;
	
	public DoublyLinkedList() {
		header = new Node(null, null, null);
		trailer = new Node(null, header, null);
		header.next = trailer;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return header.next == trailer;
	}
	
	private void insertBetween(E newValue, Node node1, Node node2) {
		Node newNode = new Node(newValue, node1, node2);
		node1.next = newNode;
		node2.prev = newNode;
		size++;
	}

	private E removeBetween(Node node1, Node node2) {
		if (this.isEmpty()) {
			throw new IllegalStateException("Cannot remove from empty list");
		}
		E result = node1.next.value;
		
		node1.next = node2;
		node2.prev = node1;
		size--;
		
		return result;
	}
	
	public void insertAtHead(E newValue) {
		insertBetween(newValue, header, header.next);
	}
	
	public void addLast(E newValue) {
		insertBetween(newValue, trailer.prev, trailer);
	}
	
	public boolean remove(E target) {
		Node current = header.next;
		while (current != trailer) {
			if (current.value.equals(target)) {
				removeBetween(current.prev, current.next);
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public E removeHead() {
		return removeBetween(header, header.next.next);
	}
	
	public E removeTail() {
		return removeBetween(trailer.prev.prev, trailer);
	}
	
	public String toString() {
		if (this.isEmpty()) {
			return "List is empty";
		}
		String result = "";
		Node current = header.next;
		while (current != trailer) {
			result += current.value.toString() + " ";
			current = current.next;
		}
		return result;
	}
	
	public String reverseToString() {
		if (this.isEmpty()) {
			return "List is empty";
		}
		String result = "";
		Node current = trailer.prev;
		while (current != header) {
			result += current.value.toString() + " ";
			current = current.prev;
		}
		return result;
	}
	

	
	private class DLIterator implements TwoWayIterator<E>{
		
		private Node current;
		
		public DLIterator() {
			current  = header;
			
		}

		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current.next != trailer;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if(!hasNext())
			{
				throw new NoSuchElementException("No more elements");
			}
			
			current = current.next;
			
			return current.value;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return current != header;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			
			if(!hasPrevious())
			{
				throw new NoSuchElementException("No more elements");
			}
			
			E value  = current.value;
			current = current.prev;
			return value;
		}
		
		
	}



	@Override
	public TwoWayIterator<E> iterator() {
		// TODO Auto-generated method stub
		return new DLIterator();
	}

}
