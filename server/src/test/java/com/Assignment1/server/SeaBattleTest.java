package com.Assignment1.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SeaBattleTest {
	Game game = new Game();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testRow118(){
    	PlayerClass p = new PlayerClass("");
    	p.setScore(300);
    	String[] dieRoll = {"Diamond", "Skull", "Skull", "Parrot", "Parrot", "Parrot", "Diamond", "Sword"};
    	game.setCurrentRoll(dieRoll);
    	
    	
    	p.setGame(game);
    	game.setFortuneCard("SB2300");
    	game.setTurn(false);
    	
    	assertEquals(0, p.getScore());
    	assertTrue(game.getSymbolCount("Sword") < 2);
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow119(){
    	PlayerClass p = new PlayerClass("");
    	p.setScore(500);
    	
    	String[] dieRoll = {"Skull", "Skull", "Skull", "Parrot", "Parrot", "Parrot", "Diamond", "Sword"};
    	game.setCurrentRoll(dieRoll);
    	
    	
    	p.setGame(game);
    	game.setFortuneCard("SB3500");
    	game.setTurn(false);
    	
    	
    	assertEquals(0, p.getScore());
    	assertTrue(game.getSymbolCount("Sword") < 3);
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow120(){
    	PlayerClass p = new PlayerClass("");
    	p.setScore(1000);
 
    	
    	String[] dieRoll = {"Skull", "Skull", "Skull", "Parrot", "Parrot", "Parrot", "Diamond", "Sword"};
    	game.setCurrentRoll(dieRoll);
    	
    	
    	p.setGame(game);
    	game.setFortuneCard("SB41000");
    	game.setTurn(false);
    	
    	
    	assertEquals(0, p.getScore());
    	assertTrue(game.getSymbolCount("Sword") < 4);
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow121(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Coin", "Parrot", "Parrot"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setFortuneCard("SB2300");
    	game.setTurn(false);
    	
    	
    	assertEquals(500, p.getScore());
    	assertTrue(game.getSymbolCount("Sword") >= 2);
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow123(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Monkey", "Sword", "Skull", "Parrot", "Parrot"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setFortuneCard("SB2300");
    
    	assertTrue(game.getSymbolCount("Sword") < 2);
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll2 = {"Monkey", "Monkey", "Monkey", "Monkey", "Sword", "Skull", "Sword", "Skull"};
    	game.setCurrentRoll(dieRoll2);
    	game.setTurn(false);
    	
    	
    	assertTrue(game.getSymbolCount("Sword") >= 2);
    	assertEquals(500, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow125(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Sword", "Skull"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setFortuneCard("SB3500");
    	game.setTurn(false);
    	
    
    	assertTrue(game.getSymbolCount("Sword") >= 3);
    	assertEquals(800, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow126(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Monkey", "Sword", "Skull", "Sword", "Skull"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setFortuneCard("SB3500");
    
    	assertTrue(game.getSymbolCount("Sword") < 3);
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll2 = {"Skull", "Skull", "Sword", "Sword", "Sword", "Skull", "Sword", "Skull"};
    	game.setCurrentRoll(dieRoll2);
    	game.setTurn(false);
    	
    
    	assertTrue(game.getSymbolCount("Sword") >= 3);
    	assertEquals(0, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertTrue(game.isDead());
    	
    }
    
    @Test
    public void testRow128(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Sword", "Skull"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setFortuneCard("SB41000");
    	game.setTurn(false);
    	
    
    	assertTrue(game.getSymbolCount("Sword") >= 4);
    	assertEquals(1300, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }
    
    @Test
    public void testRow129(){
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Skull", "Diamond", "Parrot", "Parrot"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setFortuneCard("SB41000");
    
    	assertTrue(game.getSymbolCount("Sword") < 4);
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll2 = {"Monkey", "Monkey", "Monkey", "Sword", "Skull", "Diamond", "Sword", "Sword"};
    	game.setCurrentRoll(dieRoll2);
    	
    	assertTrue(game.getSymbolCount("Sword") < 4);
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll3 = {"Sword", "Parrot", "Parrot", "Sword", "Skull", "Diamond", "Sword", "Sword"};
    	game.setCurrentRoll(dieRoll3);
    	game.setTurn(false);
    	
    	
    	assertEquals(1300, p.getScore());
    	assertTrue(game.getSymbolCount("Sword") >= 4);
    	assertTrue(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    }

}
