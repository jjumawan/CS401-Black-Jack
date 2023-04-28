
public class Table {
	private Deck playingDeck;
	private Player[] playersAtTable; /// chaneg to player later
	private boolean tabeleAvailability;
	private Dealer newDealer; /// make a desaler type
	private int time;
	private boolean endOfRound;
	private int totPlayers;

	public Table() {
		playingDeck = new Deck();
		playersAtTable = new Player[5];
		tabeleAvailability = true;
		newDealer = new Dealer();
		time = 30;
		endOfRound = false;
		totPlayers = 0;

	}

	public boolean eorCheck() {
		for (int i = 0; i < totPlayers; i++) {
			if (playersAtTable[i].getPlayerStatus() != PlayerStatus.STANDING
					|| playersAtTable[i].getPlayerStatus() != PlayerStatus.BUSTED) {
				return false;
			}
		}
		return true;
	}

	public void addPlayer(Player newPlayer) {
		totPlayers = playersAtTable.length;

		if (tabeleAvailability == false) {
			System.out.println("it's full");
			// make a new table
		} else {
			System.out.println("This many spots are opne:" + (5 - totPlayers));
			playersAtTable[totPlayers + 1] = newPlayer;
			if (totPlayers == 5) {
				tabeleAvailability = false;
			}
		}
	}

	// Check if there is a player needs to be removed after each round.
	public void removePlayer(Player playerToRemove) {
		if (totPlayers == 0) {
			System.out.println("No player to remove!");
			return;
		} else {
			for (int i = 0; i < playersAtTable.length; i++) {
				// If the player is busted, remove it from the array by setting their status to
				// EMPTY.
				if (playerToRemove.getUserID() == playersAtTable[i].getUserID()) {
					playersAtTable[i].setPlayerStatus(PlayerStatus.EMPTY);
				}
			}
			tabeleAvailability = true;
		}
	}

	public Player getPlayer(int num) {
		return playersAtTable[num];
	} // return a player

	public Dealer getDealer() {
		return this.newDealer;
	} // return the dealer

	// TODO: Need to redo the timer.
	public void getTimer() {
		System.out.println("Starting a new timer");
		while (time != 0) {
			try {
				Thread.sleep(1000); // update time every 1 second
				time--;
				System.out.println(time);
			} catch (InterruptedException e) {

			}

		}
		time = 30;
	}

	public void countTime() {
	} /// ?????

	public void playRound() {
		if (playingDeck.getCardsLeft() < 52) {
			System.out.println("Not enough cards to play the round!");
			return;
		}

		playingDeck.shuffle();
		// deal cards using a for loop and the getPlayer/dealer

		System.out.println("round has started");
		// while loop that checks if all players are "fishished round"
		while (endOfRound == false) {
			for (int i = 0; i < totPlayers; i++) {
				playersAtTable[i].hit(playingDeck.drawACard());
				playersAtTable[i].hit(playingDeck.drawACard());
			}

			newDealer.addNewCard(playingDeck.drawACard());
			newDealer.addNewCard(playingDeck.drawACard());

			// loop each players acts
			// call the traker bool if true, break

			// updateMoney Accordingly with a loop

			// call continueGame

		}
	}

	// TODO: Need to implement continueGame().
	public void continueGame() {
		// ask the players if the wish to keep plying
		System.out.println("Do you want to keep playing?");
		getTimer();
		// if the player runs out of time or no -> removed
		// if player hits yes -> check for min bet -> if good
	}

	public void updateMoney() {
		int pValue;
		int dValue = newDealer.getHand().getValue();

		for (int i = 0; i < totPlayers; i++) {
			pValue = playersAtTable[i].getPlayerHand().getValue();

			if (pValue > dValue && pValue <= 21) {
				System.out.println("2:3");
				// give the account bet * 1.5
			} else {
				System.out.println("you lost");
				// gose to house
			}
		}

	}

}
