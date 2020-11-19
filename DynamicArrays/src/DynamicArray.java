
public class DynamicArray<T> implements List<T>
{
	protected T[] theArray;
	protected int size;

	public DynamicArray()
	{
		theArray = (T[]) new Object[2];
		size = 0;
	}

	@Override
	public T get(int i) 
	{
		if(i < 0 || i >= size)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		return theArray[i];
	}

	@Override
	public T remove(int index) 
	{
		if(index < 0 || index >= size)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		T value = theArray[index];
		
		for(int i=index; i < size-1; i++)
		{
			theArray[i] = theArray[i+1];
		}
		//Remove the last value
		theArray[size-1] = null;
		
		size--;
		return value;
	}

	protected void expandArray()
	{
		//Maker a bigger array
		T[] newArray = (T[]) new Object[theArray.length * 2];
		
		for(int i=0; i < size; i++)
		{
			newArray[i] = theArray[i];
		}
		
		theArray = newArray;
		
	}

	@Override
	public void add(int index, T v) 
	{
		if(index < 0 || index > size)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		for(int i = size-1; i >= index; i--)
		{
			theArray[i+1] = theArray[i];
		}

		theArray[index] = v;
		size++;

		//Reached capacity
		if(size == theArray.length)
		{
			expandArray();
		}
	}

	@Override
	public void add(T v) 
	{

		add(size, v);
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public String toString()
	{
		String r = "";
		for(int i=0; i < size; i++)
		{
			r += theArray[i] + " ";
		}
		
		return r;
	}

	@Override
	public T set(int i, T v) 
	{
		if(i < 0 || i >= size)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		T oldValue = theArray[i];
		theArray[i] = v;
		return oldValue;
	}

}
