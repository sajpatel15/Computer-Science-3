
public class Driver {
	public static void main(String[] args)
	{
		Stack<Character> s = new StackList<>();
		
		System.out.println(s.pop());
		s.push('A');
		s.push('B');
		
	
		System.out.println(s);	
		
		System.out.println(s.pop());

		System.out.println(s);	
		System.out.println(s.top());
		s.push('C');
		System.out.println(s);	
		s.push('D');
		System.out.println(s);	
		System.out.println(s.top());
		System.out.println(s.pop());
		System.out.println(s);	

	}

}
