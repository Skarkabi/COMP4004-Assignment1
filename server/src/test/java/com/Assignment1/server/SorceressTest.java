package com.Assignment1.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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
    	int[] dieToReRoll = {8, 9};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setFortuneCard("SO");
  
    	assertEquals(1, game.getSymbolCount("Skull"));
    	game.reRoll(dieToReRoll);
    	
    	
    	assertFalse(game.getOutCome()[7].equals("Skull"));
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
    	
    	String[] dieRoll2 = {"Skull", "Parrot", "Monkey", "Sword", "Sword", "Sword", "Diamond", "Sword"};
    	int[] dieToReRoll = {1, 9};
    	game.setCurrentRoll(dieRoll2);
    
    	assertEquals(1, game.getSymbolCount("Skull"));
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	game.reRoll(dieToReRoll);
    	game.setTurn(false);
    	assertEquals(0, game.getSymbolCount("Skull"));
    	assertNotEquals(0, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow82(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Diamond", "Sword"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("SO");
    	
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll2 = {"Skull", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Diamond", "Sword"};
    	int[] dieToReRoll = {1, 9};
    	game.setCurrentRoll(dieRoll2);

    	assertEquals(1, game.getSymbolCount("Skull"));
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	game.reRoll(dieToReRoll);
    	assertEquals(0, game.getSymbolCount("Skull"));
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
}
