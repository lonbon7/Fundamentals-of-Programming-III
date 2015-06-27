public class HashTest
{
   public static void main (String[] args)
   {
      HashTableSC<Integer> table = new HashTableSC<Integer>(10);
      
      /*for (int i = 0; i < 100; i++)
      {
         table.insert((Integer)i);
      }
      */
      
      System.out.println("find 89: " + table.find(89));
      System.out.println("find 18: " + table.find(18));
      System.out.println("find 49: " + table.find(49));
      System.out.println("find 58: " + table.find(58));
      System.out.println("find 69: " + table.find(69)); 
      table.insert(89);
      table.insert(18);
      table.insert(49);
      table.insert(58);
      table.insert(69);
      
      System.out.println("find 89: " + table.find(89));
      System.out.println("find 18: " + table.find(18));
      System.out.println("find 49: " + table.find(49));
      System.out.println("find 58: " + table.find(58));
      System.out.println("find 69: " + table.find(69)); 
      System.out.println("find 69: " + table.find(9)); 

      System.out.println(table.isEmpty());
      
      table.delete(89);
      table.delete(18);
      table.delete(49);
      table.delete(58);
      table.delete(69);
      System.out.println(table.isEmpty());
      
      System.out.println("find 89: " + table.find(89));
      System.out.println("find 18: " + table.find(18));
      System.out.println("find 49: " + table.find(49));
      System.out.println("find 58: " + table.find(58));
      System.out.println("find 69: " + table.find(69)); 
      
      
      table.print();
   }
}