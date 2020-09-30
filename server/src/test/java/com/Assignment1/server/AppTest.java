package com.Assignment1.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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
    	assertTrue(p.getGame().isTurnOver());
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
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(p.getGame().isDead());
    	
    	String[] dieRoll2 = {"Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Skull", "Sword", "Skull"};
    	game.setCurrentRoll(dieRoll2);
    	assertEquals(3, p.getGame().getSymbolCount("Skull"));
    	assertEquals(4, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(1, p.getGame().getSymbolCount("Sword"));
    	
    	assertEquals(0, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
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
    	assertFalse(p.getGame().isTurnOver());
    	assertFalse(p.getGame().isDead());
    	
    	String[] dieRoll2 = {"Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Skull", "Sword", "Skull"};
    	game.setCurrentRoll(dieRoll2);
    	assertEquals(3, p.getGame().getSymbolCount("Skull"));
    	assertEquals(4, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(1, p.getGame().getSymbolCount("Sword"));
    	
    	assertEquals(0, p.getScore());
    	assertTrue(p.getGame().isTurnOver());
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
    	
    	assertFalse(p.getGame().isTurnOver());
    	assertEquals(300,p.getScore());
    	assertFalse(p.getGame().isDead());
    	
    	String[] dieRoll2 = {"Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Monkey", "Monkey", "Skull"};
    	game.setCurrentRoll(dieRoll2);
    	assertEquals(2, p.getGame().getSymbolCount("Skull"));
    	assertEquals(4, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(2, p.getGame().getSymbolCount("Monkey"));
    	
    	assertFalse(p.getGame().isTurnOver());
    	assertEquals(200, p.getScore());
    	assertFalse(p.getGame().isDead());
    	
    	String[] dieRoll3 = {"Skull", "Parrot", "Parrot", "Parrot", "Parrot", "Monkey", "Skull", "Skull"};
    	game.setCurrentRoll(dieRoll3);
    	assertEquals(3, p.getGame().getSymbolCount("Skull"));
    	assertEquals(4, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(1, p.getGame().getSymbolCount("Monkey"));
    	
    	assertTrue(p.getGame().isTurnOver());
    	assertEquals(0, p.getScore());
    	assertTrue(p.getGame().isDead());
    	
    }
    
    @Test
    public void testRow53() {
    	String[] dieRoll = {"Coin", "Coin", "Diamond", "Diamond", "Parrot", "Sword", "Monkey", "Skull"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CA");
    	game.setTurn(false);
    	assertEquals(2, p.getGame().getSymbolCount("Coin"));
    	assertEquals(2, p.getGame().getSymbolCount("Diamond"));
    	assertEquals("CA", p.getGame().getFortuneCard());
    	assertEquals(800, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    	
    }
    
    @Test
    public void testRow54() {
    	String[] dieRoll = {"Monkey", "Parrot", "Sword", "Skull", "Parrot", "Sword", "Monkey", "Skull"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CO");
    	
    	assertEquals(2, p.getGame().getSymbolCount("Monkey"));
    	assertEquals(100, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	
    	String[] dieRoll2 = {"Monkey", "Monkey", "Sword", "Skull", "Parrot", "Sword", "Monkey", "Skull"};
    	game.setCurrentRoll(dieRoll2);
    	game.setTurn(false);
    	assertEquals(3, p.getGame().getSymbolCount("Monkey"));
    	assertEquals(200, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    	
    }
    
    @Test
    public void testRow55() {
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Sword", "Sword", "Sword", "Parrot", "Skull"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CO");
    	game.setTurn(false);
    	assertEquals(3, p.getGame().getSymbolCount("Monkey"));
    	assertEquals(3, p.getGame().getSymbolCount("Sword"));
    	assertEquals(300, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
    @Test
    public void testRow56() {
    	String[] dieRoll = {"Monkey", "Monkey", "Skull", "Sword", "Parrot", "Sword", "Parrot", "Skull"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CO");
    	assertNotEquals(3, p.getGame().getSymbolCount("Monkey"));
    	assertNotEquals(3, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(100, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	
    	String[] dieRoll2 = {"Monkey", "Monkey", "Skull", "Monkey", "Parrot", "Parrot", "Parrot", "Skull"};
    	game.setCurrentRoll(dieRoll2);
    	game.setTurn(false);
    	assertEquals(3, p.getGame().getSymbolCount("Monkey"));
    	assertEquals(3, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(300, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
    @Test
    public void testRow57() {
    	String[] dieRoll = {"Diamond", "Diamond", "Diamond", "Sword", "Parrot", "Sword", "Parrot", "Skull"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CO");
    	game.setTurn(false);
    	assertEquals(3, p.getGame().getSymbolCount("Diamond"));
    	assertEquals(500, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
    @Test
    public void testRow58() {
    	String[] dieRoll = {"Coin", "Coin", "Coin", "Coin", "Monkey", "Sword", "Parrot", "Skull"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("DI");
    	game.setTurn(false);
    	assertEquals(4, p.getGame().getSymbolCount("Coin"));
    	assertEquals(700, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
    @Test
    public void testRow59() {
    	String[] dieRoll = {"Sword", "Parrot", "Sword", "Parrot", "Monkey", "Sword", "Parrot", "Parrot"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CO");
    	game.setTurn(false);
    	assertEquals(3, p.getGame().getSymbolCount("Sword"));
    	assertEquals(4, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(400, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
    @Test
    public void testRow60() {
    	String[] dieRoll = {"Sword", "Parrot", "Monkey", "Parrot", "Monkey", "Coin", "Coin", "Parrot"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CO");
    	
    	assertNotEquals(4, p.getGame().getSymbolCount("Sword"));
    	assertNotEquals(4, p.getGame().getSymbolCount("Coin"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	
    	String[] dieRoll2 = {"Sword", "Sword", "Monkey", "Parrot", "Sword", "Coin", "Coin", "Parrot"};
    	game.setCurrentRoll(dieRoll2);
    	
    	assertNotEquals(4, p.getGame().getSymbolCount("Sword"));
    	assertNotEquals(4, p.getGame().getSymbolCount("Coin"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	

    	String[] dieRoll3 = {"Sword", "Sword", "Skull", "Parrot", "Sword", "Coin", "Coin", "Parrot"};
    	game.setCurrentRoll(dieRoll3);
    	
    	assertNotEquals(4, p.getGame().getSymbolCount("Sword"));
    	assertNotEquals(4, p.getGame().getSymbolCount("Coin"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	
    	String[] dieRoll4 = {"Sword", "Sword", "Skull", "Sword", "Sword", "Coin", "Coin", "Coin"};
    	game.setCurrentRoll(dieRoll4);
    	p.getGame().setTurn(false);
    	
    	assertEquals(4, p.getGame().getSymbolCount("Sword"));
    	assertEquals(4, p.getGame().getSymbolCount("Coin"));
    	assertEquals(800, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    	
    }
    
    @Test
    public void testRow61() {
    	String[] dieRoll = {"Sword", "Parrot", "Monkey", "Parrot", "Monkey", "Coin", "Coin", "Parrot"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CA");
    	
    	assertNotEquals(4, p.getGame().getSymbolCount("Sword"));
    	assertNotEquals(4, p.getGame().getSymbolCount("Coin"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	
    	String[] dieRoll2 = {"Sword", "Sword", "Monkey", "Parrot", "Sword", "Coin", "Coin", "Parrot"};
    	game.setCurrentRoll(dieRoll2);
    	
    	assertNotEquals(4, p.getGame().getSymbolCount("Sword"));
    	assertNotEquals(3, p.getGame().getSymbolCount("Coin"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	

    	String[] dieRoll3 = {"Sword", "Sword", "Skull", "Parrot", "Sword", "Coin", "Coin", "Parrot"};
    	game.setCurrentRoll(dieRoll3);
    	
    	assertNotEquals(4, p.getGame().getSymbolCount("Sword"));
    	assertNotEquals(3, p.getGame().getSymbolCount("Coin"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	
    	String[] dieRoll4 = {"Sword", "Sword", "Skull", "Sword", "Sword", "Coin", "Coin", "Coin"};
    	game.setCurrentRoll(dieRoll4);
    	p.getGame().setTurn(false);
    	
    	assertEquals(4, p.getGame().getSymbolCount("Sword"));
    	assertEquals(3, p.getGame().getSymbolCount("Coin"));
    	assertEquals(1200, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    	
    }
    
    @Test
    public void testRow62() {
    	String[] dieRoll = {"Sword", "Parrot", "Monkey", "Parrot", "Monkey", "Skull", "Sword", "Parrot"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CO");
    	
    	assertNotEquals(5, p.getGame().getSymbolCount("Sword"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	
    	String[] dieRoll2 = {"Sword", "Sword", "Monkey", "Parrot", "Monkey", "Skull", "Sword", "Parrot"};
    	game.setCurrentRoll(dieRoll2);
    	assertNotEquals(5, p.getGame().getSymbolCount("Sword"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	
    	String[] dieRoll3 = {"Sword", "Sword", "Sword", "Sword", "Monkey", "Skull", "Sword", "Parrot"};
    	game.setCurrentRoll(dieRoll3);
    	game.setTurn(false);
    	assertEquals(5, p.getGame().getSymbolCount("Sword"));
    	assertEquals(600, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
    @Test
    public void testRow63() {
    	String[] dieRoll = {"Monkey", "Monkey", "Monkey", "Monkey", "Monkey", "Monkey", "Sword", "Parrot"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CO");
    	game.setTurn(false);
    	
    	assertEquals(6, p.getGame().getSymbolCount("Monkey"));
    	assertEquals(1100, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
    @Test
    public void testRow64() {
    	String[] dieRoll = {"Parrot", "Parrot", "Parrot", "Parrot", "Parrot", "Parrot", "Sword", "Parrot"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CO");
    	game.setTurn(false);
    	
    	assertEquals(7, p.getGame().getSymbolCount("Parrot"));
    	assertEquals(2100, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
    @Test
    public void testRow65() {
    	String[] dieRoll = {"Coin", "Coin", "Coin", "Coin", "Coin", "Coin", "Coin", "Coin"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CO");
    	game.setTurn(false);
    	
    	assertEquals(9, p.getGame().getSymbolCount("Coin"));
    	assertEquals(5400, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
    @Test
    public void testRow66() {
    	String[] dieRoll = {"Coin", "Coin", "Coin", "Coin", "Coin", "Coin", "Coin", "Coin"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("DI");
    	game.setTurn(false);
    	
    	assertEquals(8, p.getGame().getSymbolCount("Coin"));
    	assertEquals(5400, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
    @Test
    public void testRow67() {
    	String[] dieRoll = {"Sword", "Sword", "Sword", "Sword", "Sword", "Sword", "Sword", "Sword"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CA");
    	game.setTurn(false);
    	
    	assertEquals(8, p.getGame().getSymbolCount("Sword"));
    	assertEquals(9000, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    }
    
    @Test
    public void testRow68() {
    	String[] dieRoll = {"Monkey", "Parrot", "Monkey", "Parrot", "Monkey", "Coin", "Coin", "Parrot"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CO");
    	
    	assertNotEquals(8, p.getGame().getSymbolCount("Monkey"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	
    	String[] dieRoll2 = {"Monkey", "Monkey", "Monkey", "Parrot", "Monkey", "Coin", "Coin", "Monkey"};
    	game.setCurrentRoll(dieRoll2);
    	
    	assertNotEquals(8, p.getGame().getSymbolCount("Monkey"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	

    	String[] dieRoll3 = {"Monkey", "Monkey", "Monkey", "Parrot", "Monkey", "Monkey", "Monkey", "Monkey"};
    	game.setCurrentRoll(dieRoll3);
    	
    	assertNotEquals(8, p.getGame().getSymbolCount("Monkey"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	
    	String[] dieRoll4 = {"Monkey", "Monkey", "Monkey", "Monkey", "Monkey", "Monkey", "Monkey", "Monkey"};
    	game.setCurrentRoll(dieRoll4);
    	p.getGame().setTurn(false);
    	
    	assertEquals(8, p.getGame().getSymbolCount("Monkey"));
    	assertEquals(4600, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
    @Test
    public void testRow69() {
    	String[] dieRoll = {"Diamond", "Monkey", "Skull", "Sword", "Parrot", "Sword", "Parrot", "Skull"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("DI");
    	
    	assertNotEquals(3, p.getGame().getSymbolCount("Diamond"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	
    	String[] dieRoll2 = {"Diamond", "Monkey", "Skull", "Diamond", "Parrot", "Monkey", "Parrot", "Skull"};
    	game.setCurrentRoll(dieRoll2);
    	game.setTurn(false);
    	
    	assertEquals(3, p.getGame().getSymbolCount("Diamond"));
    	assertEquals(400, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
    @Test
    public void testRow70() {
    	String[] dieRoll = {"Diamond", "Monkey", "Skull", "Sword", "Parrot", "Sword", "Parrot", "Skull"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CO");
    	
    	assertNotEquals(3, p.getGame().getSymbolCount("Diamond"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	
    	String[] dieRoll2 = {"Diamond", "Diamond", "Skull", "Diamond", "Parrot", "Monkey", "Parrot", "Skull"};
    	game.setCurrentRoll(dieRoll2);
    	game.setTurn(false);
    	
    	assertEquals(3, p.getGame().getSymbolCount("Diamond"));
    	assertEquals(500, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
    @Test
    public void testRow71() {
    	String[] dieRoll = {"Coin", "Monkey", "Skull", "Sword", "Parrot", "Sword", "Parrot", "Skull"};
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setCurrentRoll(dieRoll);
    	game.setFortuneCard("CO");
    	
    	assertNotEquals(4, p.getGame().getSymbolCount("Coin"));
    	assertFalse(p.getGame().isDead());
    	assertFalse(p.getGame().isTurnOver());
    	
    	String[] dieRoll2 = {"Coin", "Coin", "Skull", "Coin", "Parrot", "Monkey", "Parrot", "Skull"};
    	game.setCurrentRoll(dieRoll2);
    	game.setTurn(false);
    	
    	assertEquals(4, p.getGame().getSymbolCount("Coin"));
    	assertEquals(600, p.getScore());
    	assertFalse(p.getGame().isDead());
    	assertTrue(p.getGame().isTurnOver());
    	
    }
    
}