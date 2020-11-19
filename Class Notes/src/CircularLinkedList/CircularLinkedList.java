package CircularLinkedList;

public class CircularLinkedList<T> {

	private class Node {

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

	private Node cursor;
	private int size;

	public CircularLinkedList() {
		cursor = null;
		size = 0;
	}

	public void IsertAfterCursor(T v) {
		if (cursor == null) {
			cursor = new Node(v);
			cursor.next = cursor;

		} else {
			Node newNode = new Node(v);
			newNode.next = cursor.next;
			cursor.next = newNode;

		}

		size++;

	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		
		return false;
	}

	public T removeAfterCursor() {
		
		//list is empty
		if(cursor == null) {
			throw new IllegalStateException("List is empty");
		}
		
		// one element
		T value = cursor.next.value;
		if(cursor.next == cursor) {
			cursor = null;
		}
		
		//All other
		else {
			cursor.next = cursor.next.next;
		}
		
		
		size--;
		return value;
	}

	public String toString() {

		if(cursor == null) {
			return "List is empty";
		}
		String results = "List: ";

		Node temp = cursor;

		do {
			results += temp + " ";
			temp = temp.next;
		} while (temp != cursor);

		return results;

	}

}
