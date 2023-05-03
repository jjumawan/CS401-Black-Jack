package BlackJack;

public class AccountPage {
    private UserAuthentication currentUser;

    public AccountPage() {
        // default constructor
    }

    public void accountOptions() {
        // display account options for the current user
    }

    public void doLogin(UserAuthentication UserAuthentication) {
        // perform login for the given user
    }

    public void doSignUp(UserAuthentication UserAuthentication) {
        // perform sign up for the given user
    }

    // getters and setters for currentUser
    public UserAuthentication getCurrentUser() {
        return this.currentUser;
    }

    public void setCurrentUser(UserAuthentication currentUser) {
        this.currentUser = currentUser;
    }
}