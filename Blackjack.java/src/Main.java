import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // create an instance of AccountPage
        AccountPage accountPage = new AccountPage();
        
        // ask the user to log in
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        // create a UserLogin object with the entered username and password
        UserLogin userLogin = new UserLogin(username, password);
        
        // perform login for the given user
        accountPage.doLogin(userLogin);
        
        // set the current user in the account page
        accountPage.setCurrentUser(userLogin);
        
        // display account options for the current user
        accountPage.accountOptions();
        
        scanner.close();
    }
}