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
	PlayerClass[] players = new PlayerClass[3];
	String name = new String();
	int numP = 0;
	
	 public static void main( String[] args ) throws Exception{
		 Scanner myObj = new Scanner(System.in);
			System.out.print("What is your name ? ");
			String name = myObj.next();
			PlayerClass p = new PlayerClass(name);
			p.initializePlayers();
			p.connectToClient();
			p.startGame();
	

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
	
	public void startGame() {
		// receive players once for names
		numP = clientConnection.receiveInt();
		players = clientConnection.receivePlayer();
		
		
			for (int i = 0; i < players.length; i++) {
				System.out.println("Player Name is " + players[i].name);
			
		}
	
	}
	
	
	
	public class Client{
		Socket socket;
		private ObjectInputStream jIn;
		private ObjectOutputStream jOut;
		int playerId = 0;
	   
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
