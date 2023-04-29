import javax.swing.JOptionPane;

public class HomePage {
	
	private Account anAccount;
	
	public HomePage(Account newAccount) {
		anAccount = newAccount;
	}
	
	public void HomePageOptions(int userChoice) {
		
		int choice = userChoice;
	 
		switch (choice) {
			case 0: startGame(); break;
			case 1: exitGame(); break;
			case 2: editFunds(); break;
			default:  // do nothing
		}
		
	}
	
	public String doGetUserID() {
		return anAccount.getUserID();
	}
	
	private void startGame() {
		// TODO: to start Game Play
	}
	
	private void exitGame() {
		anAccount.logOut();
	}
	
	private void editFunds() {
		// TODO: after implementing startGame and exitGame
	}
	
	public void displayBalance() {
		// request to add a getBalance() to Account class
	}

}
