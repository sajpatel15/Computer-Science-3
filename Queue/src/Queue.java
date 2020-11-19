
public interface Queue<T> 
{
	public T dequeue();
	public void enqueue(T v);
	public T front();
	public int size();
	public boolean isEmpty();

}
