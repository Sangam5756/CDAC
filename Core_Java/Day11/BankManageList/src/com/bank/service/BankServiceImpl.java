package com.bank.service;

import com.bank.core.AccountType;
import com.bank.core.BankAccount;
import com.custome_exceptions.BankException;

import static com.bank.utils.BankValidation.*;

import java.util.ArrayList;

public class BankServiceImpl implements BankService {

	private ArrayList<BankAccount> accounts = new ArrayList<>();

	

	@Override
	public void openAccount(int accountNumber, double balance, String name, String phoneNumber,
			double interestRate, String accountType) throws BankException {

		BankAccount b = ValidateAccountDetails(accountNumber, balance, name, phoneNumber, accountType, interestRate,
				accounts);
		accounts.add(b);
	}

	@Override
	public ArrayList<BankAccount> accountSummary() {
		
		return accounts;

	}

}
