/**
 * Description: Lab9
 *
 * @author: John Mercer
 * @version: Lab9
 */


import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BasicBST
{
   BSTNode root;
   LStack<Integer> preStack = new LStack<Integer>();

   BasicBST()
   {
      root = null;
   }

   private class BSTNode
   {
      public int element;
      public BSTNode leftChild;
      public BSTNode rightChild;

      BSTNode(int element)
      {
         this.element = element;
         leftChild = null;
         rightChild = null;
      }
   }

   public void insert(int x)
   {
      BSTNode node = new BSTNode(x);

      root = insert(root, node);
   }

   private BSTNode insert(BSTNode parent, BSTNode child)
   {
      if(parent == null)
      {
         return child;
      }
      else if (child.element < parent.element)
      {
         parent.leftChild = insert(parent.leftChild, child);
      }
      else if (child.element > parent.element)
      {
         parent.rightChild = insert(parent.rightChild, child);
      }
      else // child.element == parent.element
      {
         ;
      }
      return parent;
   }

   public int countLower(int x)
   {
      if(root == null)
      {
         return 0;
      }
      else
      {
         return countLower(root, x);
      }
   }

   private int countLower(BSTNode parent, int x)
   {
      if(parent == null)
      {
         return 0;
      }
      else if (x < parent.element)
      {
         return countLower(parent.leftChild, x);
      }
      else if (x > parent.element)
      {
         return 1 + countLower(parent.leftChild, x)
                + countLower(parent.rightChild, x);
      }
      else // node.element == root.element
      {
         return countLower(parent.leftChild, x);
      }
   }

   public int height()
   {
      if(root == null)
      {
         return -1;
      }
      else if (root.leftChild == null && root.rightChild == null)
      {
         return 0;
      }
      else
      {
         return height(root);
      }
   }

   private int height(BSTNode node)
   {
      if(node == null)
      {
         return 0;
      }
      else if(node.rightChild == null && node.leftChild == null)
      {
         return 0;
      }
      else
      {
         return 1 + Math.max(height(node.leftChild), height(node.rightChild));
      }
   }

   public int countLeaves()
   {
      if(root == null)
      {
         return 0;
      }
      else
      {
         return countLeaves(root);
      }
   }

   private int countLeaves(BSTNode node)
   {
      if(node == null)
      {
         return 0;
      }
      else if (node.leftChild == null && node.rightChild == null)
      {
         return 1;
      }
      else
      {
         return countLeaves(node.leftChild) + countLeaves(node.rightChild);
      }
   }

   public int countOneChildParents()
   {
      if(root == null)
      {
         return 0;
      }
      else
      {
         return countOneChildParents(root);
      }
   }

   private int countOneChildParents(BSTNode node)
   {
      if(node == null)
      {
         return 0;
      }
      else if(node.leftChild == null && node.rightChild != null)
      {
         return 1 + countOneChildParents(node.rightChild);
      }
      else if(node.rightChild == null && node.leftChild != null)
      {
         return 1 + countOneChildParents(node.leftChild);
      }
      else if(node.rightChild == null && node.leftChild == null)
      {
         return 0;
      }
      else // both children not null
      {
         return countOneChildParents(node.leftChild) +
                countOneChildParents(node.rightChild);
      }
   }

   public void print()
   {
      if(root == null)
      {
         System.out.println("null");
      }
      else
      {
         print(root);
      }
   }

   private void print(BSTNode node)
   {
      if(node == null)
      {
         return;
      }
      else
      {
         System.out.print(node.element + " ");
         print(node.leftChild);
         print(node.rightChild);
      }
   }

   public Iterator<Integer> preIter()
   {

      if(root == null)
      {
         return null;
      }
      else
      {
         buildStack(root);
         return new preIter();
      }
   }

   private void buildStack(BSTNode parent)
   {
      if(parent.rightChild != null)
      {
         buildStack(parent.rightChild);
      }
      if (parent.leftChild != null)
      {
         buildStack(parent.leftChild);
      }

      preStack.push(parent.element);
   }

   private class preIter implements Iterator<Integer>
   {
      @Override
      public boolean hasNext()
      {
         return preStack.peek() != null;
      }

      @Override
      public Integer next()
      {
         if(!hasNext())
         {
            throw new NoSuchElementException();
         }
         return preStack.pop();
      }

      @Override
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }

   public void printPre(Iterator<Integer> iter)
   {
      try
      {
         while(iter.hasNext())
         {
            System.out.print(iter.next() + " ");

         }
      }
      catch(NoSuchElementException e)
      {
//         e.printStackTrace();
      }
      catch(EmptyStackException e)
      {
//         e.printStackTrace();
      }
      System.out.println();
   }
}
