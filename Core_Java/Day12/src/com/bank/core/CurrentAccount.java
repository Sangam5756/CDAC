package com.bank.core;

public class CurrentAccount extends BankAccount {
	private double overdraftLimit = 5000;

	public CurrentAccount(int accountNumber,double balance, String name, String phoneNumber, double overdraftLimit,
			AccountType accountType) {
		super(accountNumber,balance, name, phoneNumber, accountType);
		this.overdraftLimit = overdraftLimit;
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("Withdrawal amount must be positive.");
			return;
		}

		double availableFunds = super.getBalance() + overdraftLimit;

		if (availableFunds >= amount) {
			super.setBalance(super.getBalance() - amount);
			System.out.println(
					"Overdraft used. Withdrawal of " + amount + " successful. New balance is " + super.getBalance());
		} else {
			System.out
					.println("Insufficient funds. Withdrawal amount exceeds the available limit of " + availableFunds);
		}
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public String toString() {
		return super.toString() + "\nOverdraft Limit: " + overdraftLimit;
	}

}
