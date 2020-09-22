package com.Assignment1.server;

import java.nio.channels.ClosedByInterruptException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ClientConnecter client = new ClientConnecter();
        client.sendToClient("Saleem's World!");
       
       
    }
}
