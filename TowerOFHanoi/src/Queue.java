
public interface Queue<E> 
{
	public E dequeue();
	public E front();
	public int size();
	public boolean isEmpty();
	public void enqueue(E v);

}
