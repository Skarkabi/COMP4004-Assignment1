package com.Assignment1.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SeaBattleTest {
	Game game = new Game();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testRow118(){
    	String[] dieRoll = {"Skull", "Skull", "Skull", "Parrot", "Parrot", "Parrot", "Diamond", "Sword"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setScore(300);
    	aseertEquals(300, p.getScore());
    	
    	p.setGame(game);
    	game.setFortuneCard("SB2300");
    	
    	assertEquals(0, p.getScore());
    	assertTrue(game.getSymbolCount("Sword") < 2);
    	assertTrue(p.getGame().isTurnOver());
    	assertTrue(game.isDead());
    	
    }
    
    @Test
    public void testRow119(){
    	String[] dieRoll = {"Skull", "Skull", "Skull", "Parrot", "Parrot", "Parrot", "Diamond", "Sword"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setScore(500);
    	aseertEquals(500, p.getScore());
    	p.setGame(game);
    	game.setFortuneCard("SB3500");
    	
    	assertEquals(0, p.getScore());
    	assertTrue(game.getSymbolCount("Sword") < 3);
    	assertTrue(p.getGame().isTurnOver());
    	assertTrue(game.isDead());
    	
    }
    
    @Test
    public void testRow120(){
    	String[] dieRoll = {"Skull", "Skull", "Skull", "Parrot", "Parrot", "Parrot", "Diamond", "Sword"};
    	game.setCurrentRoll(dieRoll);
    	PlayerClass p = new PlayerClass("");
    	p.setScore(1000);
    	aseertEquals(1000, p.getScore());
    	p.setGame(game);
    	game.setFortuneCard("SB41000");
    	
    	assertEquals(0, p.getScore());
    	assertTrue(game.getSymbolCount("Sword") < 4);
    	assertTrue(p.getGame().isTurnOver());
    	assertTrue(game.isDead());
    	
    }

}
