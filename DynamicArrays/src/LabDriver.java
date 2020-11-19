
public class LabDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// testing with n 
		DynamicArray<Integer> array = new DynamicArray<>();
		DynamicArrayArithmetic<Integer> arithmetic = new DynamicArrayArithmetic<>();
		System.out.println("n\tGeometric\tArithmetic");

		int n = 1000000;
		int n1 = n * 2;
		int n2 = n * 4;
		int n3 = n * 8;

		
		long start = System.currentTimeMillis();

		for (int i = 0; i < n; i++) {
			array.add(n + 1);
		}
		System.out.print(n + "\t");
		long end = System.currentTimeMillis();

		System.out.print(end - start + "\t\t");

		start = System.currentTimeMillis();

		for (int i = 0; i < n; i++) {
			arithmetic.add(n + 1);
		}

		end = System.currentTimeMillis();

		System.out.print(end - start + "\t");

		System.out.println();
		
		// testing with n1 
		
		DynamicArray<Integer> array1 = new DynamicArray<>();
		DynamicArrayArithmetic<Integer> arithmetic1 = new DynamicArrayArithmetic<>();
		
		start = System.currentTimeMillis();

		for (int i = 0; i < n1; i++) {
			array1.add(n1 + 1);
		}
		System.out.print(n1 + "\t");
		end = System.currentTimeMillis();

		System.out.print(end - start + "\t\t");

		start = System.currentTimeMillis();

		for (int i = 0; i < n1; i++) {
			arithmetic1.add(n1 + 1);
		}

		end = System.currentTimeMillis();

		System.out.print(end - start + "\t");

		System.out.println();
		
		//testing with n2
		
		DynamicArray<Integer> array2 = new DynamicArray<>();
		DynamicArrayArithmetic<Integer> arithmetic2 = new DynamicArrayArithmetic<>();
		
		start = System.currentTimeMillis();

		for (int i = 0; i < n2; i++) {
			array2.add(n2 + 1);
		}
		System.out.print(n2 + "\t");
		end = System.currentTimeMillis();

		System.out.print(end - start + "\t\t");

		start = System.currentTimeMillis();

		for (int i = 0; i < n2; i++) {
			arithmetic2.add(n2 + 1);
		}

		end = System.currentTimeMillis();

		System.out.print(end - start + "\t");

		System.out.println();


		// testing with n3
		
		DynamicArray<Integer> array3 = new DynamicArray<>();
		DynamicArrayArithmetic<Integer> arithmetic3 = new DynamicArrayArithmetic<>();
		
		start = System.currentTimeMillis();

		for (int i = 0; i < n3; i++) {
			array3.add(n3 + 1);
		}
		System.out.print(n3 + "\t");
		end = System.currentTimeMillis();

		System.out.print(end - start + "\t\t");

		start = System.currentTimeMillis();

		for (int i = 0; i < n3; i++) {
			arithmetic3.add(n3 + 1);
		}

		end = System.currentTimeMillis();

		System.out.print(end - start + "\t");

		System.out.println();
		
	}

}
