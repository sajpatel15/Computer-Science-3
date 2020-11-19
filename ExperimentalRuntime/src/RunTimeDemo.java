import java.util.ArrayList;

public class RunTimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// n is the input size (number of values I insert into the array or linked list

		System.out.println("n\tArray(ms)\tSinglyList(ms)\tDoublyList(ms)");
		for (int n = 0; n <= 200000; n += 20000) {
			ArrayList<Integer> array = new ArrayList<>();

			long start = System.currentTimeMillis();

			System.out.print(n + "\t");
			for (int i = 0; i < n; i++) {
				array.add(0, i);
			}
			long end = System.currentTimeMillis();
			System.out.print((end - start) + "\t\t");

			// Timing inserting n elements in a singly list
			start = System.currentTimeMillis();

			int count = 1000;
			for (int j = 0; j < count; j++) {
				SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
				for (int i = 0; i < n; i++) {
					list.insertFirst(i);
				}

			}

			end = System.currentTimeMillis();
			System.out.print((end - start)/(double)count + "\t\t");

			// Timing inserting n elements in a doubly list
			start = System.currentTimeMillis();

			for (int j = 0; j < count; j++) {
				DoublyLinkedList<Integer> dList = new DoublyLinkedList<>();

				for (int i = 0; i < n; i++) {
					dList.addFirst(i);
				}
			}
			end = System.currentTimeMillis();
			System.out.println((end - start)/(double)count + "");

		}

	}

}
