package Testing;

import java.beans.Transient;

import BlackJack.*;

public class TableTest {
    Table TestTable = new Table();

    @Test
    public void TableTester(){
        Table newTable = new Table();

        assertNotNull(newTable);
    }

    @Test 
    public void restTest(){
        Player one = new Player("ted");
        TestTable.addPlayer(one);

        assertTrue(TestTable.getPlayer(0).equals("ted"));
        TestTable.reset();

        assertNotNull(TestTable);
    }

    @Test
    public void deckDeckTest(){
        assertNotNull(TestTable.getDeck());
    }

    @Test 
    public void setEORTest(){
        assertTrue(TestTable.getEOR() == false);
        TestTable.setEOR(true);
        assertTrue(TestTable.getEOR() == true);
    }

    @Test
    public void getEORTest(){
        Table table = new Table();
        boolean expect = false;
        boolean actual = table.getEOR();
        assertsEquals(expected, actual);
    }

    @Test
    public void eorCheckTest(){
        assertFalse(TestTable.eorCheck());
    }

    @Test
    public void addTest(){
        Table table = new Table();
        Player player = new Player("Jievy");
        table.addPlayer(player1);

        assertsEquals(1, table.getNumberOfPlayers());
        assertsEquals(player1, table.getPlayersAtTable()[0]);
        
    }

    @Test
    public void removeTest(){
        Player two = new Player("T");
        TestTable.addPlayer(two);
        
        assertSame(TestTable.getPlayer(0));
        TestTable.removePlayer(0);

        assertFalse(TestTable.getPlayer(0).equals(two));
    }

    
}
