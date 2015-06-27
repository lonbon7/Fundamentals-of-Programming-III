import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The binary search tree for use in project2B.
 * @author Lonnie Bissmeyer
 * @version 5/12/13
 * @param <T> for generic use.
 */
public class BST<T extends Comparable<? super T>>
{
   private BinaryNode<T> root;
   
   /**
    * The class for pre-order iteration.
    * @author Lonnie Bissmeyer
    *
    */
   private class PreIter implements Iterator<T>
   {
      private BinaryNode<T> cursor;      
      private LStack<BinaryNode<T>> stack = new LStack<BinaryNode<T>>();
      
      /**
       * Constructor for the pre-order iterator class.
       * @param node where to start the iterator.
       */
      public PreIter(BST<T> tree)
      {
         cursor = tree.root;
      }
      
      /**
       * Returns true or false if the tree has another node or not.
       * @return true or false if the tree has another not or not. 
       */
      public boolean hasNext()
      {
         if(cursor == null)
         {
            return false;
         }
         else
         {
            return true;
         }
      }
      
      /**
       * Moves the iterator along.
       * @return the item from the node just moved on from.
       * @throws NoSuchElementException
       */
      public T next()
      {
         T element = cursor.getData();
         
         if(cursor == null)
         {
            throw new NoSuchElementException();
         }
         else if(cursor.getRightNode() != null && cursor.getLeftNode() != null)
         {
            stack.push(cursor.getRightNode());
            cursor = cursor.getLeftNode();
            return element;
         }
         else if(cursor.getRightNode() != null)
         {
            cursor = cursor.getRightNode();
            return element;
         }
         else if(cursor.getLeftNode() != null)
         {
            cursor = cursor.getLeftNode();
            return element;
         }
         else if((!stack.isEmpty()))
         {
            cursor = stack.pop();
            return element;
         }
         else               
         {
            cursor = null;
            return element;            
         }
      }
      
      /**
       * An unsupported remove method.
       * @throws UnsupportedOperationException
       */
      public void remove()
      {
         throw new UnsupportedOperationException();
      }      
   }
   
   /**
    * The class for level-order iteration.
    * @author Lonnie Bissmeyer
    *
    */
   private class LevelIter implements Iterator<T>
   {
      private BinaryNode<T> cursor;
      private LQueue<BinaryNode<T>> queue = new LQueue<BinaryNode<T>>();
      
      /**
       * The constructor for the level-order iterator class. 
       * @param node the node you want to start iterating at.
       */
      public LevelIter(BST<T> tree)
      {
         cursor = tree.root;
      }
      
      /**
       * Checks to see if there are more nodes.
       * @return true or false if there are more nodes or not.
       */
      public boolean hasNext()
      {
         if(cursor == null)
         {
            return false;
         }
         else
         {
            return true;
         }
      }
      
      /**
       * Moves the iterator along in level-order.
       * @return the element from the node just passed up.
       * @throws NoSuchElementException
       */
      public T next()
      {
         T element = cursor.getData();
         
         if(cursor == null)
         {
            throw new NoSuchElementException();
         }
         else
         {
            if(cursor.getLeftNode() != null)
            {
               queue.enqueue(cursor.getLeftNode());
            }
            if(cursor.getRightNode() != null)
            {
               queue.enqueue(cursor.getRightNode());
            }
            if(!(queue.isEmpty()))
            {
               cursor = queue.dequeue();
               return element;
            }
            else
            {
               cursor = null;
               return element;
            }            
         }
      }
      
      /**
       * Unsupported remove method.
       * @throws UnsupportedOperationException
       */
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
   
   /**
    * Constructor for BST class that initializes it to empty.
    */
   public BST()
   {
      root = null;
   }
   
   /**
    * Inserts an item maintaining BST structure.
    * @param item the item to be inserted.
    */
   public void insert(T item)
   {
      BinaryNode<T> cursor = root, node = new BinaryNode<T>(item);
      
      if(root == null)
      {
         root = node;
         return;
      }
      else
      {
         while(true)
         {
            if(cursor.getData().equals(node.getData()))
            {
               System.out.println("Error. Duplicates not allowed.");
               return;
            }
            else if(node.getData().compareTo(cursor.getData()) < 0)
            {
               if(cursor.getLeftNode() == null)
               {
                  cursor.setLeftNode(node);
                  return;
               }
               else
               {
                  cursor = cursor.getLeftNode();
               }
            }
            else if(node.getData().compareTo(cursor.getData()) > 0)
            {
               if(cursor.getRightNode() == null)
               {
                  cursor.setRightNode(node);
                  return;
               }
               else
               {
                  cursor = cursor.getRightNode();
               }
            }
         }         
      }  
   }
   
   /**
    * Finds an item in the tree.
    * @param item the item to be found.
    * @return true or false if the item is found or not.
    */
   public boolean find(T item)
   {
      BinaryNode<T> cursor = root, node = new BinaryNode<T>(item);    
      
      while(cursor != null)
      {
         if(cursor.getData().compareTo(node.getData()) == 0)
         {
            return true;
         }
         else if(node.getData().compareTo(cursor.getData()) < 0)
         {
            if(cursor.getLeftNode() == null)
            {
               return false;
            }
            else
            {
               cursor = cursor.getLeftNode();
            }
         }
         else if(node.getData().compareTo(cursor.getData()) > 0)
         {
            if(cursor.getRightNode() == null)
            {
               return false;
            }
            else
            {
               cursor = cursor.getRightNode();
            }
         }
      }
      
      return false;
   }
   
   /**
    * Checks to see if the tree is empty or not.
    * @return true or false if the tree is empty or not.
    */
   public boolean isEmpty()
   {
      return root == null;
   }
   
   /**
    * Public method for determining size.
    * @return the size of the tree.
    */
   public int size()
   {      
      return sizeOf(root);
   }
   
   /**
    * Private helper method for determining the size of the tree.
    * @param node where you want to start counting in the tree.
    * @return the size as an integer of the tree.
    */
   private int sizeOf(BinaryNode<T> node)
   {
      if(node == null)
      {         
         return 0;
      }
      else
      {         
         return 1 + sizeOf(node.getLeftNode()) + sizeOf(node.getRightNode());
      }
   }
   
   /**
    * Method that prints out the tree in pre-order using the iterator.
    */
   public void printPre()
   {
      PreIter iterator = new PreIter(this);
      
      while(iterator.hasNext())
      {
         System.out.print(iterator.next() + " ");
      }
      System.out.println();
   }   
   
   /**
    * Prints out the tree in level-order using the iterator.
    */
   public void printLevel()
   {
      LevelIter iterator = new LevelIter(this);
      
      while(iterator.hasNext())
      {
         System.out.print(iterator.next() + " ");
      }
      System.out.println();
   }
   
   public LevelIter getLevelIterator()
   {
      return new LevelIter(this);
   }
   
   /**
    * Prints out the tree in pre-order maintaining proper tab spacings per line.
    */
   public void testPrintPre()
   {
      ArrayList<T> list = new ArrayList<T>();      
      int height = 0;
      String line = "";
      
      testPrintPre(root, list);      
      
      for(T element : list)
      {
         height = height(root, element);
         
         for(int i = 0; i < height; i++)
         {
            line += '\t';
         }
         
         line += element.toString();
         System.out.println(line);
         line = "";
      }
     
   }
   
   /**
    * Gets an array list of the tree in pre-order.
    * @param node where to start adding to the list.
    * @param list the array list to add to.
    */
   private void testPrintPre(BinaryNode<T> node, ArrayList<T> list)
   {
      if(node != null)
      {
       list.add(node.getData());
       testPrintPre(node.getLeftNode(), list);
       testPrintPre(node.getRightNode(), list);
      }      
   }
   
   /**
    * Determines what line a particular node is at.
    * @param cursor the root of the tree.
    * @param item the item being looked for.
    * @return what line the node is at as an int.
    */
   private int height(BinaryNode<T> cursor, T item)
   {
      int height = 0;
      
      while(true)
      {
         if(cursor.getData().compareTo(item) == 0)
         {
            return height;
         }
         else if(cursor.getData().compareTo(item) > 0)
         {
            cursor = cursor.getLeftNode();
            height++;
            
         }
         else if(cursor.getData().compareTo(item) < 0)
         {
            cursor = cursor.getRightNode();
            height++;
         }
      }
   }  
}