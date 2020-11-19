package doublyLinkedList;
import java.util.Random;

public class HomeworkDirver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		int seed = 1983;
		Random rnd = new Random(seed);
		for (int i = 1; i <= 10; i++) {
			list.addLast(rnd.nextInt(10));
		}
		System.out.println(list);
		int search = rnd.nextInt(10);
		System.out.println(search);
		System.out.println(list.search(search));

	}

}
