
public class UserLogin {
    private String username;
    private String password;
    
    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(this.username) && enteredPassword.equals(this.password);
    }
    
    // getters and setters
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}