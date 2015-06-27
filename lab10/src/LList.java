import java.util.Iterator;

/**
 * Description: Lab10
 *
 * @author: John Mercer
 * @version: Lab10
 */
public class LList<T>
{
   private Node head;

   public LList()
   {
      head = null;
   }

   private class Node
   {
      public T data;
      public Node next;

      public Node(T data, Node next)
      {
         this.data = data;
         this.next = next;
      }
   }

   public void add(T data)
   {
      Node temp = head;
      Node node = new Node(data, null);

      if(head == null)
      {
         head = node;
      }
      else
      {
         while(temp.next != null)
         {
            temp = temp.next;
         }

         temp.next = node;
      }
   }

   public Iterator<T> iterator()
   {
      return new Iter(head);
   }

   private class Iter implements Iterator<T>
   {
      private Node cursor;

      public Iter(Node head)
      {
         this.cursor = head;
      }

      @Override
      public boolean hasNext()
      {
         return cursor.next != null;
      }

      @Override
      public T next()
      {
         Node node = cursor;
         cursor = cursor.next;
         return node.data;
      }

      @Override
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
}
