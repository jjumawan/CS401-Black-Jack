
public class UserAuthentication {
    private String username;
    private String password;
    private UserAuthenticationType type;

    public UserAuthentication(String username, String password, UserAuthenticationType type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(this.username) && enteredPassword.equals(this.password);
    }

    // getters and setters for username and password
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