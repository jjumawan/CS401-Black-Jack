public interface ClientUI {

    public UserAuthentication loginCommands();

    public Account accountCommands(Account account);

    public Player inGame(Player player, Dealer dealer);

}
