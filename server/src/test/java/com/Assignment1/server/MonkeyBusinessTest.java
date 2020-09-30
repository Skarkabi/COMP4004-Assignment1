package com.Assignment1.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MonkeyBusinessTest {
	Game game = new Game();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testRow85(){
    	PlayerClass p = new PlayerClass("");
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Parrot", "Parrot", "Parrot", "Skull", "Coin"};
    	game.setCurrentRoll(dieRoll);
    	
    	
    	p.setGame(game);
    	game.setFortuneCard("MB");
    	game.setTurn(false);
    	
    	assertEquals(1100, p.getScore());
    	assertTrue(game.getSymbolCount("Monkey") == 3);
    	assertTrue(game.getSymbolCount("Parrot") == 3);
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow86(){
    	PlayerClass p = new PlayerClass("");
    	String[] dieRoll = {"Monkey", "Parrot", "Coin", "Diamond", "Parrot", "Monkey", "Coin", "Coin"};
    	game.setCurrentRoll(dieRoll);
    	
    	
    	p.setGame(game);
    	game.setFortuneCard("MB");
    	
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll2 = {"Monkey", "Parrot", "Coin", "Sword", "Parrot", "Monkey", "Coin", "Coin"};
    	game.setCurrentRoll(dieRoll2);
    	
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll3 = {"Monkey", "Parrot", "Diamond", "Sword", "Sword", "Monkey", "Coin", "Coin"};
    	game.setCurrentRoll(dieRoll3);
    	game.setTurn(false);
    	
    	assertEquals(400, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow87(){
    	PlayerClass p = new PlayerClass("");
    	String[] dieRoll = {"Monkey", "Parrot", "Coin", "Diamond", "Parrot", "Diamond", "Coin", "Coin"};
    	game.setCurrentRoll(dieRoll);
    	
    	
    	p.setGame(game);
    	game.setFortuneCard("MB");
    	
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll2 = {"Monkey", "Parrot", "Coin", "Monkey", "Parrot", "Monkey", "Coin", "Coin"};
    	game.setCurrentRoll(dieRoll2);
    	
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll3 = {"Monkey", "Parrot", "Parrot", "Monkey", "Parrot", "Monkey", "Parrot", "Sword"};
    	game.setCurrentRoll(dieRoll3);
    	game.setTurn(false);
    	
    	assertEquals(2000, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
}
