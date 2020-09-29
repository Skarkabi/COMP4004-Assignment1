package com.Assignment1.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	assertEquals(0, p.getScore());
    	assertEquals(3, game.getSymbolCount("Skull"));
    	assertTrue(game.isDead());
    	
    }
    
}