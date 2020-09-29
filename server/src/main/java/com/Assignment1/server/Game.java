package com.Assignment1.server;

import java.io.Serializable;

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
		
		return count;
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
			turnOver = false;
			
			return false;
		}
		
		
	}

}
