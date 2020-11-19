
public class QueueLinked<E> implements Queue {
	
	private LinkedList<E> theQueue;

	
	public QueueLinked() {
		theQueue = new LinkedList<E>();
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if(theQueue.size() == 0) {
			return null;
		}
		return theQueue.removeAtIndex(theQueue.size()-1);
	}

	@Override
	public Object front() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enqueue(E v) {
		// TODO Auto-generated method stub
		theQueue.insertAtHead(v);
	}

}
