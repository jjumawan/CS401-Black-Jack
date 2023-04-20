
public class Hand {
	private Card[] handOfCards = new Card[10];
	private int numOfCards;
	private int vaule;
	private int bet;
	
	public Hand() {
		this.numOfCards = 0;
		this.vaule = 0;
		this.bet = 0;
	}
	
	//public Hand SplitHand();
	
	public Card DrawCard(Card x) {
		handOfCards[numOfCards] = new Card();
		handOfCards[numOfCards] = x;
		numOfCards++;
		
		return handOfCards[numOfCards - 1];
	}
	
	public int getValue() {
		this.setValue();
		return this.vaule;
	}
	
	public void setValue() {
		int ace = 0;
		for(int i = 0; i < numOfCards; i++)
		{
			if(handOfCards[i].getRank() == ace) {    //Logic is still broken 
				
				this.vaule = 11 + this.vaule;
				if(this.vaule < 21) {
					handOfCards[i].setRank(11);
				}
				else {
					handOfCards[i].setRank(1);
					}
				
			}else
				this.vaule = handOfCards[i].getRank() + this.vaule; 
		}
	}
	
	public void setBet (int newBet) {
		this.bet = newBet;
	}
	
	public int getBet(){
		return this.bet;
	}
	public int getNumCards() {
		return this.numOfCards;
	}
	
	public void printHand() {
		for(int i = 0; i< numOfCards; i++) {
			System.out.println(handOfCards[i].toString());
		}
	}
}
