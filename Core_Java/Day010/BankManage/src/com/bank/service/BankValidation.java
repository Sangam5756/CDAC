package com.bank.service;

import com.bank.core.AccountType;
import com.bank.core.BankAccount;
import com.bank.core.CurrentAccount;
import com.bank.core.SavingAccount;
import com.custome_exceptions.BankException;

public class BankValidation {

	public static BankAccount ValidateAccountDetails(int accountNumber, double balance, String name, String phoneNumber,
			String accountType, double rateOrDraft, BankAccount acc[]) throws BankException {

		AccountType type = AccountType.valueOf(accountType);
		System.out.println(type);
		validateAccountNumber(accountNumber, acc);

		if (type == AccountType.SAVING) {
			
			return new SavingAccount(accountNumber, balance, name, phoneNumber, 7, type);
			
		} else if (type == AccountType.CURRENT) {
			
			return new CurrentAccount(accountNumber, balance, name, phoneNumber, rateOrDraft, type);
		}
		
		
		return null;

	}

	public static void validateAccountNumber(int accountNumber, BankAccount acc[]) throws BankException {
		BankAccount bank = new BankAccount(accountNumber);
		for (BankAccount b : acc) {
			if (b != null) {
				if (b.equals(bank)) {
					throw new BankException("Duplicate Account Number ");
				}
			}
		}

	}

}
