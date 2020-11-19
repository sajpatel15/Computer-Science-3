import java.util.Scanner;

public class Driver {

	public static void main(String[] args) 
	{

		BST<Integer> t = new BST();
		
		for(int i=0; i < 20; i++)
		{
			t.insert((int)(Math.random() * 100));
		}
		
		System.out.println(t);
		
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("value to remove");
			int v = input.nextInt();
			t.remove(v);
			System.out.println(t);
			System.out.println("tree size: " + t.size());
		}
	}

}
