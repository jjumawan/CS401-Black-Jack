import java.util.Random;

public class Deck {
	private Card[] deckOfCards = new Card[312]; // once the array, deck of cards, is created
	// pass to a queue, so a card can be easily popped. There is a count, cardsLeft
	// track the number of remaining cards
	private int cardsLeft;
	private Random random = new Random();
	
	public Deck () {
		
		this.cardsLeft = 312;
		
		// generate 6 decks of cards
		for(int i =0; i < deckOfCards.length; i++)
		{
			deckOfCards[i] = new Card();
			deckOfCards[i].setCard(i);
			if(i%52 == 0)
			{
				System.out.println("--------------------------");	
			}
			System.out.println(deckOfCards[i].toString());
		}
	
		
	}
	
	public int getCardsLeft() {
		return cardsLeft;
	}
	
	public void shuffle() {
		for (int i = cardsLeft - 1; i > 0; i--) {
		    int index = random.nextInt(i + 1);
		    Card temp = deckOfCards[index];
		    deckOfCards[index] = deckOfCards[i];
		    deckOfCards[i] = temp;
		}
	}
	
	// return a Card, and update the deck of card list
	public Card drawACard() {
		
		// placeholder value
		Card tempCard = new Card();
		tempCard = deckOfCards[312 - cardsLeft];
		cardsLeft = cardsLeft - 1;
		
		return tempCard;
	}
}
