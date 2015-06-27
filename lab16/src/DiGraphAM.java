 
public class DiGraphAM
{
   private int[][] adjTable;
   
   public DiGraphAM(int vertices)
   {
      adjTable = new int[vertices][vertices];
   }
   
   public void addEdge(int start, int end)
   {
      adjTable[start][end]++;      
   }
   
   public void deleteEdge(int start, int end)
   {
      adjTable[start][end]--;
   }
   
   public int edgeCount()
   {
      int count = 0;
      
      for(int i = 0; i < adjTable.length; i++)
      {
         for(int j = 0; j < adjTable.length; j++)
         {
            count += adjTable[i][j];
         }
      }
      
      return count;
   }
   
   public int vertexCount()
   {
      return adjTable.length;
   }
   
   public void print()
   {
      for(int i = 0; i < adjTable.length; i++)
      {
         System.out.print(i + " is connected to: ");
         for(int j = 0; j < adjTable.length; j++)
         {
            if(adjTable[i][j] > 0)
            {
               System.out.print(j + " ");               
            }
         }
         System.out.println();
      }
   }
   
   private int[] indegrees()
   {
      int[] array = new int[adjTable.length];
      
      for(int j = 0; j < adjTable.length; j++)
      {
         for(int i = 0; i < adjTable.length; i++)
         {
            array[j] += adjTable[i][j];
         }
      }      
      
      return array;      
   }
   
   public int[] topSort()
   {
      LQueue<Integer> queue = new LQueue<Integer>();
      int[] indegrees = indegrees();
      int[] sorted = new int[indegrees.length];
      int sortedSize = 0, zeroDegree;
      
      //Go until my array is full of sorted vertices.
      while(sortedSize < indegrees.length - 1)
      {
         //Find all zero indegrees. Enqueue and add to sorted array.
         for(int i = 0; i < indegrees.length; i++)
         {
            if(indegrees[i] == 0)
            {
               //"i" is the vertex since "i" counts the vertex in indegrees.
               sorted[sortedSize] = i;
               sortedSize++;
               queue.enqueue(i);
            }            
         }
         
         //Dequeue one and clear the row of indegrees.
         zeroDegree = queue.dequeue();
         for(int j = 0; j < adjTable.length; j++)
         {
            adjTable[zeroDegree][j] = 0;
         }
         indegrees = indegrees();
      }
      
      return sorted;
   }
}
