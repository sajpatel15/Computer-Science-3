package patelProject5;
import java.util.Iterator;
import java.util.Map.Entry;

public class Driver 
{
	public static void main(String[] args)
	{
		TreeMap<Integer, String> map = new TreeMap<>();
		
		//put a new value
		System.out.println(map.put(123, "Noodle"));
		System.out.println(map.put(124, "Rascle"));
		System.out.println(map.put(125, "Charlie"));
		System.out.println(map.put(126, "Beethoven"));
		System.out.println(map.put(124, "Raxle"));
		
		System.out.println(map.get(125));
		
		System.out.println("Map: " + map);
		System.out.println("Removed: " + map.remove(126));
		System.out.println("Map: " + map);
		
		for(Integer i : map.keySet())
		{
			System.out.println(i);
		}
		
		//Iterate over values
		Iterator<String> it = map.values().iterator(); 
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		//EntrySet
		Iterator<Entry<Integer, String>> entriesIterator = map.entrySet().iterator();
		while(entriesIterator.hasNext())
		{
			System.out.println(entriesIterator.next());
		}



	}

}
