import java.util.*;

public class Sort
{
   public static <Type extends Comparable<? super Type>> void selectionSort(Type[] arr, int size)
   {
	   for(int i = 0; i < arr.length-1; i++)
	   {
	      for(int j = i + 1; j < arr.length; j++)
	      {
            if(arr[i].compareTo(arr[j]) > 0)
            {
                //... Exchange elements
                Type temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
     }
   }
   
   public static <Type extends Comparable<? super Type>> void insertionSort(Type[] arr, int size)
   {
      int i, j;
      Type newValue;

      for (i = 1; i < arr.length; i++)
      {
         newValue = arr[i];
         j = i;

         while (j > 0 && arr[j - 1].compareTo(newValue) > 0)
         {
            arr[j] = arr[j - 1];
            j--;
         }
         arr[j] = newValue;
      }
   }

   
   public static <Type extends Comparable<? super Type>> void mergeSort(Type[] arr, int size)
   {
      if (arr.length > 1)
      {
         int q = arr.length/2;
         Type[] l = Arrays.copyOfRange(arr, 0, q);
         Type[] r = Arrays.copyOfRange(arr,q,arr.length);

         mergeSort(l, l.length);
         mergeSort(r, r.length);

         int totElem = l.length + r.length;
         
         int i, li, ri;
         i = li = ri = 0;
         
        while ( i < totElem)
        {
           if((li < l.length) && (ri < r.length))
           {
              if (l[li].compareTo(r[ri]) < 0)
              {
                 arr[i] = l[li];
                 i++;
                 li++;
              }
              else
              {
                 arr[i] = r[ri];
                 i++;
                 ri++;
              }
            }
            else
            {
               if(li >= l.length)
               {
                  while(ri < r.length)
                  {
                     arr[i] = r[ri];
                     i++;
                     ri++;
                  }
                }
                if(ri >= r.length)
                {
                   while(li < l.length)
                   {
                      arr[i] = l[li];
                      li++;
                      i++;
                   }
                }
            }
        }
     }
  }
   
  public static <Type extends Comparable<? super Type>> void quickSort(Type[] arr, int left, int right)
  {
     int index = partition(arr, left, right);
     
     if(left < index - 1)
     {
        quickSort(arr, left, index - 1);
     }
     if(index < right)
     {
        quickSort(arr, index, right);
     }    
  }
  
  private static <Type extends Comparable<? super Type>> int partition(Type[] arr, int left, int right)
  {
     int i = left, j = right;
     Type tmp;
     Type pivot = arr[(left + right) / 2];
       
     while(i <= j)
     {        
        while(arr[i].compareTo(pivot) < 0)
        {
           i++;
        }
           
        while(arr[j].compareTo(pivot) > 0)
        {           
           j--;          
        }
        
        if(i <= j)
        {
           tmp = arr[i];
           arr[i] = arr[j];
           arr[j] = tmp;
           i++;
           j--;
        }
     }
     
     return i;
  }
}