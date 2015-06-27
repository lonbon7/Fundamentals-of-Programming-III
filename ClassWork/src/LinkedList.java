/*
public class LinkedList
{
   Node front;
   Node cursor = front;
   
   public LinkedList()
   {
      front = null;
   }
   
   public boolean isEmpty()
   {
      return(front == null);
   }
   
   public void makeEmpty()
   {
      front = null;
   }
   
   public void insertFront(String data)
   {
      front = new Node(data, front);
   }
   
   public void insert(String data)
   {
      //This is the front case.
      if(isEmpty() || front.elem.compareTo(data)> 0)
      {
         insertFront(data);
         return;
      }
      
      //This is the middle case.
      while(cursor.next != null)
      {
         //if(n.next.elem.compareTo(data) > 0)
         {
      }
      if(data.compareTo(cursor.elem) < 0 && cursor == front)
      {
         //Node node = new Node(data, front);         
      }
   }


   }
}
*/