import java.util.Scanner;


public class DiGraphTest
{
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      int vertices, start, end;
      String choice;
      int[] top;
      
      System.out.print("How many vertices? ");
      vertices = scanner.nextInt();
      System.out.println();
      
      DiGraphAM graph = new DiGraphAM(vertices);
      
      System.out.print("What would you like to do? ");
      System.out.println("\n\na - add edge");
      System.out.println("d - delete edge");
      System.out.println("e - edge count");
      System.out.println("v - vertex count");
      System.out.println("p - print");
      System.out.println("t - topological sort");
      System.out.println("q - quit");
      
      while(true)
      {
         choice = scanner.next();        
         
         if(choice.equals("a"))
         {
            System.out.print("Please input the two vertices of the edge you want to add " +
            		"(two integers with a space between them): ");
            start = scanner.nextInt();
            end = scanner.nextInt();
            System.out.println();
            
            graph.addEdge(start, end);
            System.out.println("The edge (" + start + ", " + end + ") was added");
            System.out.print("\nEnter a command: ");
         }
         else if(choice.equals("d"))
         {
            System.out.print("Please input the two vertices of the edge you want to delete" +
            		"(two integers with a space between them): ");
            start = scanner.nextInt();
            end = scanner.nextInt();
            System.out.println();
            
            graph.deleteEdge(start, end);
            System.out.println("The edge (" + start + ", " + end + ") was deleted");
            System.out.print("\nEnter a command: ");
         }
         else if(choice.equals("e"))
         {
            System.out.println("The edge count is: " + graph.edgeCount());
            System.out.print("\nEnter a command: ");
         }
         else if(choice.equals("v"))
         {
            System.out.println("The vertex count is: " + graph.vertexCount());
            System.out.print("\nEnter a command: ");
         }
         else if(choice.equals("p"))
         {
            System.out.println("The content of the graph is the following:");
            graph.print();
            System.out.print("\nEnter a command: ");
         }
         else if(choice.equals("t"))
         {
            top = graph.topSort();
            for(int i = 0; i < top.length; i++)
            {
               System.out.print(top[i] + " ");
            }
            
            System.out.println();
            System.out.print("\nEnter a command: ");
         }
         else if(choice.equals("q"))
         {
            System.out.println("Thank you for using the program.");
            scanner.close();
            return;
         }
         else
         {
            System.out.println("\nInvalid input, try again.");
            scanner.nextLine();
            System.out.print("\nEnter a command: ");
         }
      }
      
   }
}
