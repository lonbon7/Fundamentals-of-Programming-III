
public class RecursionPractice
{
   public static void main(String[] args)
   {
      int arr1[] = {1,4,3,6,5};
      int arr2[] = {-1,2,-3,4,-5};      
      String str1 = "Hello World, I'm a programmer. ";
      String str2 = "Helloollehh";
      String str3 = "Able was I, ere I saw Elba!";
      String str4 = "mommy";
      String str5 = "racecar";
      System.out.println("Expected total of arr1: 17. Total found: " + arrayTotal(arr1,4));
      System.out.println("Expected total of arr2: -3. Total found: " + arrayTotal(arr2,4));
      System.out.println("Expected sum of positive integers in arr1: 19. Sum found: " + arrayPosTotal(arr1, 4));
      System.out.println("Expected sum of positive integers in arr2: 6. Sum found: " + arrayPosTotal(arr2,4));      
      System.out.println("Expected number of spaces in str1: 5. Number of spaces found: " + countSpaces(str1));
      System.out.println("Expected number of spaces in str2: 0. Number of spaces found: " + countSpaces(str2));
      System.out.println("Expected max of arr1: 6. Max found: " + findMax(arr1,0));
      System.out.println("Expected max of arr2: 4. Max found: " + findMax(arr2,0));
      System.out.println("Expected boolean of string " + str3 + ": true Found: " + isPalindrome(str3));
      System.out.println("Expected boolean of string " + str2 + ": false. Found: " + isPalindrome(str2));
      System.out.println("Expected boolean of string " + str4 + ": false. Found: " + isPalindrome(str4));
      System.out.println("Expected boolean of string " + str5 + ": true. Found: " + isPalindrome(str5));
   }
   
   public static int arrayTotal(int[] items, int index)
   {
      if(index == 0)
      {
         return items[0];
      }
      
      return items[index] + arrayTotal(items, index - 1);
   }
   
   public static int arrayPosTotal(int[] items,int index)
   {
      if(index == 0)
      {
         if(items[index] < 0)
         {
            return 0;
         }
         
         return items[0];
      }
      
      while(items[index] < 0)
      {
         index = index -1;
      }
      
      return items[index] + arrayPosTotal(items, index -1);
   }
   
   public static int countSpaces(String sentence)
   {
            
      if(sentence.length() == 0)
      {
         return 0;
      }      
      else if(sentence.charAt(0) == ' ')
      {
         return 1 + countSpaces(sentence.substring(1));
      }
      else
      {
         return countSpaces(sentence.substring(1));
      }          
   }   
   
   public static int findMax(int[] items, int index)
   {
      if(index == items.length -1)
      {
         return items[index];
      }      
      else if(items[index] > findMax(items, index + 1))
      {
         return items[index];
      }
      else
      {         
         return findMax(items, index + 1);
      }      
   }
   
   public static boolean isPalindrome(String sentence)
   {
      System.out.println(sentence);
      
      if(sentence.length() <= 1)
      {
         return true;
      }      
      else if(!(Character.isLetter(sentence.charAt(0))))
      {
         return isPalindrome(sentence.substring(1, sentence.length()));
      }
      else if(!(Character.isLetter(sentence.charAt(sentence.length() - 1))))            
      {
         return isPalindrome(sentence.substring(0, sentence.length() - 1));
      }
      else if(Character.toLowerCase(sentence.charAt(0)) == Character.toLowerCase(sentence.charAt(sentence.length() - 1)))
      {
         return isPalindrome(sentence.substring(1, sentence.length() - 1));         
      }
      else
      {
         return false;
      }      
   }
}
