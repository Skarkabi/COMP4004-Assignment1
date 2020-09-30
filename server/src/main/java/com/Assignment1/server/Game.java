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
		
		if((s.equals("Coin") && FC.equals("CO") ||
				(s.equals("Diamond") && FC.equals("DI")))) {
			count++;
			
		}
		
		
		return count;
	}
	
	public boolean fullChest(int d) {
		if((FC.equals("CO") && getSymbolCount("Coin") != 9) || 
				(FC.equals("DI") && getSymbolCount("Diamond") != 9)) {
			d = d - 1;
		}
		
		System.out.println(d);
		
		if(d == 8) {
			return true;
			
		}else {
			return false;
		}
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
