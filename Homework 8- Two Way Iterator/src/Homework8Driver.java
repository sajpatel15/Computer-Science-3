import java.util.NoSuchElementException;
public class Homework8Driver {
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		TwoWayIterator<Integer> iter = list.iterator();
		// Question 1
		try {
			iter.next();
			System.out.println("Next does not throw exception");
		} catch (NoSuchElementException e) {
			System.out.println("Next throws exception");
		}
		// Question 2
		try {
			iter.previous();
			System.out.println("Previous does not throw exception");
		} catch (NoSuchElementException e) {
			System.out.println("Previous throws exception");
		}
		// Add some elements to test with
		list.addLast(42);
		list.addLast(59);
		list.addLast(12409);
		// Question 3
		try {
			iter.next();
			System.out.println("Next does not throw exception");
		} catch (NoSuchElementException e) {
			System.out.println("Next throws exception");
		}
		while (iter.hasNext()) {
			iter.next();
		}
		// Question 4
		try {
			iter.next();
			System.out.println("Next does not throw exception");
		} catch (NoSuchElementException e) {
			System.out.println("Next throws exception");
		}
		// Question 5
		try {
			iter.previous();
			System.out.println("Previous does not throw exception");
		} catch (NoSuchElementException e) {
			System.out.println("Previous throws exception");
		}
		while (iter.hasPrevious()) {
			iter.previous();
		}
		// Question 6
		try {
			iter.previous();
			System.out.println("Previous does not throw exception");
		} catch (NoSuchElementException e) {
			System.out.println("Previous throws exception");
		}

                // Question 7
		String resultString = "";
		for (int i : list) {
			resultString += i + ", ";
		}
		//remove the trailing comma
		resultString = resultString.substring(0, resultString.length() - 2);
		System.out.println(resultString);
	}
}