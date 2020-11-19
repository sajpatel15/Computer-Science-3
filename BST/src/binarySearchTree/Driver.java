package binarySearchTree;


import java.util.Scanner;

public class Driver {

	public static void main(String[] args) 
	{

		BST<Integer> t = new BST();
		
		for(int i=1; i < 11; i++)
		{
			t.insert(i);
		}
		
		
		System.out.println(t);	
		
		BST<Integer> t2 = new BST();
		
		t2.insert(5);
		t2.insert(3);
		t2.insert(6);
		t2.insert(8);
		t2.insert(4);
		t2.insert(7);
		t2.insert(2);
		t2.insert(1);
		t2.insert(10);
		t2.insert(9);
		
		System.out.println(t2);
	}
		

}
