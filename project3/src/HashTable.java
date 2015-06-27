import java.util.Iterator;

/**
 * @author Lonnie Bissmeyer
 * @author Michael Williams
 * @version 5/20/13
 * 
 * The HashTable class for project 3. Includes methods for hash table
 * functionality.
 */
public class HashTable
{
   /**
    * Class for entries in the hash table.
    * @author Lonnie Bissmeyer
    * @author Michael Williams
    *
    */
   private class HashEntry
   {
	   /**
	    * The element this entry holds
	    */
      public Object element;
      
      /**
       * Whether or not this entry is currently active
       */
      public boolean active;
   }
   
   /**
    * The array of hash entries making up the hash table
    */
   private HashEntry[] table;
   
   /**
    * The number of non-null elements in the table
    */
   private int numOccupied;
   
   /**
    * Constructor for the HashTable class. Initializes the size of the table to
    * the hashed size given the number of wanted occupied cells.
    * @param size the number of occupied cells.
    */
   public HashTable(int size)
   {
      int value = size * 2;
      int prime = value;
      boolean isPrime = true;
      
      while(true)
      {
         for(int i = 2; i < prime; i++)
         {
            if(prime % i == 0)
            {
               prime++;
               isPrime = false;
               break;
            }
         }
         
         if(isPrime)
         {
            break;
         }
         else
         {
            isPrime = true;
         }
      }
      
      table = new HashEntry[prime];
      numOccupied = 0;
   }
   
   /**
    * Private class for iterating through the hash table.
    * @author Lonnie Bissmeyer
    * @author Michael Williams
    *
    */
   @SuppressWarnings("rawtypes")
   private class Iter implements Iterator
   {
      private int cursor;
      
      /**
       * Constructor for iterator class. Initializes the cursor to the index of
       * the first active entry in the hash table.
       */
      public Iter()
      {
         cursor = 0;
         
         while(cursor<table.length)
         {
            if(table[cursor] == null)
            {
               cursor++;
            }
            else
            {
               if(table[cursor].active == false)
               {
                  cursor++;
               }
               else
               {
                  break;
               }
            }
         }
      }
      
      /**
       * Checks if there is another spot in the table to be visited. Will always
       * return true until the end of the table has been reached.
       */
      public boolean hasNext()
      {
         if(cursor >= table.length)
         {
            return false;
         }
         else
         {
            return true;
         }
      }
      
      /**
       * Moves the iterator along to the next active spot in the table.
       * @return the entry in the table just skipped.
       */
      public Object next()
      {
         HashEntry entry = table[cursor];
         cursor++;
         while(cursor<table.length)
         {
            if(table[cursor] == null)
            {
               cursor++;
            }
            else if(table[cursor].active == false)
            {
               cursor++;
            }
            else
            {
               break;
            }
         }
         
         return entry;        
      }
      
      /**
       * An unsupported operation.
       * @throws UnsupportedOperationException
       */
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
   
   /**
    * A simple hash function
    * @param hashcode the hashcode to run through the hash function
    * @return the hash index
    */
   private int hash(int hashcode)
   {
	   return hashcode%table.length;
   }

   
   /**
    * Find the object you're looking for and returns it. Otherwise, it returns
    * null.
    * @param item The item you are looking for.
    * @return The you are looking for found in the table.
    */
   public Object find(Object item)
   {   
	   int hash = hash(item.hashCode());
	   
	   int attempts = 1;
	   while(table[hash]!=null)
	   {
		   if(table[hash].element.equals(item))
		   {
			   if(table[hash].active)
			   {
				   return table[hash].element;
			   }
			   else
			   {
				   return null;
			   }
		   }
		   else
		   {
			 //if not then do quadratic probing
			   hash += (attempts*attempts);
			   while(hash>table.length)
			   {
				   hash-=table.length;
			   }
			   attempts++;
		   }
	   }
	   
	   return null;
   }
   
   /**
    * Inserts a new item into the table and rehashes if necessary.
    * @param item The item you want to insert into the table.
    */
   public void insert(Object item)
   {
	   
	   int hash = item.hashCode();
	   //Attempt to insert the object
	   for(int i = 1; i < table.length; i++)
	   {
		   //if we can insert the object at the current hash index then do so
		   if(table[hash]==null || !table[hash].active)
		   {
			   table[hash] = new HashEntry();
               table[hash].element = item;
               table[hash].active = true;
               numOccupied++;
               break;
		   }
		   else
		   {
			   //if not then do quadratic probing
			   hash += (i*i);
			   while(hash>table.length)
			   {
				   hash-=table.length;
			   }
		   }
	   }
      
      if(numOccupied >= table.length/2)
      {
         int prime, newSize = table.length * 2;
         boolean isPrime = true;
         HashEntry[] oldTable = new HashEntry[table.length];
         
         for(int i = 0; i < table.length; i++)
         {
            oldTable[i] = table[i];
         }
         
         prime = newSize;
         
         while(true)
         {
            for(int i = 2; i < prime; i++)
            {           
               if(prime % i == 0)
               {
                  prime++;
                  isPrime = false;
                  break;
               }
            }
            
            if(isPrime)
            {
               break;
            }
            else
            {
               isPrime = true;
            }
         }
         
         table = new HashEntry[prime];
         numOccupied=0;
         for(int i = 0; i < oldTable.length; i++)
         {
        	 if(oldTable[i]!=null)
        	 {
        		 insert(oldTable[i].element);
        	 }
         }
         return;
      }
      else
      {
         return;
      }
   }
   
   /**
    * Deletes an item from the table if such an item exists.
    * @param item The item you want to delete.
    */
   public void delete(Object item)
   {
	   int hash = hash(item.hashCode());
	   
	   int attempts = 1;
	   while(table[hash]!=null)
	   {
		   if(table[hash].element.equals(item))
		   {
			  table[hash].active = false;
			  return;
		   }
		   else
		   {
			 //if not then do quadratic probing
			   hash += (attempts*attempts);
			   while(hash>table.length)
			   {
				   hash-=table.length;
			   }
			   attempts++;
		   }
	   }
   }
   
   /**
    * Prints out the table using a loop.
    */
   public void printTable()
   {
      for(int i = 0; i < table.length; i++)
      {
         System.out.print("[" + i + "]: ");
         
         if(table[i] == null)
         {
            System.out.println("Empty");
         }
         else
         {
            System.out.print(table[i].element.toString() + ", ");
            
            if(table[i].active)
            {
               System.out.println("active");
            }
            else
            {
               System.out.println("inactive");
            }
         }
      }
   }
   
   /**
    * Counts the number of active entries in the table.
    * @return The number of active entries in the table.
    */
   public int elementCount()
   {
      int count = 0;
      
      for(int i = 0; i < table.length; i++)
      {
         if(table[i] != null)
         {
            if(table[i].active)
            {
               count++;
            }
         }
      }
      
      return count;
   }
   
   /**
    * Checks to see if the table has any active elements in it or not.
    * @return True or false if the table has any active elements in it or not.
    */
   public boolean isEmpty()
   {
      boolean empty = true;
      
      for(int i = 0; i < table.length; i++)
      {
         if(table[i] != null)
         {
            if(table[i].active)
            {
               empty = false;
               break;
            }
         }
      }
      
      return empty;
   }
   
   /**
    * Makes the table empty by setting everything to null.
    */
   public void makeEmpty()
   {
      for(int i = 0; i < table.length; i++)
      {
         if(table[i] != null)
         {
            table[i] = null;
         }
      }
   }
   
   /**
    * Outputs data using the iterator.
    */
   public void outputData()
   {
      Iter iterator = new Iter();
      HashEntry entry;
      
      while(iterator.hasNext())
      {
         entry = (HashEntry)iterator.next();
         
         System.out.print(entry.element.toString() + ", ");
         
        if(entry.active)
        {
           System.out.println("active");
        }
        else
        {
           System.out.println("inactive");
        }
      }
   }
}
