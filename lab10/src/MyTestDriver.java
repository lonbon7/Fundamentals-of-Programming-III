/**
 * Description: Lab10
 *
 * @author: John Mercer
 * @version: Lab10
 */
import java.util.Iterator;

public class MyTestDriver
{
   public static void main (String [] args)
   {
      LList<Integer> listInt = new LList<Integer>();
      listInt.add(1);
      listInt.add(2);
      listInt.add(3);
      listInt.add(4);
      listInt.add(5);

      Iterator<Integer> iter = listInt.iterator();
      System.out.println(iter.next());
      System.out.println(iter.next());
      System.out.println(iter.next());
      System.out.println(iter.next());
      System.out.println(iter.next());


   }
}
