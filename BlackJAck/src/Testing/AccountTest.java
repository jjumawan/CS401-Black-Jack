Package Testing;
import BlackJack.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
    @Test
    public void testLogin {
        // Create a new account with a known username and password
        UserAuthentication user = new UserAuthentication("testuser", "testpassword", UserAuthenticationType.UNDEFINED);
        Account account = new Account(user, 100, AccountStatus.OFFLINE);

        // Test logging in with correct username and password
        assertTrue(account.login(user));
        assertEquals(AccountStatus.ONLINE, account.getAccountStatus());

        // Test logging in with incorrect username or password
        UserAuthentication invalidUser = new UserAuthentication("invalid", "password", UserAuthenticationType.UNDEFINED);
        assertFalse(account.login(invalidUser));
        assertEquals(AccountStatus.OFFLINE, account.getAccountStatus());
    }

    @Test
    public void testSignUp() {
        // Create a new account with no username or password
        Account account = new Account();

        // Sign up with a new user
        UserAuthentication user = new UserAuthentication("newuser", "newpassword", UserAuthenticationType.UNDEFINED);
        account.signUp(user);

        // Test that the account is now online and has the correct user ID
        assertEquals(user, account.getUser());
        assertEquals(AccountStatus.ONLINE, account.getAccountStatus());
        assertEquals(user.getUsername(), account.getUserID());
    }

    @Test
    public void testBalance() {
        // Create a new account with a balance of 100
        Account account = new Account();
        account.setBalance(100);

        // Test adding and withdrawing from the balance
        account.addBalance(50);
        assertEquals(150, account.getBalance());
        account.withdrawBalance(75);
        assertEquals(75, account.getBalance());
        account.withdrawBalance(100);
        assertEquals(75, account.getBalance()); // Should not allow withdrawing more than balance
    }

    @Test
    public void testAccountStatus() {
        // Create a new account with a balance of -50
        Account account = new Account();
        account.setBalance(-50);

        // Test that the account status is updated to OFFLINE
        account.updateAccountStatus();
        assertEquals(AccountStatus.OFFLINE, account.getAccountStatus());

        // Test that the account status remains OFFLINE when balance is positive
        account.addBalance(100);
        account.updateAccountStatus();
        assertEquals(AccountStatus.OFFLINE, account.getAccountStatus());

        // Test that the account status is set back to ONLINE when balance is positive
        account.setAccountStatus(AccountStatus.ONLINE);
        account.setBalance(-25);
        account.updateAccountStatus();
        assertEquals(AccountStatus.ONLINE, account.getAccountStatus());
    }
}