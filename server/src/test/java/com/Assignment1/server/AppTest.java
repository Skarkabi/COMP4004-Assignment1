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
    public void testRow48(){
    	String[] dieRoll = {"Skull", "Skull", "Skull", "Coin", "Parrot", "Sword", "Diamond", "Sword"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	assertEquals(0, p.getScore());
    	assertEquals(3, p.getGame().getSymbolCount("Skull"));
    	assertTrue(game.isDead());
    	
    }
    
    @Test
    public void testRow49() {
    	String[] dieRoll = {"Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Sword", "Sword", "Sword"};
    	PlayerClass p = new PlayerClass("");
    	game.setCurrentRoll(dieRoll);
    	p.setGame(game);
    	assertEquals(1, p.getGame().getSymbolCount("Skull"));
    	assertEquals(4, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(3, p.getGame().getSymbolCount("Sword"));
    	
    	assertEquals(300,p.getScore());
    	assertFalse(p.getGame().isDead());
    	
    	String[] dieRoll2 = {"Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Skull", "Sword", "Skull"};
    	game.setCurrentRoll(dieRoll2);
    	assertEquals(3, p.getGame().getSymbolCount("Skull"));
    	assertEquals(4, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(1, p.getGame().getSymbolCount("Sword"));
    	
    	assertEquals(200, p.getScore());
    	assertTrue(p.getGame().isDead());
    	
    }
    
    @Test
    public void testRow50() {
    	String[] dieRoll = {"Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Sword", "Sword", "Skull"};
    	PlayerClass p = new PlayerClass("");
    	game.setCurrentRoll(dieRoll);
    	p.setGame(game);
    	assertEquals(2, p.getGame().getSymbolCount("Skull"));
    	assertEquals(4, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(2, p.getGame().getSymbolCount("Sword"));
    	
    	assertEquals(200,p.getScore());
    	assertFalse(p.getGame().isDead());
    	
    	String[] dieRoll2 = {"Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Skull", "Sword", "Skull"};
    	game.setCurrentRoll(dieRoll2);
    	assertEquals(3, p.getGame().getSymbolCount("Skull"));
    	assertEquals(4, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(1, p.getGame().getSymbolCount("Sword"));
    	
    	assertEquals(200, p.getScore());
    	assertTrue(p.getGame().isDead());
    	
    }
    
    @Test
    public void testRow51() {
    	String[] dieRoll = {"Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Sword", "Sword", "Sword"};
    	PlayerClass p = new PlayerClass("");
    	game.setCurrentRoll(dieRoll);
    	p.setGame(game);
    	assertEquals(1, p.getGame().getSymbolCount("Skull"));
    	assertEquals(4, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(3, p.getGame().getSymbolCount("Sword"));
    	
    	assertEquals(300,p.getScore());
    	assertFalse(p.getGame().isDead());
    	
    	String[] dieRoll2 = {"Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Monkey", "Monkey", "Skull"};
    	game.setCurrentRoll(dieRoll2);
    	assertEquals(2, p.getGame().getSymbolCount("Skull"));
    	assertEquals(4, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(2, p.getGame().getSymbolCount("Monkey"));
    	
    	assertEquals(200, p.getScore());
    	assertTrue(p.getGame().isDead());
    	
    }
    
}