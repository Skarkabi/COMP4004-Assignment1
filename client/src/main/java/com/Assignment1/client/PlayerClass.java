package com.Assignment1.client;

import java.util.ArrayList;

//This class is used to represent the player
//It keeps track of a players dice, score, & takes care of all player interactions
public class PlayerClass {
	
	private ArrayList<String> dice = new ArrayList<>(); //ArrayList of Strings to represent to dice
	private int score = 0; //Used to represent the players score
	private boolean turn = false;
	private int skullCount = 0;
	
	//This function is used to roll all 8 dice only on the first roll of a players turn
	//It does this by first making sure the dice ArrayList is cleared, then creating an instance of the dice class, & finally
	//rolling that instance 8 separate times and records the outcome of each dice in the PlayerClass's dice property
	public void firstRoll() {
		skullCount = 0;
		turn = true;
		dice.clear();
		DiceClass die = new DiceClass();
		for(int i = 0; i < 8; i++) {
			dice.add(die.rollDice());
			if(dice.get(i).equals("Skull")) {
				skullCount++;
				
			}

		} 
		checkTurn();
		
	}
	
	//This function is used to re-roll the selected dice. It takes an ArrayList of integers as its input parameter which is 
	//used to represent which dice the player chooses to re-roll. The player is able to re-roll any dice that does not have a skull
	//When the function is first called it makes sure that it is in fact this players turn, if it is the function continues
	//if not it ends. If it is the players turn to re-roll then it loops through the selected dice, making sure the selected
	//die does not have a skull. If not the die is re-rolled & then if a new skull has been rolled the skullCounter is updated
	//Once the re-roll has finished the function checks if the player has 3 skulls to signal that the turn is over
	public void reRoll(ArrayList<Integer> diceToRoll) {
		DiceClass die = new DiceClass();
		checkTurn();
		if(turn) {
			for(int i = 0; i < diceToRoll.size(); i++) {
				if(!dice.get(diceToRoll.get(i) - 1).equals("Skull")) {
					dice.set(diceToRoll.get(i) - 1, die.rollDice());
					if(dice.get(diceToRoll.get(i) - 1).equals("Skull")) {
						skullCount++;
					
					}
				}
				
			
			}
		}
		checkTurn();
		
	
	}
		
	
	private void checkTurn() {
		if(skullCount >=3) {
			turn = false;
			
		}else {
			turn = true;
			
		}
		
	}
	
	public ArrayList<String> getDice(){ return dice; }
	public int getScore() { return score; }
	public boolean getTurn() { return turn; }
	public int getSkullCount() { return skullCount; }
	
	
}
