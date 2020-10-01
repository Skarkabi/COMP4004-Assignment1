package com.Assignment1.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String[] currentRoll = new String[8];
	private boolean turnOver = false;
	private String FC = new String("");
	private boolean firstTurn = true;
	private boolean alreadyInSkullIsland = false;
	private int soCount = 0;
	private int[] tChest = new int[8];

	public int getSymbolCount(String s) {
		int count = 0;
		
		for(int i = 0; i < currentRoll.length; i++) {
			if(currentRoll[i].equals(s)) {
				count++;
			}
		}
		
		if((s.equals("Coin") && FC.equals("CO") ||
				(s.equals("Diamond") && FC.equals("DI")))) {
			count++;
			
		}
		
		if(s.equals("Skull") && seperateFC(FC)[0].equals("SK")) {
			count = count + Integer.parseInt(seperateFC(FC)[1]);
		}
		
		
		return count;
	}
	
	public int getChestDiceCount(String s) {
		int count = 0;
		ArrayList<String> chest = new ArrayList<>();
		
		chest = getChestDice();
		
		for(int i = 0; i < chest.size(); i++) {
			if(chest.get(i).equals(s)) {
				count++;
			}
		}
		
		return count;
		
	}
	
	public boolean fullChest(int d) {
		if((FC.equals("CO") && getSymbolCount("Coin") != 9 && getSymbolCount("Coin") > 1) || 
				(FC.equals("DI") && getSymbolCount("Diamond") != 9 && getSymbolCount("Diamond") > 1)) {
			d = d - 1;
		}
		
		
		
		if(d == 8 && getSymbolCount("Skull") == 0) {
			return true;
			
		}else {
			return false;
		}
	}
	
	public String[] firstRoll() {
		String[] dice = new String [6];
		dice[0] = "Monkey";
		dice[1] = "Parrot";
		dice[2] = "Sword";
		dice[3] = "Skull";
		dice[4] = "Coin";
		dice[5] = "Diamond";
		
		String[] rolledDice = new String[7];
		Random rand = new Random();
		int upperbound = 6;
		int side = rand.nextInt(upperbound);
		
		for(int i = 0; i < rolledDice.length; i++) {
			rolledDice[i] = dice[side];
		
		}
		
		firstTurn = false;
		return rolledDice;
	}
	
	public boolean reRoll(int[] dieToReRoll) {
		System.out.println("Scount first = " + soCount);
		boolean reRolled;
		boolean skullExist = false;
		String[] dice = new String [6];
		dice[0] = "Monkey";
		dice[1] = "Parrot";
		dice[2] = "Sword";
		dice[3] = "Coin";
		dice[4] = "Diamond";
		dice[5] = "Skull";
		
		Random rand = new Random();
		int upperbound = 6;
		int side = rand.nextInt(upperbound);
		int altSide = rand.nextInt(5);
		
		if(soCount != 1) {
			for(int i =0; i < dieToReRoll.length; i++) {
				if(currentRoll[dieToReRoll[i] - 1].equals("Skull")) {
					skullExist = true;
					System.out.println("Found a skull " + currentRoll[dieToReRoll[i] - 1]);
				}
			
			}
		}
		
		if(dieToReRoll.length < 2 || skullExist) {
			reRolled = false;
			
			
		}else {
			boolean realRolled = false;
			int lengthToLoop = dieToReRoll.length;
			
			if(dieToReRoll[1] == 9) {
				lengthToLoop = 1;
				
			}
			
			System.out.println("Lengtrh to loop is " + lengthToLoop);
			
			for(int i = 0; i < lengthToLoop; i++) {
				if(soCount == 1 && currentRoll[dieToReRoll[i] - 1].equals("Skull")) {
					currentRoll[dieToReRoll[i] - 1] = dice[altSide];
					System.out.println("reRolled is " + currentRoll[dieToReRoll[i] - 1]);
					soCount = 0;
					
				}else if(currentRoll[dieToReRoll[i] - 1].equals("Skull")) {
					realRolled = false;
				
				}else {
					currentRoll[dieToReRoll[i] - 1] = dice[side];
					realRolled = true;
				
				}
				
			}
			
			reRolled = realRolled;
			
				
		}
		
		System.out.println("Scount end = " + soCount);
	
		
		return reRolled;
	}
	
	
	public void setFortuneCard(String fc) {
		if(fc.equals("SO")) {
			soCount = 1;
			
		}else {
			soCount = 0;
			
		}
		FC = fc;
		
	}
	
	public ArrayList<String> getChestDice(){
		ArrayList<String> chest = new ArrayList<>();
		System.out.println("tChest length is" + tChest.length);
		for(int i = 0; i < tChest.length; i++) {
			System.out.println("tChest[" + i + "] is " + tChest[i]);
			if(tChest[i] != 11 & tChest[i] != 0) {
				if (tChest[i] == 20) {
					
					chest.add(currentRoll[0]);
					System.out.println("0 added ");
				}else {
					chest.add(currentRoll[tChest[i]]);
					System.out.println(currentRoll[tChest[i]] + " added ");
					
				}
				
			}
		}
		
		for(int i = 0; i < chest.size(); i++){
			System.out.println("Chest at " + i + " is " + chest.get(i));
		}
		
		return chest;
	}
	
	public void saveDice(int[] spaces) {
		boolean findFirst = false;
		
		for(int i = 0; i < spaces.length; i++) {
			if(spaces[i] == 1) {
				findFirst = true;
			}
		}
		for(int i = 0; i < spaces.length; i++) {
			tChest[spaces[i] - 1] = spaces[i] - 1;
		
		}
		
		if(findFirst) {
			tChest[0] = 20;
			
		}
		
		System.out.println("Chest length is " + spaces.length);
		for(int i = 0; i < tChest.length; i++) {
			System.out.println("Saved This " + tChest[i]);
		}
		
	
		
		
		
	}
	
	public void removeDice(int[] spaces) {
		for(int i = 0; i < spaces.length; i++) {
			System.out.println("Removing " + (spaces[i] - 1));
			tChest[spaces[i] - 1] = 11;
		}
		
		for(int i = 0; i < tChest.length; i++) {
			System.out.println("After Removing " + (tChest[i]));
			
		}
		
	}
	
	public void setCurrentRoll(String[] dice) { currentRoll = dice; }
	
	public void setTurn(boolean t) { turnOver = !t; }
	
	public String getFortuneCard() { return FC; }
	 
	public String[] getOutCome() { return currentRoll; }
	
	public void setFirstTurn(boolean b) {
		firstTurn = b;
	}
	
	public boolean getFirstTurn() { return firstTurn;}
	
	public boolean inSkullIsland() {
		if(firstTurn) {
			if(getSymbolCount("Skull") > 3) {
				alreadyInSkullIsland = true;
			}
		}
		
		return alreadyInSkullIsland; }
	
	public void leftSkullIsland() { alreadyInSkullIsland = false; }
	
	public void enteredSkullIsland() {alreadyInSkullIsland = true; }
	
	public boolean isTurnOver() {
		isDead();
		return turnOver;
	}
	
	
	
	public boolean isDead() {
		if(firstTurn) {
			if(getSymbolCount("Skull") == 3) {
				turnOver = true;
				alreadyInSkullIsland = false;
				return true;
			
			}else {
				if(getSymbolCount("Skull") > 3) {
					alreadyInSkullIsland = true;
					
				}
				return false;
				
			}
			
		}else {
			System.out.println("I am in here and skullisland is " + alreadyInSkullIsland);
			if(getSymbolCount("Skull") > 2 && !alreadyInSkullIsland){
				turnOver = true;
				return true;
			
			}else {
				return false;
			}
			
		}
		
		
	}
	
	private String[] seperateFC(String fortuneCard) {
		if(fortuneCard.length() <= 2) {
			String[] together = {fortuneCard};
			return together;
		}
		
		String[] seperated = new String[2];
		seperated[0] = fortuneCard.substring(0, 2);
		seperated[1] = fortuneCard.substring(2,3);
		
		return seperated;
		
	}

}
