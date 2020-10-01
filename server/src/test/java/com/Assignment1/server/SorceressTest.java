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
    	assertEquals(1, game.getSymbolCount("Skull"));
    	game.reRoll(dieToReRoll);
    	
    	assertTrue(originalRoll != game.getOutCome());
    	assertEquals(0, game.getSymbolCount("Skull"));
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow81(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Diamond", "Sword"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("SO");
    	
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll2 = {"Skull", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Diamond", "Sword"};
    	int[] dieToReRoll = {1};
    	game.setCurrentRoll(dieRoll2);
    	String[] originalRoll = game.getOutCome();

    	assertEquals(1, game.getSymbolCount("Skull"));
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	game.reRoll(dieToReRoll);
    	game.setTurn(false);
    	assertTrue(originalRoll != game.getOutCome());
    	assertEquals(0, game.getSymbolCount("Skull"));
    	assertEquals(200, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
}
