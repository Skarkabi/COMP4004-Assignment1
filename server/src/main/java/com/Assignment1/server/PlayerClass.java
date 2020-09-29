package com.Assignment1.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


//This class is used to represent the player
//It keeps track of a players dice, score, & takes care of all player interactions
public class PlayerClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	static Client clientConnection;
	
	private Game game = new Game();
	private PlayerClass[] players = new PlayerClass[3];
	private String name = new String();
	int playerId = 0;
	
	int numP = 0;
	private int score = 0;
	private int[] scoreSheet = new int[7];
	
	 public static void main( String[] args ) throws Exception{
		 Scanner myObj = new Scanner(System.in);
			//System.out.print("What is your name ? ");
			//String name = myObj.next();
			PlayerClass p = new PlayerClass("");
			//p.initializePlayers();
			//p.connectToClient();
			//p.startGame();
			Game g = p.getGame();
			String[] dieRoll = {"Parrot", "Skull", "Skull", "Parrot", "Parrot", "Sword", "Diamond", "Sword"};
			g.setCurrentRoll(dieRoll);
			p.setGame(g);
			System.out.println(p.getGame().getSymbolCount("Skull"));

	

	 }
	 
	 public void connectToClient() {
		clientConnection = new Client();
			
	}

	public void connectToClient(int port) {
		clientConnection = new Client(port);
			
	}
	
	public void initializePlayers() {
		for (int i = 0; i < 3; i++) {
			players[i] = new PlayerClass(" ");
		}
	}
	
	public PlayerClass getPlayer() {
		return this;
	}
	
	public String getName() {return name;}
	
	public void setGame(Game g) {
		game = g;
		
	}
	
	public Game getGame() {
		return game;
	}
	
	public int getScore() {
		score = scoreRound();
		return score;
		
	}
	
	public void startGame() {
		// receive players once for names
		numP = clientConnection.receiveInt();
		players = clientConnection.receivePlayer();
		while (true) {
			int round = clientConnection.receiveRoundNo();
			System.out.println("printing " + players.length);
			if (round == -1)
				break;
			for (int i = 0; i < players.length; i++) {
				System.out.println("Player Name is " + players[i].name);
			}
			
		}
	
	}
	
	
	public String[] playRound(int[] roll) {
		Scanner sc = new Scanner(System.in);
		boolean endTurn = false;
		//int stop = 0;
		
		while(!endTurn) {
			if(game.isDead()) {
				endTurn = true;
			}
			
			System.out.println("Select an action");
			if(!endTurn) {
				System.out.println("(1) Roll All Dice Again");
				System.out.println("(2) Pick Dice To Re-Roll");
				
			}
			System.out.println("(3) Score This Round");
			
			int act = sc.nextInt();
			if(act == 1 && !endTurn) {
				
			}
			
			if(act == 2 && !endTurn) {
				
				
			}
			
			if(act == 3){
				endTurn = true;
				
			}
		}
		
		scoreRound();
		return game.getOutCome(); 
		
	}
	
	public int scoreRound() {
		if(!(game.getSymbolCount("Skull") >= 3)) {
			int[] rCounts = new int[5];
			int[] sCounts = new int[2];
			int sCount = game.getSymbolCount("Sword");
			int mCount = game.getSymbolCount("Monkey");
			int pCount = game.getSymbolCount("Parrot");
			int cCount = game.getSymbolCount("Coin");
			int dCount = game.getSymbolCount("Diamond");
			
			rCounts[0] = sCount;
			rCounts[1] = mCount;
			rCounts[2] = pCount;
			rCounts[3] = cCount;
			rCounts[4] = dCount;
			
			for(int i = 0; i < rCounts.length; i++) {
				if(rCounts[i] == 3) {
					score = score + 100;
					
				}else if(rCounts[i] == 4) {
					score = score + 200;
					
				}else if(rCounts[i] == 5) {
					score = score + 500;
					
				}else if(rCounts[i] == 6) {
					score = score + 1000;
					
				}else if(rCounts[i] == 7) {
					score = score + 2000;
					
				}else if(rCounts[i] == 8) {
					score = score + 4000;
					
				}
				
			}
			
			int cBonus = 100 * cCount;
			int dBonus = 100 * dCount;
			score = score + cBonus + dBonus;
			
		}
		
		return score;
	}
	
	
	
	public class Client{
		Socket socket;
		private ObjectInputStream jIn;
		private ObjectOutputStream jOut;
		
	   
		public Client() {
			try {
				socket = new Socket("localhost", 3333);
				jOut = new ObjectOutputStream(socket.getOutputStream());
				jIn = new ObjectInputStream(socket.getInputStream());

				playerId = jIn.readInt();

				System.out.println(name + " Connected as player " + playerId);
				sendPlayer();

			} catch (IOException ex) {
				System.out.println("Client failed to open");
			}
			
		
		}
		
		public Client(int portId) {
			try {
				socket = new Socket("localhost", portId);
				jOut = new ObjectOutputStream(socket.getOutputStream());
				jIn = new ObjectInputStream(socket.getInputStream());

				playerId = jIn.readInt();

				System.out.println(name + " Connected as player " + playerId);
				sendPlayer();

			} catch (IOException ex) {
				System.out.println("Client failed to open");
			}
		}
		
		
		public void sendPlayer() {
			try {
				jOut.writeObject(getPlayer());
				jOut.flush();
			} catch (IOException ex) {
				System.out.println("Player not sent");
				ex.printStackTrace();
			}
		}
		
		public int receiveRoundNo() {
			try {
				int rt = jIn.readInt();
				System.out.println("Received " + rt);
				return rt;

			} catch (IOException e) {
				System.out.println("Score sheet not received in round");
				e.printStackTrace();
			}
			return 0;
		}
		
		public int receiveInt() {
			try {
				System.out.println("Received int");
				return jIn.readInt();
				

			} catch (IOException e) {
				System.out.println("Score sheet not received int");
				e.printStackTrace();
			}
			return 0;
		}
		
		public PlayerClass[] receivePlayer() {
			PlayerClass[] pl = new PlayerClass[numP];
			PlayerClass p = new PlayerClass(" ");
			try {
				for(int i = 0; i < pl.length; i++) {
					p = (PlayerClass) jIn.readObject();
					pl[i] = p;
				}
				
				System.out.println("Players received:");
				
				return pl;

			} catch (IOException e) {
				System.out.println("Score sheet not received player");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("class not found");
				e.printStackTrace();
			}
			return pl;
		}
		
		/*private PlayerClass[] convertArrayList(ArrayList<PlayerClass> p) {
			PlayerClass[] player = new PlayerClass[p.size()];
			for(int i = 0; i < p.size(); i++) {
				player[i] = p.get(i);
				
			}
			return player;
		}*/
		
	}
	
	public PlayerClass(String n) {
		name = n;
		
	}
	
	
}