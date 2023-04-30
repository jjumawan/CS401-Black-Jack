import java.io.*;
import java.net.*;
import java.util.*;

// Client class
public class Client {

    // driver code
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        // Initiate the UI
        Account account = new Account();
        ClientGUI clientGUI = new ClientGUI(account);
        Player player = new Player(account.getUserID());

        // Establish the connection with server
        try (Socket socket = new Socket("localhost", 8000)) {

            System.out.println("Connected to server");

            // Writing to server
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            // Reading from server
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            clientGUI.accountCommands();

            // Get the username and password from GUI
            UserAuthentication userAuthentication = clientGUI.loginCommands();

            System.out.println(userAuthentication.getUsername());

            objectOutputStream.writeUnshared(userAuthentication);
            objectOutputStream.flush();

        }
    }

    public void Albert() {
        System.out.println("");
    }

    public void Parsa9PM(){
        system.out.println("wattup boyz");
    }

    public void flora() {
    }

    public void jjumawan() {
        return ""
    }

    public String getName() {
        return "Thomas";
    }
}