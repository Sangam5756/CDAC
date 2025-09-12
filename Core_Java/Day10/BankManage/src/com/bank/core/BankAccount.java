package com.bank.core;

import com.custome_exceptions.InsufficientBalance;

public class BankAccount {
	private int accountNumber;
	private double balance;
	private String name;
	private String phoneNumber;
	private AccountType accountType;

	public BankAccount(int accountNumber, double balance, String name, String phoneNumber, AccountType accountType) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.accountType = accountType;
	}

	public BankAccount(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}

	public void withdraw(double amount) throws InsufficientBalance {
		if (this.balance > 0) {
			this.balance -= amount;
		} else {
			throw new InsufficientBalance("Cannot withdraw amount from account..! jkjkjk");
		}
	}

	public String getAccountSummary() {
		return "\nAccount Number: " + accountNumber + "\nname: " + name + "\nbalance: " + balance + "\nphoneNumber: "
				+ phoneNumber + "\n AccountType" + accountType;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BankAccount) {
			BankAccount acc = (BankAccount) obj;
			return this.accountNumber == acc.accountNumber;
		}
		return false;

	}

}
