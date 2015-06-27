import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Game
{
   public static final int EMPTY = 0;
   public static final int CHEAT = -1;
   public static final int DRAW = 0;   
   public static final int HEARTS = 1;
   public static final int DIAMONDS = 2;
   public static final int CLUBS = 3;
   public static final int SPADES = 4;
   
   public static void main(String[] args)
   {
      //This is all of the setup for the game.
      Deck deck = new Deck();
      LQueue<Card> deckQueue = deck.giveDeck();
      Hand playerHand = new Hand(deckQueue), computerHand = new Hand(deckQueue);       
      ArrayList<Card> pHand = playerHand.giveHand(), cHand = computerHand.giveHand();      
      Card topCard = deckQueue.dequeue(), wildCard;
      Scanner choice = new Scanner(System.in);
      int play, suit, wild;
      Random random = new Random();      
      
      System.out.println("Greetings. Let's play Crazy 8's.");
      System.out.println("______________________________________________________________________________________________");
      
      //This is the loop that goes until the game has been won, lost, or tied.
      while(true)
      {  
         //This is printing stuff to the screen.
         System.out.println("Here's your hand:\n");
         playerHand.showHand();
         
         System.out.println("\nThe top card is a " + topCard.getName());
         System.out.print("\nWhat would you like to do? Select 1 - 8 to play a card, or 0 to draw from the deck. ");
         
         //This loop goes through all of the operations in a single round of play for the player.
         while(true)
         {
            //This loop ensures that a valid integer was inputed for the hand.
            while(true)
            {
               if(!(choice.hasNextInt()))
               {
                  System.out.print("\nThat's not a valid choice. Try again. ");
                  choice.nextLine();
               }
               else
               {
                  play = choice.nextInt();
                  choice.nextLine();
                  if(!(play >= -1 && play <= pHand.size()))
                  {
                     System.out.print("\nThat's not a valid choice. Try again. ");                     
                  }
                  else
                  {
                     break;
                  }
               }
            }            
            
            //This deals with the "cheat" case.
            if(play == CHEAT)
            {
               topCard = pHand.remove(0);
               break;
            }
            
            //This is for when the player wants to draw from the deck.
            if(play == DRAW)
            {
               pHand.add(deckQueue.dequeue());
               break;
            }            
            
            //This block deals with the wildcard case.
            if(pHand.get(play - 1).getNumber().equals("8"))
            {
               System.out.println("\nYou played a Crazy 8. Please pick from the following suits.\n");
               System.out.println("1. Hearts");
               System.out.println("2. Diamonds");
               System.out.println("3. Clubs");
               System.out.println("4. Spades\n");
               System.out.print("What suit would you like? ");       
               
               //This ensures correct input for the wildcard case.
               while(true)
               {
                  if(choice.hasNextInt())
                  {
                     suit = choice.nextInt();
                     choice.nextLine();
                     
                     if(suit != HEARTS && suit != DIAMONDS && suit != CLUBS && suit != SPADES)
                     {
                        System.out.print("\nPlease enter a valid suit. ");
                     }
                     else
                     {
                        break;
                     }
                  }
                  else
                  {
                     System.out.print("\nPlease enter a valid suit. ");                        
                     choice.nextLine();
                  }
               }    
               
               wildCard = pHand.get(play - 1);
               wildCard.setCard(suit);
               pHand.set(play - 1, wildCard);
               topCard = pHand.remove(play - 1);
               break;
            }
            
            if(pHand.get(play - 1).getNumber().equals(topCard.getNumber()) ||
                  pHand.get(play - 1).getSuit().equals(topCard.getSuit()))
            {
               topCard = pHand.remove(play - 1);
               break;                  
            }
            else
            {
               System.out.print("\nThat's not a valid play. Try again. ");               
            }      
         }         
         
         System.out.println("______________________________________________________________________________________________");
         
       //This deals with a tie case.
         if(deckQueue.isEmpty())
         {
            System.out.println("The deck is empty. It is a tie.");
            choice.close();
            return;
         }
         
         //This is if you win.
         if(pHand.size() == EMPTY)
         {
            System.out.println("Congratulations, you've won!");
            choice.close();
            return;
         }      
                  
         System.out.println("The top card is a " + topCard.getName());
         
         //This is everything the computer has to do.
         //This chooses the first valid option.         
         int i = 0, oldSize = cHand.size();
         
         while(i < cHand.size())
         {
            if(cHand.get(i).getNumber().equals("8"))
            {
               wild = random.nextInt(4) + 1;
               wildCard = cHand.get(i);
               wildCard.setCard(wild);
               cHand.set(i, wildCard);
               topCard = cHand.remove(i);
               System.out.print("\nThe computer has played a wild card. The computer now has " + cHand.size() + " cards.");
               break;
            }
            else if(cHand.get(i).getNumber().equals(topCard.getNumber()) ||
                  cHand.get(i).getSuit().equals(topCard.getSuit()))
            {
               topCard = cHand.remove(i);
               System.out.print("\nThe computer has played a card. The computer now has " + cHand.size() + " cards.");
               break;
            }
            i++;            
         }         
         
         //The computer draws if it couldn't play anything.
         if(oldSize == cHand.size())
         {          
               cHand.add(deckQueue.dequeue());
               System.out.print("\nThe computer has drawn a card. The computer now has " + cHand.size() + " cards.");          
         }
         
         System.out.println("\n______________________________________________________________________________________________");
         
         //This is if the computer wins.
         if(cHand.size() == EMPTY)
         {
            System.out.println("The computer won. And it was just guessing too. Wow.");
            choice.close();
            return;            
         }
      }     
   }   
}
