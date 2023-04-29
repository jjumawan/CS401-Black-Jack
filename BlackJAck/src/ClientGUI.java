import javax.swing.*;

public class ClientGUI implements ClientUI {
    private Account tempA = new Account();
    private Player tempP = new Player(tempA.getUserID());

    public ClientGUI(Account curr) {
        tempA = curr;
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
        // if (tempA.getUserMap().containsKey(username)) {
        // if (user.authenticate(username, password)) {
        // JOptionPane.showMessageDialog(null, "Login successful!");
        // accountCommands();
        // } else {
        // JOptionPane.showMessageDialog(null, "Incorrect username or password. Please
        // try again.");
        // doLogin();
        // }
        // } else {
        // JOptionPane.showMessageDialog(null, "Username not found. Please create an
        // account.");
        // doCreateAccount();
        // }
    }

    public UserAuthentication doCreateAccount() {
        String username = JOptionPane.showInputDialog(null, "Enter a username:");
        String password = JOptionPane.showInputDialog(null, "Enter a password:");
        UserAuthentication userAuthentication = new UserAuthentication(username, password,
                UserAuthenticationType.SINGUP);
        return userAuthentication;
        // if (tempA.getUserMap().containsKey(username)) {
        // JOptionPane.showMessageDialog(null, "Username already exists. Please choose a
        // different one.");
        // doCreateAccount();
        // } else {
        // tempA.getUserMap().put(username, password);
        // JOptionPane.showMessageDialog(null, "Account created successfully!");
        // accountCommands();
        // }
    }

    public void accountCommands() {
        // TODO: Implement accountCommands method
    }

    public void inGame() {
        // TODO: Implement inGame method
    }
}