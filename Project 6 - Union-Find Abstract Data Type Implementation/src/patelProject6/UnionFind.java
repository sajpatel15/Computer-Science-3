package patelProject6;

public interface UnionFind<T> {

	// creates a set of only x as an element
	public void makeSet(T x);

	// this method performs the union between the sets that contain x and y
	public void union(T x, T y);

	// returns the element that represents the set that contains x
	public T find(T x);

}
