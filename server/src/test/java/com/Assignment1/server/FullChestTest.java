package com.Assignment1.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FullChestTest {
	Game game = new Game();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testRow101(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Diamond", "Parrot"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setTurn(false);
    	game.setFortuneCard("CO");
    	
    	assertEquals(400, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow102(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Coin", "Coin"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setTurn(false);
    	game.setFortuneCard("CA");
    	
    	assertEquals(1800, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }

}
