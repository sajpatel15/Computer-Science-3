
public interface List<T>
{
	public T get(int i);
	public T remove(int i);
	public void add(int i, T v);
	public void add(T v);
	
	public T set(int i, T v);
	
	public int size();
	public boolean isEmpty();

}
