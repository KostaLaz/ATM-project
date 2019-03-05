package atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account {

	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

	int selection;

	// Validate login information, customer number and pin number

	public void getLogin() throws IOException{
		int x = 1;

		do {
			try {
				data.put(0000, 0000);
				data.put(1111, 1111);
				data.put(2222, 2222);

				System.out.println("Welcome to the ATM project");
				
				System.out.println("Enter your Customer Number");
				setCustomerNumber(menuInput.nextInt());

				System.out.println("Enter your pin number");
				setPinNumber(menuInput.nextInt());
			} catch (Exception e) {
				System.out.println("\n" + "Invalid character/s, numbers only" + "\n");
				x = 2;

				for (Entry<Integer, Integer> entry : data.entrySet()) {
					if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
						
						getAccountType();
					}
				}
				System.out.println("\n" + " Wrong Customer number or PIN number" + "\n");
			}
			
		} while (x == 1);
	}

	// Display Account type with menu selections
	public void getAccountType() {
		System.out.println("Select the account you want to access");
		System.out.println("Type 1 - Checking account");
		System.out.println("Type 2 - Saving account");
		System.out.println("Type 3 - Deposit founds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice:");

		selection = menuInput.nextInt();

		switch (selection) {

		case 1:
			getCheking();
			break;

		case 2:
			getSaving();
			break;

		case 3:
			System.out.println("Thank you for using our ATM");
			break;

		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
			getAccountType();
		}

	}

	//Display Checking account Menu With Selections
	public void getCheking() {

		System.out.println("Checking account");
		System.out.println("Type 1 - View balance");
		System.out.println("Type 2 - Windraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice");

		selection = menuInput.nextInt();

		switch (selection) {

		case 1:
			System.out.println("Saving Account Balance: " + moneyFormat.format(getChekingBalance()));
			getAccountType();
			break;

		case 2:
			getCheckingWindrawInput();
			getAccountType();

		case 3:
			getCheckingWindrawInput();
			getAccountType();
			break;

		case 4:
			System.out.println("Thank you for using our ATM");
			break;

		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
			getSaving();

		}
	}

	//Display Savings Account Menu With Selections
	public void getSaving() {

		System.out.println("Checking account");
		System.out.println("Type 1 - View balance");
		System.out.println("Type 2 - Windraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice");

		switch (selection) {

		case 1:
			System.out.println("Saving Account Balance: " + moneyFormat.format(getSaveingBalance()));
			getAccountType();
			break;

		case 2:
			getSavingWindrawInput();
			getAccountType();

		case 3:
			getCheckingWindrawInput();
			getAccountType();
			break;

		case 4:
			System.out.println("Thank you for using our ATM");
			break;

		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
			getSaving();

		}

	}

}
