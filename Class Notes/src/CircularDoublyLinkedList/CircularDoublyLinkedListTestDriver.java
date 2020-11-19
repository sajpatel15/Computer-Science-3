package CircularDoublyLinkedList;

public class CircularDoublyLinkedListTestDriver {

	public static void main(String[] args) {
		/**
		 * This driver tests methods you have implemented in your circular doubly linked
		 * list. To ensure that your methods are correct, all of the tests should PASS.
		 * If a test produces a FAIL, then you have an issue with your implementation.
		 * This driver tests the following methods: addAfterCursor(T value),
		 * deleteCursor(), toString(), isEmpty(), size()
		 */
		
		//We have previously only placed Integers in our lists, but making them generic means we can
		//place any object inside our lists
		CircularDoublyLinkedList<Character> list = new CircularDoublyLinkedList<Character>();
		/*---- Testing addAfterCursor, deleteCursor() toString(), isEmpty() and size()--- */
		if (list.isEmpty()) {
			System.out.println("PASS: isEmpty works for an empty list");
		} else {
			System.err.println("FAIL: isEmpty fails for an empty list");
		}

		// testing deleteCursor on an empty list
		try {
			System.err.println("FAIL: " + list.deleteCursor());
		} catch (Exception e) {
			System.out.println("PASS: deleteCursor throws an exception for empty list");
		}
		// test adding 1 element to the list
		list.addAfterCursor('a');
		if (list.toString().equals("a ")) {
			System.out.println("PASS: addAfterCursor works when adding 1 element");
			System.out.println("PASS: toString works for a list with 1 element");
		} else {
			System.err.println("FAIL: addAfterCursor failed when adding 1 element");
		}
		System.out.println(list.size());
		// test deleteCursor with 1 element
		if (list.deleteCursor() == 'a' && list.isEmpty()) {
			System.out.println("PASS: deleteCursor works for a single element");
		} else {
			System.err.println("FAIL: deleteCursor failed for a single element");
		}
		

		// test adding multiple elements to our list
		// adding the alphabetic characters a-z to our list using their ASCII value
		for (int i = 97; i < 123; i++) {
			list.addAfterCursor((char) i); // does an explicit cast from an int to a char
		}
		System.out.println("List after adding 26 elements: " + list + " (notice the position of the cursor)");
		if (list.toString().equals("a z y x w v u t s r q p o n m l k j i h g f e d c b ")) {
			System.out.println("PASS: addAfterCursor works when adding 26 elements");
			System.out.println("PASS: toString works for a list with 26 elements");
		} else {
			System.err.println("FAIL: addAfterCursor failed when adding 26 elements");
		}

		if (list.size() == 26) {
			System.out.println("PASS: size works for 26 elements");
		} else {
			System.err.println("FAIL: size is incorrect for 26 elements");
		}

		// test delete cursor by deleting some elements one at a time. Make sure the
		// return value of deleteCursor() method call is correct,
		// and make sure that the cursor moves the subsequent element after deletion
		if (list.deleteCursor() == 'a' && list.size() == 25) {
			System.out.println("PASS: deleteCursor removes the correct element, 'a'");
		} else {
			System.err.println("FAIL: deleteCursor fails to remove the correct element");
		}
		
		if (list.deleteCursor() == 'z' && list.size() == 24) {
			System.out.println("PASS: deleteCursor removes the correct element, 'z'");
		} else {
			System.err.println("FAIL: deleteCursor fails to remove the correct element");
		}
		
		if (list.deleteCursor() == 'y' && list.size() == 23) {
			System.out.println("PASS: deleteCursor removes the correct element, 'y'");
		} else {
			System.err.println("FAIL: deleteCursor fails to remove the correct element");
		}
		
		if (list.deleteCursor() == 'x' && list.size() == 22) {
			System.out.println("PASS: deleteCursor removes the correct element, 'x'");
		} else {
			System.err.println("FAIL: deleteCursor fails to remove the correct element");
		}
		
		//remove the rest of the elements from the list
		while(!list.isEmpty()) {
			Character deletedElement = list.deleteCursor();
			System.out.println("Deleted element: " + deletedElement + " | List right now: " + list);
		}
		
		

	}

}
