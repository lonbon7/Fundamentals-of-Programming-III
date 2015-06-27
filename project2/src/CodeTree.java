import java.util.Scanner;

/**
 * @author Lonnie Bissmeyer
 * @version 5/11/13
 * 
 * This is class is the driver for the morse code lab.
 */
public class CodeTree
{
   private static BinaryTree<String> tree;
   private static String[] table = {".-", "-...", "-.-.", "-..", ".", "..-.",
      "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
      "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};   
   
   /**
    * The main function for the program.
    * @param args any command-line arguments.
    */
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      String answer = "", sentence = "";
      
      createBinaryTree();
      testCases();
      
      System.out.println("(p) print pre-order traversal of binary tree");
      System.out.println("(d) decode Morse to English");
      System.out.println("(e) encode English to Morse");
      System.out.println("(q) quit");
      
      while(true)
      {
         answer = scanner.next();
         
         if(answer.equals("p"))
         {
            System.out.println(CodeTree.tree.traverse());
            scanner.nextLine();
         }
         else if(answer.equals("d"))
         {
            System.out.println("What would you like to decode?");
            scanner.nextLine();
            sentence = scanner.next();
            System.out.println(decode(sentence));
            scanner.nextLine();
         }
         else if(answer.equals("e"))
         {
            System.out.println("What would you like to encode?");
            scanner.nextLine();
            sentence = scanner.next();
            System.out.println(encode(sentence));
            scanner.nextLine();
         }
         else if(answer.equals("q"))
         {
            scanner.close();
            return;
         }
         else
         {
            System.out.println("Incorrect input. Try again.");
            scanner.nextLine();
         }
      }
   }
   
   /**
    * Decodes a String of morse code.
    * @param morseText  the String of morse code to decode.
    * @return the English String from the morse code String.
    */
   public static String decode(String morseText)
   {
      String sentence = "", spaces = "";
      
      //Handles spaces in the beginning of the string.
      while(morseText.charAt(0) == ' ')
      {
         morseText = morseText.substring(1);
      }
         
      while(morseText.length() > 0)
      {
         if(morseText.charAt(0) == '.')
         {
            CodeTree.tree.move(Relative.LEFT_CHILD);
            morseText = morseText.substring(1);
         }
         else if(morseText.charAt(0) == '-')
         {
            CodeTree.tree.move(Relative.RIGHT_CHILD);
            morseText = morseText.substring(1);
         }
         else if(morseText.charAt(0) == ' ')
         {
            sentence += CodeTree.tree.retrieve();
            CodeTree.tree.move(Relative.ROOT);
            morseText = morseText.substring(1);
            
            //Spaces now holds all of the extra spaces.
            while(morseText.charAt(0) == ' ')
            {
               spaces += morseText.charAt(0);
               morseText = morseText.substring(1);
               
               //This is if we're at the end of the word with extra spaces.
               if(morseText.length() == 0)
               {
                  return sentence;
               }
            }
            
            //If we're not at the end, all of the extra spaces get put onto sentence.
            for(int i = 0; i < spaces.length(); i++)
            {
               sentence += spaces.charAt(0);
               spaces.substring(1);
            }
            spaces = "";
         }
         else//This is for invalid characters.
         {
            morseText = morseText.substring(1);
         }
      }
      sentence += CodeTree.tree.retrieve();
      return sentence;    
   }
   
   /**
    * Encodes an English String to morse code.
    * @param sentence the English String to encode.
    * @return the encoded English String in morse code.
    */
   public static String encode(String sentence)
   {
      String code = "";  
      
      while(sentence.length() > 0)
      {
         if(sentence.charAt(0) == ' ')
         {
            code += sentence.charAt(0);
            sentence = sentence.substring(1);            
         }
         else if(Character.isUpperCase(sentence.charAt(0)))
         {
            code += CodeTree.table[sentence.charAt(0) - 'A'];
            code += ' ';
            sentence = sentence.substring(1);            
         }
         else if(Character.isLowerCase(sentence.charAt(0)))
         {
            code += CodeTree.table[sentence.charAt(0) - 'a'];
            code += ' ';
            sentence = sentence.substring(1);            
         }
         else
         {
            sentence = sentence.substring(1);            
         }
      }
      
      return code;
   }
   
   /**
    * Creates a binary tree for use in decoding. Contains the alphabet.
    */
   public static void createBinaryTree()
   {
      CodeTree.tree = new BinaryTree<String>();
      CodeTree.tree.insert("", Relative.ROOT);      
      CodeTree.tree.insert("E", Relative.LEFT_CHILD);      
      CodeTree.tree.insert("I", Relative.LEFT_CHILD);      
      CodeTree.tree.insert("S", Relative.LEFT_CHILD);     
      CodeTree.tree.insert("H", Relative.LEFT_CHILD);      
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: S. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.insert("V", Relative.RIGHT_CHILD);      
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: S. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: I. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.insert("U", Relative.RIGHT_CHILD);      
      CodeTree.tree.insert("F", Relative.LEFT_CHILD);      
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: U. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: I. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: E. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.insert("A", Relative.RIGHT_CHILD);      
      CodeTree.tree.insert("R", Relative.LEFT_CHILD);      
      CodeTree.tree.insert("L", Relative.LEFT_CHILD);      
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: R. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: A. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.insert("W", Relative.RIGHT_CHILD);     
      CodeTree.tree.insert("P", Relative.LEFT_CHILD);      
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: W. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.insert("J", Relative.RIGHT_CHILD);     
      CodeTree.tree.move(Relative.ROOT);      
      CodeTree.tree.insert("T", Relative.RIGHT_CHILD);     
      CodeTree.tree.insert("N", Relative.LEFT_CHILD);      
      CodeTree.tree.insert("D", Relative.LEFT_CHILD);     
      CodeTree.tree.insert("B", Relative.LEFT_CHILD);     
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: D. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.insert("X", Relative.RIGHT_CHILD);     
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: D. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: N. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.insert("K", Relative.RIGHT_CHILD);      
      CodeTree.tree.insert("C", Relative.LEFT_CHILD);    
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: K. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.insert("Y", Relative.RIGHT_CHILD);     
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: K. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: N. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: T. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.insert("M", Relative.RIGHT_CHILD);     
      CodeTree.tree.insert("G", Relative.LEFT_CHILD);      
      CodeTree.tree.insert("Z", Relative.LEFT_CHILD);      
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: G. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.insert("Q", Relative.RIGHT_CHILD);      
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: G. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.move(Relative.PARENT);
      System.out.println("Expected current after move to parent: M. Found: " + CodeTree.tree.retrieve());
      CodeTree.tree.insert("O", Relative.RIGHT_CHILD);      
      CodeTree.tree.move(Relative.ROOT);     
   }
   
   /**
    * The test cases to be run for the program.
    */
   public static void testCases()
   {
      String in1 = "Hello   ";
      String expected1 = ".... . .-.. .-.. ---   ";
      
      String in2 = " 1 1 1 Hsh";
      String expected2 = "    .... ... ....";
      
      String in3 = "   7#4f kdfe";
      String expected3 = "   ..-.  -.- -.. ..-. .";
      
      String in4 = "Hello world!";
      String expected4 = ".... . .-.. .-.. ---  .-- --- .-. .-.. -..";
      
      String in5 = "thi s is  s test";
      String expected5 = "- .... ..  ...  .. ...   ...  - . ... - ";
      
      String in6 = "... ..- .--. . .-. -- .- -.";//Superman
      String expected6 = "SUPERMAN";
      
      String in7 = ".... . .-.. .-.. ---  .-- --- .-. .-.. -..";//Hello world
      String expected7 = "HELLO WORLD";
      
      String in8 = "- ....  ..  ..!aaa .  .-  - . ..b. -  ";//this is a test
      String expected8 = "TH I IE A TEST";
      
      String in9 = "   -- --- .-. ... .    -.-. --- -.. .    ";//morsecode
      String expected9 = "MORSE   CODE";
      
      String in10 = "   -... .- - -- .- -.";//Batman
      String expected10 = "BATMAN";
      
      String in11 = "w";
      String expected11 = ".--";
      
      String in12 = ".--";
      String expected12 = "w";
      
      System.out.println("\nTesting string: " + in1);
      String out1 = CodeTree.encode(in1);
      System.out.println("Expected output: " + expected1);
      System.out.println("          Found: " + out1);      
      
      System.out.println("\nTesting string: " + in2);
      String out2 = CodeTree.encode(in2);
      System.out.println("Expected output: " + expected2);
      System.out.println("          Found: " + out2 + "\n");
      
      System.out.println("\nTesting string: " + in3);
      String out3 = CodeTree.encode(in3);
      System.out.println("Expected output: " + expected3);
      System.out.println("          Found: " + out3 + "\n");
      
      System.out.println("\nTesting string: " + in4);
      String out4 = CodeTree.encode(in4);
      System.out.println("Expected output: " + expected4);
      System.out.println("          Found: " + out4 + "\n");
      
      System.out.println("\nTesting string: " + in5);
      String out5 = CodeTree.encode(in5);
      System.out.println("Expected output: " + expected5);
      System.out.println("          Found: " + out5 + "\n");
      
      System.out.println("\nTesting string: " + in6);
      String out6 = CodeTree.decode(in6);
      System.out.println("Expected output: " + expected6);
      System.out.println("          Found: " + out6 + "\n");
      
      System.out.println("\nTesting string: " + in7);
      String out7 = CodeTree.decode(in7);
      System.out.println("Expected output: " + expected7);
      System.out.println("          Found: " + out7 + "\n");
      
      System.out.println("\nTesting string: " + in8);
      String out8 = CodeTree.decode(in8);
      System.out.println("Expected output: " + expected8);
      System.out.println("          Found: " + out8 + "\n");
      
      System.out.println("\nTesting string: " + in9);
      String out9 = CodeTree.decode(in9);
      System.out.println("Expected output: " + expected9);
      System.out.println("          Found: " + out9 + "\n");
      
      System.out.println("\nTesting string: " + in10);
      String out10 = CodeTree.decode(in10);
      System.out.println("Expected output: " + expected10);
      System.out.println("          Found: " + out10 + "\n");
      
      System.out.println("\nTesting string: " + in11);
      String out11 = CodeTree.encode(in11);
      System.out.println("Expected output: " + expected11);
      System.out.println("          Found: " + out11 + "\n");
      
      System.out.println("\nTesting string: " + in12);
      String out12 = CodeTree.decode(in12);
      System.out.println("Expected output: " + expected12);
      System.out.println("          Found: " + out12 + "\n");
      
   }  
}
