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
	private int tempScore = 0;
	private int diceUsed = 0;
	private int deductionToSend = 0;
	private int deductionReceived = 0;
	
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
	
	public void setScore(int s) {
		score = s;
	}
	
	public int getScore() {
		score = scoreRound();
		return score;
		
	}
	
	public void setDeductionReieved(int i) {
		deductionReceived = i;
		
	}
	
	public int getDeductionReceived() {
		return deductionReceived;
	}
	
	public void setDeductionToSend(int i) {
		deductionToSend = i;
	}
	
	public int getDeductionSent() {
		return deductionToSend;
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
		
		score = score + scoreRound();
		return game.getOutCome(); 
		
	}
	
	public int scoreRound() {
		tempScore = 0;
		diceUsed = 0;
		boolean fCHandled = false;
		
		if(!(game.isDead())) {
			int[] rCounts = new int[5];
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
			
			if(game.getFortuneCard().equals("MB")) {
				rCounts[1] = mCount + pCount;
				rCounts[2] = 0;
				
			}
			
			if(cCount < 3 && !(game.getFortuneCard().equals("CO"))) {
				System.out.println("Dice Before " +  diceUsed);
				diceUsed = diceUsed + cCount;
				System.out.println("Dice After " +  diceUsed);
			
			}
			
			if(dCount < 3 && !(game.getFortuneCard().equals("DI"))) {
				diceUsed = diceUsed + dCount;
			}
			
			for(int i = 0; i < rCounts.length; i++) {
				if(rCounts[i] == 3) {
					tempScore = tempScore + 100;
					diceUsed = diceUsed + 3;
					
				}else if(rCounts[i] == 4) {
					tempScore = tempScore + 200;
					diceUsed = diceUsed + 4;
					
				}else if(rCounts[i] == 5) {
					tempScore = tempScore + 500;
					diceUsed = diceUsed + 5;
					
				}else if(rCounts[i] == 6) {
					tempScore = tempScore + 1000;
					diceUsed = diceUsed + 6;
					
				}else if(rCounts[i] == 7) {
					tempScore = tempScore + 2000;
					diceUsed = diceUsed + 7;
					
				}else if(rCounts[i] >= 8) {
					tempScore = tempScore + 4000;
					diceUsed = diceUsed + 8;
					
				}
				
			}
			
			int cBonus = 100 * cCount;
			int dBonus = 100 * dCount;
			tempScore = tempScore + cBonus + dBonus;
			
		}
		
		System.out.println("dietoUse = " + diceUsed);
		
		if(seperateFC(game.getFortuneCard())[0].equals("SB")) {
			handleFC(seperateFC(game.getFortuneCard())[0]);
			fCHandled = true;
			
		}
		
		if(game.fullChest(diceUsed)) {
			tempScore = tempScore + 500;
			if(!(seperateFC(game.getFortuneCard())[0].equals("SB"))) {
				handleFC(seperateFC(game.getFortuneCard())[0]);
			}
			
			fCHandled = true;
			
		}
		
		if(!fCHandled) {
			handleFC(seperateFC(game.getFortuneCard())[0]);
			
		}

		return tempScore;
		
	}
	
	private void handleFC(String fc) {
		if(fc.equals("CA")) {
			handleCA(tempScore);
			
		}
		
		if(fc.equals("SB")) {
			handleSB();
		}
		
	}
	
	private void handleCA(int newScore) {
		tempScore = newScore * 2;
		System.out.println("score " + newScore);
		
		
	}
	
	private void handleSB() {
		int sCount = game.getSymbolCount("Sword");
		System.out.println("Dealing with SB " + sCount);
		if(sCount >= Integer.parseInt(seperateFC(game.getFortuneCard())[1]) && !game.isDead()) {
			tempScore = tempScore + Integer.parseInt(seperateFC(game.getFortuneCard())[2]);
			if(sCount < 3) {
				diceUsed = diceUsed + sCount;
				System.out.println("insde Dealing with SB " + diceUsed);
				
			}
		}else {
			tempScore = 0;
		}
	}
	
	private String[] seperateFC(String fortuneCard) {
		if(fortuneCard.length() <= 2) {
			String[] together = {fortuneCard};
			return together;
		}
		
		String[] seperated = new String[3];
		seperated[0] = fortuneCard.substring(0, 2);
		seperated[1] = fortuneCard.substring(2,3);
		seperated[2] = fortuneCard.substring(3, fortuneCard.length());
		
		return seperated;
		
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