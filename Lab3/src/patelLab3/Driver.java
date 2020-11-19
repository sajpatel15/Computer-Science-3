package patelLab3;

import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		
		System.out.println("n\tmin1\tmin2");
		for (int n = 5000; n <= 50000; n += 5000) {
			System.out.print(n + "\t");
			
			int[] arr = new int[n];
			Random rand = new Random();
			for (int i = 0; i < n; i++) {
				arr[i] = Math.abs(rand.nextInt()) % 100;
			}
			

			int count = 1000000;

			long start = System.currentTimeMillis();

			for (int i = 0; i < count; i++) {

				MinTester.min1(arr);
			}

			long end = System.currentTimeMillis();
			System.out.println((end - start) / (double) count + "\t");
//
//			long start = System.currentTimeMillis();
//
//			for (int i = 0; i < count; i++) {
//
//				MinTester.min2(arr);
//			}
//
//			long end = System.currentTimeMillis();
//			System.out.println((end - start) / (double) count + "\t");

		}
	}

}
