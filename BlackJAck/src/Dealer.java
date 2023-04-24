
public class Dealer {
	
	private Hand dealerHand;
	private boolean stand;
	
	public Dealer() {
		
		dealerHand = new Hand();
		stand = false;
	}
	
	// return the hand of the dealer, contains the set of cards in hand,
	// value and bet amount of the hand
	public Hand getHand() {
		
		return dealerHand;
	}
	
	// add new card to dealer's hand
	// Logic for dealer to hit is in table class
	public void addNewCard(Card newCard) {
		dealerHand.addCardToHand(newCard);
		
	}
	
	// dealer can hit until hand's value is greater than or equal to 17
	// Logic for dealer to hit is in table class
	public void endRound() {
		
		if (dealerHand.getValue() >= 17)
			stand = true;
	}
}
