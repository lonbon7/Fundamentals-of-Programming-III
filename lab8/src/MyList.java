
public class MyList {
   private class Node
   {
      public int data;
      public Node next;
   }
   
   private Node head;
   
   public MyList()
   {
      head = null;
   }
   
   public void add(int value)
   {
      Node newNode = new Node();
      newNode.data = value;
      newNode.next = head;
      head = newNode;
   }
   
   public boolean find(int target)
   {
      return find(target, head);
   }
   
   private boolean find(int item, Node node)
   {
      if(node == null)
         return false;
      else if(node.data == item)
         return true;
      else
         return find(item, node.next);
   }
   
   public void print()
   {
      print(head);
   }
    
   private void print(Node node)
   {
      if(node != null)
      {
         print(node.next);
         System.out.println(" " + node.data);
      }
   }

}
