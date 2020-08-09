package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuItems {

	private String snackID;
	private String snackName;
	private String snackPrice;
	private String snackType;
	private List<String> allSnacks = new ArrayList<String>();
	int j;

	// // //

	StringBuilder result = new StringBuilder();
	String holder = "";
	String path = "Vendingmachine.csv";
	File inputFile = new File(path);

	// wtf are these array sizes, was I drunk?
	String[] snack = new String[1];
	String[] snackValues = new String[4];
	
	public String snackDisplay(Map<String, Integer> map) {
		for (int i = 1; i <= 16; i++) {
			snackValues = snack[i].split("\\|");
			snackID = snackValues[0];
			snackName = snackValues[1];
			snackPrice = snackValues[2];
			snackType = snackValues[3];
			
			if (snackName.length() < 5) {
				System.out.println(snackID 
						+ "|" + snackName
						+ "\t\t\t|\t" + snackPrice
						+ "\t|\t" + snackType
						+ "\t|\t" + map.get(snackID));
				}
			else if (snackName.length() < 13) {
			System.out.println(snackID 
					+ "|" + snackName
					+ "\t\t|\t" + snackPrice
					+ "\t|\t" + snackType
					+ "\t|\t" + map.get(snackID));
			} else if (snackName.length() >= 13){
			System.out.println(snackID 
						+ "|" + snackName
						+ "\t|\t" + snackPrice
						+ "\t|\t" + snackType
						+ "\t|\t" + map.get(snackID));
			}
		}
		return "";
	}

	public String snackSplitter() throws FileNotFoundException {
		if (inputFile.exists()) {
			System.out.println("");
		}
		if (!inputFile.exists()) {
			System.out.println("--File NOT Found--");
		}

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(inputFile);
		while (scan.hasNextLine()) {
			holder = scan.nextLine();
			result.append("\n" + holder);
			// add hashmap onto end of this
		}
		return result.toString();
	}

	public void snackExtract(String userID) {
		try {
			snackSplitter();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// splits lines into each snack
		this.snack = result.toString().split("\\\n");
		// cycles thru each snack for ID
		for (int i = 1; i <= 16; i++) {
			snackValues = snack[i].split("\\|");
			snackID = snackValues[0];
			allSnacks.add(snackID);
			if (snackID.equals(userID)) {
				j = i;
			}
		}
		snackValues = snack[j].split("\\|");
		snackID = snackValues[0];
		snackName = snackValues[1];
		snackPrice = snackValues[2];
		snackType = snackValues[3];

	}

	public String getSnackID() {
		return snackID;
	}

	public String getSnackName() {
		return snackName;
	}

	public String getSnackPrice() {
		return snackPrice;
	}

	public String getSnackType() {
		return snackType;
	}

	public List<String> getAllSnacks() {
		return allSnacks;
	}

}
