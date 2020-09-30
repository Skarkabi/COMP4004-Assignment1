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
    
    @Test
    public void testRow103(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Sword", "Diamond"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setTurn(false);
    	game.setFortuneCard("CO");
    	
    	assertEquals(1000, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow104(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Monkey", "Sword", "Parrot", "Parrot", "Coin"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setFortuneCard("SB2300");
    	
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll2 = {"Monkey", "Monkey", "Monkey", "Monkey", "Sword", "Sword", "Coin", "Coin"};
    	game.setCurrentRoll(dieRoll2);
    	game.setTurn(false);
    	
    	assertEquals(1200, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow107(){
    	String[] dieRoll = {"Monkey", "Monkey", "Parrot", "Coin", "Coin", "Diamond", "Diamond", "Diamond"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setTurn(false);
    	game.setFortuneCard("MB");
    	
    	assertEquals(1200, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }

}