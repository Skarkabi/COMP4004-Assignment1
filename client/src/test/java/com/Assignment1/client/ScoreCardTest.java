package com.Assignment1.client;

import java.util.ArrayList;

import junit.framework.TestCase;
/*
 * This class is used to simulate a single Score Card within our game
 * 
 */

public class ScoreCardTest extends TestCase  {

	//Test Case to check that the players that a sequence of 2 Coins & 2 Diamonds is recorded
	//It does this by first creating an instance of the PlayerClass & then proceeds to roll the dice for the first time
	//Once the first roll is completed a while loop checks to see if our case has been meet, if not it loops the current
	//dice to make sure not to roll a Coin or Diamond. Once the positions of the Coins & Diamonds has been determined, the function
	//then checks to see if the player has lost or not. If the players turn is not over then the specified dice are re-rolled. 
	//& the function repeats until 2 Diamonds & Coins are registered. 
	//If the players turn has ended the while loop then checks if the conditions have been meet again & if not the dice are
	//re-rolled and the function starts again.
	//Since the ScoreCard class keeps track of how many of each dice the player currently holds a call to getCoins & getDiamonds
	//that result in 2 should be sufficient to show that the RTS currently has a sequence with 2 Coins & 2 Diamonds
	private void test2Diamond2Coin() {
		PlayerClass player = new PlayerClass();
		

			player.firstRoll();
			while(player.getScoreCard().getCoins != 2 && player.getScoreCard().getDiamonds() !=2) {
				ArrayList<Integer> diceToReRoll = new ArrayList<>();
				for(int i = 0; i < player.getDice().size(); i++) {
					if(player.getDice().get(i) != "Coin" && player.getDice().get(i) != "Diamond") {
						diceToReRoll.add(i + 1);
					
					}
				
				}
			
				if(player.getTurn()) {
					player.reRoll(diceToReRoll);
				
				}else if(player.getScoreCard().getCoins != 2 && player.getScoreCard().getDiamonds() !=2) {
					player.firstRoll();
					
				}
				
			
			}
	
		
		System.out.println("Final sequence is = " + player.getScoreCard().getCurrent());
		assertEquals(2, player.getScoreCard().getCoins());
		assertEquals(2, player.getScoreCard().getDiamonds());
	}
}
