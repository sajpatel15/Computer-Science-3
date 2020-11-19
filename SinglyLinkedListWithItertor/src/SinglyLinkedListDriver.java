import java.util.Iterator;

public class SinglyLinkedListDriver 
{

	public static void main(String[] args) 
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		for(int i=0; i < 10; i++)
		{
			list.insertLast(i+1);
			System.out.println(list);

		}

		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext())
		{
			Integer i = it.next();
			System.out.print(i + " ");
			if(i % 2 == 0)
			{
				it.remove();
			}
		}
		System.out.println();
		
		System.out.println(list);
		
		//Because linkedList is itearble, I can use foreach loop
		for(Integer i : list)
		{
			System.out.println("i : " + i);
		}



	}

}
