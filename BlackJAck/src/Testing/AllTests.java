package Testing;

//public class AllTests {
//
//}


import BlackJack.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({
	TestsCard.class, HandTest.class, DeckTest.class, DealerTest.class, PlayerTest.class, TableTest.class, AccountTest.class
})
public class AllTests {
}
