package com.bank.accounts;

public class CurrentAccount extends BankAccount {
	private double overdraftLimit;
	private double defaultDraftLimit = 5000;

	public CurrentAccount(double balance, String name, String phoneNumber) {
		super(balance, name, phoneNumber);
		this.overdraftLimit = defaultDraftLimit;
	}

	public void useOverdraftFacility(double amount) {
		if ((getBalance() - 1000) <= 0) {
			if (overdraftLimit < defaultDraftLimit && amount < defaultDraftLimit && amount <= overdraftLimit) {

				this.setOverdraftLimit(this.overdraftLimit - amount);

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