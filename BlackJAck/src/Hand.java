public class Hand {

	// attributes

	// initialize cards to have 15 indexes, to cover for the unlikely number of
	// cards
	private final int maxCards = 15;
	private Card[] cards;
	private int numCards;
	private int value;
	private int bet;

	// an empty hand is created with a player/dealer object
	public Hand() {
		cards = new Card[maxCards];
		numCards = 0;
		value = 0;
		bet = 0;

	}

	// TODO: consider this the split hand helper, since it would be easier to
	// modify this hand/cards instead of writing a public updateCards method

	// recommend moving splitHand() to player class
	// player class can call for another instance of hand with same bet and one card
	// value
	// and modify the original hand's cards.
	// public Hand SplitHand(Card[] oldCards, int oldBet) {
	// // check if there are two cards of the same value
	//
	// // if yes
	// Hand secondHand = new Hand();
	// }

	// return all the cards' value (rank and suit) in the hand
	public Card[] getCards() {

		return this.cards;
	}

	// return the total value of the hand
	public int getValue() {

		value = 0;

		// re-calculate value of the hand

		for (int i = 0; i < numCards; i++) {

			// handles face cards, value 10
			if (cards[i].getRank() > 9)
				value += 10;

			// general cases, values 2-9
			else if (cards[i].getRank() > 1 && cards[i].getRank() < 10)
				value += cards[i].getRank();

			// handles ace, value 1 or 11
			else {
				if (value + 11 > 21) {
					value += 1;
				} else {
					value += 11;
				}
			}

		}

		return value;
	}

	// update the bet of the hand
	public void setBet(int bet) {

		this.bet = bet;
	}

	// return the bet amount for the hand
	public int getBet() {

		return bet;
	}

	// get the number of cards in the hand
	public int getNumCards() {

		return numCards;
	}

	// to add a new card to the hand of player/dealer
	public void addCardToHand(Card newCard) {

		cards[numCards++] = newCard;
	}

}