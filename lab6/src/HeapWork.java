
public class HeapWork
{
   public static <T extends Comparable<? super T>> boolean isHeap (T[] arr, int N)
   {
      for(int i = 0; i < N; i++)
      {
         if(2*i+1 >= N)
         {
            break;
         }
         else if(arr[i].compareTo(arr[2*i+1]) > 0)
         {
            return false;
         }
         
         if(2*i+2 >= N)
         {
            break;
         }
         else if(arr[i].compareTo(arr[2*i+2]) > 0)
         {
            return false;
         }
      }
      return true;
   }
   
   public static <T > void printTree (T[] arr, int N)
   {
      int i = 0, j = 0, tree = 0;
      while(i < N)
      {
         tree = j * 2 + 1;
         while(j < tree)
         {
            if(j >= N)
            {
               System.out.println();
               return;
            }
            System.out.print(arr[j] + " ");
            j++;
            i++;
         }
         System.out.println();        
      }      
   }
}
