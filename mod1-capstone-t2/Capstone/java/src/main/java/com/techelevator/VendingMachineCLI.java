package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "EXIT";
	private static final String[] MAIN_MENU_OPTIONS = 
		{ MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_OPTION_EXIT };

	private static final String[] PURCHASE_MENU = { "Feed Money", "Select Product", "Finish Transaction", "Back" };
	private static final String[] MONEY_MENU = { "$1 Bill", "$2 Bill", "$5 Bill", "$10 Bill", "Back" };
	private static final String[] SELECT_PRODUCT_MENU = { "Back" };
	private static final String[] TRANSACTION_COMPLETE_MENU = { "BUY SOME MORE SNACKS!", "EXIT" };

	private Menu menu;
	private MenuItems snacc = new MenuItems();
	private UserMoney usermoney = new UserMoney();
	private SnackStock snackStock = new SnackStock();
	private ChangeMaker changeMaker = new ChangeMaker();
	private PurchaseLog purchaseLog = new PurchaseLog();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
//populates the hashmap
		snacc.snackExtract("A1");
		snackStock.snackStock(snacc.getAllSnacks(), 5);
	}

	public void run() {
		while (true) {
			System.out.println("MAIN MENU");
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayFullMenu();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				displayPurchaseMenu();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Get outta here!");
				System.exit(1);
			}
		}
	}

	private void displayFullMenu() {
		String feedOptions = "";
		System.out.println(snacc.snackDisplay(snackStock.getSnackStockHash()));

		if (feedOptions.equals("Purchase")) {
			displayPurchaseMenu();
		} else if (feedOptions.equals("EXIT")) {
			System.out.println("Have a good one!");
			System.exit(1);
		}
	}

	private void displayPurchaseMenu() {
		String purchaseMenuOption = "";
		while (!purchaseMenuOption.equals("Back")) {
			System.out.println("Current Balance: $" + usermoney.getUserBalance());
			purchaseMenuOption = (String) menu.getChoiceFromOptions(PURCHASE_MENU);
			if (purchaseMenuOption.equals("Feed Money")) {
				displayMoneyFeedMenu();
			} else if (purchaseMenuOption.equals("Select Product")) {
				displaySelectProductMenu();
			} else if (purchaseMenuOption.equals("Finish Transaction")) {
				displayFinishTransactionMenu();
			}
		}
	}

	private void displaySelectProductMenu() {
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		String feedOptions = "";

		System.out.println(snacc.snackDisplay(snackStock.getSnackStockHash()));

		System.out.println("\nCurrent Balance: $" + usermoney.getUserBalance());
		System.out.println("Please enter a snack ID\n(EXAMPLE: A1)");
		String snackSelect = userInput.nextLine();

		try {
			snacc.snackExtract(snackSelect);
			// checks if you have enough money
			BigDecimal bigmoney = new BigDecimal(snacc.getSnackPrice());
			if (usermoney.getUserBalance().compareTo(bigmoney) < 0) {
				System.out.println("INSUFFICIENT FUNDS!");
			}
			if (snackStock.getSnackLeft(snackSelect) == 0) {
				System.out.println("SORRY, OUTTA STOCK!");
			}
			if (usermoney.getUserBalance().compareTo(bigmoney) >= 0 && snackStock.getSnackLeft(snackSelect) > 0) {
				usermoney.subtract(snacc.getSnackPrice());
				snackStock.subtractSnack(snackSelect);
				try {
					purchaseLog.addSnack(snacc.getSnackName(), snacc.getSnackID(), snacc.getSnackPrice(),
							usermoney.getUserBalance().toString());
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("\nTHANK YOU FOR YOUR PURCHASE");
				System.out.println("---" + snacc.getSnackName() + "---$" + snacc.getSnackPrice() + "---");
				System.out.println("Current balance: $" + usermoney.getUserBalance() + "\n");

				if (snacc.getSnackType().equals("Chip")) {
					System.out.println("Crunch Crunch, Yum!");
				}
				if (snacc.getSnackType().equals("Candy")) {
					System.out.println("Munch Munch, Yum!");
				}
				if (snacc.getSnackType().equals("Drink")) {
					System.out.println("Glug Glug, Yum!");
				}
				if (snacc.getSnackType().equals("Gum")) {
					System.out.println("Chew Chew, Yum!");
				}
			}
// Catches all nullPointerExeceptions here
		} catch (NullPointerException e) {
			System.out.println("--INVALID SNACK ID--");
		}
		while (!feedOptions.equals("Back")) {
			feedOptions = (String) menu.getChoiceFromOptions(SELECT_PRODUCT_MENU);
		}
	}

	private void displayMoneyFeedMenu() {
		String feedOptions = "";

		while (!feedOptions.equals("Back")) {
			System.out.println("$" + usermoney.getUserBalance());
			feedOptions = (String) menu.getChoiceFromOptions(MONEY_MENU);

			if (feedOptions.equals("$1 Bill")) {
				usermoney.addOne();
				try {
					purchaseLog.addCash("1.00", usermoney.getUserBalance());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (feedOptions.equals("$2 Bill")) {
				usermoney.addTwo();
				try {
					purchaseLog.addCash("2.00", usermoney.getUserBalance());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (feedOptions.equals("$5 Bill")) {
				usermoney.addFive();
				try {
					purchaseLog.addCash("5.00", usermoney.getUserBalance());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (feedOptions.equals("$10 Bill")) {
				usermoney.addTen();
				try {
					purchaseLog.addCash("10.00", usermoney.getUserBalance());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void displayFinishTransactionMenu() {
		String feedOptions = "";
		String postReset = "0.00";
		while (!feedOptions.equals("Back")) {
			
			System.out.println(changeMaker.change(usermoney.getUserBalance()));
			try {
				purchaseLog.addChange(usermoney.getUserBalance().toString(), postReset);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Change dispensed: $" + usermoney.getUserBalance());
			usermoney.reset();
			
			feedOptions = (String) menu.getChoiceFromOptions(TRANSACTION_COMPLETE_MENU);
			if (feedOptions.equals("BUY SOME MORE SNACKS!")) {
				run();
			} else if (feedOptions.equals("EXIT")) {
				System.out.println("Have a nice day!");
				System.exit(1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("**WELCOME TO SNACK VENDER**");
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
