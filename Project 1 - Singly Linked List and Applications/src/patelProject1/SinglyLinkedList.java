package patelProject1;

public class SinglyLinkedList<T> {

	// Declaring the inner class
	private class Node {

		// declaring the variables for the class
		private T value;
		private Node next;

		// creating a constructor for the node
		public Node(T v) {
			this.value = v;
			this.next = null;
		}

		// A to string method for the node
		public String toString() {
			return value.toString();

		}
	}

	// Declaring the variables for the list
	private Node head;
	private int size;

	// a no-argument constructor for the list
	public SinglyLinkedList() {
		head = null; // initially points the head to null;
		size = 0; // creates a list with no elements hence it's size is 0

	}

	// a method to get the size of the list
	public int size() {
		return size; // returns the size of the list
	}

	// a method to check if the list is empty.
	public boolean isEmpty() {
		// checks what the content of the head if the head is pointing to null means the
		// list is empty.
		if (head == null && size == 0) {
			return true;
		} else {
			return false;
		}
	}

	// a method that adds a node at the beginning of the list.
	public void addFirst(T v) {
		// create a new node and store the value
		Node newNode = new Node(v);

		// point the next of head to new node
		newNode.next = head;

		// change the head reference to the new node
		head = newNode;

		// increase the size
		size++;
	}
	
	public void addBetween(int index1, T v) {
		Node newNode = new Node(v);
		
		Node temp = head;
		for(int i = 0; i < index1; i++) {
			temp = temp.next;
		}
		
			newNode.next = temp.next;
			temp.next = newNode;
	}

	// a method that adds a node at the end of the list
	public void addLast(T v) {

		// creating a new Node that is pointing to null
		Node newNode = new Node(v);
		newNode.next = null;

		// checking to see if the list is empty
		// if it is then it will create a new node as the head
		if (head == null) {
			head = new Node(v); // replaces the current head node with a new node
			size++;
			return;
		}

		// creating a temporary node that can be manipulated without affecting the whole
		// list
		Node last = head;

		// going through the whole list until the last node to point the last node to
		// the new node
		while (last.next != null) {
			last = last.next;
		}

		// finally the last node is set to point to the newly added node
		last.next = newNode;

		// increase the size of the list
		size++;

	}

	// Method that removes and returns the first element of the list
	public T removeFirst() {

		// first checks to see if the list is empty.
		if (size == 0) {
			throw new IllegalStateException("List is empty. Can't remove an element from empty list");
		}

		// gets the value of the first node
		T value = head.value;

		// advances the head reference so now the first node is pointing to nothing
		head = head.next;

		// reduces the size of the list because an element has been taken out
		size--;

		// returns the value that was removed;
		return value;

	}

	// Method that removes and returns the last element of the list
	public T removeLast() {
		// first checks to see if the list is empty
		if (size == 0) {
			throw new IllegalStateException("List is empty. Can't remove an element from empty list");
		}

		T value = head.value;

		// checks to see if there is only one element in the list
		if (head.next == null) {
			head = null;
			size--;
			return value;

		}

		// checks to see if there are more than two values in the list
		if (head.next.next == null) {
			value = head.next.value;
			head.next = null;
			size--;
			return value;
		}

		// creating a temporary node to iterate through the list until it gets to the
		// second last node
		Node temp = head;

		// loop to get to the second-last node in the list
		while (temp.next.next != null) {
			temp = temp.next;
		}

		// gets the value of the last element
		value = temp.next.value;

		// points the second last element to null which will disconnect the connection
		// between the last element and the list
		temp.next = null;

		// reduce the size of the list because an element has been taken out
		size--;

		// return the element that was taken out
		return value;

	}

	// method that removes an element at a given index
	public T removeAtIndex(int index) throws IndexOutOfBoundsException {
		// checks to see if the list is empty
		if (size == 0) {
			System.out.println("List is empty");
			return null;
		}

		// checks to see if the parameters passed are within range
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		// creates a variable to store the value of the element
		T value = head.value;
		// creates a temp node that will go through the list without making unnecessary
		// changes
		Node temp = head;

		// if the index of the node is 0 it removes the first node
		if (index == 0) {
			removeFirst();
			return value;
		}
		if (index == 1 && size == 2) {
			value = head.next.value;
			removeLast();
			return value;
		}

		// it iterates through the list and gets to the element that is before the one
		// that needs to be removed
		for (int i = 0; temp != null && i < index - 1; i++) {

			temp = temp.next;
		}

		if (temp == null || temp.next == null) {
			return null;
		}

		Node next = temp.next.next;
		temp.next = next;

		value = temp.value;
		size--;
		return value;
	}

	// method that removes the first occurrence of an element in the list that
	// equals the parameter
	public boolean remove(T v) {
		// checks to see if the list is empty
		if (size == 0) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		// creates a temp node
		Node temp = head;

		// creating a variable that counts the number of times the loop has advances the
		// temp variable
		int count = 0;

		// loop that iterates through out the list to see if any variables match the
		// element passed through as a parameter
		while (!(temp.value.equals(v))) {

			temp = temp.next;
			count++;

			// checks to see if the temp has reached the end of the list in which case the
			// loop stop and no varaible was found
			if (temp.next == null) {
				return false;
			}

		}

		removeAtIndex(count);
		return true;

	}

	// method to get the element at the position i without modifying the list
	public T get(int i) {

		// checks to see if there are any elements in the list
		if (size == 0) {
			// throws an exception with error message
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		// creates a temp node that moves along the list
		Node temp = head;

		// loop to get the the jth value of the list by moving the pointer in the node
		for (int j = 0; j < i; j++) {
			temp = temp.next;
		}
		// returns the value at which the temp node is at
		return temp.value;
	}

	// method that returns a string representing all the elements in the list
	public String toString() {

		// creates a string that will contain all the information about the list
		String resultString = "";

		// creates a temporary node that iterates through the string
		Node temp = head;

		// creates a loop that iterates through out the string and adds the value to the
		// resultString and advances the temp node to the next one
		while (temp != null) {
			resultString += temp + " ";
			temp = temp.next;
		}

		// final string that contains all the elements in the list
		return resultString;
	}

}
