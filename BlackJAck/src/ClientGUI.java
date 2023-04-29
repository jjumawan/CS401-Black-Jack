import javax.swing.*;

public class ClientGUI implements ClientUI {
    private Account currAccount = new Account();
    private Player currPlayer = new Player(currAccount.getUserID());

    public ClientGUI(Account account) {
        currAccount = account;
    }

    public UserAuthentication loginCommands() {
        String[] options = { "Log in", "Create Account", "Exit" };
        int choice;
        do {
            choice = JOptionPane.showOptionDialog(null,
                    "Pick an option", "Portal page",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == 0) {
                return doLogin();
            } else if (choice == 1) {
                return doCreateAccount();
            } else {
                System.exit(0);
            }
        } while (choice != options.length - 1);
        System.exit(0);
        return null;
    }

    private UserAuthentication doLogin() {
        String username = JOptionPane.showInputDialog(null, "Enter your username:");
        String password = JOptionPane.showInputDialog(null, "Enter your password:");
        UserAuthentication userAuthentication = new UserAuthentication(username, password,
                UserAuthenticationType.LOGIN);
        return userAuthentication;
    }

    public UserAuthentication doCreateAccount() {
        String username = JOptionPane.showInputDialog(null, "Enter a username:");
        String password = JOptionPane.showInputDialog(null, "Enter a password:");
        UserAuthentication userAuthentication = new UserAuthentication(username, password,
                UserAuthenticationType.SINGUP);
        return userAuthentication;
    }

    public void accountCommands() {
        String[] commands = { "Start Game",
                "Log Out",
                "Edit Balance" };

        int choice;

        do {
            choice = JOptionPane.showOptionDialog(null,
                    currAccount.getUserID() + "\nSelect a command",
                    "Home Page",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    commands,
                    commands[commands.length - 1]);

            switch (choice) {
                case 0:
                    // inGame();
                    break;
                case 1:
                    currAccount.logOut();
                    currAccount.setUser(loginCommands());
                    break;
                case 2:
                    editFunds();
                    break;
                default: // do nothing
            }

        } while (choice != commands.length - 1);
    }

    // public Player inGame() {

    // }

    private void editFunds() {
        int amount;

        String[] commands = { "Add",
                "Withdraw" };

        int choice;

        do {
            choice = JOptionPane.showOptionDialog(null,
                    currAccount.getUserID() + "\nSelect a command",
                    "Update Balance",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    commands,
                    commands[commands.length - 1]);

            switch (choice) {
                case 0:
                    amount = Integer.parseInt(JOptionPane.showInputDialog("Enter amount"));
                    currAccount.addBalance(amount);
                    break;
                case 1:
                    amount = Integer.parseInt(JOptionPane.showInputDialog("Enter amount"));
                    currAccount.withdrawBalance(amount);
                    break;
                default: // do nothing
            }

        } while (choice != commands.length - 1);
    }

    public Player inGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inGame'");
    }

}
