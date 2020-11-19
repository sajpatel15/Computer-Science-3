package patelProject2;

import java.util.Arrays;

public class MaxProduct {

	/*
	 * According to the analysis carried out the asymptotic analysis of the method's
	 * worst-case runtime would be O(n^2)
	 */
	public static int Algorithm1(int[] a) {
		int result = Integer.MIN_VALUE; // cost to initialize results c1 = 1

		// assume a.length = n
		for (int i = 0; i < a.length - 1; i++) { // cost c2 = n
			for (int j = i + 1; j < a.length; j++) { // cost c3 = (n-1)(n+1);
				int product = a[i] * a[j]; // cost c4 = n(n-1)
				if (product > result) { // cost c5 = n(n-1)
					result = product; // cost c6 = n(n-1)
				}
			}
		}

		return result; // cost to return the results c7 = 1
	}

	/*
	 * According to the analysis carried out the asymptotic analysis of the method's
	 * worst-case runtime would be O(nlog(n))
	 */

	public static int Algorithm2(int[] a) {

		if (a.length < 2) { // cost c1 = 1
			throw new IllegalArgumentException("Array size should be greater than 2"); // cost c2 = 1
		}
		int[] copy = a.clone(); // cost to clone the array... cost c3 = n
		Arrays.sort(copy); // cost to sort the array... cost c4 = nlog(n)

		int smallestValues = copy[0] * copy[1]; // cost c5 = 1
		int largestValues = copy[copy.length - 1] * copy[copy.length - 2]; // cost c6 = 1

		if (smallestValues > largestValues) { // cost c7 = 1
			return smallestValues; // cost c8 = 1
		} else { // cost c9 = 1
			return largestValues; // cost c10 = 1
		}

	}

	/*
	 * According to the analysis carried out the asymptotic analysis of the method's
	 * worst-case runtime would be O(n)
	 */
	public static int Algorithm3(int[] a) {

		int smallest = Integer.MAX_VALUE; // cost c1 = 1
		int secondSmallest = Integer.MAX_VALUE; // cost c2 = 1
		int largest = Integer.MIN_VALUE; // cost c3 = 1
		int secondLargest = Integer.MIN_VALUE; // cost c4 = 1

		// assume a.length = n
		for (int i = 0; i < a.length; i++) { // cost c5 = n + 1
			if (a[i] < smallest) { // cost c6 = n
				secondSmallest = smallest; // cost c7 = n
				smallest = a[i]; // cost c8 = n
			} else if (a[i] > smallest && a[i] < secondSmallest) { // cost c9 = n
				secondSmallest = a[i]; // cost c10 = n
			}

			if (a[i] > largest) { // cost c11 = n
				secondLargest = largest; // cost c12 = n
				largest = a[i]; // cost c13 = n
			} else if (a[i] < largest && a[i] > secondLargest) { // cost c14 = n
				secondLargest = a[i]; // cost c15 = n
			}

		}

		int smallestValues = smallest * secondSmallest; // cost  c16 = n
		int largestValues = largest * secondLargest; // cost c17 = n

		if (smallestValues > largestValues) { // cost c18 = n
			return smallestValues; // cost c19 = n
		} else {	
			return largestValues; // cost c20 = n
		}

	}

}
