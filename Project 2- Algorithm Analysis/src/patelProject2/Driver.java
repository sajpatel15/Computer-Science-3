package patelProject2;

import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("n \tAlgorithm 1\tAlgorithm2\tAlgorithm3 ");
		for (int n = 25000; n <= 400000; n += 25000) {
			int[] a = new int[n];
			System.out.print(n + "\t");

			Random rand = new Random();

			for (int i = 0; i < n; i++) {
				a[i] = rand.nextInt() % 1000;

			}
			long start = System.currentTimeMillis();

			MaxProduct.Algorithm1(a);

			long end = System.currentTimeMillis();
			System.out.print((end - start) + "\t\t");

			int count = 1500;
			 start = System.currentTimeMillis();
			 for(int i = 0; i< count; i++) {
				 MaxProduct.Algorithm2(a);
			 }
	
			 end = System.currentTimeMillis();
			System.out.print((end - start)/(double)count + "\t\t");
			
			
			 start = System.currentTimeMillis();
			 int count2 = 10000;
			 for(int i = 0; i < count2; i++) {
					MaxProduct.Algorithm3(a);
			 }
		
			end = System.currentTimeMillis();
			System.out.println((end - start)/(double)count2 + "\t\t");

		}

	}

}
