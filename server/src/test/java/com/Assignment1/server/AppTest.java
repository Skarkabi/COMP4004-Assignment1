package com.Assignment1.server;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	Game game = new Game();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void Skulls3Returned(){
    	String[] dieRoll = {"Skull", "Skull", "Skull", "Coin", "Parrot", "Sword", "Diamond", "Sword"};
    	assertEquals(3, game.getSkulls(dieRoll));
    	assertTrue(game.turnOver(dieRoll));
    	
    }
    
}
