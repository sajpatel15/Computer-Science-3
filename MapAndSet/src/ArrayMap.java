import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayMap<K, V> implements Map<K, V>
{
	private ArrayList<Entry<K,V>> theMap;
	
	public ArrayMap()
	{
		theMap = new ArrayList<>();
	}
	
	@Override
	public V put(K key, V value) 
	{
		//Find the MapEntry that has key k
		for(Entry<K,V> e: theMap)
		{
			if(e.getKey().equals(key))
			{
				return e.setValue(value);
			}
		}
		theMap.add(new MapEntry(key,value));
		
		return null;
	}

	@Override
	public V get(K key) 
	{
		for(Entry<K,V> e: theMap)
		{
			if(e.getKey().equals(key))
			{
				return e.getValue();
			}
		}
		return null;
	}

	@Override
	//You are implementing this for lab
	public V remove(K key)
	{
		
		for(Entry<K,V> e: theMap) {
			if(e.getKey().equals(key)) {
				V value = e.getValue();
				e.setValue(theMap.get(size()-1).getValue());
				theMap.remove(size()-1);
				return value;
			}
		}
		return null;
	}

	@Override
	public int size() 
	{
		return theMap.size();
	}

	@Override
	public boolean isEmpty() 
	{
		return theMap.isEmpty();
	}

	@Override
	public Iterable<K> keySet() 
	{
		ArrayList<K> keys = new ArrayList<>();
		for(Entry<K,V> e : theMap)
		{
			keys.add(e.getKey());
		}
		return keys;
	}

	@Override
	public Iterable<V> values() 
	{
		ArrayList<V> values = new ArrayList<>();
		for(Entry<K,V> e : theMap)
		{
			values.add(e.getValue());
		}
		return values;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() 
	{
		return theMap;
	}
	
	public String toString()
	{
		String r = "";
		for(Entry<K, V> e : theMap)
		{
			r += e + ", ";
		}
		
		return r;
	}
	
	private class MapEntry implements Entry<K, V>
	{

		private K key;
		private V value;

		public MapEntry(K k, V v)
		{
			this.key = k;
			this.value = v;
		}
		
		@Override
		public K getKey()
		{
			return key;
		}

		@Override
		public V getValue() 
		{
			return value;
		}

		@Override
		public V setValue(V v) 
		{
			V oldValue = this.value;
			this.value = v;
			return oldValue;
		}
		
		public String toString()
		{
			return key.toString() + " : " + value.toString();
		}
		
	}
}
