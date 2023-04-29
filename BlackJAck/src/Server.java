import java.io.*;
import java.net.*;

// Server class
class Server {
	
	
	public static void main(String[] args)
	{
		ServerSocket server = null;

		try {

			// server is listening on port 1234
			server = new ServerSocket(8000);
			server.setReuseAddress(true);
			House Vult = new House();
			System.out.println("Listening........");

			// running infinite loop for getting
			// client request
			System.out.println("Start of loop");
			while (true) {
				// socket object to receive incoming client
				// requests
				Socket client = server.accept();

				// Displaying that new client is connected
				// to server
				System.out.println("New client connected: "
								+ client.getInetAddress()
										.getHostAddress());

				// create a new thread object
				ClientHandler clientSock = new ClientHandler(client);

				// This thread will handle the client
				// separately
				new Thread(clientSock).start();
				System.out.println("Something happens here");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (server != null) {
				try {
					server.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ClientHandler class
	private static class ClientHandler implements Runnable {
		private final Socket clientSocket;
		private boolean loged = false;

		// Constructor
		public ClientHandler(Socket socket)
		{
			this.clientSocket = socket;
		}

		public void run()
		{
			
			try {
					
				System.out.println("get output");
				// Output stream socket & Create object output stream from the output stream to send an object through it
		        OutputStream outputStream = clientSocket.getOutputStream();
		        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
				
				
				// get the input stream from the connected socket & create a ObjectInputStream so we can read data from it.
		        InputStream inputStream = clientSocket.getInputStream();
		        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		        		
				System.out.println("get intput");
				
		
				Account buf = null;
				
				//read in the account class
				//while ((buf = (Account) objectInputStream.readObject()) != null) 
				
				//check the log in
				//buf.login(buf.getUser());
				//if worked pass a log in /set logged to true 
				//if nnot break (repeat the loop)

				//home page actions play, edit funds, exit 
				//play needs network 
				//edit can be done localy on the clint 
				//exit can send a good by and kill tread 


				
			}
			
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
			}
		}
	}
}