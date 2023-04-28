
public class Card {
	private int rank;
	private int worth;
	private Suit suit;
	
	public Card() {
		this.rank = 0;
		this.worth = 0;
		this.suit = Suit.CLUBS;
		// place holder
		//setCard(rank, suit);
		
	}
	
	// should this method make the attribute immutable?, so setCard is private?
	public void setCard(int num) {
		
		this.rank = (num%13) + 1;
		
		if(this.rank == 11 || this.rank == 12 || this.rank == 13) {
			this.worth = 10;
		}else
			this.worth = this.rank;
			
		
		switch ((num / 13) % 4) {
	    case 0:
	    	this.suit  = Suit.DIAMONDS;
	        // code to execute if expression is equal to value1
	        break;
	    case 1:
	    	this.suit  = Suit.HEARTS;
	        // code to execute if expression is equal to value2
	        break;
	        
	    case 2:
	    	this.suit  = Suit.SPADES;
	    	break;
	    default:
	    	this.suit  = Suit.CLUBS;
	        // code to execute if none of the cases match the expression
	}

	}
	
	public Card getCard() {
		return this;
	}
	
	public int getRank(){
		return this.rank;
	}
	
	public int getWorth() {
		return this.worth;
	} 
	
	public void setWorth(int newWorth) {
		this.worth = newWorth;
	}
	public Suit getSuit() {
		return this.suit;
	}
	
	public String toString() {
		return ("Data in card is ->" + this.rank + " " + this.suit);
	}

}
