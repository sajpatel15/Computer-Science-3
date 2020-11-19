package CircularDoublyLinkedList;

public class CircularDoublyLinkedList<T> {

	private class Node {

		private T value;
		private Node next;
		private Node prev;

		public Node(T v) {
			this.value = v;
			this.next = null;
			this.prev = null;
		}


		public String toString() {
			return value.toString();
		}

	}

	private int size;
	private Node cursor;

	public CircularDoublyLinkedList() {
		size = 0;
		cursor = null;
	}

	public void addAfterCursor(T value) {
		Node newNode = new Node(value);

		if (size == 0) {

			cursor = newNode;
			cursor.next = cursor;
			cursor.prev = cursor;
		} else if (size == 1) {

			cursor.next = newNode;
			newNode.prev = cursor;
			newNode.next = cursor;
			cursor.prev = newNode;
		} else {

			newNode.prev = cursor;
			newNode.next = cursor.next;
			cursor.next.prev = newNode;
			cursor.next = newNode;
		}

		size++;
	}

	public T deleteCursor() {

		if (size == 0) {
			throw new IllegalStateException("List is empty cannot delete from an empty list");
		} else if (size == 1) {
			T value = cursor.value;

			cursor = null;
			size--;
			return value;
		} else {
			T value = cursor.value;
			cursor.prev.next = cursor.next;
			cursor.next.prev = cursor.prev;
			cursor = cursor.next;
			size--;
			return value;
		}

	}

	public T getValue() {
		if (size == 0) {
			throw new IllegalStateException("Cannot get a value from empty list");
		}

		return cursor.value;
	}

	public void advanceCursor(int n) {
		if (cursor == null || n < 0) {
			return;
		}

		for (int i = 0; i < n; i++) {
			cursor = cursor.next;
		}

	}

	public String toString() {
		if (cursor == null) {
			return "list is empty!";
		}

		String r = "";
		Node temp = cursor;

		do {
			r += temp.toString() + " ";
			temp = temp.next;
		} while (temp != cursor);

		return r;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return cursor == null;
	}

}
