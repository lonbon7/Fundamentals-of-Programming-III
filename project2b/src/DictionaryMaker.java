import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class DictionaryMaker 
{
   public static void main(String[] args) throws FileNotFoundException
   {
      BST<String> tree = new BST<String>();
      File file = new File("C:\\cygwin\\home\\Lonnie Bissmeyer\\school\\cpe103\\project2b\\src\\Essay.txt");
      Scanner scanner = new Scanner(file);
      File output = new File("Words.txt");
      FileOutputStream out = new FileOutputStream(output);
      PrintWriter writer = new PrintWriter(out);
      ArrayList<String> list = new ArrayList<String>();
      int i = 0;
      ArrayList<ArrayList<String>> stringList = new ArrayList<ArrayList<String>>();
      boolean added = false;
      BST<String> duplicateTree = new BST<String>();
      
      //Adds everything from the file to an array list.
      while(scanner.hasNext())
      {
         list.add(scanner.next());
      }
      
      //Takes out all undesired characters in the list.
      for(String s : list)
      {
         list.set(i, s.replaceAll("[\\W]", ""));         
         i++;                 
      }      
      
      //Converts everything to uppercase.
      for(int j = 0; j < list.size(); j++)
      {
         list.set(j, list.get(j).toUpperCase());
      }
      
      //Adds the words to the tree.
      for(String s : list)
      {
         //If not a duplicate, add to the tree.
         if(tree.find(s) == false)
         {
           tree.insert(s);            
         }
         else
         {
            //If my array of arrays is empty, just add the word right to it.
            if(stringList.isEmpty())
            {
               stringList.add(new ArrayList<String>());
               stringList.get(0).add(s);
            }
            else
            {
               for(int k = 0; k < stringList.size(); k++)
               {
                  //This says  to go through to array list and our word equals an
                  //array list's word, add to it.
                  if(s.equals(stringList.get(k).get(0)))
                  {
                     stringList.get(k).add(s);
                     added = true;
                     break;
                  }
               }
               
               //If we didn't find any matching duplicates, make a new array list
               //for the word.
               if(!added)
               {
                  stringList.add(new ArrayList<String>());
                  stringList.get(stringList.size() - 1).add(s);
               }
               added = false;
            }
         }
      }      
      
      //Adding unique words to the file.
      Iterator<String> iterator = tree.getLevelIterator();      
      while(iterator.hasNext())
      {
         writer.write(iterator.next());
         writer.println();
      }
      
      //Adds duplicates to our new tree.
      for(ArrayList<String> s : stringList)
      {
         duplicateTree.insert(s.get(0));
      }
      
      writer.println();
      writer.write("Repeated words:");
      writer.println();      
      Iterator<String> duplicateIter = duplicateTree.getLevelIterator();
      
      int duplicateNum = 0;
      String duplicate = "";
      
      duplicateTree.printLevel();
      while(duplicateIter.hasNext())
      {
         
         duplicate += duplicateIter.next();
         
         System.out.println(duplicate + " ");
         
         writer.write(duplicate + " ");
         writer.println();
         for(int j = 0; j < stringList.size(); j++ )
         {
            if(stringList.get(j).get(0).equals(duplicate))
            {
               duplicateNum = stringList.get(j).size()/tree.size();
               writer.write(duplicateNum);
               writer.println();
               break;
            }
                  
         }
      }
      scanner.close();
      writer.close();
   } 
}
