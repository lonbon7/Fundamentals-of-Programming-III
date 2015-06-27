import java.util.*;

public class MyHashTable<T>
{
   private LinkedList<T>[] arr; 

   @SuppressWarnings("unchecked")
public MyHashTable(int size)
   {
      arr = (LinkedList<T>[])new LinkedList[size];
      for (int i = 0; i < arr.length; i++)
      {
         arr[i] = new LinkedList<T>();
      }
   }
   
   private int Hash(T value)
   {
      int code = value.hashCode();
      code = Math.abs(code);
      return code% arr.length;
   }
   
   public void makeEmpty()
   {
      for (int i = 0; i < arr.length; i++)
      {
         arr[i].clear();
      }      
   }
   
   public int size()
   {
	   int size = 0;
	   
	   for(int i = 0; i < arr.length; i++)
	   {
		   size += arr[i].size();
	   }
	   return size;
   }
   
   public void output()
   {
	   Iter iterator = new Iter();
	   int i = 0;
	   
	   while(iterator.hasNext())
	   {
		   System.out.print(i + ": ");		   
		   		   
		   while(iterator.j < arr[i].size())
		   {
			   
			   System.out.print(iterator.next() + " ");			   				   
		   }	   
		   System.out.println();
		   i++;
	   }
	   
	   while(i < arr.length)
	   {
		   System.out.println(i + ": ");
		   i++;
	   }	   
   }
   
   private class Iter implements Iterator<T>
   {
	   private int i, j;	   
	   
	   public Iter()
	   {
		   for(int k = 0; k < arr.length; k++)
		   {
			   if(!(arr[k].isEmpty()))
			   {
				   i = k;
				   j = 0;
				   break;
			   }
		   }
	   }
	   
	   public boolean hasNext()
	   {
		   if(j == arr[i].size())
		   {
			   i++;
			   while(i < arr.length)
			   {
				   if(arr[i].size() > 0)
				   {
					   j = 0;
					   return true;
				   }
				   i++;
			   }
			   return false;
		   }
		   else
		   {
			   return true;
		   }
	   }
	   
	   public T next()
	   {
		   T item = arr[i].get(j);
		   
		   if(j == arr[i].size())
		   {
			   while(i < arr.length)
			   {
				   if(arr[i].size() != 0)
				   {
					   j = 0;
					   return item;
				   }
				   i++;
			   }
			   return item;
		   }
		   else
		   {
			   j++;
			   return item;
		   }
	   }
	   
	   public void remove()
	   {
		   throw new UnsupportedOperationException("This operation is not supported.");
	   }
   }  
   
   public void insert (T value)
   {
      int index = Hash(value);
      arr[index].addFirst(value);
   }
   
   public void delete (T value)
   {
      int index = Hash(value);
      if (arr[index].contains(value))
      {  
         arr[index].remove(value);
      }
   }
   
   public boolean find (T value)
   {
      int index = Hash(value);
      return arr[index].contains(value);
   }
   
   public boolean isEmpty()
   {
      for (int i = 0; i < arr.length; i++)
      {
         if (arr[i].size() != 0)
         {
            return false;
         }
      }
      return true;
   }
   
   public void print()
   {
      for (int i = 0; i < arr.length; i++)
      {
         System.out.print(i + ": ");
         for (int j = 0; j < arr[i].size(); j++)
         {
            System.out.print(arr[i].get(j) + " ");
         }
         System.out.println();
      }
   }
}