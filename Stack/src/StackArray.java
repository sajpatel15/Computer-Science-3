
public class StackArray<T> implements Stack<T>
{

	private T[] stack;
	private int size;
	
	public StackArray(int capacity)
	{
		stack = (T[]) new Object[capacity];
		size = 0;
	}
	
	@Override
	public void push(T v) 
	{
		if(size == stack.length)
		{
			throw new ArrayIndexOutOfBoundsException("stack is full");
		}
		stack[size] = v;
		size++;
	}

	@Override
	public T pop() 
	{
		if(size == 0)
		{
			throw new IllegalStateException("Stack is empty");
		}
		
		T top = stack[size-1];
		stack[size-1] = null;
		size--;

		return top;
	}

	@Override
	public T top() 
	{
		if(size == 0)
		{
			throw new IllegalStateException("Stack is empty");
		}
		return stack[size-1];
	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public boolean isEmpty() 
	{
		return size == 0;
	}
	
	public String toString()
	{
		String r = "Top: ";

		for(int i=size-1; i >= 0; i--)
		{
			r += stack[i] + " ";
		}
		return r;
	}

}
