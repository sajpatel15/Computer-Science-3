
public class Driver 
{
	public static void main(String[] args)
	{
		DynamicArray<Integer> a = new DynamicArray<>();
		
		for(int i=0; i < 20; i++)
		{
			a.add(i+1);
			System.out.println(a);
		}
		
		a.set(0, 10);
		a.set(a.size()-1, 100);
		System.out.println(a);

		a.remove(0);
		a.remove(a.size()-1);
		a.remove(a.size()/2);
		System.out.println(a);
		
		a.add(100);
		System.out.println(a);
	}

}
