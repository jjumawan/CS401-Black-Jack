
public class Account {
    private UserAuthentication userIDPassword;
    private int balance;
    private AccountStatus accountStatus;

    public Account() {
        this.userIDPassword = new UserAuthentication("", "", UserAuthenticationType.UNDEFINED);
        this.balance = 0;
        this.accountStatus = AccountStatus.OFFLINE;
    }

    public boolean login(UserAuthentication user) {
        if (user.getUsername().equals(this.userIDPassword.getUsername())
                && user.getPassword().equals(this.userIDPassword.getPassword())) {
            this.accountStatus = AccountStatus.ONLINE;
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public void signUp(UserAuthentication user) {
        this.userIDPassword = user;
        this.accountStatus = AccountStatus.ONLINE;
        System.out.println("Account created.");
    }

    public void logOut() {
        this.accountStatus = AccountStatus.OFFLINE;
        System.out.println("Logged out.");
    }

    public UserAuthentication getUser() {
        return this.userIDPassword;
    }

    public String getUserID() {
        return this.userIDPassword.getUsername();
    }

    public int getBalance() {
        return this.balance;
    }

    public void addBalance(int amount) {
        this.balance += amount;
        System.out.println(amount + " added to balance. New balance: " + this.balance);
    }

    public void withdrawBalance(int amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient funds.");
        } else {
            this.balance -= amount;
            System.out.println(amount + " withdrawn from balance. New balance: " + this.balance);
        }
    }

    public void updateAccountStatus() {
        if (this.balance < 0) {
            this.accountStatus = AccountStatus.OFFLINE;
            System.out.println("Account status updated to OFFLINE due to negative balance.");
        }
    }

    public AccountStatus getAccountStatus() {
        return this.accountStatus;
    }

    public void setUser(UserAuthentication loginCommands) {
        this.userIDPassword = loginCommands;
    }
}
