import java.io.*;
import java.net.*;

// Server class
class Server {

	public static void main(String[] args) {
		ServerSocket server = null;

		try {

			// server is listening on port 1234
			server = new ServerSocket(8000);
			server.setReuseAddress(true);
			House house = new House();
		

			// try (BufferedReader br = new BufferedReader(new FileReader("Playerlist.txt"))) {
			// 	String line;
			// 	while ((line = br.readLine()) != null) {
			// 		String username = line;
			// 		String password = br.readLine();
			// 		// Do something with the username and password, e.g. print them out
			// 		System.out.println("Username: " + username);
			// 		System.out.println("Password: " + password);
			// 	}
			// } catch (IOException e) {
			// 	System.out.println("input output error");
			// }

			// System.out.println("Print AccountList");
			// for (int i = 0; i < accountNum; i++) {
			// 	System.out.print(i + " ");
			// 	System.out.println(accountList[i].getBalance());
			// }


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

System.out.println("About to create a thread");

				// This thread will handle the client
				// separately
				new Thread(clientSock).start();
				System.out.println("Something happens here");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ClientHandler class
	private static class ClientHandler implements Runnable {
		private final Socket clientSocket;
		private boolean logged = false;
		int accountListSize;
		Account[] accountList;
		int accountNum;
		int numInAccountList;

		// Constructor
		public ClientHandler(Socket socket) {

			System.out.println("ClientHandler constructor");

			this.clientSocket = socket;

			accountListSize = 100; // accountList length/size
			accountList = new Account[accountListSize];
			accountNum = 0; // number of accounts in acount list
			numInAccountList = 0; // this thread/account's index in 

			// this.accountNum = accountNum;
			// for (int i = 0; i < accountNum; i++) {
			// 	this.accountList[i] = accountList[i];
			// }
			// numInAccountList = 0;

						// MADE A READER
			
			// read the content
			try (BufferedReader br = new BufferedReader(new FileReader("Playerlist.txt"))) {
				String line = br.readLine();

				while (line != null) {

					
					
					// file line is read as
					// userID:userPassword, balance, accountStatus
					String[] accountDetails = line.split(",");
					String[] userDetails = accountDetails[0].split(":");

					UserAuthentication tempUser = new UserAuthentication(userDetails[0], userDetails[1], UserAuthenticationType.UNDEFINED);
					
					System.out.println(userDetails[0]);
					System.out.println(userDetails[1]);

					Account newAccount = new Account(tempUser, Integer.parseInt(accountDetails[1]), AccountStatus.OFFLINE);

					System.out.println(accountDetails[1]);

					accountList[accountNum] = newAccount;
					
					System.out.println("accountList[accountNum Balance " + accountList[accountNum].getBalance());

					accountNum++;

					

					// breaks out of while loop if accountNum is 100, or reached accountList size
					if (accountNum <= accountListSize) break;

					line = br.readLine();
					
				}
				
			} catch (FileNotFoundException e) {
				System.out.println("file not found");
				// Exception handling
			} catch (IOException e) {
				System.out.println("input output error");
				// Exception handling
			}
		}

		public void run() {

			try {

				System.out.println("get output");
				// Output stream socket & Create object output stream from the output stream to
				// send an object through it
				OutputStream outputStream = clientSocket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

				// get the input stream from the connected socket & create a ObjectInputStream
				// so we can read data from it.
				InputStream inputStream = clientSocket.getInputStream();
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

				System.out.println("get intput");

				Account account = new Account(); // change
				Player player = null;
				Dealer dealer = null;
				UserAuthentication userAuthentication = null;

				System.out.println("Server: Entering the loop");

				// read in the account class
				while ((userAuthentication = (UserAuthentication) objectInputStream.readObject()) != null) {

					System.out.println(userAuthentication.getUsername());
					if (userAuthentication.getType() == UserAuthenticationType.LOGIN_REQUEST) {
						// TODO: Loop through the account list and check if the username and password
						// already exist
						System.out.println("LOGIN_REQ");
						System.out.println(numInAccountList);
						System.out.println(accountNum);
						while (numInAccountList < accountNum && !logged) {

							System.out.println(numInAccountList);

							// loop the account array
							if (userAuthentication.authenticate(accountList[numInAccountList].getUser())) {

								// account = accountlist[i];
								userAuthentication.setType(UserAuthenticationType.LOGGED_IN);

								objectOutputStream.writeUnshared(userAuthentication);
								objectOutputStream.flush();
								// write to account based on accountList
								objectOutputStream.writeUnshared(account);
								objectOutputStream.flush();
								logged = true;
							}
							numInAccountList++;
						}
						break;

					} else if (userAuthentication.getType() == UserAuthenticationType.SIGNUP) {
						// check it to a list with a for loop
						// if it's uA == um form list
						// try {
						// 	FileOutputStream fos = new FileOutputStream("Playerlist.txt", true);
						// 	String data = userAuthentication.getUsername() + "," + userAuthentication.getPassword()
						// 			+ "\n";
						// 	fos.write(data.getBytes());
						// 	fos.close();
						// } catch (IOException e) {
						// 	System.out.println("output to file error");
						// }
						userAuthentication.setType(UserAuthenticationType.NAME_TAKEN);
						objectOutputStream.writeUnshared(userAuthentication);
					}
					else {
						// returns it as undefine
						objectOutputStream.writeUnshared(userAuthentication);
					}

				}

				// check the log in
				// buf.login(buf.getUser());
				// if worked pass a log in /set logged to true
				// if nnot break (repeat the loop)

				account = (Account) objectInputStream.readObject();
				// do stuff

				// home page actions play, edit funds, exit
				// play needs network
				// edit can be done localy on the clint
				// exit can send a good by and kill tread

			}

			catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
			}
		}
	}
}