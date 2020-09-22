package com.Assignment1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//This class is used to connect, receive, & send data to the Client
//All information sent or received from the Clients are dealt with here
public class ClientConnecter 
{
	
	//This function is used to start the server using port 9999
	//The function opens a new ServerSocket which can later be used
	private ServerSocket start() throws Exception{
		System.out.println("Server is started");
		ServerSocket ss = new ServerSocket(9999);
		System.out.println("S: Server is waiting for client request");
		return ss;
		
	}
	
	
	//This function is used to send Strings to the client
	//It does this by first starting the server, then while the connection is true it sends the String to the client,
	//once the client disconnects the server stays open waiting for its next connection
	public void sendToClient(String text) throws Exception {
		ServerSocket server = start();
		while(true) {
			Socket s = server.accept();
			System.out.println("Client Connected in the sendToClient Function");
			
			OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
			PrintWriter out = new PrintWriter(os);
			out.println(text);
			out.flush();
			
			System.out.println("S: Data sent from Server to Client");

		}	
		
	}

}
