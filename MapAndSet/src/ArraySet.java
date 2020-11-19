import java.util.ArrayList;
import java.util.Iterator;

public class ArraySet<E> implements Set<E>, Iterable<E> {
	private ArrayList<E> theSet;

	public ArraySet() {
		theSet = new ArrayList<>();
	}

	@Override
	public boolean contains(E element) {
		for (E e : theSet) {
			if (e.equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(E element) {
		if (this.contains(element)) {
			return false;
		}
		theSet.add(element);
		return true;
	}

	@Override
	public boolean remove(E element) {
		for (int i = 0; i < theSet.size(); i++) {
			if (theSet.get(i).equals(element)) {
				theSet.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return theSet.size();
	}

	@Override
	public boolean isEmpty() {
		return theSet.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return theSet.iterator();
	}

	@Override
	public void addAll(Set<E> otherSet) {
		for (E e : otherSet) {
			this.add(e);
		}
	}

	@Override
	// Lab
	public void retainAll(Set<E> otherSet) {
		ArrayList<E> temp = new ArrayList<E>();
		for (E e : otherSet) {
			if (this.contains(e)) {
				temp.add(e);
			}
		}

		theSet = temp;

	}

	@Override
	public void removeAll(Set<E> otherSet) {
		for (E e : otherSet) {
			this.remove(e);
		}
	}

	public String toString() {
		String r = "";
		for (E e : theSet) {
			r += e + ", ";
		}
		return r;
	}

}
