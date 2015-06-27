import java.util.Scanner;


public class LQueueDriver
{
   public static void main(String[] args)
   {
      LQueue<Integer> queue = new LQueue<Integer>();
      Scanner scanner = new Scanner(System.in);
      String input;
      char answer;
      int element, addCount = 0, deleteCount = 0;    
      
      while(true)
      {         
         System.out.println("Choose from one of the following operations:");
         System.out.println("-enqueue/add(enter the letter a)");
         System.out.println("-dequeque/delete(enter the letter d)");
         System.out.println("-check if the list is empty(enter the letter e)");
         System.out.println("-quit(enter the letter q)");
         
         input = scanner.nextLine();
         answer = input.charAt(0);         
         
         if(answer != 'a' && answer != 'd' && answer != 'e' && answer != 'q')
         {
            System.out.println("ERROR! You didn't not choose a correct option.\n");
         }
         else
         {
            if(answer == 'q')
            {
               scanner.close();
               System.out.println("quitting…thanks for using the program");
               break;
            }
            
            if(answer == 'a')
            {
               System.out.print("Please enter an integer: ");
               if(scanner.hasNextInt())
               {
                  element = scanner.nextInt();
                  scanner.nextLine();
                  queue.enqueue(element);
                  addCount++;
                  if(addCount == 1)
                  {
                     System.out.println(addCount + " element enqueued");
                  }
                  else
                  {
                     System.out.println(addCount + " elements enqueued");
                  }
                  System.out.println();
               }
               else
               {
                  System.out.println("ERROR! You did not enter an integer.\n");
                  scanner.nextLine();
               }
            }
            
            if(answer == 'd')
            {
               if(queue.isEmpty())
               {
                  System.out.println("ERROR! The queue is empty and will throw and exception.\n");
               }
               else
               {
                  queue.dequeue();
                  deleteCount++;
                  if(deleteCount == 1)
                  {
                     System.out.println(deleteCount + " element dequeued");
                  }
                  else
                  {
                     System.out.println(deleteCount + " elements dequeued");
                  }
                  System.out.println();
               }
            }
            
            if(answer == 'e')
            {
               if(queue.isEmpty())
               {
                  System.out.println("The queue is empty.");
               }
               else
               {
                  System.out.println("The queue is not empty.");
               }
               System.out.println();
            }            
         }         
      }
      
      while(!(queue.isEmpty()))
      {
         element = queue.dequeue();
         System.out.print(element + " ");
      }
   }
}
