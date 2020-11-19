package CircularDoublyLinkedList;

import java.util.Random;

public class Driver {
	public static void main(String[] args) {
		int seed = 642435;
		Random rnd = new Random(seed);
		CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();

		for (int i = 1; i < 11; i++) {
			list.addAfterCursor(i);
		}
		while (!list.isEmpty()) {
			int n = rnd.nextInt(1000);
			list.advanceCursor(n);
			System.out.print(list.deleteCursor() + " ");

		}

	}
}