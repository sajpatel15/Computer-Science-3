package patelProject5;

import java.util.ArrayList;
import java.util.Map.Entry;


public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {

	private BST<MapEntry<K, V>> map;

	public TreeMap() {
		map = new BST<>();
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		for (Entry<K, V> e : map) {
			if (e.getKey().compareTo(key) == 0) {
				return e.setValue(value);
			}
		}

		// It's not in the map
		map.insert(new MapEntry<K, V>(key, value));

		return null;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		for (Entry<K, V> e : map) {
			if (e.getKey().compareTo(key) == 0) {
				return e.getValue();
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		for (MapEntry<K, V> e : map) {
			if (e.getKey().compareTo(key) == 0) {

				V value = e.getValue();
				map.remove(e);
				return value;
			}
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return map.isEmpty();
	}

	@Override
	public Iterable<K> keySet() {
		// TODO Auto-generated method stub
		ArrayList<K> keys = new ArrayList<K>();
		for(Entry<K,V> e: map) {
			keys.add(e.getKey());
		}
		return keys;
	}
	
	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		ArrayList<V> values = new ArrayList<>();
		for(Entry<K,V> e : map)
		{
			values.add(e.getValue());
		}
		return values;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		ArrayList<Entry<K,V>> entries = new ArrayList<>();
		for(Entry<K,V> e : map)
		{
			entries.add(e);
		}
		return entries;
		
	}
	
	public String toString() {
		return map.toString();
	}

	private class MapEntry<K extends Comparable<K>, V> implements Entry<K, V>, Comparable<MapEntry<K, V>> {

		private K key;
		private V value;

		MapEntry(K k, V v) {
			this.key = k;
			this.value = v;
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
			V oldValue = this.value;
			this.value = v;
			return oldValue;
		}

		public String toString() {
			return key.toString() + " : " + value.toString();
		}

		public int compareTo(MapEntry<K, V> o) {
			// TODO Auto-generated method stub
			return this.key.compareTo(o.key);
		}

	}

}
