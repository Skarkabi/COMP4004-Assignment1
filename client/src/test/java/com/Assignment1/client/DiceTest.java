package com.Assignment1.client;

import java.util.ArrayList;

import junit.framework.TestCase;

//Test Class used for all test that relate to Dice functionality 
public class DiceTest extends TestCase {
	
	//Test Case to check that the players turn ends if they get 3 skulls on the first roll
	//It does this by creating an instance of the player & then while the players skull count is less than 3 the test keeps 
	//rolling the dice for the first time. Once 3 skulls are rolled on the first roll the while loop ends & the test passes
	//This test case proves the functionality of the 3 skulls on the first roll, as the first roll  function sets the skullCount
	//to 0 & sets the players turn to true, only after it has called the firstRoll function can the skullCount increase & it is reset
	//every time the firstRoll function is called
	public void test3Skull() {
		PlayerClass player = new PlayerClass();
		
		while (player.getSkullCount() != 3) { player.firstRoll(); }
		
		assertEquals(3, player.getSkullCount());
		assertEquals(false, player.getTurn());
		
			
	}
	
	public void test1SkullFirst2SkullNext() {
		PlayerClass player = new PlayerClass();
		ArrayList<Integer> diceToReRoll = new ArrayList<>();
		
		diceToReRoll.add(1); diceToReRoll.add(2); diceToReRoll.add(3); diceToReRoll.add(4); diceToReRoll.add(5);
		diceToReRoll.add(6); diceToReRoll.add(7); diceToReRoll.add(8);
		
		while (player.getSkullCount() != 3) {
			while (player.getSkullCount() != 1) {
				player.firstRoll();
			
			}
			
			player.reRoll(diceToReRoll);
		
		}
		
		assertEquals(3, player.getSkullCount());
		assertEquals(false, player.getTurn());
		
	}
	
}
