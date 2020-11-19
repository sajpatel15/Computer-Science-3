import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Homework15Driver {
	
	private static final int SEED = 35;
	private static Random rand = new Random(SEED);
	
	public static void main(String[] args) {
		
		ArrayList<Integer> unsortedList = generateShuffledArray(rand.nextInt(20));
		ArrayList<Integer> sortedList = binarySearchTreeSort(unsortedList);
		System.out.println(sortedList);
	}
	
	public static ArrayList<Integer> generateShuffledArray(int arrSize) {
		ArrayList<Integer> output = new ArrayList<>();
		int mult = rand.nextInt(100);
		for (int i = 0; i < arrSize; i++) {
			output.add(i * mult);
		}
		Collections.shuffle(output,rand);
		return output;
		
	}
	
		public static ArrayList<Integer> binarySearchTreeSort(ArrayList<Integer> unsortedList){
	            //TODO: Implement this method
			BST<Integer> sort = new BST();
			ArrayList<Integer> sorted = new ArrayList<>();
	            //create a BST and use it to sort the unsortedList
			for(int i = 0;  i < unsortedList.size(); i++) {
				sort.insert(unsortedList.get(i));
			}
			
			sorted = sort.inOrder();
		    // return the sorted list;
			return sorted;
			
		}
}