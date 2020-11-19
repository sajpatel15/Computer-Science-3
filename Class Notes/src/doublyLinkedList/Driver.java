package doublyLinkedList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		for(int i = 0; i< 10; i++) {
			list.addFirst(i+1);
		}
		
		System.out.println(list);
		
//		for(int i =0; i< 10; i++) {
//			list.addLast(i + 1);
//		}
		
		//System.out.println(list);
		
		list.removeFirst();
		System.out.println(list);

	}

}
