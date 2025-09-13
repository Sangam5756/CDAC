package com.bank.service;

import java.util.ArrayList;

import com.bank.core.AccountType;
import com.bank.core.BankAccount;
import com.custome_exceptions.BankException;

public interface BankService {

	public void openAccount(int accountNumber, double balance, String name, String phoneNumber,
			double interestRate, String accountType) throws BankException;

	public ArrayList<BankAccount> accountSummary();
}
