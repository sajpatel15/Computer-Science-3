import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Map.Entry;

public class HashMap<K, V> implements Map<K, V> {

	private LinkedList<Entry<K, V>>[] theTable;
	private int size; // number of keys in the hashMap

	// parameters
	private int a;
	private int b;
	private int p; // prime number bigger than N
	private int N; // number of buckets

	public HashMap() {

		// initial size is 16
		initHashMap(16);
		size = 0;

	}

	private int getNextPrime(int x) {
		return (new BigInteger(Integer.toString(x))).nextProbablePrime().intValue();
	}

	public int hash(K key) {
		return Math.abs(((key.hashCode()) * a + b) % p) % N;
	}

	private void initHashMap(int newN) {

		N = newN;
		p = getNextPrime(N);
		a = (int) Math.random() * (p - 1) + 1;
		b = (int) Math.random() * (p);

		theTable = (LinkedList<Entry<K, V>>[]) new LinkedList[N];

		for (int i = 0; i < theTable.length; i++) {
			theTable[i] = new LinkedList<Entry<K, V>>();
		}
	}

	private void expandIfNeeded() {
		double loadFactor = (double) size / N; //

		if (loadFactor > 0.75) {

			LinkedList<Entry<K, V>>[] oldTable = theTable;
			initHashMap(N * 2);

			for (LinkedList<Entry<K, V>> bucket : oldTable) {
				for (Entry<K, V> entry : bucket) {
					this.put(entry.getKey(), entry.getValue());
				}
			}

		}
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub

		LinkedList<Entry<K, V>> bucket = theTable[this.hash(key)];

		for (Entry<K, V> entry : bucket) {
			// key already exists
			if (entry.getKey().equals(key)) {
				return entry.setValue(value);
			}
		}
		// This is a new Key
		bucket.add(new MapEntry(key, value));
		size++;
		return null;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		LinkedList<Entry<K, V>> bucket = theTable[this.hash(key)];
		
		for (Entry<K, V> entry : bucket) {
			// key already exists
			if (entry.getKey().equals(key)) {
				return entry.setValue(null);
			}
		}
		
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Iterable<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	private class MapEntry implements Entry<K, V> {

		private K key;
		private V value;

		public MapEntry(K k, V v) {
			key = k;
			value = v;
		}

		public String toString() {
			return key.toString() + ", " + value.toString();
		}

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public V setValue(V v) {
			// TODO Auto-generated method stub
			V oldValue = value;
			value = v;
			return oldValue;
		}

	}

}
