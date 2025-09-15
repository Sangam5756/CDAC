package com.bank.accounts;

public class SavingAccount extends BankAccount {
	private double interestRate = 7;

	public SavingAccount(double balance, String name, String phoneNumber, double interestRate) {
		super(balance, name, phoneNumber);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void applyInterest() {
		double currentBalance = super.getBalance();
		double interestAmount = currentBalance * (this.interestRate / 100);
		super.setBalance(currentBalance + interestAmount);
	}

	public void withdraw(double amount) {
		double currentBalance = super.getBalance();
		if (currentBalance <= 1000) {
			System.out.print("Please maintain minimum balance..!");
		} else if ((currentBalance - 1000) >= amount) {
			currentBalance -= amount;
			setBalance(currentBalance);
		} else {
			System.out.println("Cannot withdraw amount from account..!");
		}
	}

	public String getAccountSummary() {
		return super.getAccountSummary() + "\nInterest Rate: " + interestRate;
	}
}