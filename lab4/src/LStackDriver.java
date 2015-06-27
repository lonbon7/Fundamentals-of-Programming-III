/*import java.util.EmptyStackException;
import java.util.Scanner;


public class LStackDriver 
{
	@SuppressWarnings("rawtypes")
  /* public static void main(String[] args)
	{
		LStack intStack = new LStack();
		Scanner scan = new Scanner(System.in);
		
		boolean looper = true;
		while(looper == true)
		{
			System.out.println("Choose one of the following operations:");
			System.out.println("-push/add (enter the letter a)");
			System.out.println("-pop/delete (enter the letter d)");
			System.out.println("-peek (enter the letter p)");
			System.out.println("-check if the list is empty (enter the letter e)");
			System.out.println("-Quit (enter the letter q)");
	
			String prompt = scan.next();
			if(prompt.equals("a"))
			{
				System.out.println("Enter Integer to push on the stack:");
				try
				{
					int element = scan.nextInt();
					intStack.push(element);
				}
				catch(EmptyStackException exc)
				{
					System.out.println("Invalid operation on an empty stack.");
					scan.nextLine();
				}
			}
			else if(prompt.equals("d"))
			{
				try
				{
					intStack.pop();
					System.out.println(intStack.pop() + " popped out");
				}
				catch(EmptyStackException exc)
				{
					System.out.println("Invalid operation on an empty stack.");
					scan.nextLine();
				}
			}
			else if(prompt.equals("p"))
			{
				try
				{
					intStack.peek();
					System.out.println(intStack.peek() + " on top");
				}
				catch(EmptyStackException exc)
				{
					System.out.println("Invalid operation on an empty stack.");
					scan.nextLine();
				}
			}
			else if(prompt.equals("e"))
			{
				if(intStack.isEmpty())
				{
					System.out.println("empty");
				}
				System.out.println("not empty");
			}
			else if(prompt.equals("q"))
			{
				while(intStack.isEmpty() == false)
				{
					intStack.pop();
					System.out.println(intStack.pop());
				}
				looper = false;
			}
			else
			{
				System.out.println("Invalid choice");
			}
		}
	}
}
*/