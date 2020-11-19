	import java.util.Iterator;

public interface Set<E> extends Iterable<E>
{
	//Set methods
	public boolean contains(E e);
	public boolean add(E e);
	public boolean remove(E e);
	
	//Size
	public int size();
	public boolean isEmpty();
	
	//Iterator
	public Iterator<E> iterator();
	
	//Set operation methods
	//Union
	public void addAll(Set<E> otherSet);
	
	//Intersection
	public void retainAll(Set<E> otherSet);
	
	//set difference
	public void removeAll(Set<E> otherSet);

}
