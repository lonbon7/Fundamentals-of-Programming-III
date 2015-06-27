/**
 * Description: Lab9
 *
 * @author: John Mercer
 * @version: Lab9
 */
import java.util.EmptyStackException;

public class LStack<T>
{
   private class Node
   {
      public T element;
      public Node next;
   }

   private Node head;

   public LStack()
   {
      head = null;
   }

   public void push(T element)
   {
      Node n = new Node();
      n.element = element;
      n.next = head;
      head = n;
   }

   public T pop() throws EmptyStackException
   {
      if (isEmpty())
      {
         throw new EmptyStackException();
      }
      T elem = head.element;
      head = head.next;
      return elem;
   }

   public T peek()
   {
      if (isEmpty())
      {
         throw new EmptyStackException();
      }
      return head.element;
   }

   public boolean isEmpty()
   {
      return head == null;
   }
}
