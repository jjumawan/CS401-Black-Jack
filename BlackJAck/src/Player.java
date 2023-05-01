import java.io.Serializable;

public class Player implements Serializable {
    private String userID;
    private Hand playerHand;
    private PlayerStatus playerStatus;
    // The player's current balance when they join the game (must be passed in as a
    // parameter by Account object, and the Account object must check and update the
    // balance after each round)
    private int roundBalance;

    // Constructor
    public Player(final String userID) {
        this.userID = userID; // userID: passed in from the Account class
        this.playerHand = new Hand();
        // Initialize player status to WAITING because player is making a decision
        // (make a bet)
        this.playerStatus = PlayerStatus.WAITING;
    }

    // Getters
    public String getUserID() {
        return this.userID;
    }

    public Hand getPlayerHand() {
        return this.playerHand;
    }

    public PlayerStatus getPlayerStatus() {
        return this.playerStatus;
    }

    // Return the update balance after each round.
    // This method should be called by the Account object after each round.
    public int getRoundBalance() {
        return this.roundBalance;
    }

    // Setters
    public void setPlayerHands(Hand playerHand) {
        this.playerHand = playerHand;
    }

    public void updateStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    // roundBalance should be passed in as a parameter by Account class
    public void setRoundBalance(int currentAccountBalance) {
        this.roundBalance = currentAccountBalance;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    // Methods
    public void makeBet(int betAmount) {
        // Check if the player has enough balance in their account to make bet
        if (betAmount > roundBalance) {
            // If not, ask player to make a smaller bet
            // TODO: Display these messages in the GUI
            System.out.println("You do not have enough balance to make this bet.");
            System.out.println("Please make a smaller bet.");
        } else {
            // Make bet (Always make bet on the latest hand (top of the stack)).
            this.playerHand.setBet(betAmount);
            // Update balance
            this.roundBalance -= betAmount;
            // Update player status to WAITING
            this.playerStatus = PlayerStatus.WAITING;
        }
    }

    // Get a new card from the table (table gets a new card from the deck)
    public void hit(Card newCard) {

        this.playerHand.addCardToHand(newCard);

        // Check if hand is busted
        if (this.playerHand.getValue() > 21) {
            this.playerStatus = PlayerStatus.BUSTED;
            // TODO: Display this message in the GUI
            System.out.println("You are busted.");
        }
    }

    public void stand() {
        // Update player status to STANDING
        this.playerStatus = PlayerStatus.STANDING;
    }

}
