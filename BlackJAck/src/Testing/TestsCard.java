package Testing;

import BlackJack.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestsCard {
	
	// Parsa's code
	
    @Test
    public void testGettersAndSetters() {
        Card card = new Card();

        // Test default values
        assertEquals(0, card.getRank());
        assertEquals(0, card.getWorth());
        assertEquals(Suit.CLUBS, card.getSuit());

        // Test setting rank and suit using setCard()
        card.setCard(10); // Ten of Diamonds
        assertEquals(10, card.getRank());
        assertEquals(10, card.getWorth());
        assertEquals(Suit.DIAMONDS, card.getSuit());

        // Test setting worth directly using setWorth()
        card.setWorth(5);
        assertEquals(5, card.getWorth());

        // Test toString() method
        assertEquals("Data in card is ->10 DIAMONDS", card.toString());
    }

    @Test
    public void testGetCard() {
        Card card = new Card();
        Card sameCard = card.getCard();
        assertSame(card, sameCard);
    }

}
