package com.Assignment1.server;

import java.awt.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//This class is used to connect, receive, & send data to the Client
//All information sent or received from the Clients are dealt with here
public class MainServer implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int turnsMade;
	private int maxTurns;
	private boolean finalTurn = false;
	PlayerClass winningPlayer = new PlayerClass("");
	static String[] fortuneCards = new String[35];
	int cardsTaken = 0;
	
	Server[] playerServer;
	PlayerClass[] players;
	
	
	ServerSocket ss;
	
	Game game = new Game();
	int numPlayers;
	static int numConnectionNeeded;
	
	public static void setFortuneCards() {
		for (int i = 0; i < 5; i++) {
			fortuneCards[i] = "TC";
		}
		
		for (int i = 5; i < 10; i++) {
			fortuneCards[i] = "CA";
		}
		
		for (int i = 10; i < 15; i++) {
			fortuneCards[i] = "SO";
		}
		
		for (int i = 15; i < 20; i++) {
			fortuneCards[i] = "CO";
		}
		
		for (int i = 20; i < 25; i++) {
			fortuneCards[i] = "DI";
		}
		
		for (int i = 25; i < 30; i++) {
			fortuneCards[i] = "MB";
		}
		
		fortuneCards[30] = "SB2300";
		fortuneCards[31] = "SB3500";
		fortuneCards[32] = "SB41000";
		fortuneCards[33] = "SK2";
		fortuneCards[34] = "SK1";
		
		fortuneCards = Randomize(fortuneCards);
		
	}
	
	public static String[] Randomize(String[] arr) {
	    String[] randomizedArray = new String[arr.length];
	    System.arraycopy(arr, 0, randomizedArray, 0, arr.length);
	    Random rgen = new Random();

	    for (int i = 0; i < randomizedArray.length; i++) {
	        int randPos = rgen.nextInt(randomizedArray.length);
	        String tmp = randomizedArray[i];
	        randomizedArray[i] = randomizedArray[randPos];
	        randomizedArray[randPos] = tmp;
	    }

	    return randomizedArray;
	}
	
	public static void main( String[] args ) throws Exception {
		setFortuneCards();
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
		System.out.println("Server is starting");
		numPlayers = 0;
		numConnectionNeeded = numPlayersToConnect;
		turnsMade = 0;
		maxTurns = 3;
		
		for(int i = 0; i < players.length; i++) {
			players[i] = new PlayerClass("");
			
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
				System.out.println("Player " + server.pId + " ~ " + in.getName() + " ~ has joined");
				
			
				players[server.pId - 1] = in;
				playerServer[numPlayers - 1] = server;
				
			}
			System.out.println(numPlayers + " players have joined the game");
			
			for(int i = 0; i < playerServer.length; i++) {
				Thread t = new Thread(playerServer[i]);
				t.start();
				
			}
				
		} catch (IOException ex) {
			System.out.println("Could not connect 3 players");
		
		}
		
		
	}
	
	public void gameLoop() {
		int topScore = 0;
		boolean lastMove = false;
		try {
			for(int i = 0; i < playerServer.length; i++) {
				playerServer[i].sendPlayers(players);
				
				System.out.println("Sent to " + i);
				playerServer[i].receiveConfirmation();
				
			}
			
			
			while(!finalTurn) {
				turnsMade++;
				
				if(lastMove) {
					finalTurn = true;
				}
				
				System.out.println("*****************************************");
				System.out.println("Round number " + turnsMade);
				for(int i = 0; i < playerServer.length; i++) {
					
					playerServer[i].sendFortuneCard();
					cardsTaken++;
					playerServer[i].sendTurnNo(turnsMade);
					playerServer[i].sendPlayers(players);
					
					System.out.println("player is " + players.length);
					System.out.println("Server is " + playerServer.length);
					players[i].setScore(playerServer[i].receiveScores()[i]);
					
					System.out.println("Player 1 completed turn and their score is " + players[i].getScoreBeforeCalulating());
					
					playerServer[i].receiveConfirmation();
					
				}
				for(int i = 0; i < players.length; i++) {
					if(topScore < players[i].getScoreBeforeCalulating()) {
						topScore = players[i].getScoreBeforeCalulating();
						winningPlayer = players[i];
						
					}
					if(players[i].getScoreBeforeCalulating() >= 6000) {
						lastMove = true;
					}
				}
				
			
			
			}
			
			System.out.println("The Winner is " + winningPlayer.getName() + " With a score of " + winningPlayer.getScoreBeforeCalulating());
			
			for(int i = 0; i < players.length; i++) {
				players[i].setScore(players[i].getScoreBeforeCalulating());
				
				//playerServer[i].sendTurnNo(turnsMade);
				
				playerServer[i].sendScores(players);
				
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
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
				while(true) {
				}
		
			}catch (Exception e) {
				{
					System.out.println("Run Failed!");
					e.printStackTrace();
				}
			
			}
		
		}
		
		public void sendPlayers(PlayerClass[] pl) {
			System.out.println("Sending players");
			try {
				for(PlayerClass p : pl) {
					System.out.println(p.getName() + " of " + p.getClass());
					jOut.writeObject(p);
					jOut.flush();
					
				}
				

			} catch (IOException ex) {
				System.out.println("Players not sent");
				ex.printStackTrace();
			}

		}
		
		public void sendFortuneCard() {
			try {
				jOut.writeUTF(fortuneCards[cardsTaken]);
				jOut.flush();
				
			}catch (IOException ex) {
				System.out.println("Players not sent");
				ex.printStackTrace();
			}
		}
		
		public void sendTurnNo(int r) {
			try {
				System.out.println("sending turn number");
				jOut.writeInt(r);
				jOut.flush();
			} catch (Exception e) {
				System.out.println("turn number not sent");
				e.printStackTrace();
			}
		}
		
		
		public boolean receiveConfirmation() {
			try {
				return jIn.readBoolean();
			}catch (Exception e) {
				System.out.println(e);
			}
			
			return false;
		}
		
		public int[] receiveScores() {
			try {
				int[] sc = new int [1];
				for(int i = 0; i < 1; i++) {
					sc[i] = jIn.readInt();
				}
				
					return sc;
				
				
			}catch (Exception e) {
				System.out.println("Score sheet not receicved");
				e.printStackTrace();
				
			}
			return null;
			
		}
		
		public void sendScores(PlayerClass[] pl) {
			try {
				for(int i = 0; i < pl.length; i++) {
					jOut.writeInt(pl[i].getScoreBeforeCalulating());
				}
				jOut.flush();
			}catch (Exception e) {
				System.out.println("Score not sent");
				e.printStackTrace();
			}
		}
		
	}
	
}
	

