package com.techelevator;

import java.math.BigDecimal;

public class ChangeMaker {

	int quarters = 0;
	int dimes = 0;
	int nickels = 0;
	
	public String change(BigDecimal input) {
	//	Please don't laugh	//
		BigDecimal hundred = new BigDecimal("100.00");
		BigDecimal holder = (input.multiply(hundred));
		int n = holder.intValue();

		while (n >= 25) {
			quarters++;
			n -= 25;
		}
		while (n >= 10) {
			dimes++;
			n -= 10;
		}
		while (	Math.round(n) >= 5) {
			nickels++;
			n -= 5;
		}

		String result = 
				"DISPENSING CHANGE..."
				+ "\n$0.25:\t"+quarters
				+ "\n$0.10:\t"+dimes
				+ "\n$0.05:\t"+nickels
				+ "\n";
		return result;
	}	
	
	public int getQuarters() {
		return quarters;
	}

	public int getDimes() {
		return dimes;
	}

	public int getNickels() {
		return nickels;
	}
}
