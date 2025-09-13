package com.bank.utils;

import java.util.ArrayList;

import com.bank.core.AccountType;
import com.bank.core.BankAccount;
import com.bank.core.CurrentAccount;
import com.bank.core.SavingAccount;
import com.custome_exceptions.BankException;

public class BankValidation {

	public static BankAccount ValidateAccountDetails(int accountNumber, double balance, String name, String phoneNumber,
			String accountType, double rateOrDraft, ArrayList<BankAccount> acc) throws BankException {

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

	public static void validateAccountNumber(int accountNumber, ArrayList<BankAccount> acc) throws BankException {
		BankAccount bank = new BankAccount(accountNumber);

		if (acc.contains(bank)) {
			throw new BankException("Duplicate Account Number ");

		}

	}

}
