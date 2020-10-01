package com.Assignment1.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TressureChestTest {
	Game game = new Game();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testRow90(){
    	String[] dieRoll = {"Parrot", "Parrot", "Parrot", "Sword", "Sword", "Diamond", "Diamond", "Coin"};
    	int[] dieToSave = {6, 7, 8};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setGame(game);
    	game.setFortuneCard("TC");
    	
    	game.saveDice(dieToSave);
    	assertEquals(3, game.getChestDice().size());
    	assertEquals(1, game.getChestDiceCount("Coin"));
    	assertEquals(2, game.getChestDiceCount("Diamond"));
    	
    	String[] dieRoll2 = {"Parrot", "Parrot", "Parrot", "Parrot", "Parrot", "Diamond", "Diamond", "Coin"};
    	int[] dieToSave2 = {1,2,3,4,5};
    	int[] dieToRemove2 = {6, 7, 8};
    	
    	game.setCurrentRoll(dieRoll2);
    	game.saveDice(dieToSave2);
    	game.removeDice(dieToRemove2);
    	
    	assertEquals(5, game.getChestDice().size());
    	assertEquals(0, game.getChestDiceCount("Coin"));
    	assertEquals(0, game.getChestDiceCount("Diamond"));
    	assertEquals(5, game.getChestDiceCount("Parrot"));
    	
    	
    	String[] dieRoll3 = {"Parrot", "Parrot", "Parrot", "Parrot", "Parrot", "Skull", "Coin", "Parrot"};
    	
    	game.setCurrentRoll(dieRoll3);
    	assertEquals(11000, p.getScore());
    	
    
    }
    
}
