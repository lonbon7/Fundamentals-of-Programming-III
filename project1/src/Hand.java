import java.util.ArrayList;


public class Hand
{
   private ArrayList<Card> hand = new ArrayList<Card>();
   
   public Hand(LQueue<Card> deck)
   {
      for(int i = 0; i < 8; i++)
      {
         hand.add(deck.dequeue());
      }
   }
   
   public void showHand()
   {
      for(int i = 0; i < hand.size(); i++)
      {
         System.out.println(i + 1 + ".  " + hand.get(i).getName());
      }
   }
   
   public Card playCard(int card)
   {
      return hand.remove(card -1);
   }
   
   public ArrayList<Card> giveHand()
   {
      return hand;
   }
}
