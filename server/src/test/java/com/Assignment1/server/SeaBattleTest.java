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
    	p.setGame(game);
    	game.setFortuneCard("SB");
    	
    	assertEquals(-300, p.getScore());
    	assertTrue(game.getSymbolCount("Sword") < 2);
    	assertTrue(p.getGame().isTurnOver());
    	assertTrue(game.isDead());
    	
    }

}
