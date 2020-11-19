
public class StackList<T> implements Stack<T> 
{
	private SinglyLinkedList<T> stack;
	
	public StackList()
	{
		stack = new SinglyLinkedList<>();
	}

	@Override
	public void push(T v) 
	{
		stack.insertAtHead(v);
		
	}

	@Override
	public T pop() 
	{		
		return stack.removeHead();
	}

	@Override
	public T top() 
	{
		return stack.head();
	}

	@Override
	public int size() 
	{
		return stack.size();
	}

	@Override
	public boolean isEmpty() 
	{
		return stack.size() == 0;
	}
	
	public String toString()
	{
		return "Top: " + stack.toString();
	}
	

}
