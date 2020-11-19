
public class DynamicArrayArithmetic<T> extends DynamicArray<T> {
	
	public DynamicArrayArithmetic() {
		
		super();
	}
	
	@Override
	protected void expandArray()
	{
		//Maker a bigger array
		T[] newArray = (T[]) new Object[theArray.length + 10000];
		
		for(int i=0; i < size; i++)
		{
			newArray[i] = theArray[i];
		}
		
		theArray = newArray;
		
	}
	

}
