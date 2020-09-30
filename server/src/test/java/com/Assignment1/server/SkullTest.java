package com.Assignment1.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SkullTest {
	Game game = new Game();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testRow110(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Diamond", "Skull"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setTurn(false);
    	game.setFortuneCard("SK2");
    	
    	assertEquals(0, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertTrue(game.isDead());
    	
    }
    
    @Test
    public void testRow111(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Skull", "Skull"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setTurn(false);
    	game.setFortuneCard("SK1");
    	
    	assertEquals(0, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertTrue(game.isDead());
    	
    }

}
