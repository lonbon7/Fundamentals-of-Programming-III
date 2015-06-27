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
   
   public T peek()
   {
      if(head == null)
      {
         throw new EmptyStackException();
      }
      return head.element;
   }
   
   public boolean isEmpty()
   {
      return(head == null);
   }
}
