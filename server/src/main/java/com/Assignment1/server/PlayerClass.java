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
	
	 public static void main( String[] args ) throws Exception{
		 Scanner myObj = new Scanner(System.in);
			System.out.print("What is your name ? ");
			String name = myObj.next();
			PlayerClass p = new PlayerClass(name);
			p.initializePlayers();
			p.connectToClient();
	

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
		
	}
	
	public PlayerClass(String n) {
		name = n;
		
	}
	
	
}
