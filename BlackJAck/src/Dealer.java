
public class Dealer {
	
	private Hand dealerHand;
	private int dealerHandNum;
	private Card[] hiddenCards;
	private int hiddenCardsNum;
	private boolean stand;
	
	public Dealer() {
		dealerHand = new Hand(0);
		Card[] hiddenCards = new Card[10];
		
		dealerHandNum = 0;
		hiddenCardsNum = 0;
		
		stand = false;
	}

//	public Hand geHand() {
//		Hand tempHand = new Hand();
//		
//		System.arraycopy(hiddenCards, 0, tempCards, 0, hiddenCardNum);
//		
//		return tempHand;
//		
//	}
	
	public Card[] getHiddenCard() {
		
		Card[] tempCards = new Card[hiddenCards.length];
		
		System.arraycopy(hiddenCards, 0, tempCards, 0, hiddenCardsNum);
		
		return tempCards;
		
	}
	
//	public Card getCard() {
//		
//	}
	
	public void endRound() {
		stand = true;
	}
}
