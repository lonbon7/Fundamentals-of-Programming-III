import java.util.InputMismatchException;
import java.util.Scanner;

public class ListWork 
{
   public static void main(String[] args)
   {
       Integer[] ints = new Integer[10];
       int size = 0, num = 0;
       Scanner scanner = new Scanner(System.in);
       boolean result = true;
       
       System.out.println("Please input values, inlcuding at least 10 integers.");
       
       while(size != 10)
       {
          try
          {
             num = scanner.nextInt();
             ints[size] = num;
             size++;
          }
          catch(InputMismatchException exception)
          {
             scanner.next();
          }          
       }       
       scanner.nextLine();
       System.out.println("Would you like to search?(yes/no)");
       String answer = scanner.next();       
       
       while(!(answer.equals("no")))
       {   
          System.out.println("What would integer you like to search for?");
          try
          {
             num = scanner.nextInt();
          }
          catch(InputMismatchException exception)
          {
             System.out.println("Error! You did not enter an integer!");
             break;
          }
         
          result = search(ints, num);
          if(result)
          {
             System.out.println("Your number was found!");
          }
          else
          {
             System.out.println("Your number was not found");
          }
          
          System.out.println("Would you like to search again?(yes/no)");
          answer = scanner.next(); 
       }
       
       print(ints);
       scanner.close();
   }
    
   public static <T> boolean search(T[] arr, T target)
   {
       for(int i = 0; i < arr.length; i++)
       {
           if(arr[i].equals(target))
           {
               return true;
           }
       }        
       return false;
   }
    
   public static <T> void print(T[] arr)
   {
       for(int i = 0; i < arr.length; i++)
       {
           System.out.println(arr[i]);
       }
   }
}
