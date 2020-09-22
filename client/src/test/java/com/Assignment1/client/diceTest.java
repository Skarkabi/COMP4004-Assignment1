package com.Assignment1.client;

import java.util.ArrayList;

import junit.framework.TestCase;

public class diceTest extends TestCase {
	public void test3Skull() {
		int skullCount = 0;
		PlayerClass player = new PlayerClass();
		ArrayList<String> dice = new ArrayList<>();
		
		while (skullCount != 3) {
			dice = player.firstRoll();
			for(int i = 0; i < dice.size(); i++) {
				if (dice.get(i).equals("Skull")){
					skullCount++;
					
				}
			}
			
		}
		
		assertEquals(3, skullCount);
		
		
	}

}
