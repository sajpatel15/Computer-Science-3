package patelProject3;
/*
 * Author: Saj Patel
 * Date: 4/30/2020
 * 
 * Description: This is a simple driver that tests whether or not the queue is working when implemented, 
 * it basically tests most of the methods that were implemented in the DoublyLinkedListQueue class.
 */

public class QueueTestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoublyLinkedListQueue<Integer> q = new DoublyLinkedListQueue<>();

		for (int i = 0; i < 10; i++) {
			q.enqueue(i + 1);
			System.out.println(q);
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(q.dequeue());
			System.out.println(q);
		}

		for (int i = 20; i < 25; i++) {
			q.enqueue(i);
			System.out.println(q);
		}
	}

}
