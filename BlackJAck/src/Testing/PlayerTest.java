package Testing;

import BlackJack.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void testConstructor() {
        Player player = new Player("testID");

        // Test default values
        assertEquals("testID", player.getUserID());
        assertNotNull(player.getPlayerHand());
        assertEquals(PlayerStatus.WAITING, player.getPlayerStatus());
    }

    @Test
    public void testGettersAndSetters() {
        Player player = new Player("testUserID");
        assertEquals("testUserID", player.getUserID());

        Hand hand = new Hand();
        player.setPlayerHands(hand);
        assertEquals(hand, player.getPlayerHand());

        player.updateStatus(PlayerStatus.DECIDING);
        assertEquals(PlayerStatus.DECIDING, player.getPlayerStatus());

        player.setRoundBalance(100);
        assertEquals(100, player.getRoundBalance());
    }

    @Test
    public void testStand() {
        Player player = new Player("testPlayer");
        player.stand();
        assertEquals(PlayerStatus.STANDING, player.getPlayerStatus());
    }

}
