package patelProject3;

/*
 * Author: Saj Patel 
 * Date: 4/30/2020
 * 
 * Description: This class represents a doubly linked list that 
 * is of generic type. It can move forwards and backwards, add 
 * and remove items and is more easy to iterate over as compared 
 * to array lists
 */
public class DoublyLinkedList<T> {

	// Declaring the variables
	private int size;
	private Node header;
	private Node trailer;

	// a no- input cosntructor that initializes all of the variables
	public DoublyLinkedList() {
		size = 0;
		header = new Node(null);
		trailer = new Node(null);
		header.next = trailer;
		trailer.prev = header;
	}

	// a get method that returns the head of the list
	public T getHeader() {
		return header.value;
	}

	// a get method that returns the tail of the list
	public T getTrailer() {
		return trailer.getValue();
	}

	// a method that adds an item at the front of the list
	public void addFirst(T v) {
		addBetween(v, header, header.next);
	}

	// a method that adds an item a the end of the list
	public void addLast(T v) {

		addBetween(v, trailer.prev, trailer);
	}

	// a method that checks to see if the list is empty
	// returns true is the list is empty else false
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}

	}

	// a method that removes the first element in the list
	public T removeFirst() {
		if (isEmpty()) {
			System.out.println("Cannot remove from an empty list");
			return null;
		}

		return remove(header.getNext());
	}

	// a method that adds a new item between two other items
	private void addBetween(T v, Node before, Node after) {
		if (v == null) {
			throw new RuntimeException("Cannot insert null value in list");
		}

		if (before == null || after == null) {
			throw new IllegalStateException("Cannot use null reference for before and after node");

		}

		// Insert new value between before and after
		Node newNode = new Node(v);
		newNode.next = after;
		newNode.prev = before;

		before.next = newNode;
		after.prev = newNode;
		size++;

	}

	// a toString method that allows the contents of the list to be displayed
	public String toString() {
		String resultString = "";
		Node temp = trailer.prev;

		while (temp != header) {
			resultString += temp + " ";
			temp = temp.prev;
		}

		return resultString;

	}

	// remove between method that removes an item between two nodes
	public T removeBetween(Node node1, Node node2) {
		// check if either is null
		if (node1 == null || node2 == null) {
			throw new IllegalArgumentException("Must have valid parameters");
		}
		// Check for an empty list
		if (header.next == trailer) {
			throw new IllegalStateException("Cannot delete from an empty list");
		}
		// check that given nodes are 1 apart
		if (node1.next.next != node2) {
			throw new IllegalArgumentException("Must be 1 node apart");
		}
		T valueToReturn = null;
		// TODO: Your code goes here

		node1.next = node2;
		node2.prev = node1;

		return valueToReturn;
	}

	// a method that searches for a perticular element in the list
	public int search(T v) {
		if (v == null) {
			throw new RuntimeException("Cannot insert null value in list");
		}

		Node temp = header.next;
		int count = 0;

		while (temp != trailer) {
			if (temp.value == v) {
				return count;
			}

			temp = temp.next;
			count++;
		}

		System.out.println("Search not found");
		return 0;
	}

	// a method that removes a node that has been passed as the parameter and
	// returns in when the method is called
	private T remove(Node node) {

		Node predecessor = node.getPrev();
		Node successor = node.getNext();

		predecessor.setNext(successor);
		successor.setPrev(predecessor);

		size--;
		return node.getValue();
	}

	// a private class node that stores a reference to the next node and the
	// previous node and holds the element that is in the list
	private class Node {

		// declaring the variables that are needed for the class
		private T value;
		private Node next;
		private Node prev;

		// a constructor that thats a generic type as an input
		public Node(T v) {
			this.value = v;
			this.next = null;
			this.prev = null;
		}

		// a getter to get the previous node that is linked to the current node
		public Node getPrev() {
			return prev;
		}

		// a getter to get the next node that is linked to the current node
		public Node getNext() {
			return next;
		}

		// a setter that sets the previous node to a particular value
		public void setPrev(Node p) {
			prev = p;
		}

		// a setter that sets the next node to a particular value
		public void setNext(Node n) {
			next = n;
		}

		// a getter that gets the value of the element
		public T getValue() {
			return value;
		}

		// a toString method for the class that allows the value to be displayed
		public String toString() {
			return value.toString();
		}

	}

}
