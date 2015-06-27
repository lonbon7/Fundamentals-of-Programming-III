
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Lonnie Bissmeyer
 * @author Michael Williams
 * @version 5/20/13
 * 
 * The HTDriver class for project 3.
 *
 */

public class HTDriver
{
	public static void main(String[] args) throws FileNotFoundException
	{
	   String fileName, line;
	   Scanner scanner = new Scanner(System.in), reader;	   
	   
	  
      System.out.print("Please enter the name of the file you would like the read: ");
      fileName = scanner.nextLine();
      System.out.println();
      reader = new Scanner(new File(fileName));
      
      int numline = reader.nextInt();
	   HashTable table = new HashTable(numline);  
	   
	   for(int i = 0; i <= numline; i++)
	   {
	      line = reader.nextLine();
	      makeStudent(line, table);
	   }
	   
	   System.out.println("What would you like to do?");
	   System.out.println("a - add the element");
	   System.out.println("d - delete the element");
	   System.out.println("f - find and retrieve the element");
	   System.out.println("n - get the number of elements in the collection");
	   System.out.println("e - check if the collection is empty");
	   System.out.println("k - make the hash table empty");
	   System.out.println("p - print out the content of the hash table");
	   System.out.println("o - output the elements of the collection");
	   System.out.println("q - quit the program");
	   line = scanner.nextLine();
	   	   
	   while(true)
	   {
	      if(line.equals("a"))
	      {
	         
	         System.out.print("Please enter an id and last name: ");
	         line = scanner.nextLine();
	         Student student = (Student)makeStudent(line, table);
	         
	         if(student == null)
	         {
	            System.out.println("Error! Invalid line.");    
	         }
	         else
	         {
	            System.out.println(student.toString() + " was added.");
	         }
	         System.out.print("Choose another option: ");
            line = scanner.nextLine();          
            System.out.println();
	      }
	      else if(line.equals("d"))
	      {
	         System.out.print("Please enter a key to delete: ");
	         line = scanner.nextLine();
	         Student student = makeDummy(line);	         
	         
	         if(student == null)
	         {
	            System.out.println("Error! Invalid line.");
	         }
	         else
	         {
	            table.delete(student);
	            System.out.println("The student was deleted.");
	         }
	         System.out.print("Choose another option: ");
            line = scanner.nextLine();          
            System.out.println();
	      }
	      else if(line.equals("f"))
	      {
	         System.out.print("Please enter a key to find: ");
	         line = scanner.nextLine();
	         Student student = makeDummy(line);            
	         
            if(student == null)
            {
               System.out.println("Error! Invalid line.");
            }
            else
            {
               student = (Student)table.find(student);
               
               if(student == null)
               {
                  System.out.println("The student was not found.");
               }
               else
               {
                  System.out.println("The student was found.");
                  System.out.println(student.toString());
               }
            }
            System.out.print("Choose another option: ");
            line = scanner.nextLine();          
            System.out.println();
	      }
	      else if(line.equals("n"))
	      {
	         System.out.print("There are " + table.elementCount() + " elements" +
	         		" in the table.");
	         System.out.println(); 
	         System.out.print("Choose another option: ");
            line = scanner.nextLine();          
            System.out.println(); 
	      }
	      else if(line.equals("e"))
	      {
	         if(table.isEmpty())
	         {
	            System.out.println("The table is empty.");
	         }
	         else
	         {
	            System.out.println("The table is not empty.");
	         }
	         System.out.print("Choose another option: ");
            line = scanner.nextLine();          
            System.out.println();
	      }
	      else if(line.equals("k"))
	      {
	         table.makeEmpty();
	         System.out.println("The table has been emptied.");
	         System.out.print("Choose another option: ");
            line = scanner.nextLine();          
            System.out.println();
	      }
	      else if(line.equals("p"))
	      {
	         table.printTable();
	         System.out.println();
	         System.out.print("Choose another option: ");
            line = scanner.nextLine();          
            System.out.println();
	      }
	      else if(line.equals("o"))
	      {
	         table.outputData();
	         System.out.println();
	         System.out.print("Choose another option: ");
            line = scanner.nextLine();          
            System.out.println();
	      }
	      else if(line.equals("q"))
	      {
	         System.out.println("Thank you for using the program!");
	         scanner.close();
	         reader.close();
	         return;
	      }
	      else
	      {
	         System.out.println("Invalid line!");
	         System.out.print("Choose another option: ");
	         line = scanner.nextLine();	         
	         System.out.println();
	      }	      
	   }	   
	}
	
	private static Object makeStudent(String line, HashTable table)
	{
	   long id;
	   String lastName;
	   Scanner scanner;	   
	   
	   scanner = new Scanner(line);
	   
	   if(!scanner.hasNextLong())
	   {
	      scanner.close();
	      return null;
	   }
	   else
	   {
	      id = scanner.nextLong();
	      if(id <= 0)
	      {
	         scanner.close();
	         return null;
	      }
	   }
	   
	   if(!scanner.hasNext())
	   {
	      scanner.close();
	      return null;
	   }
	   else
	   {
	      lastName = scanner.next();
	   }
	   
	   if(scanner.hasNext())
	   {
	      scanner.close();
	      return null;
	   }
	   else
	   {
	      scanner.close();
	      Student student = new Student(id, lastName);
	      table.insert(student);
	      return student;
	   }	   
	}
	
	private static Student makeDummy(String line)
	{
	   long id;
	   Scanner lineScanner = new Scanner(line);
	   
	   if(!(lineScanner.hasNextLong()))
	   {
	      lineScanner.close();
	      return null;
	   }
	   else
	   {
	      id = lineScanner.nextLong();	     
	      if(id <= 0)
	      {
	         lineScanner.close();
	         return null;
	      }
	      else if(lineScanner.hasNext())
	      {
	         lineScanner.close();
	         return null;	         
	      }
	      else
	      {
	         lineScanner.close();
	         return new Student(id, "Dummy");
	      }
	   }
	}	
}
