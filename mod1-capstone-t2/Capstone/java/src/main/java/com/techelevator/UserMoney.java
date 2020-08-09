package com.techelevator;

import java.math.BigDecimal;

public class UserMoney {

	private BigDecimal userBalance = new BigDecimal("0.00");
	
	public BigDecimal getUserBalance() {
		return userBalance;
	}
	
	public BigDecimal addOne() {
		BigDecimal muns = new BigDecimal("1.00");
		return this.userBalance = userBalance.add(muns);
	}
	
	public BigDecimal addTwo() {
		BigDecimal muns = new BigDecimal("2.00");
		return this.userBalance = userBalance.add(muns);
	}
	
	public BigDecimal addFive() {
		BigDecimal muns = new BigDecimal("5.00");
		return this.userBalance = userBalance.add(muns);
	}
	
	public BigDecimal addTen() {
		BigDecimal muns = new BigDecimal("10.00");
		return this.userBalance = userBalance.add(muns);
	}
	
	public BigDecimal subtract(String cost) {
		BigDecimal muns = new BigDecimal(cost);
		return this.userBalance = userBalance.subtract(muns);
	}
	
	public BigDecimal reset() {
		BigDecimal reset = new BigDecimal(this.userBalance.toString());
		return this.userBalance = userBalance.subtract(reset);
	}
}
