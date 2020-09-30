package com.Assignment1.server;

import java.io.Serializable;
import java.util.Random;

public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String[] currentRoll = new String[7];
	private boolean turnOver = false;
	private String FC = new String("");
	
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
		
		
		return count;
	}
	
	public boolean fullChest(int d) {
		if((FC.equals("CO") && getSymbolCount("Coin") != 9 && getSymbolCount("Coin") > 1) || 
				(FC.equals("DI") && getSymbolCount("Diamond") != 9 && getSymbolCount("Diamond") > 1)) {
			d = d - 1;
		}
		
		
		
		if(d == 8) {
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
	
	public boolean isTurnOver() {
		isDead();
		return turnOver;
	}
	
	public boolean isDead() {
		if(getSymbolCount("Skull") > 2){
			turnOver = true;
			return true;
			
		}else {
			return false;
		}
		
		
	}

}
