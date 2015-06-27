import java.util.Scanner;

/**
 * The driver for Project 2B.
 * @author Lonnie Bissmeyer
 * @version 5/13/13
 */
public class BSTDriver
{
   /**
    * The main function for the program.
    * @param args any command line arguments.
    */
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      BST<Integer> tree = new BST<Integer>();
      String answer = "";
      Integer integer;
      
      System.out.println("Choose one of the following operations by entering provided letter:");
      System.out.println("a - add the element");
      System.out.println("f - find the element");
      System.out.println("e - check if the tree is empty");
      System.out.println("n - get the number of nodes (the size) of the tree");
      System.out.println("p - print the tree in preorder");
      System.out.println("l - print the tree in level order");
      System.out.println("t - test print the content of the tree");
      System.out.println("q - quit the program");
      
      answer = scanner.next();      
      
      while(!(answer.equals("q")))
      {
         if(answer.equals("a"))
         {
            System.out.print("Please enter an integer to add: ");
            integer = scanner.nextInt();
            
            System.out.println();
            tree.insert(integer);
            answer = scanner.next();
            
         }
         else if(answer.equals("f"))
         {
            System.out.print("Please choose an element to find: ");
            integer = scanner.nextInt();
            
            System.out.println();
            
            if(tree.find(integer))
            {
               System.out.println("Your item is in the tree.");
            }
            else
            {
               System.out.println("Your item is not in the tree.");
            }
            
            answer = scanner.next();
         }            
         else if(answer.equals("e"))
         {
            if(tree.isEmpty())
            {
               System.out.println("The tree is empty.");
            }
            else
            {
               System.out.println("The tree is not empty.");
            }
            
            answer = scanner.next();
            
         }
         else if(answer.equals("n"))
         {
            System.out.println("The size of the tree is: " + tree.size());
            answer = scanner.next();
            
         }
         else if(answer.equals("p"))
         {
            tree.printPre();
            answer = scanner.next();
            
         }
         else if(answer.equals("l"))
         {
            tree.printLevel();
            answer = scanner.next();
            
         }
         else if(answer.equals("t"))
         {
            tree.testPrintPre();
            answer = scanner.next();            
         }
      }
      scanner.close();
      return;
   }
}