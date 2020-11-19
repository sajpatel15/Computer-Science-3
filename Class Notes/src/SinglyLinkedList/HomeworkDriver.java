package SinglyLinkedList;

import java.util.Random;
public class HomeworkDriver {
	public static void main(String[] args) {
		int seed = 17171;
		Random rnd = new Random(seed);
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		for (int i = 1; i <= 5; i++) {
			list.insertFirst(i * rnd.nextInt(10));
			list.insertLast(i * rnd.nextInt(10));
			list.insertFirst(i * rnd.nextInt(10));
			list.insertLast(i * rnd.nextInt(10));
		}
		System.out.println(list);
		try {
			list.removeAtIndex(19);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("remove() throws an IndexOutOfBoundsException for an invalid index: 19");
		}
		System.out.println(list);
		try {
			System.out.println("element at index -1 removed from the list: " + list.removeAtIndex(-1));
		} catch (IndexOutOfBoundsException e) {
		}
		System.out.println(list);
		try {
			list.removeAtIndex(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("remove() throws an IndexOutOfBoundsException for an invalid index: 0");
		}
		System.out.println(list);
		try {
			list.removeAtIndex(4);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("remove() throws an IndexOutOfBoundsException for an invalid index: 4");
		}
		System.out.println(list);
	}
}