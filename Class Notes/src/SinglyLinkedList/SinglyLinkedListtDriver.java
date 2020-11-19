package SinglyLinkedList;

public class SinglyLinkedListtDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		for(int i = 0; i < 10; i++) {
			list.insertFirst(i+1);
			System.out.println(list);

			
		}
		
		System.out.println(list);
		
		
		System.out.println(list.getMin());
	}
	
	

}
