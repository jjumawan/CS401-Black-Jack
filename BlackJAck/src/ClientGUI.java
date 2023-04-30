import javax.swing.*;
import java.awt.*;

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

    public Account accountCommands() {
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
        
        return currAccount;
    }

    // public Player inGame() {

    // }

    private void editFunds() {
        int amount;

        String[] commands = { "Add",
                "Withdraw" };

        int choice = JOptionPane.showOptionDialog(null,
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


    }

    public Player inGame() {
        // create two arrays
        String[] dealer = { "12 Of spades", "Ace of hearts"};
        String[] array2 = {"Red", "Green", "Blue", "Yellow", "Purple", "Orange"};

        // create two JList components to display the arrays
        JList<String> list1 = new JList<>(dealer);
        JList<String> list2 = new JList<>(array2);

        // create two JLabel components to hold the names of the arrays
        JLabel label1 = new JLabel("Dealer:");
        JLabel label2 = new JLabel("Your name:");

        // create a JPanel to hold the JList components and labels
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(label1, c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(new JScrollPane(list1), c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(label2, c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(new JScrollPane(list2), c);

        // add three buttons to the dialog
        Object[] options = {"Hit", "Stand", "Quit"};

        // display the panel and buttons in a JOptionPane message dialog
        int choice = JOptionPane.showOptionDialog(null, panel, "Black Jack",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        // handle the user's choice
        if (choice == 0) {
            System.out.println("User chose Hit");
        } else if (choice == 1) {
            System.out.println("User chose Stand");
        } else if (choice == 2) {
            System.out.println("User chose Quit");
        }

        return currPlayer;
    }

}
