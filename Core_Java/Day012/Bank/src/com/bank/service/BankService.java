package com.bank.service;

import java.util.ArrayList;

import com.bank.core.BankAccount;
import com.custome_exceptions.BankException;
import com.custome_exceptions.InsufficientBalance;

public interface BankService {

	public String openAccount(int accountNumber, double balance, String name, String phoneNumber, double interestRate,
			String accountType) throws BankException;

	public ArrayList<BankAccount> accountSummary();

	public String withdraw(int accountNumber, double amount) throws InsufficientBalance, BankException;

	public String deposit(int accountNumber, double amount) throws BankException;

	public String transferAmount(int currentAccointNumber, int destAccountNumber, double amount)
			throws InsufficientBalance, BankException;

	public String closeAccount(int accountNumber) throws BankException;

	public String applyInterest();

	public String displayPhoneNumberFilterByBalanceAndAccountType(String accountType, double balance);
	
	public void SortByAccountNos() ;
	public String closeAllAccounts();

}
