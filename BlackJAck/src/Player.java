import java.util.ArrayList;

public class Player {
    private enum PlayerStatus {
        DECIDING,
        STANDING,
        WAITING,
        FINISHEDROUND,
        BUSTED,
        SURRENDERD
    }

    private String userID;
    private Hand hand;
    private ArrayList<Hand> playerHands;
    private int numOfHands;
    private PlayerStatus playerStatus;
    // The player's current balance when they join the game (must be passed in as a
    // parameter by Account object, and the Account object must check and update the
    // balance after each round)
    private int roundBalance;

    // Constructor
    public Player(String userID) {
        this.userID = userID;
        this.playerHands = new ArrayList<Hand>();
        this.numOfHands = playerHands.size();
        // Initialize player status to DECIDING because player is making a decision
        // (make a bet)
        this.playerStatus = PlayerStatus.DECIDING;
    }

    // Getters
    public String getUserID() {
        return this.userID;
    }

    public ArrayList<Hand> getPlayerHands() {
        return this.playerHands;
    }

    public int getNumOfHands() {
        return numOfHands;
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
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPlayerHands(ArrayList<Hand> playerHands) {
        this.playerHands = playerHands;
    }

    public void setNumOfHands(int numOfHands) {
        this.numOfHands = numOfHands;
    }

    public void updateStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    // roundBalance should be passed in as a parameter by Account class
    public void setBalance(int currentAccountBalance) {
        this.roundBalance = currentAccountBalance;
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
            this.playerHands.get(this.numOfHands - 1).setBet(betAmount);
            // Update balance
            this.roundBalance -= betAmount;
            // Update player status to WAITING
            this.playerStatus = PlayerStatus.WAITING;
        }
    }

    public void hit() {
        // Add card to hand
        this.playerHands.get(0).updateCards();

        // Check if hand is busted
        if (this.playerHands.get(0).getValue() > 21) {
            this.playerStatus = PlayerStatus.BUSTED;
            // TODO: Display this message in the GUI
            System.out.println("You are busted.");
        } else {
            // If not busted, add a card to the hand.
            this.playerHands.get(0).addCard();

            // Update player status to WAITING
            this.playerStatus = PlayerStatus.WAITING;
        }
    }

    public void stand() {
        // Update player status to STANDING
        this.playerStatus = PlayerStatus.STANDING;
    }

    public void surrender() {
        // Update player status to SURRENDERD
        this.playerStatus = PlayerStatus.SURRENDERD;
    }

}
