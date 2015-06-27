/**
 * This the queue class used for project 2B.
 * @author Lonnie Bissmeyer
 * @version 5/12/13
 * @param <T> This is for generic use.
 */
public class LQueue<T>
{
   private Node front;
   private Node end;
   
   /**
    * This constructs an empty queue.
    */
   public LQueue()
   {
      front = null;
      end = null;
   }
   /**
    * This is a private node class.
    * @author Lonnie Bissmeyer
    *
    */
   private class Node
   {
      public T element;
      public Node next;
   }
   
   /**
    * This is an exception class.
    * @author Lonnie Bissmeyer
    *
    */
   public static class MyException extends RuntimeException
   {
      private static final long serialVersionUID = -244806549310243756L;
      
      /**
       * Constructs a standard exception.
       */
      public MyException()
      {
         
      }
      
      /**
       * Constructs an exception with a message.
       * @param message the message you want entered.
       */
      public MyException(String message)
      {
         super(message);
      }      
   }
   
   /**
    * Enqueues an item.
    * @param item the item you want to enqueue.
    */
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
   
   /**
    * Dequeues from the queue.
    * @return the element that got dequeued.
    */
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
   
   /**
    * Checks if the queue is empty or not.
    * @return true or false if the queue is empty or not.
    */
   public boolean isEmpty()
   {
      return front == null;
   }
}
