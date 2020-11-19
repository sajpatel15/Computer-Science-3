
public class Homework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		for(int n = 0; n < 10000; n+= 1000 ) {
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = i * i;
			}
			long start = System.currentTimeMillis();
			
			int count = 100;
			for(int i = 0; i < count; i++) {
				mystery_method(arr);
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println((end - start)/(double)count);
		}
		
//		for(int n = 0; n <= 10000; n += 1000) {
//			
//			int[][] arr2 = new int[n][n];
//			
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					arr2[i][j] = i*j;
//				}
//			}
//			
//			long start = System.currentTimeMillis();
//			
//			int count = 50;
//			for(int i = 0; i < count; i++) {
//				mystery_method2(arr2);
//			}
//			
//			long end = System.currentTimeMillis();
//			System.out.println((end - start)/(double)count);
//			
//		}
		

		
		
	}

	public static int mystery_method(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static int mystery_method2(int[][] arr){
	     int sum = 0;
	     for (int i = 0; i < arr.length; i++) {
	          for (int j = 0; j < arr[i].length; j++) {
	               sum += arr[i][j]; 
	          }    
	     }
	     return sum;
	}
}
