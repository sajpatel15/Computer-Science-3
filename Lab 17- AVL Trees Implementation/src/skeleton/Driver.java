package skeleton;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) 
	{

		AVLTree<Integer> t = new AVLTree<Integer>();
		
		for(int i=0; i < 20; i++)
		{
			t.add(i);
		}
		
		System.out.println(t);
		
		Scanner input = new Scanner(System.in);
		boolean running = true;
		
		while(running)
		{
			System.out.println("value to remove");
			int v = input.nextInt();
			t.remove(v);
			System.out.println(t);
			System.out.println("tree size: " + t.size());
		}
		
		input.close();
	}

}
