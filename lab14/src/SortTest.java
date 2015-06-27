import java.util.*;

public class SortTest
{

   public static void main(String[] args)
   {
      //Declaring arrays.
      Integer[] arr1 = new Integer[100];
      Integer[] arr2 = new Integer[100];
      Integer[] arr3 = new Integer[100];
      Integer[] arr4 = new Integer[100];
      Random random = new Random();
    
      //Filling up arrays.
      for(int i = 0; i < 100; i++)
      {
         arr1[i] = random.nextInt(500);
         arr2[i] = random.nextInt(500);
         arr3[i] = random.nextInt(500);
         arr4[i] = random.nextInt(500);
      }
    
      Sort.selectionSort(arr1, arr1.length);
      System.out.print("Selection sort test: ");
      for(int i = 0; i < 100; i++)
      {
         System.out.print( arr1[i] + " ");
      }    
      System.out.println();
    
      Sort.insertionSort(arr2, arr2.length);
      System.out.print("Insertion sort test: ");
      for(int i = 0; i < 100; i++)
      {
         System.out.print( arr2[i] + " ");
      }    
      System.out.println();
    
      Sort.mergeSort(arr3, arr3.length);
      System.out.print("Merge sort test: ");
      for(int i = 0; i < 100; i++)
      {
         System.out.print( arr3[i] + " ");
      }    
      System.out.println();    
    
      Sort.quickSort(arr4, 0, arr4.length - 1);
      System.out.print("Quick sort test: ");
      for(int i = 0; i < 100; i++)
      {
         System.out.print( arr4[i] + " ");
      }    
   } 
}