package com.bank.service;

import com.bank.core.AccountType;
import com.bank.core.BankAccount;
import com.custome_exceptions.BankException;

import static com.bank.service.BankValidation.*;

public class BankServiceImpl implements BankService {

	private BankAccount accounts[];
	private int counter;

	public BankServiceImpl(int size) {
		this.accounts = new BankAccount[size];

	}

	@Override
	public void openCurrentAccount(int accountNumber, double balance, String name, String phoneNumber,
			double overdraftLimit, AccountType accountType) {

		System.out.println("sdfds");

	}

	@Override
	public void openSavingAccount(int accountNumber, double balance, String name, String phoneNumber,
			double interestRate, String accountType) throws BankException {

		BankAccount b = ValidateAccountDetails(accountNumber, balance, name, phoneNumber, interestRate, phoneNumber,
				accounts);
		accounts[counter++] = b;
	}

	@Override
	public String accountSummary() {
		return null;
	}

}
