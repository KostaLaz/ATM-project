package atm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	private int customerNumber;
	private int pinNumber;
	private double chekingBalance = 0;
	private double savingBalance = 0;
	

	// Get the customer number
	public int getCustomerNumber() {
		return customerNumber;
	}
	
	// Set the customer number
	
	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
		
	}
	
	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public double getChekingBalance() {
		return chekingBalance;
	}

	public void setChekingBalance(int chekingBalance) {
		this.chekingBalance = chekingBalance;
	}

	public double getSaveingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(int saveingBalance) {
		this.savingBalance = saveingBalance;
	}
	
	public double calcCheckingWindraw(double amount) {
		chekingBalance = (int) (chekingBalance - amount);
		return chekingBalance;
	}
	
	public double calcCheckingSaving(double amount) {
		savingBalance = (int) (savingBalance - amount);
		return savingBalance;
	}	
	
	
	//Calculate checking account deposit
	public double calcCheckingDeposit(double amount) {
		chekingBalance = (int) (chekingBalance + amount);
		return chekingBalance;
	}
	
	//Calculate saving account deposit
	public double calcSavingDeposit(double amount) {
         savingBalance = (int) (savingBalance + amount);
        		 return savingBalance;
	}
	
	// Customer checking account windraw input
	public void getCheckingWindrawInput() {
		System.out.println("Checking Account Ballance: " + moneyFormat.format(chekingBalance));
		System.out.println("Amount you want to Windraw From Account: ");
		double amount = input.nextDouble();
		
		if((chekingBalance - amount) >=0) {
			calcCheckingWindraw(amount);
			System.out.println("New Checking account balance is: " + moneyFormat.format(chekingBalance));
		}else {
			System.out.println("The account balance can not be negative." + "\n");
		}
	}
		
		//Customer Saving Account Windraw Input
		public void getSavingWindrawInput() {
			System.out.println("Saving Account Ballance: " + moneyFormat.format(savingBalance));
			System.out.println("Amount you want to Windraw From Saving Account: ");
			double amount = input.nextDouble();
			
			if((savingBalance - amount) >=0) {
				calcCheckingSaving(amount);
				System.out.println("New Saving account balance is: " + savingBalance + "\n");
			}else {
				System.out.println("The account balance can not be negative." + "\n");
			}
		}
		//Customer checking Deposit account Input
		public void getCheckingDepositInput() {
			System.out.println("Checking Account balance: " + moneyFormat.format(chekingBalance));
			System.out.println("Amount you want to deposit from Checking Account");
			double amount = input.nextDouble();
			
			if((chekingBalance + amount) >=0) {
				calcCheckingWindraw(amount);
				System.out.println("New Checking account balance is: " + moneyFormat.format(chekingBalance) + "\n");
			}else {
				System.out.println("The account balance can not be negative." + "\n");
			}
		}
		//Customer Saving Deposit account Input
		public void getSavingDepositInput() {
			System.out.println("Saving Account balance: " + moneyFormat.format(chekingBalance));
			System.out.println("Amount you want to deposit from Saving Account");
			double amount = input.nextDouble();
			
			if((chekingBalance + amount) >=0) {
				calcCheckingWindraw(amount);
				System.out.println("New Saving account balance is: " + moneyFormat.format(chekingBalance) + "\n");
			}else {
				System.out.println("The account balance can not be negative." + "\n");
			}
		}
	

}

