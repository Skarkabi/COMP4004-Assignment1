package com.Assignment1.client;

import java.util.ArrayList;
import java.util.Random;

/*
 * This class is used to simulate a single dice within our game
 * This class has 2 functions
 *	setDiceFaces, used to initiate the dice faces
 *	rollDice, used to get a random dice face
 */
public class Dice {
	ArrayList<String> sides = new ArrayList<>(); //ArrayList representing the physical dice sides
	
	//This functions adds all sides to the ArrayList representing the physical dice sides
	private void setDiceFaces() {
		sides.clear();
		sides.add("Skull");
		sides.add("Monkey");
		sides.add("Parrot");
		sides.add("Sword");
		sides.add("Coin");
		sides.add("Diamond");
		
	}

	//This function selects a random element from the sides ArrayList, & outputs this side as the dice roll
	public String rollDice() {
		setDiceFaces();
		
		String output = new String();
		Random rand = new Random();
		int upperbound = 6;
		int side = rand.nextInt(upperbound);
		
		output = sides.get(side);
		
		return output;
		
		
	}
	
}
