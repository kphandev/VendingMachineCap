package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;

public class PurchaseLog {
String path = "Log.txt";
File f = new File(path);

	public void addSnack(String snackName, String snackID, String cost, String balance) throws IOException {
		Date date = java.util.Calendar.getInstance().getTime();
		StringBuilder purchaseLog = new StringBuilder();
		purchaseLog.append(date 
				+ " Purchase"
				+ "\t" + snackName 
				+ "\t" + snackID 
				+ "\t-" + cost 
				+ "\tBalance:" + balance
				+ "\n"); 
		PrintWriter written = new PrintWriter(new FileOutputStream(f,true));
		written.append(purchaseLog.toString());
		written.close();
	}
	
	public void addCash(String added, BigDecimal balance) throws IOException {
		Date date = java.util.Calendar.getInstance().getTime();
		StringBuilder purchaseLog = new StringBuilder();
		purchaseLog.append(date
				+ " Cash added"
				+ "\t+" + added 
				+ "\tBalance:" + balance.toString() 
				+ "\n");

		PrintWriter written = new PrintWriter(new FileOutputStream(f,true));
		written.append(purchaseLog.toString());
		written.close();
	}
	
	public void addChange(String change, String balance) throws IOException {
		Date date = java.util.Calendar.getInstance().getTime();
		StringBuilder purchaseLog = new StringBuilder();
		purchaseLog.append(date
				+ " Change: "
				+ "+" + change 
				+ "\tBalance:" + balance.toString() 
				+ "\n");

		PrintWriter written = new PrintWriter(new FileOutputStream(f,true));
		written.append(purchaseLog.toString());
		written.close();
	}
}
