/*import java.util.Scanner;


public class AQueueClient 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		AQueue client = new AQueue(5);
		
		System.out.println("Enter a numeric value to enqueue");
		while(scan.hasNext())
		{
			System.out.println("Enter a numeric value to enqueue");
			if(scan.hasNextFloat())
			{
				float element = scan.nextFloat();
				client.enqueue(element);
			}
			else
			{
				scan.next();
			}
		}
		while(client.isEmpty() == false)
		{
			System.out.print(client.dequeue() + " ");
		}
		System.out.print("\n");
	}
}
*/