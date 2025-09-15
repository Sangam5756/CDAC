package com.actions;

import java.util.Scanner;

import com.bank.core.BankAccount;
import com.bank.service.BankService;
import com.bank.service.BankServiceImpl;

public class BankTest {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			BankService bankService = new BankServiceImpl();
			int ch;

			do {
				System.out.println("1.Open Saving Account " + "\n2.Open current account \n"
						+ "3.Display Accounts \n4.Withdraw " + "\n5.deposit \n6.transfer amount "
						+ "\n7.Close Account \n8.applyinterest \n9.PrintPhoneNumberByAccountType \n10.SortTheRecord by Account Number \n 11.Delete All Accounts");
				System.out.println("Enter the Choice ");
				ch = sc.nextInt();
				try {
					switch (ch) {

					case 1:
						System.out.println("Enter the Account Number, initialBalance name mobileNumber : ");
						bankService.openAccount(106, 2000, "dummy1", "1254456565", 7, "SAVING");
						bankService.openAccount(102, 1000, "dummy2", "1254456565", 7, "SAVING");
						break;

					case 2:
						System.out.println("Enter the Account Number, initialBalance name mobileNumber : ");
						bankService.openAccount(101, 1000, "dummy1", "1254456565", 5000, "current");
						bankService.openAccount(104, 1000, "dummy2", "1254456565", 5000, "current");
						break;

					case 3:
						System.out.println("Account Details ");
						for (BankAccount b : bankService.accountSummary())
							System.out.println(b.getAccountSummary());
						break;

					case 4:
						System.out.println(bankService.withdraw(103, 500));
						break;

					case 5:
						System.out.println(bankService.deposit(103, 1000));
						break;

					case 6:
						System.out.println(bankService.transferAmount(101, 102, 1000));
						break;

					case 7:
						System.out.println(bankService.closeAccount(101));
						break;
					case 8:
						System.out.println(bankService.applyInterest());
						break;
					case 9:
						bankService.displayPhoneNumberFilterByBalanceAndAccountType("SAVING", 200);
						break;
					case 10:
						bankService.SortByAccountNos();
						break;
					case 11:
						System.out.println(bankService.closeAllAccounts());
						break;

					default:
						System.out.println("Invalid Choice ");

					}
				} catch (Exception e) {
					System.out.println(e);
				}

			} while (ch != 0);

		}
	}
}
