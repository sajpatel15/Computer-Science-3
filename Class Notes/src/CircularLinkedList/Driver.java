package CircularLinkedList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList<Integer> list = new CircularLinkedList();
		
		for(int i = 0; i < 10; i++) {
			list.IsertAfterCursor(i);
		}
		System.out.println(list);
		for(int i = 0; i < 10; i++) {
			list.removeAfterCursor();
			System.out.println(list);
		}
	
		

	}

}
