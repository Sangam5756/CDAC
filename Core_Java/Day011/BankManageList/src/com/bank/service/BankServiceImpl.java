package com.bank.service;

import static com.bank.service.BankValidation.ValidateAccountDetails;

import java.util.ArrayList;
import java.util.Collections;

import com.bank.core.AccountType;
import com.bank.core.BankAccount;
import com.bank.core.CurrentAccount;
import com.bank.core.SavingAccount;
import com.custome_exceptions.BankException;
import com.custome_exceptions.InsufficientBalance;

public class BankServiceImpl implements BankService {

	private ArrayList<BankAccount> accounts = new ArrayList<>();

	@Override
	public String openAccount(int accountNumber, double balance, String name, String phoneNumber, double interestRate,
			String accountType) throws BankException {

		BankAccount b = ValidateAccountDetails(accountNumber, balance, name, phoneNumber, accountType, interestRate,
				accounts);
		accounts.add(b);

		return accountType + "Account Created Successfull";
	}

	@Override
	public ArrayList<BankAccount> accountSummary() {

		return accounts;

	}

	private BankAccount findAccountByAccountNumber(int accountNumber) throws BankException {
		BankAccount b = new BankAccount(accountNumber);
		int index = accounts.indexOf(b);
		if (index == -1) {
			throw new BankException("Account Not Found !!");
		}
//		find the account by Index that we got 
		BankAccount bank = accounts.get(index);

		return bank;

	}

	@Override
	public String withdraw(int accountNumber, double amount) throws BankException, InsufficientBalance {

		BankAccount bank = findAccountByAccountNumber(accountNumber);
//		withdraw amount from account
//		 check the type of account
		if (bank instanceof SavingAccount) {
//			if bank is saving then downCast to SavinAccount
			SavingAccount saveAcc = (SavingAccount) bank;
			saveAcc.withdraw(amount);
		} else if (bank instanceof CurrentAccount) {
//			if bank is saving then downCast to currAccount
			CurrentAccount currAcc = (CurrentAccount) bank;
			currAcc.withdraw(amount);
		}

		return "SuccessFull Withdrawl of Amount " + amount;
	}

	@Override
	public String deposit(int accountNumber, double amount) throws BankException {

		BankAccount bank = findAccountByAccountNumber(accountNumber);

		bank.deposit(amount);

		return "Successfull deposit of Amount " + amount;

	}

	@Override
	public String transferAmount(int currentAccountNumber, int destAccountNumber, double amount)
			throws InsufficientBalance, BankException {

//		1.first step find the check whether accounts exits or not
//		2. store the return ref in bankref variable 
		BankAccount currBank = findAccountByAccountNumber(currentAccountNumber);
		BankAccount destBank = findAccountByAccountNumber(destAccountNumber);

//		3. check the balance of current user as we already did in core class balance check
//		4. then deduct from current and add into destaccountNumber
//		5. update the Balance of CurrentUser if Successfull transfer
		currBank.withdraw(amount);

		destBank.setBalance(destBank.getBalance() + amount);

		return "FundTransferSuccessfull";
	}

	@Override
	public String closeAccount(int accountNumber) throws BankException {

		BankAccount b = findAccountByAccountNumber(accountNumber);
//			if the account is Exist then delete it
		accounts.remove(b);

		return "You Have Closed Your Account";
	}

	@Override
	public String applyInterest() {

//		see here find all the account where type is saving and apply the interest 
//		 but we need to downcast because list stores Two types of Account saving and current
//		 and apply interest is functionality is saving specific;
		for (BankAccount b : accounts) {
			if (b instanceof SavingAccount) {
				((SavingAccount) b).applyInterest();
			}
		}

		return "Successfully Applied the interest";
	}

	@Override
	public String displayPhoneNumberFilterByBalanceAndAccountType(String accountType, double min_balance) {

//		first need to parse the accountType
		AccountType type = AccountType.valueOf(accountType);

		System.out.println(type == AccountType.CURRENT);

//			display number of user where balance is greater than specific
		for (BankAccount bank : accounts) {
			if (bank.getBalance() > min_balance && bank.getAccountType() == type) {
				System.out.println(bank.getPhoneNumber());
			}
		}

		return null;
	}

	
	@Override
	public void SortByAccountNos() {
		Collections.sort(accounts);

	}

	@Override
	public String closeAllAccounts() {

		accounts.clear();

		return "All Account Closed";
	}

}
