package patelProject3;

/*
 * Author: Saj Patel 
 * Date: 4/30/2020
 * 
 * Description: This is a queue that is make from a doublyLinkedList.
 *  It implements the queue interface and stores values that are of generic type
 */
public class DoublyLinkedListQueue<E> implements Queue<E> {

	// declaring the variables that are used in the class
	private DoublyLinkedList<E> q;
	private int size;

	// a constructor that initializes the linked list and starts of with size 0.
	public DoublyLinkedListQueue() {
		q = new DoublyLinkedList<>();
		size = 0;
	}

	// adds an element to the queue
	@Override
	public void enqueue(E v) {
		// TODO Auto-generated method stub
		q.addLast(v);
		size++;

	}

	// removes an element from the queue, in the order that it was put in it follows
	// the FIFO(First In First Out) method and reduces the size of the queue
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw new IllegalStateException("queue is empty");
		}
		size--;
		return q.removeFirst();
	}

	// method that returns the first element of the queue
	@Override
	public E first() {
		// TODO Auto-generated method stub
		return q.getHeader();
	}

	// method that returns the size of the queue
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	// method that checks to see if the queue is empty, returns true is the queue is
	// empty
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	// a toSring method that converts the contents of the list to a string
	@Override
	public String toString() {
		return "Front: " + q.toString();
	}

}
