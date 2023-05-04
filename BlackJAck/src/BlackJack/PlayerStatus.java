package BlackJack;

public enum PlayerStatus {
    // when a player first joins the game, they are deciding (making a bet);
    // also, when they are making decisions they are deciding.
    DECIDING,
    STANDING,
    WAITING,
    BUSTED,
    EMPTY, // when a player is removed, the status is set to EMPTY
}
