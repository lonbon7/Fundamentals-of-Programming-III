import java.util.ArrayList;
import java.util.Random;


public class Deck extends LQueue<Card>
{
   private LQueue<Card> deck = new LQueue<Card>();
   
   public Deck()
   {
      ArrayList<Card> deckList = new ArrayList<Card>();
      
      for(int i = 1; i <=52; i++)
      {
         deckList.add(new Card(i));
      }
      
      shuffle(deckList);
      
      for(int i = 0; i < 52; i++)
      {
         deck.enqueue(deckList.get(i));
      }
   }
   
   private void shuffle(ArrayList<Card> deck)
   {
      ArrayList<Integer> cards = new ArrayList<Integer>();
      Random random = new Random();
      int number;
      
      for(int i = 1; i <= 52; i++)
      {
         cards.add(i);
      }
      
      for(int i = 0; i < 52; i++)
      {
         number = random.nextInt(cards.size());
         deck.set(i, new Card(cards.get(number)));
         cards.remove(number);         
      }      
   }
   
   public LQueue<Card> giveDeck()
   {
      return deck;
   }
}
