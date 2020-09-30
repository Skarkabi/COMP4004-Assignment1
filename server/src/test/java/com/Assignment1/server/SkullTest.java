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
    	game.setFortuneCard("SK1");
    	
    	assertEquals(0, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertTrue(game.isDead());
    	
    }
    
    @Test
    public void testRow112(){
    	Game game2 = new Game();
    	Game game3 = new Game();
    	
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Skull", "Skull"};
    	String[] dieRollAlt = {"Monkey", "Sword", "Parrot", "Sword", "Monkey", "Parrot", "Skull", "Skull"};
    	
    	game.setCurrentRoll(dieRoll);
    	game2.setCurrentRoll(dieRollAlt);
    	game3.setCurrentRoll(dieRollAlt);
    	
    	PlayerClass p = new PlayerClass("");
    	PlayerClass p2 = new PlayerClass("");
    	PlayerClass p3 = new PlayerClass("");
    	p.setGame(game);
    	p2.setGame(game2);
    	p3.setGame(game3);
    	game.setFortuneCard("SK2");
    	
    	assertEquals(0, p.getScore());
    	assertEquals(400, p.getDeductionSent());
    	
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll2 = {"Skull", "Skull", "Monkey", "Sword", "Sword", "Sword", "Skull", "Skull"};
    	game.setCurrentRoll(dieRoll);
    	
    	assertEquals(0, p.getScore());
    	assertEquals(600, p.getDeductionSent());
    	
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[]dieRoll3 = {"Skull", "Skull", "Skull", "Sword", "Sword", "Sword", "Skull", "Skull"};
    	game.setCurrentRoll(dieRoll);
    	game.setTurn(false);
    	
    	p2.setScore(1000);
    	p3.setScore(2000);
    	
    	assertEquals(0, p.getScore());
    	assertEquals(700, p.getDeductionSent());
    	
    	p2.setDeductionReieved(p.getDeductionSent());
    	p3.setDeductionReieved(p.getDeductionSent());
    	
    	assertEquals(300, p2.getScore());
    	assertEquals(1300, p3.getScore());
    	
    	assertEquals(0, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
    	assertTrue(game.isDead());
    	
    }
    
    @Test
    public void testRow113(){
    	Game game2 = new Game();
    	Game game3 = new Game();
    	
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Skull", "Skull", "Skull"};
    	String[] dieRollAlt = {"Monkey", "Sword", "Parrot", "Sword", "Monkey", "Parrot", "Skull", "Skull"};
    	
    	game.setCurrentRoll(dieRoll);
    	game2.setCurrentRoll(dieRollAlt);
    	game3.setCurrentRoll(dieRollAlt);
    	
    	PlayerClass p = new PlayerClass("");
    	PlayerClass p2 = new PlayerClass("");
    	PlayerClass p3 = new PlayerClass("");
    	p.setGame(game);
    	p2.setGame(game2);
    	p3.setGame(game3);
    	game.setFortuneCard("SK2");
    	
    	assertEquals(0, p.getScore());
    	assertEquals(500, p.getDeductionSent());
    	
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll2 = {"Sword", "Sword", "Parrot", "Monkey", "Monkey", "Skull", "Skull", "Skull"};
    	game.setCurrentRoll(dieRoll);
    	
    	
    	p2.setScore(1000);
    	p3.setScore(2000);
    	
    	assertEquals(0, p.getScore());
    	
    	p2.setDeductionReieved(p.getDeductionSent());
    	p3.setDeductionReieved(p.getDeductionSent());
    	
    	assertEquals(500, p2.getScore());
    	assertEquals(1500, p3.getScore());
    	assertEquals(500, p.getDeductionSent());
    	assertTrue(p.getGame().isTurnOver());
    	assertTrue(game.isDead());
    	
    }
    
    @Test
    public void testRow114(){
    	Game game2 = new Game();
    	Game game3 = new Game();
    	
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Skull", "Skull", "Skull"};
    	String[] dieRollAlt = {"Monkey", "Sword", "Parrot", "Sword", "Monkey", "Parrot", "Skull", "Skull"};
    	
    	game.setCurrentRoll(dieRoll);
    	game2.setCurrentRoll(dieRollAlt);
    	game3.setCurrentRoll(dieRollAlt);
    	
    	PlayerClass p = new PlayerClass("");
    	PlayerClass p2 = new PlayerClass("");
    	PlayerClass p3 = new PlayerClass("");
    	p.setGame(game);
    	p2.setGame(game2);
    	p3.setGame(game3);
    	game.setFortuneCard("SK1");
    	
    	assertEquals(0, p.getScore());
    	assertEquals(400, p.getDeductionSent());
    	
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[] dieRoll2 = {"Skull", "Monkey", "Monkey", "Sword", "Sword", "Skull", "Skull", "Skull"};
    	game.setCurrentRoll(dieRoll);
    	
    	assertEquals(0, p.getScore());
    	assertEquals(500, p.getDeductionSent());
    	
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(game.isDead());
    	
    	String[]dieRoll3 = {"Skull", "Parrot", "Monkey", "Sword", "Sword", "Skull", "Skull", "Skull"};
    	game.setCurrentRoll(dieRoll);
    	game.setTurn(false);
    	
    	p2.setScore(1000);
    	p3.setScore(2000);
    	
    	assertEquals(0, p.getScore());
    	
    	p2.setDeductionReieved(p.getDeductionSent());
    	p3.setDeductionReieved(p.getDeductionSent());
    	
    	assertEquals(500, p2.getScore());
    	assertEquals(1500, p3.getScore());
    	assertEquals(500, p.getDeductionSent());
    	
    	assertTrue(p.getGame().isTurnOver());
    	assertTrue(game.isDead());
    	
    }

}
