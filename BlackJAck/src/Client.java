import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JOptionPane;

// Client class
public class Client {

    // driver code
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        // Initiate the UI
        Account account = new Account();
        ClientGUI clientGUI = new ClientGUI(account);
        Dealer dealer = new Dealer();
        Player player = new Player(account.getUserID());

        // Establish the connection with server
        try (Socket socket = new Socket("localhost", 8000)) {

            System.out.println("Connected to server");

            // Writing to server
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            // Reading from server
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            // Get user authentication information (username and password) from GUI
            System.out.println("Getting user authentication information");
            UserAuthentication userAuthentication = clientGUI.loginCommands();
            System.out.println(userAuthentication.getUsername());

            // Send user authentication information to server to check if the user is valid
            objectOutputStream.writeUnshared(userAuthentication);
            // objectOutputStream.flush();

            System.out.println("Sent to server");

            // Listen to server's response to see if the authentication information is valid
            while ((userAuthentication = (UserAuthentication) objectInputStream.readObject()) != null) {
                // Check if the authentication information is valid
                if (userAuthentication.getType() == UserAuthenticationType.LOGGED_IN) {
                    System.out.println("Client: User " + userAuthentication.getUsername() + " is valid!");
                    // If the authentication information is valid, get the account information from
                    // the server
                    account = (Account) objectInputStream.readObject();
                    account.setAccountStatus(AccountStatus.ONLINE);
                    System.out.println("User " + userAuthentication.getUsername() + " logged in");
                    // Break the loop and go to the home page
                    break;
                }
                //
                else if (userAuthentication.getType() == UserAuthenticationType.NAME_TAKEN) {
                    System.out.println("Name Taken");
                }

                userAuthentication = clientGUI.loginCommands();
                objectOutputStream.writeUnshared(userAuthentication);
            }

            // print out the account information
            System.out.println(account.getUserID());
            System.out.println(account.getBalance());

            // Home page

            // Pop up the home page and pass the account information (username,
            // password, and balance) from GUI
            account = clientGUI.accountCommands(account);
            System.out.println(account.getAccountAction());
            // Send the account information to the server
            objectOutputStream.writeUnshared(account);

            objectOutputStream.flush();
            account = (Account) objectInputStream.readObject();

            // Listen to the server's response (see if the server has received the account
            // and stored it successfully)
            System.out.println("Entering the account part");

            while (account.getAccountAction() != AccountAction.LOG_OUT) {
                if (account.getAccountAction() == AccountAction.UPDATE_BALANCE) {
                    account = clientGUI.accountCommands(account);
                } else if (account.getAccountAction() == AccountAction.PLAY_GAME) {
                    // If the user clicks the play button, break the loop and start the game
                    break;
                } else if (account.getAccountAction() == AccountAction.LOG_OUT) {
                    // If the user clicks the logout button, break the loop and logout
                    account = clientGUI.accountCommands(account);

                    // userAuthentication = clientGUI.loginCommands();
                    break;
                }
                // // Otherwise, keep popping up the home page
                // account = clientGUI.accountCommands(account);
                // Send the account information to the server
                objectOutputStream.writeUnshared(account);
                // objectOutputStream.flush();
            }

            System.out.println("Listening to the user's actions on the home page...");

            Table roundTable = new Table();
            roundTable.addPlayer(player);
            roundTable.playRound();

            String bet = JOptionPane.showInputDialog(null, "Enter a bet:");
            // Check if the user has enough money to bet
            while (Integer.parseInt(bet) > account.getBalance()) {
                // Display user's balance
                bet = JOptionPane.showInputDialog(null, "You have $" + account.getBalance()
                        + " in your account. You don't have enough money to bet! Enter a lower bet:");
                break;
            }

            roundTable.getPlayer(0).getPlayerHand().setBet(Integer.parseInt(bet));

            while (roundTable.getEOR() != true) {
                clientGUI.inGame(player, roundTable);
            }
            account = clientGUI.accountCommands(account);
        }
    }
}