
public class Hand {
	
	// attributes
	private final int maxCards = 15;
	private Card[] cards;
	private int numCards;
	private int value;
	private int bet;
	
	
	public Hand(int bet) {
		// initialize cards to have 15? indexes, to cover for the unlikely number of cards
		cards = new Card[maxCards];
		numCards = 0;
		value = 0;
		setBet(bet);
	}
	
	public Hand(int newBet, Card[] newCard, int newNumCards, int newVal) {
		// initialize cards to have 15? indexes, to cover for the unlikely number of cards
		
		cards = new Card[maxCards];
		numCards = newNumCards;
		
		for (int i = 0; i < newNumCards; i++) {
			cards[i] = newCard[i];
		}
		
		
		value = newVal;
		setBet(newBet);
	}

	// TODO: consider this the split hand helper, since it would be easier to
	// modify this hand/cards instead of writing a public updateCards method
	
	// recommend moving splitHand() to player class
	// player class can call for another instance of hand with same bet and one card value
	// and modify the original hand's cards.
//	public Hand SplitHand(Card[] oldCards, int oldBet) {
//		// check if there are two cards of the same value
//		
//		// if yes
//		Hand secondHand = new Hand();
//	}
	

	// return all the cards' value in the hand
	public Card[] getCards() {
		
		Card[] tempCards = new Card[cards.length];
		
		System.arraycopy(cards, 0, tempCards, 0, numCards);
		
		return tempCards;
		
	}
	
	public int getValue() {
		
		int handValue = 0;
		
		for (int i = 0; i < numCards; i++) {
			
			// handles face cards, value 10
			if (cards[i].getRank() > 9)
				handValue += 10;
			
			// general cases, values 2-9
			if (cards[i].getRank() > 1 && cards[i].getRank() < 10 )
				handValue += cards[i].getRank();
			
			// handles ace, value 1 or 11
			if (handValue + 11 > 21) {
				handValue += 1;
			}
			else {
				handValue += 11;
			}
			
		}
		
		return handValue;
		
	}
	
	public void setBet(int bet) {
		this.bet = bet;
	}
	
	public int getBet() {
		return bet;
	}
	
	public int getNumCards() {
		return numCards;
	}
	
	public void addCardToHand(Card newCard) {
		
		cards[numCards++] = newCard;

	}
	
}