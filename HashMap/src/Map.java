import java.util.Map.Entry;

public interface Map<K, V>
{
	//Map operatios
	public V put(K key, V value);
	public V get(K key);
	public V remove(K key);
	
	//Size related ones
	public int size();
	public boolean isEmpty();
	
	//Iterable ones
	public Iterable<K> keySet();
	public Iterable<V> values();
	public Iterable<Entry<K,V>> entrySet();
}
