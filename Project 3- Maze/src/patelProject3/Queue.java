package patelProject3;
/*
 * Author: Saj Patel
 * Date: 4/30/2020
 * 
 * Description: This is an interface that declares the methods that need to be i
 * Implemented when the interface has been extended.
 */
public interface Queue <E> {
	
	public void enqueue(E v);
	public E dequeue();
	public E first();
	public int size();
	public boolean isEmpty();
	public String toString();
}
