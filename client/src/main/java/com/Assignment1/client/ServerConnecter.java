package com.Assignment1.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

//This class is used to connect, receive, & send data to the Server
//All information sent or received from the Server are dealt with here
public class ServerConnecter {
	
	//This function is used to receive data from the server in the form of a String
	//It creates a new Socket with the needed port & IP address (in this case the IP address is the local host & port 9999 is used
	//Once Connected it receives the input from the server & then closes the connection
	public void receiveFromServer() throws Exception {
		String ip = "localhost";
		int port = 9999;
		Socket client = new Socket(ip,port);
	
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String text = br.readLine();
		
		System.out.println("C: Data from Server " + text);
		client.close();
	}

	
}
