
public class Driver {

	public static void main(String[] args) 
	{
		Queue<Integer> q = new QueueArray<>(10);
		
		for(int i=0; i < 10; i++)
		{
			q.enqueue(i+1);
			System.out.println(q);
		}
		
		for(int i=0; i < 5; i++)
		{
			System.out.println(q.dequeue());
			System.out.println(q);
		}
		
		for(int i= 20; i< 25; i++)
		{
			q.enqueue(i);
			System.out.println(q);
		}

	}

}
