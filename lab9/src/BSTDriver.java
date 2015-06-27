/**
 * Description: Lab9
 *
 * @author: John Mercer
 * @version: Lab9
 */

public class BSTDriver
{
   public static void main (String [] args)
   {
      BasicBST one = new BasicBST();
      int arr[] = {2, 4, 6, 1, 3, 7, 5, -1, 10, 12, -2, 0};
      one = loadBST(one, arr);

      System.out.println("Lower than 4: " + one.countLower(4));
      System.out.println("Leaves: " + one.countLeaves());
      System.out.println("One Child Parents: " + one.countOneChildParents());
      System.out.println("Height: " + one.height());


//      BasicBST one = new BasicBST();
//      BasicBST two = new BasicBST();
//      BasicBST three = new BasicBST();
//      BasicBST four = new BasicBST();
//
//
//      int[] arr1 = {5, 2, 8, 1, 4, 0, 3, 7, 10, 6, 9};
////      int[] arr1 = {5, 2, 8, 1, 4, 7, 10, 0 , 3, 6, 9};\
//      int[] arr2 = {50, 20, 80, 10, 40, 0, 30, 70, 100, 60, 90};
//      int[] arr3 = {0, -50, 50, -75, -25, 25, 75, -100, -65, -40, -15, 15,
//                    40, 65, 100};
//      int[] arr4 = {50, 25, 75, 10, 30, 60, 80, 0, 5, 27, 33, 55, 65, 77, 85};
//
//      one = loadBST(one, arr1);
//      one.printPre(one.preIter());
//      two = loadBST(two, arr2);
//      two.printPre(two.preIter());
//      three = loadBST(three, arr3);
//      three.printPre(three.preIter());
//      four = loadBST(four, arr4);
//      four.printPre(four.preIter());


   } // end main

   public static BasicBST loadBST(BasicBST bst, int[] arr)
   {
      for(int i = 0; i < arr.length; i++)
      {
         bst.insert(arr[i]);
      }
      return bst;
   }

   public static void testLab9Methods(BasicBST bst)
   {
      bst.print();
      System.out.println("\nHeight: " + bst.height());
      System.out.println(bst.countOneChildParents());
      System.out.println(bst.countLeaves());
      System.out.println("\n" + bst.countLower(4));
   }
}
