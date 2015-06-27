import java.util.*;

public class HashTableSC<T>
{
   private LinkedList<T>[] arr; 

   @SuppressWarnings("unchecked")
   public HashTableSC(int size)
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