package Testing;

import BlackJack.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class HandTest {
	
	// Parsa's code
	
	  @Test
	  public void testGetValue() {
	    Hand hand = new Hand();
	    Card card1 = new Card();
	    Card card2 = new Card();
	    card1.setCard(1);
	    card2.setCard(10);
	    
//	    card1.setCard(0);
//	    card2.setCard(9);
	    
	    
	    hand.addCardToHand(card1);
	    hand.addCardToHand(card2);
	    assertEquals(21, hand.getValue());
	  }

	  @Test
	  public void testSetBet() {
	    Hand hand = new Hand();
	    hand.setBet(10);
	    assertEquals(10, hand.getBet());
	  }

	  @Test
	  public void testGetNumCards() {
	    Hand hand = new Hand();
	    assertEquals(0, hand.getNumCards());
	    Card card1 = new Card();
	    card1.setCard(1);
	    hand.addCardToHand(card1);
	    assertEquals(1, hand.getNumCards());
	  }

}
