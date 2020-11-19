package patelLab3;

public class MinTester {
	public static int min1(int[] input){
		int min = input[0];
		for (int i = 1; i < input.length; i++) {
			if (min > input[i]) {
				min = input[i];
			}
		}
		return min;
	}

	public static int min2(int[] input){
		// performs bubble sort on the input
		int n = input.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (input[j - 1] > input[j]) {
					// swap elements
					temp = input[j - 1];
					input[j - 1] = input[j];
					input[j] = temp;
				}
			}
		}
		return input[0];
	}
}
