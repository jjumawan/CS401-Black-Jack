
public class AccountPage {
    private UserLogin currentUser;
    
    public AccountPage() {
        // default constructor
    }
    
    public void accountOptions() {
        // display account options for the current user
    }
    
    public void doLogin(UserLogin userLogin) {
        // perform login for the given user
    }
    
    public void doSignUp(UserLogin userLogin) {
        // perform sign up for the given user
    }
    
    // getters and setters for currentUser
    public UserLogin getCurrentUser() {
        return this.currentUser;
    }
    
    public void setCurrentUser(UserLogin currentUser) {
        this.currentUser = currentUser;
    }
}