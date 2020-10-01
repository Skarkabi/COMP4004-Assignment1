package com.Assignment1.server;

import java.io.Serializable;
import java.util.Random;

public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String[] currentRoll = new String[7];
	private boolean turnOver = false;
	private String FC = new String("");
	private boolean firstTurn = true;
	private boolean alreadyInSkullIsland = false;
	
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
		boolean reRolled;
		String[] dice = new String [6];
		dice[0] = "Monkey";
		dice[1] = "Parrot";
		dice[2] = "Sword";
		dice[3] = "Skull";
		dice[4] = "Coin";
		dice[5] = "Diamond";
		
		Random rand = new Random();
		int upperbound = 6;
		int side = rand.nextInt(upperbound);
		
		if(dieToReRoll.length < 2) {
			reRolled = false;
			
		}else {
			for(int i = 0; i < dieToReRoll.length; i++) {
				currentRoll[dieToReRoll[i] - 1] = dice[side];
				
			}
			
			reRolled = true;
			
		}
	
		for(int i = 0; i < currentRoll.length; i++) {
			System.out.print(currentRoll[i] + " ");
			
		}
		
		return reRolled;
	}
	
	
	public void setFortuneCard(String fc) { FC = fc; }
	
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
