/*import java.util.Scanner;


public class AQueueDriver 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		AQueue testQueue = new AQueue(5);
		
		boolean toQuit = false;
		while(toQuit == false)
		{
			System.out.println("Choose one of the following operations:");
			System.out.println("-add (enter the letter a)");
			System.out.println("-delete (enter the letter d)");
			System.out.println("-isEmpty (enter the letter e)");
			System.out.println("-print (enter the letter p)");
			System.out.println("-Quit (enter the letter q)");
			
			String prompt = scan.next();
			if(prompt.equals("a"))
			{
				System.out.println("Enter a value to enqueue:");
				int element = scan.nextInt();
				testQueue.enqueue(element);
				System.out.println(element + " enqueue");
			}
			if(prompt.equals("d"))
			{
				System.out.println(testQueue.dequeue() + " dequeue");
			}
			if(prompt.equals("e"))
			{
				if(testQueue.isEmpty())
				{
					System.out.println("empty");
				}
				else
				{
					System.out.println("not empty");
				}
			}
			if(prompt.equals("p"))
			{
				testQueue.printArray();
			}
			if(prompt.equals("q"))
			{
				toQuit = true;
			}
		}
	}
}
*/