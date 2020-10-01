package com.Assignment1.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SorceressTest {
	Game game = new Game();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testRow80(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Diamond", "Skull"};
    	int[] dieToReRoll = {8};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setFortuneCard("SO");
    	String[] originalRoll = game.getOutCome();
    	game.reRoll(dieToReRoll);
    	
    	assertTrue(originalRoll != game.getOutCome());
    	assertEquals(0, game.getSymbolCount("Skull"));
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
}
