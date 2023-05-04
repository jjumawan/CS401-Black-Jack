package Testing;

import BlackJack.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class DealerTest {
	
	@Test
	public void testConstructor() {
		
		Dealer tempDealer = new Dealer();
		
		assertTrue(tempDealer != null);
		
	}
	
	@Test
	public void testGetHand() {
		
		Dealer tempDealer = new Dealer();
		Card tempCard = new Card();
		
		tempDealer.addNewCard(tempCard);
		
		
        assertEquals(0, tempDealer.getHand().getCards()[0].getRank());
        assertEquals(0, tempDealer.getHand().getCards()[0].getWorth());
        assertEquals(Suit.CLUBS, tempDealer.getHand().getCards()[0].getSuit());
		
	}
	
	@Test
	public void testAddNewCard() {
		
		Dealer tempDealer = new Dealer();
		Card tempCard = new Card();
		
		tempDealer.addNewCard(tempCard);
		
		
        assertEquals(0, tempDealer.getHand().getCards()[0].getRank());
        assertEquals(0, tempDealer.getHand().getCards()[0].getWorth());
        assertEquals(Suit.CLUBS, tempDealer.getHand().getCards()[0].getSuit());
		
	}
	
	@Test
	public void testEndRound() {
		
		Dealer tempDealer = new Dealer();

		// endRound = false because isStand = false
		assertTrue(tempDealer.getIsStand() == false);
		
		
		Card tempCard1 = new Card();
		tempCard1.setCard(7); // worth 8
		tempDealer.addNewCard(tempCard1);
		
		Card tempCard2 = new Card();
		tempCard2.setCard(12); // worth 10
		tempDealer.addNewCard(tempCard2);
		
		tempDealer.endRound();
		
		// total worth is 18
		// endRound = true because isStand = true
		assertTrue(tempDealer.getIsStand() == true);
		
	}
	
	@Test
	public void testIsStand() {
		
		Dealer tempDealer = new Dealer();
		
		// isStand is false
		assertTrue(tempDealer.getIsStand() == false);
		
		
		Card tempCard1 = new Card();
		tempCard1.setCard(7); // worth 8
		tempDealer.addNewCard(tempCard1);
		
		Card tempCard2 = new Card();
		tempCard2.setCard(12); // worth 10
		tempDealer.addNewCard(tempCard2);
		
		tempDealer.endRound();
		// total worth is 18
		// isStand = true
		assertTrue(tempDealer.getIsStand() == true);
		
	}

}
