
/*public class AQueue<T> 
{	
	private T[] arr;
	private int front, end, count;
	
	public static class MyException extends RuntimeException
	{
		public MyException()
		{
		}
		
		public MyException(String message)
		{
			super(message);
		}
	}
	
	public AQueue(int size)
	{
		arr = (T[])new Object[size];
		front = 0;
		end = -1;
		count = 0;
	}
	
	
	private void increaseCapacity()
	{
		int oldCapacity = arr.length;
		int newCapacity = arr.length * 2;
		T[] newArray = (T[]) new Object[newCapacity];
		int tempFront = front;
		for(int i = 0; i < arr.length; i++)
		{	
			newArray[i] = arr[tempFront];
			tempFront++;
			if(tempFront > arr.length - 1)
			{
				tempFront = 0;
			}
		}
		arr = newArray;
		end = oldCapacity - 1;
		front = 0;
	}
	
	public void enqueue(T addToEnd)
	{
		int oldCapacity = arr.length;
		if(count == arr.length)
		{
			increaseCapacity();
		}
		end++;
		count++;
		if(end > arr.length - 1 && oldCapacity == arr.length)
		{
			end = 0;
		}
		arr[end] = addToEnd;
	}
	
	public T dequeue()
	{
		if(count == 0)
		{
			throw new MyException();
		}
		T deletedElement = arr[front];
		arr[front] = null;
		front++;
		if(front > arr.length - 1)
		{
			front = 0;
		}
		count--;
		return deletedElement;
	}
	
	public boolean isEmpty()
	{
		return (count == 0);
	}
	
	public void printArray()
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}
}*/
