package com.bank.accounts;

import com.exceptions.BalanceOutOfBoundException;

public class BankAccount {
	private int accountNumber;
	private double balance;
	private String name;
	private String phoneNumber;
	private static int accountNumberIncrement;

	static {
		accountNumberIncrement = 10000;
	}

	public BankAccount(double balance, String name, String phoneNumber) {
		this.accountNumber = ++accountNumberIncrement;
		this.balance = balance;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}

	public void withdraw(double amount) throws BalanceOutOfBoundException {
		if (this.balance > 0) {
			this.balance -= amount;
		} else {
			 throw new BalanceOutOfBoundException("Cannot withdraw amount from account..! jkjkjk");
		}
	}

	public String getAccountSummary() {
		return "\nAccount Number: " + accountNumber + "\nname: " + name + "\nbalance: " + balance + "\nphoneNumber: "
				+ phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
