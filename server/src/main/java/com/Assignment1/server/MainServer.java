package com.Assignment1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//This class is used to connect, receive, & send data to the Client
//All information sent or received from the Clients are dealt with here
public class MainServer implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int turnsMade;
	private int maxTurns;
	private boolean finalTurn = false;
	
	static Server[] playerServer;
	static PlayerClass[] players;
	
	
	ServerSocket ss;
	
	int numPlayers;
	static int numConnectionNeeded;
	public static void main( String[] args ) throws Exception {
		System.out.print("How many players are connected? ");
	    Scanner sc = new Scanner(System.in);
	    int numPlayer = sc.nextInt();
		MainServer server = new MainServer(numPlayer);
		server.ConnectToClients();   
		server.gameLoop();
			
	}
	
	public MainServer(int numPlayersToConnect) throws ClassNotFoundException {
		playerServer = new Server[numPlayersToConnect];
		players = new PlayerClass[numPlayersToConnect];
		numPlayers = 0;
		numConnectionNeeded = numPlayersToConnect;
		System.out.println("Server is starting");
		turnsMade = 0;
		for(int i = 0; i < players.length; i++) {
			players[i] = new PlayerClass(" ");
		}
		
		try {
			ss = new ServerSocket(3333);
			
		}catch (IOException e) {
			System.out.println("Connection Failed");
		}
		
	}
	
	public void ConnectToClients() throws ClassNotFoundException{
		try {
			System.out.println("Waitin for " + numConnectionNeeded + " players to connect...");
			while(numPlayers < numConnectionNeeded) {
				
				Socket s = ss.accept();
				numPlayers++;
				
				Server server = new Server (s, numPlayers);
				
				
				server.jOut.writeInt(server.pId);
				server.jOut.flush();
				
				PlayerClass in = (PlayerClass) server.jIn.readObject();
				System.out.println("Player " + server.pId + " ~ " + in.name + " ~ has joined");
				
			
				players[server.pId - 1] = in;
				playerServer[numPlayers - 1] = server;
				
			}
			System.out.println(numConnectionNeeded + " players have joined the game");
			
			for(int i = 0; i < playerServer.length; i++) {
				Thread t = new Thread(playerServer[i]);
				t.start();
				
			}
				
		} catch (IOException ex) {
			System.out.println("Could not connect 3 players");
			System.out.println(ex);
		
		}
		
		
	}
	
	public void gameLoop() {
		int count = 0;
		try {
			for(int i = 0; i < playerServer.length; i++) {
				playerServer[i].sendInt(numPlayers);
				playerServer[i].sendPlayers(players);
			
			}
			
			while(!finalTurn) {
				System.out.println("*****************************************");
				System.out.println("Round number " + turnsMade);
				turnsMade++;
				if(turnsMade == 2) {
				finalTurn = true;
				}
				
			}
			
			
			playerServer[0].sendTurnNo(-1);
			playerServer[1].sendTurnNo(-1);
			
		}catch (Exception e) {
			
		}
	}
	
	
	
	
	
	public class Server implements Runnable{
		private Socket socket;
		private ObjectInputStream jIn;
		private ObjectOutputStream jOut;
		private int pId;
		
		//Scanner scanner = new Scanner(jIn).useDelimiter("\\A");
		
		public Server(Socket s, int id) {
			socket = s;
			pId = id;
			try {
				jOut = new ObjectOutputStream(socket.getOutputStream());
				jIn = new ObjectInputStream(socket.getInputStream());
				
				
			}catch(IOException e){
				System.out.println("Connection Failed!");
				e.printStackTrace();
				
			}
			
		}
		
		public void run() {
			try {
				while(true) {}
		
			}catch (Exception e) {
				System.out.println("Run Failed!");
				e.printStackTrace();
			}
		
		}
		
		
		
		public int[] receiveScores() {
			try {
				int[] sc = new int[15];
				for(int i = 0; i < 15; i++) {
					sc[i] = jIn.readInt();
					
				}
				return sc;
				
			}catch (Exception e) {
				System.out.println("Score sheet not receicved");
				e.printStackTrace();
				
			}
			return null;
			
		}
		
		public String receiveString() {
			try {
				return jIn.readUTF();
				
			}catch(IOException e) {
				System.out.println("Score sheet not received");
				e.printStackTrace();
				
			}
			
			return "";
			
		}
		
		public void sendPlayers(PlayerClass[] pl) {
			System.out.println("Sending players");
			try {
				for (PlayerClass p : pl) {
					jOut.writeObject(p);
					jOut.flush();
				}

			} catch (IOException ex) {
				System.out.println("Score sheet not sent");
				ex.printStackTrace();
			}

		}
		
		public void sendTurnNo(int r) {
			try {
				System.out.println("sending turn number");
				jOut.writeInt(r);
				jOut.flush();
			} catch (Exception e) {
				System.out.println("Score sheet not received");
				e.printStackTrace();
			}
		}
		
		public void sendInt(int r) {
			try {
				jOut.writeInt(r);
				jOut.flush();
			} catch (Exception e) {
				System.out.println("Score sheet not received");
				e.printStackTrace();
			}
		}
		
		
	}
	
}
	

