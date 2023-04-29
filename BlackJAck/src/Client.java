import java.io.*;
import java.net.*;
import java.util.*;

// Client class
class Client {
	
	// driver code
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException
	{
        ClientUI Ainterface;
        Account  line = new Account();      
        Player    x = new Player(line.getUserID());  
		// establish a connection by providing host and port
		// number
		try (Socket socket = new Socket("localhost", 8000)) {
			
           
	        
			// Output stream socket & Create object output stream from the output stream to send an object through it
	        OutputStream outputStream = socket.getOutputStream();
	        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

			// reading from server
			InputStream inputStream = socket.getInputStream();
		    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

			// object of scanner class
		    System.out.println("give me a line:");
			Scanner sc = new Scanner(System.in);
			
            
             //open the gui for log in
             //get info with 
             sc.nextLine();

             //log in button -> to send clint  rgw dummy account *can use the status as a flag of what they can and cant do 
             objectOutputStream.writeUnshared(line);
		       objectOutputStream.flush();

            //read back the account
            line = (Account) objectInputStream.readObject();

            //check the a satus 
            //if online, go pt.2 enter a new loop 
            

             /* 
			while (line.getType() != "LOGOUT") {
				
				// reading from user
				line.setText(sc.nextLine());

				// sending the user input to server
		       objectOutputStream.writeUnshared(line);
		       objectOutputStream.flush();

				// displaying server reply
		       
		       line = (Message) objectInputStream.readObject();
		       if(line.getStatus() != Status.Pendeing) {
				System.out.println("Server replied: " + line.toString());
		       }else if(line.getStatus().equals(Status.Success)){
		    	   System.out.println("\nEnter text you'd like to be caped:");
		    	   break;
		       }else
		    	   System.out.println("\nEnter text");
				
				*/
			
			// closing the scanner object
			sc.close();
		}
	
	}
}