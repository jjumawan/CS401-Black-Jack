package Testing;

import BlackJack.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class DeckTest {
	
    @Test
    public void testDeckConstructor() {
        Deck deck = new Deck();
        assertEquals(312, deck.getCardsLeft()); // 6 decks 52 cards per deck
    }

    @Test
    public void testShuffle() {
        Deck deck = new Deck();
        Card firstCard = deck.drawACard();

        // Shuffle the deck
        deck.shuffle();

        // Draw another card and ensure it's not the same as the first card
        Card secondCard = deck.drawACard();
        assertNotEquals(firstCard, secondCard);
    }

    @Test
    public void testDrawACard() {
        Deck deck = new Deck();
        int initialCardsLeft = deck.getCardsLeft();

        // Draw a card and ensure the number of cards left has decreased
        Card card = deck.drawACard();
        assertEquals(initialCardsLeft - 1, deck.getCardsLeft());

        // Draw all the cards and ensure the deck is now empty
        for (int i = 1; i < 312; i++) {
            card = deck.drawACard();
        }
        assertEquals(0, deck.getCardsLeft());
    }

}
