import java.util.EmptyStackException;

/**
 * The stack to be used for project2B.
 * @author Lonnie Bissmeyer
 * @version 5/12/13
 * @param <T> for generic use.
 */
public class LStack<T> 
{
   /**
    * Private class for node.
    * @author Lonnie Bissmeyer
    *
    */
	private class Node
	{
		public T element;
		public Node next;
	}
	
	private Node head;
	
	/**
	 * Constructs an empty stack.
	 */
	public LStack()
	{
		head = null;
	}
	
	/**
	 * Pushes an item onto the stack.
	 * @param data the item you want pushed onto the stack.
	 */
	public void push(T data)
	{
		if(head == null)
		{
			Node n = new Node();
			n.element = data; 
			head = n;
		}
		else
		{
			Node n = new Node();
			n.element = data;
			n.next = head;
			head = n;
		}		
	}
	
	/**
	 * Pops an item off of the stack.
	 * @return the item that got popped off.
	 */
	public T pop()
	{
		T element = head.element;
		
	   if(head.next == null)
		{
			head = null;
		}
		else
		{
			head = head.next;
		}
		return element;
	}
	
	/**
	 * Gives you the element on the top of the stack without changing the stack.
	 * @return the item at the top of the stack.
	 */
	public T peek()
	{
		if(head == null)
		{
			throw new EmptyStackException();
		}
		return head.element;
	}
	
	/**
	 * Checks to see if the stack is empty or not.
	 * @return true or false if the stack is empty or not.
	 */
	public boolean isEmpty()
	{
		return(head == null);
	}
}
