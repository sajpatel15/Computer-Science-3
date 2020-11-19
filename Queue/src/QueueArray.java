
public class QueueArray<T> implements Queue<T>
{
	private T[] q;
	private int back;
	private int front;
	private int size;

	public QueueArray(int capacity)
	{
		q = (T[]) new Object[capacity];
		back = 0;
		front = 0;
		size = 0;
	}
	
	@Override
	public T dequeue() 
	{
		if(size == 0)
		{
			throw new IllegalStateException("queue is empty");
		}
		
		T f = q[front];
		q[front] = null;
		size--;
		front = (front + 1) % q.length;
		
		return f;
	}

	@Override
	public void enqueue(T v) 
	{
		if(size == q.length)
		{
			throw new ArrayIndexOutOfBoundsException("Queue is full");
		}
		
		q[back] = v;
		size++;
		back = (back+1) % q.length;
		
	}

	@Override
	public T front()
	{
		if(size == 0)
		{
			throw new IllegalStateException("queue is empty");
		}
		return q[front];
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public boolean isEmpty() 
	{
		return size == 0;
	}
	
	public String toString()
	{
		String r = "Front: ";
		for(int i = 0; i < size; i++)
		{
			r += q[(front + i) % q.length] + " ";
		}
		
		return r;
	}
	

}
