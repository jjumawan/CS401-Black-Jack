import javax.swing.*
;
public class ClientGUI implements ClientUI {

    private Account tempA = new Account();
    private Player tempP = new Player(tempA.getUserID());


    public ClientGUI(Account curr){
        tempA = curr;
    }
   
    public void loginCommands() {
        String[] options = {"Log in", "Create Account", "Exit"};

        int choice;

        		 
		 do {
            choice = JOptionPane.showOptionDialog(null, 
                    "Pick an opption", "Portal page",
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.PLAIN_MESSAGE, 
                    null, 
                    options,
                    options[0]);
        
           if(choice == 0){
            doLogin();
        }else if (choice == 1){
            doCreateAccount();
        }else{
            System.exit(0);
    }

            
        } while (choice != options.length-1);
        System.exit(0);
    }

    private void doLogin(){
        tempA.signUp(null);
    }
   
    private void doCreateAccount() {}
    
    public void accountCommands() {
        
    }

    public void inGame() {
      
    }

    
    
}
