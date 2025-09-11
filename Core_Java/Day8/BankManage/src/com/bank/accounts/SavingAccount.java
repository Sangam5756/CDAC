package com.bank.accounts;

import com.exceptions.BalanceOutOfBoundException;

public class SavingAccount extends BankAccount{
	private double interestRate;

	public SavingAccount(double balance, String name, String phoneNumber, double interestRate) {
		super(balance , name, phoneNumber);
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
		double interestAmount = currentBalance * (this.interestRate /100);
		super.setBalance(currentBalance + interestAmount);
	}
	
	public void withdraw(double amount) throws BalanceOutOfBoundException {
		double currentBalance = super.getBalance();
		if (currentBalance <= 1000 ) {
			throw new BalanceOutOfBoundException("Please maintain minimum balance..!");
		} else if ((currentBalance - 1000) >= amount ) {
			currentBalance -= amount;
			super.setBalance(currentBalance);
			
		} else {
			 throw new BalanceOutOfBoundException("Cannot withdraw amount from account..! jkjkjk");
		}
	}

	public String getAccountSummary() {
		return super.getAccountSummary() + "\nInterest Rate: " + interestRate;
	}
}
