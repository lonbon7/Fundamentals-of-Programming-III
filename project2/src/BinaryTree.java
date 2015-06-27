/**
 * This is the binary tree class for use in CodeTree.
 * @author Lonnie Bissmeyer
 * @version 5/11/13
 */
public class BinaryTree<Element>
{
   private BinaryNode<Element> root;
   private BinaryNode<Element> current;   
   
   /**
    * A recursive function to find the parent of the current node.
    * @param finder  The root of the tree to start at.
    */
   private void findParent(BinaryNode<Element> finder)
   {
      if (finder==null) return;
      
      if(finder.getLeftNode() == current || finder.getRightNode() == current)
      {
         current = finder;
         return;
      }
      else
      {        
         findParent(finder.getRightNode());      
         findParent(finder.getLeftNode());        
      }
   }
   
   /**
    * A method for inserting a left or right child.
    * @param item The date you want inserted.
    * @param where Where you want inserted (left or right child).
    */
   public void insert(Element item, Relative where)
   {  
      BinaryNode<Element> node = new BinaryNode<Element>(item);
      
      if(where == Relative.ROOT)
      {
         root = node;
         current = root;
      }
      else if(where == Relative.LEFT_CHILD)
      {
         current.setLeftNode(node);
         current = current.getLeftNode();
      }
      else if(where == Relative.RIGHT_CHILD)
      {
         current.setRightNode(node);
         current = current.getRightNode();
      }
   }
   
   /**
    * A method for checking is the tree is empty.
    * @return true or false, if the tree is empty or not.
    */
   public boolean isEmpty()
   {
      return root == null;
   }
   
   /**
    * A method for making the tree empty.
    */
   public void makeEmpty()
   {
      root = null;
   }
   
   /**
    * Moves your current location to either left, right, root, or parent.
    * @param where Where to move current.
    * @return returns true or false if the move was successful or not.
    */
   public boolean move(Relative where)
   {    
      if(where == Relative.LEFT_CHILD)
      {
         if(current.getLeftNode() == null || root == null)
         {
            return false;
         }
         else
         {
            current = current.getLeftNode();
            return true;
         }
      }
      else if(where == Relative.RIGHT_CHILD)
      {
         if(current.getRightNode() == null || root == null)
         {
            return false;
         }
         else
         {
            current = current.getRightNode();
            return true;
         }
      }
      else if(where == Relative.PARENT)
      {
         if(current == root || root == null)
         {
            return false;
         }
         else
         {
            findParent(root);
            return true;
         }
      }
      else if(where == Relative.ROOT)
      {
         if(root == null)
         {
            return false;
         }
         else
         {
            current = root;
            return true;
         }
      }
      else
      {
         return false;
      }
   }
   
   /**
    * Gets the data of the current node.
    * @return The data at the current node.
    */
   public Element retrieve()
   {
      return current.getData();
   }
   
   /**
    * Traverses the tree in preorder.
    * @return A predorder String representation of the tree.
    */
   public String traverse()
   {
      return traverseTree(root);
   }
   
   /**
    * The private method called to traverse the tree in preorder.
    * @param target The root to start at.
    * @return A String representation of the tree in preorder.
    */
   private String traverseTree(BinaryNode<Element> target)
   {
      if(target == null)
      {         
         return "";
      }
      else
      {         
         return target.getData().toString() + traverseTree(target.getLeftNode()) + traverseTree(target.getRightNode());
      }
      
   }  
}
