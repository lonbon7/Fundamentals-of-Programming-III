
public class LQueue<T>
{
   private Node front;
   private Node end;
   
   public LQueue()
   {
      front = null;
      end = null;
   }
   private class Node
   {
      public T element;
      public Node next;
   }
   
   public static class MyException extends RuntimeException
   {
      private static final long serialVersionUID = -244806549310243756L;
      
      public MyException()
      {
         
      }
      
      public MyException(String message)
      {
         super(message);
      }      
   }
   
   public void enqueue(T item)
   {
      if(front == null)
      {
         Node newNode = new Node();
         newNode.element = item;
         front = newNode;
         end = newNode;
      }
      else if(front.next == null)
      {
         Node newNode = new Node();
         newNode.element = item;
         front.next = newNode;
         end = newNode;
      }
      else
      {
         Node newNode = new Node();
         newNode.element = item;
         end.next = newNode;
         end = newNode;
      }
   }
   
   public T dequeue()
   {
      if(isEmpty())
      {
         throw new MyException();
      }
      
      T element = front.element;
      front = front.next;
      
      return element;
   }
   
   public boolean isEmpty()
   {
      return front == null;
   }
}
