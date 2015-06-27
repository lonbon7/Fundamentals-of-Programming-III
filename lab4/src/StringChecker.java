/*import java.util.ArrayList;
import java.util.Scanner;


public class StringChecker 
{
	public static boolean isBalanced(String toCheck)
	{
		LStack charStack = new LStack();
		ArrayList<Character> charList = new ArrayList<Character>();
		for(char c : toCheck.toCharArray())
		{
			charList.add(c);
		}
		int i = 0;
		while(i < charList.size())
		{
			//System.out.println("i:" + i);
			if(charList.get(i) == '{')
			{
				charStack.push(charList.get(i));
				//i++;
			}
			if(charList.get(i) == '}')
			{
				if(charStack.isEmpty() == true)
				{
					return false;
				}
				else
				{
					
					if((char)charStack.pop() != '{')
					{
						return false;
					}
					//i++;
				}
			}
			if(charList.get(i) == '(')
			{
				charStack.push(charList.get(i));
				//i++;
			}
			if(charList.get(i) == ')')
			{
				if(charStack.isEmpty() == true)
				{
					return false;
				}
				else
				{
					
					if((char)charStack.pop() != '(')
					{
						return false;
					}
					//i++;
				}
			}
			if(charList.get(i) == '[')
			{
				charStack.push(charList.get(i));
				//i++;
			}
			if(charList.get(i) == ']')
			{
				if(charStack.isEmpty() == true)
				{
					return false;
				}
				else
				{
					
					if((char)charStack.pop() != '[')
					{
						return false;
					}
					//i++;
				}
			}
			i++;
		}
		if(charStack.isEmpty() == false)
		{
			return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		boolean looper = true;
		while(looper == true)
		{
			System.out.println("Enter a String to analyze (press q to quit):");
			String prompt = scan.nextLine();
			
			if(isBalanced(prompt) == true && !(prompt.equals("q")))
			{
				System.out.println("Brackets, braces, and parenthesis are balanced");
			}
			else if(isBalanced(prompt) == false)
			{
				System.out.println("Brackets, braces, and parenthesis are not balanced");
			}
			else if(prompt.equals("q"))
			{
				return;
			}
		}
	}
}*/
