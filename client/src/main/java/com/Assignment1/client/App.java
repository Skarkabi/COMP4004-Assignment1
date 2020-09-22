package com.Assignment1.client;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws Exception{
    	ServerConnecter server = new ServerConnecter();
    	System.out.println("Connecting to Server");
    	server.receiveFromServer();  	

    }
}
