/**
 * Description: Lab10
 *
 * @author: John Mercer
 * @version: Lab10
 */
import java.util.Iterator;
import java.util.Random;

public class SeparateAndMerge
{
   public static void main (String [] args)
   {
      final int SIZE = 21;
      int[] intArr = {-13, 7, 6, 5, 4, 8, 9, 10, 11, 200, 12, 0, 1, 2,
              3}; // 15
      float[] floatArr = {1.2f, 2.3f, 3.4f, 6.5f, 4.3f, 0.0f}; // 6
      int[] selection = new int[SIZE];

      LList<Integer> intList = new LList<Integer>();
      LList<Float> floatList = new LList<Float>();

      for(int i = 0; i < SIZE; i++)
      {
         Random r = new Random();

         int j = r.nextInt(2);
         int k = r.nextInt(15);
         int l = r.nextInt(6);

         if(j == 0)
         {
            intList.add(intArr[k]);
            selection[i] = j;
//            System.out.println("Added int: " + intArr[k]);
         }
         else // j == 1
         {
            floatList.add(floatArr[l]);
            selection[i] = j;
//            System.out.println("Added float: " + floatArr[k]);
         }
      }

      System.out.println("Selection: ");

      for(int i = 0; i < SIZE; i++)
      {
         System.out.print(selection[i] + " ");
      }

      Iterator<Integer> intIter = intList.iterator();
      Iterator<Float> floatIter = floatList.iterator();

      System.out.println("\nInputted Values: ");


      for(int i = 0; i < SIZE; i++)
      {
         if(intIter.hasNext())
         {
            System.out.print(intIter.next() + " ");
         }
         if(floatIter.hasNext())
         {
            System.out.print(floatIter.next() + " ");
         }
      }
   }
}
