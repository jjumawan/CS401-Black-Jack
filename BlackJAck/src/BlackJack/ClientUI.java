package BlackJack;
public interface ClientUI {

    public UserAuthentication loginCommands();

    public Account accountCommands(Account account);

    public Table inGame(Player player, Table table);

}
