
public class HeapTest
{
   public static void main(String[] args)
   {
      Integer arr1[] = {1,2,3,17,19,36,7,25,100,20};
      Integer arr2[] = {1,0,3,17,19,36,7,25,100};
      Integer arr3[] = {1,2,3,17,19,36,7,25,100,8};

      boolean heapValue;

      heapValue = HeapWork.isHeap(arr1, 10);
      System.out.println(heapValue);
      if(heapValue)
      {
         HeapWork.printTree(arr1, 10);
      }
      
      heapValue = HeapWork.isHeap(arr2, 9);
      System.out.println(heapValue);
      if(heapValue)
      {
         HeapWork.printTree(arr2, 9);
      }
      
      heapValue = HeapWork.isHeap(arr3, 10);
      System.out.println(heapValue);
      if(heapValue)
      {
         HeapWork.printTree(arr3, 10);
      }      
   }
}
