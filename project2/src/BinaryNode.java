/**
 * The binary node class to be used in the binary tree.
 * @author Lonnie Bissmeyer
 * @version 5/11/13
 * @param <T> generic, can hold any data type.
 */
public class BinaryNode<T>
{
   private BinaryNode<T> left, right;
   private T nodeData;
   
   /**
    * The constructor for the class. Allows you to pass in the data type and sets
    * left and right to null.
    * @param data the data the node is going to hold.
    */
   public BinaryNode(T data)
   {
      nodeData = data;
      left = null;
      right = null;
   }
   
   /**
    * A constructor for the class. Allows you to set the data and the left and 
    * right children.
    * @param data the data you want the node to hold.
    * @param left what you want the left child to be set to.
    * @param right what you want the right child to be set to.
    */
   public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right)
   {
      nodeData = data;
      this.left = left;
      this.right = right;
   }
   
   /**
    * Sets the data to the desired value.
    * @param data the data you want to set the node to.
    */
   public void setData(T data)
   {
      nodeData = data;
   }
   
   /**
    * Retrieves the data at the current node.
    * @return the data at the current node.
    */
   public T getData()
   {
      return nodeData;
   }
   
   /**
    * Sets the left child to the desired value.
    * @param left the node you want to set the left child to.
    */
   public void setLeftNode(BinaryNode<T> left)
   {
      this.left = left;
   }
   
   /**
    * Returns the left child of the current node.
    * @return the left child of the current node.
    */
   public BinaryNode<T> getLeftNode()
   {
      return left;
   }
   
   /**
    * Sets the right child to the desired value.
    * @param right the desired value for the right child.
    */
   public void setRightNode(BinaryNode<T> right)
   {
      this.right = right;
   }
   
   /**
    * Returns the left child of the current node.
    * @return the left child of the current node.
    */
   public BinaryNode<T> getRightNode()
   {
      return right;
   }
}
