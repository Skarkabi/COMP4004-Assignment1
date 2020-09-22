package com.Assignment1.client;

import java.util.ArrayList;

public class PlayerClass {
	ArrayList<String> dice = new ArrayList<>();
	int score = 0;
	
	public ArrayList<String> firstRoll() {
		dice.clear();
		DiceClass die = new DiceClass();
		for(int i = 0; i < 6; i++) {
			dice.add(die.rollDice());

		}
		
		return dice;
	}
	
	
}
