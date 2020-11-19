package hashTest;

public class Hash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] table = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95};
		
		for(int i = 0; i < table.length; i++) {
			System.out.println(table[i] + " index " + hashfunction(table[i], 20));
		}
		
	}

	public static int hashfunction(int x, int n) {
		int func = ((13 * x + 5) % 23) % n;

		return func;
	}

}
