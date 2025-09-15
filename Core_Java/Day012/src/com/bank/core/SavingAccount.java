package com.bank.core;

import com.custome_exceptions.InsufficientBalance;

public class SavingAccount extends BankAccount {
	private double interestRate;

	public SavingAccount(int accountNumber, double balance, String name, String phoneNumber, double interestRate,
			AccountType accountType) {
		super(accountNumber, balance, name, phoneNumber, accountType);
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

	public void withdraw(double amount) throws InsufficientBalance {
		double currentBalance = super.getBalance();
		if (currentBalance <= 1000) {
			throw new InsufficientBalance("Please maintain minimum balance..!");
		} else if ((currentBalance - 1000) >= amount) {
			currentBalance -= amount;
			super.setBalance(currentBalance);

		} else {
			throw new InsufficientBalance("Cannot withdraw amount from account..! jkjkjk");
		}
	}

	public String getAccountSummary() {
		return super.getAccountSummary() + "\nInterest Rate: " + interestRate;
	}
}
