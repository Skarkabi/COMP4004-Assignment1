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
		
		if(skullCount >= 3) {
			turn = false; 
			
		}
		
		
	}
	
	public ArrayList<String> getDice(){ return dice; }
	public int getScore() { return score; }
	public boolean getTurn() { return turn; }
	public int getSkullCount() { return skullCount; }
	
	
}
