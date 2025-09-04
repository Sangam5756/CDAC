package com.bank.accounts;

public class CurrentAccount extends BankAccount {
	private double overdraftLimit = 5000;
	
	public CurrentAccount(double balance, String name, String phoneNumber, double overdraftLimit) {
		super(balance, name, phoneNumber);
		this.overdraftLimit = overdraftLimit;
	}

	public void useOverdraftFacility(double amount) {
		if(this.getBalance() <= 0) {
			if(overdraftLimit >= this.getBalance()) {
				double getBalance = this.getBalance() - amount;
				 this.setBalance(getBalance);
			}
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
