package com.bank.service;

import com.bank.core.AccountType;
import com.custome_exceptions.BankException;

public interface BankService {

	public void openCurrentAccount(int accountNumber, double balance, String name, String phoneNumber,
			double overdraftLimit, AccountType accountType);

	public void openSavingAccount(int accountNumber, double balance, String name, String phoneNumber,
			double interestRate, String accountType) throws BankException;

	public String accountSummary();
}
