import java.util.Scanner;

public class Separator
{
   private static final int MAX = 5;
   
   public static void main(String args[])
   {
      Scanner scanner = new Scanner(System.in);
      int[] ints = new int[MAX];
      float[] floats = new float[MAX];
      int sizeInts = 0, sizeFloats = 0, intNum = 0;
      float floatNum = 0;
      
      System.out.println("Please type some numbers:");
      
      while(true)
      {
         if(scanner.hasNextInt())
         {
           if(sizeInts == MAX)
           {
              break;
           }
           intNum = scanner.nextInt();
           ints[sizeInts] = intNum;
           sizeInts++;
         }         
         else if(scanner.hasNextFloat())
         {
            if(sizeFloats == MAX)
            {
               break;
            }
            floatNum = scanner.nextFloat();
            floats[sizeFloats] = floatNum;
            sizeFloats++;
         }
         else
         {
            break;
         }
      }
      
      System.out.print("Integers: ");
      for(int i = 0; i < sizeInts; i++)
      {
         System.out.print(ints[i] + " ");
      }
      
      System.out.print("\nFloats: ");
      for(int i = 0; i < sizeFloats; i++)
      {
         System.out.print(floats[i] + " ");
      }
      
      scanner.close();
   }   
}
