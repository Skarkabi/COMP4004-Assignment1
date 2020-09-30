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
    	p.setScore(300);
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
}
