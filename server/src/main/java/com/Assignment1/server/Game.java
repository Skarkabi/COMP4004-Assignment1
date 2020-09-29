package com.Assignment1.server;

import java.io.Serializable;

public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String[] currentRoll = new String[7];
	private boolean currentTurn = false;
	
	public int getSymbolCount(String s) {
		int count = 0;
		
		for(int i = 0; i < 7; i++) {
			if(currentRoll[i].equals(s)) {
				count++;
			}
		}
		
		return count;
	}
	
	public void setCurrentRoll(String[] dice) {
		currentRoll = dice;
	}
	
	public String[] getOutCome() {
		return currentRoll;
	}
	
	public boolean isTurnOver() {
		isDead();
		return currentTurn;
	}
	
	public boolean isDead() {
		if(getSymbolCount("Skull") > 2){
			currentTurn = true;
			return true;
			
		}else {
			currentTurn = false;
			
			return false;
		}
		
		
	}

}
