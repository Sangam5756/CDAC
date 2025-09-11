package com.bank.service;

import com.bank.core.AccountType;
import com.bank.core.BankAccount;
import com.bank.core.SavingAccount;
import com.custome_exceptions.BankException;

public class BankValidation {

	public static BankAccount ValidateAccountDetails(int accountNumber, double balance, String name, String phoneNumber,
			String accountType, BankAccount acc[]) throws BankException {

		validateAccountNumber(accountNumber, acc);

		return new SavingAccount(accountNumber, balance, name, phoneNumber, 7, AccountType.valueOf(accountType));
	}

	public static void validateAccountNumber(int accountNumber, BankAccount acc[]) throws BankException {
		BankAccount bank = new BankAccount(accountNumber);

		for (BankAccount b : acc) {
			if (b != null) {
//				call the equals method
				if (b.equals(acc)) {
					throw new BankException("Duplicate Account Number ");
				}
			}
		}

	}

}
