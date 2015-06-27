import java.util.*;

public class SortPerformance
{
	public static void main(String[] args)
	{
	   long start = 0, end = 0, total = 0;
	   
	   //Arrays with 40000
	   Integer[] arrUnsorted = new Integer[40000];	     
	   Integer[] arrSorted = new Integer[40000];
	   Integer[] arrReverse = new Integer[40000];
	   
	   //Arrays with 80000
	   Integer[] arrUnsorted2 = new Integer[80000];	   
	   Integer[] arrSorted2 = new Integer[80000];
	   Integer[] arrReverse2 = new Integer[80000];	   
	   
	   //Arrays with 160000
	   Integer[] arrUnsorted3 = new Integer[160000];	   
	   Integer[] arrSorted3 = new Integer[160000];
	   Integer[] arrReverse3 = new Integer[160000];	   
	   
	   Random random = new Random();
	   
	   //Initialize 40,000
	   for (int i = 0; i < 40000; i++)
	   {
	      arrUnsorted[i] = random.nextInt(40000);	      
	      arrSorted[i] = i;
	      arrReverse[i] = 40000 - i;
	   }
	   
	   //Initialize 80,000
	   for (int i = 0; i < 80000; i++)
	   {
	      arrUnsorted2[i] = random.nextInt(80000);	      
	      arrSorted2[i] = i;
	      arrReverse2[i] = 80000 - i;
	   }
	   
	   //Initialize 160,000
	   for (int i = 0; i < 160000; i++)
	   {
	      arrUnsorted3[i] = random.nextInt(160000);	      
	      arrSorted3[i] = i;
	      arrReverse3[i] = 160000 - i;
	   }
	   
	   //First block of 40,000.
	   start = System.currentTimeMillis();
	   Sort.selectionSort(arrUnsorted, 40000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting unsorted 40,000 with selection sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.insertionSort(arrSorted, 40000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting sorted 40,000 with insertion sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.mergeSort(arrReverse, 40000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting reverse 40,000 with merge sort: " + total);
	   
	   //Randomizing 40,000 arrays
	   for (int i = 0; i < 40000; i++)
	   {
	      arrUnsorted[i] = random.nextInt(40000);	      
	      arrSorted[i] = i;
	      arrReverse[i] = 40000 - i;
	   }
	   
	   //Second block of 40,000.
	   start = System.currentTimeMillis();
	   Sort.selectionSort(arrReverse, 40000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting reverse 40,000 with selection sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.insertionSort(arrUnsorted, 40000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting unsorted 40,000 with insertion sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.mergeSort(arrSorted, 40000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting sorted 40,000 with merge sort: " + total);
	   
	   //Randomizing 40,000 second time	   
	   for (int i = 0; i < 40000; i++)
	   {
	      arrUnsorted[i] = random.nextInt(40000);	      
	      arrSorted[i] = i;
	      arrReverse[i] = 40000 - i;
	   }
	   
	   //Third block of 40,000.
	   start = System.currentTimeMillis();
	   Sort.mergeSort(arrUnsorted, 40000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting unsorted 40,000 with merge sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.insertionSort(arrReverse, 40000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting reverse 40,000 with insertion sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.selectionSort(arrSorted, 40000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting sorted 40,000 with selection sort: " + total);
	   
	   //Randomizing 40,000 a third time.
	   for (int i = 0; i < 40000; i++)
      {
         arrUnsorted[i] = random.nextInt(40000);         
         arrSorted[i] = i;
         arrReverse[i] = 40000 - i;
      }
	   
	   //Fourth block of 40,000.
	   start = System.currentTimeMillis();
      Sort.quickSort(arrUnsorted, 0, arrUnsorted.length - 1);
      end = System.currentTimeMillis();
      total = end - start;
      System.out.println("Time sorting unsorted 40,000 with quick sort: " + total);
      
      start = System.currentTimeMillis();
      Sort.quickSort(arrReverse, 0, arrReverse.length - 1);
      end = System.currentTimeMillis();
      total = end - start;
      System.out.println("Time sorting reverse 40,000 with quick sort: " + total);
      
      start = System.currentTimeMillis();
      Sort.quickSort(arrSorted, 0, arrSorted.length - 1);
      end = System.currentTimeMillis();
      total = end - start;
      System.out.println("Time sorting sorted 40,000 with quick sort: " + total);
	   
	   //First block of 80,000.
	   start = System.currentTimeMillis();
	   Sort.selectionSort(arrUnsorted2, 80000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting unsorted 80,000 with selection sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.insertionSort(arrSorted2, 80000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting sorted 80,000 with insertion sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.mergeSort(arrReverse2, 8000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting reverse 80,000 with merge sort: " + total);
	   
	   //Randomizing 80,000 the first time.   
	   for (int i = 0; i < 80000; i++)
	   {
	      arrUnsorted2[i] = random.nextInt(80000);	      
	      arrSorted2[i] = i;
	      arrReverse2[i] = 80000 - i;
	   }
	   
	   //Second block of 80,000.
	   start = System.currentTimeMillis();
	   Sort.selectionSort(arrReverse2, 80000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting reverse 80,000 with selection sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.insertionSort(arrUnsorted2, 80000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting unsorted 80,000 with insertion sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.mergeSort(arrSorted2, 80000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting sorted 80,000 with merge sort: " + total);
	   
	   //Randomizing 80,000 the second time.
	   for (int i = 0; i < 80000; i++)
	   {
	      arrUnsorted2[i] = random.nextInt(80000);	      
	      arrSorted2[i] = i;
	      arrReverse2[i] = 80000 - i;
	   }
	   
	   //Third block of 80,000.
	   start = System.currentTimeMillis();
	   Sort.mergeSort(arrUnsorted2, 80000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting unsorted 80,000 with merge sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.insertionSort(arrReverse2, 80000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting reverse 80,000 with insertion sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.selectionSort(arrSorted2, 80000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting sorted 80,000 with selection sort: " + total);
	   
	   //Randomizing 80,000 the third time.
      for (int i = 0; i < 80000; i++)
      {
         arrUnsorted2[i] = random.nextInt(80000);        
         arrSorted2[i] = i;
         arrReverse2[i] = 80000 - i;
      }
	   
      //Fourth block of 80,000.
      start = System.currentTimeMillis();
      Sort.quickSort(arrUnsorted2, 0, arrUnsorted2.length - 1);
      end = System.currentTimeMillis();
      total = end - start;
      System.out.println("Time sorting unsorted 80,000 with quick sort: " + total);
      
      start = System.currentTimeMillis();
      Sort.quickSort(arrReverse2, 0, arrReverse2.length - 1);
      end = System.currentTimeMillis();
      total = end - start;
      System.out.println("Time sorting reverse 80,000 with quick sort: " + total);
      
      start = System.currentTimeMillis();
      Sort.quickSort(arrSorted2, 0, arrSorted2.length - 1);
      end = System.currentTimeMillis();
      total = end - start;
      System.out.println("Time sorting sorted 80,000 with quick sort: " + total);
      
	   //First block of 160,000.
	   start = System.currentTimeMillis();
	   Sort.selectionSort(arrUnsorted3, 160000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting unsorted 160,000 with selection sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.insertionSort(arrSorted3, 160000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting sorted 160,000 with insertion sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.mergeSort(arrReverse3, 16000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting reverse 160,000 with merge sort: " + total);
	   
	   //Randomizing 160,000 the first time	   
	   for (int i = 0; i < 160000; i++)
	   {
	      arrUnsorted3[i] = random.nextInt(160000);	      
	      arrSorted3[i] = i;
	      arrReverse3[i] = 160000 - i;
	   }
	   
	   //Second block of 160,000.
	   start = System.currentTimeMillis();
	   Sort.selectionSort(arrReverse3, 160000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting reverse 160,000 with selection sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.insertionSort(arrUnsorted3, 160000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting unsorted 160,000 with insertion sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.mergeSort(arrSorted3, 160000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting sorted 160,000 with merge sort: " + total);
	   
	   //Randomizing 160,000 the second time.	   
	   for (int i = 0; i < 160000; i++)
	   {
	      arrUnsorted3[i] = random.nextInt(160000);	      
	      arrSorted3[i] = i;
	      arrReverse3[i] = 160000 - i;
	   }
	   
	   //Third block of 160,000.
	   start = System.currentTimeMillis();
	   Sort.mergeSort(arrUnsorted3, 160000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting unsorted 160,000 with merge sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.insertionSort(arrReverse3, 160000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting reverse 160,000 with insertion sort: " + total);
	   
	   start = System.currentTimeMillis();
	   Sort.selectionSort(arrSorted3, 160000);
	   end = System.currentTimeMillis();
	   total = end - start;
	   System.out.println("Time sorting sorted 160,000 with selection sort: " + total);
	   
	   //Randomizing 160,000 the third time.      
      for (int i = 0; i < 160000; i++)
      {
         arrUnsorted3[i] = random.nextInt(160000);       
         arrSorted3[i] = i;
         arrReverse3[i] = 160000 - i;
      }
      
      //Fourth block of 160,000.
      start = System.currentTimeMillis();
      Sort.quickSort(arrUnsorted3, 0, arrUnsorted3.length - 1);
      end = System.currentTimeMillis();
      total = end - start;
      System.out.println("Time sorting unsorted 160,000 with quick sort: " + total);
      
      start = System.currentTimeMillis();
      Sort.quickSort(arrReverse3, 0, arrReverse3.length - 1);
      end = System.currentTimeMillis();
      total = end - start;
      System.out.println("Time sorting reverse 160,000 with quick sort: " + total);
      
      start = System.currentTimeMillis();
      Sort.quickSort(arrSorted3, 0, arrSorted3.length - 1);
      end = System.currentTimeMillis();
      total = end - start;
      System.out.println("Time sorting sorted 160,000 with quick sort: " + total);
	}
}