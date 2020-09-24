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
	
	//Test Case to check that the player rolls a skull on the first roll, then another 2 on the re-roll
	//It does this by creating an instance of the PlayerClass and an ArrayList of integers to represent which dice to re-roll
	//This test case proves this functionality by creating a nested while loop, where the outer loop checks for 3 skulls &
	//the inner loop checks for a single skull on the first roll. Once a single skull is registered the whole loop repeats
	//until the first re-roll results in a skullCount of 3 which would signify receiving the other 2 skulls. Since the player
	//returned with 3 skulls & a turn property of false we can conclude that the test was completed correctly 
	public void test1SkullFirst2SkullNext() {
		PlayerClass player = new PlayerClass();
		ArrayList<Integer> diceToReRoll = new ArrayList<>();
		
		//Populating the array to simulate the player trying to re-roll all the dice, but since the function only re-rolls
		//if the selected dice is not a skull, it does not affect the first skull rolled
		diceToReRoll.add(1); diceToReRoll.add(2); diceToReRoll.add(3); diceToReRoll.add(4); diceToReRoll.add(5);
		diceToReRoll.add(6); diceToReRoll.add(7); diceToReRoll.add(8);
		
		while (player.getSkullCount() != 3) {
			while (player.getSkullCount() != 1) { player.firstRoll(); }
			player.reRoll(diceToReRoll);
		
		}
		
		assertEquals(3, player.getSkullCount());
		assertEquals(false, player.getTurn());
		
	}
	
	//Test Case to check that the player rolls 2 skulls on the first roll, then another on the re-roll
	//This test case works almost exactly like test1SkullFirst2SkullNext() with the only difference being the inner loop
	//now checks to make sure 2 skulls were registered in the first roll instead of 1
	public void test2SkullFirst1SkullNext() {
		PlayerClass player = new PlayerClass();
		ArrayList<Integer> diceToReRoll = new ArrayList<>();
		
		//Populating the array to simulate the player trying to re-roll all the dice, but since the function only re-rolls
		//if the selected dice is not a skull, it does not affect the first skull rolled
		diceToReRoll.add(1); diceToReRoll.add(2); diceToReRoll.add(3); diceToReRoll.add(4); diceToReRoll.add(5);
		diceToReRoll.add(6); diceToReRoll.add(7); diceToReRoll.add(8);
		
		while (player.getSkullCount() != 3) {
			while (player.getSkullCount() != 2) { player.firstRoll(); }
			player.reRoll(diceToReRoll);
		
		}
		
		assertEquals(3, player.getSkullCount());
		assertEquals(false, player.getTurn());
		
	}
	
}
