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
						+ "\n7.Close Account \n8.applyinterest \n9.PrintPhoneNumberByAccountType \n10.SortTheRecord by Account Number \n11.Delete All Accounts");
				System.out.println("Enter the Choice ");

				ch = sc.nextInt();

				try {
					switch (ch) {
					case 1: {
						System.out.print("Enter Account Number: ");
						int accNo = sc.nextInt();
						System.out.print("Enter Initial Balance: ");
						double balance = sc.nextDouble();
						System.out.print("Enter Name: ");
						String name = sc.next();
						System.out.print("Enter Mobile Number: ");
						String mobile = sc.next();

						bankService.openAccount(accNo, balance, name, mobile, 7, "SAVING");
						break;
					}
					case 2: {
						System.out.print("Enter Account Number: ");
						int accNo = sc.nextInt();
						System.out.print("Enter Initial Balance: ");
						double balance = sc.nextDouble();
						System.out.print("Enter Name: ");
						String name = sc.next();
						System.out.print("Enter Mobile Number: ");
						String mobile = sc.next();

						bankService.openAccount(accNo, balance, name, mobile, 5000, "CURRENT");
						break;
					}
					case 3: {
						System.out.println("Account Details:");
						for (BankAccount b : bankService.accountSummary())
							System.out.println(b.getAccountSummary());
						break;
					}
					case 4: {
						System.out.print("Enter Account Number: ");
						int accNo = sc.nextInt();
						System.out.print("Enter Amount to Withdraw: ");
						double amt = sc.nextDouble();
						System.out.println(bankService.withdraw(accNo, amt));
						break;
					}
					case 5: {
						System.out.print("Enter Account Number: ");
						int accNo = sc.nextInt();
						System.out.print("Enter Amount to Deposit: ");
						double amt = sc.nextDouble();
						System.out.println(bankService.deposit(accNo, amt));
						break;
					}
					case 6: {
						System.out.print("Enter Source Account Number: ");
						int src = sc.nextInt();
						System.out.print("Enter Destination Account Number: ");
						int dest = sc.nextInt();
						System.out.print("Enter Amount to Transfer: ");
						double amt = sc.nextDouble();
						System.out.println(bankService.transferAmount(src, dest, amt));
						break;
					}
					case 7: {
						System.out.print("Enter Account Number to Close: ");
						int accNo = sc.nextInt();
						String Confirm = sc.next().toLowerCase();
						if(Confirm.equals("y"))
						System.out.println(bankService.closeAccount(accNo));
						break;
					}
					case 8: {
						System.out.println(bankService.applyInterest());
						break;
					}
					case 9: {
						System.out.print("Enter Account Type (SAVING/CURRENT): ");
						String type = sc.next();
						System.out.print("Enter Minimum Balance: ");
						double balance = sc.nextDouble();
						bankService.displayPhoneNumberFilterByBalanceAndAccountType(type, balance);
						break;
					}
					case 10: {
						bankService.SortByAccountNos();
						break;
					}
					case 11: {
						System.out.println(bankService.closeAllAccounts());
						break;
					}
					case 0: {
						System.out.println("Exiting...");
						break;
					}
					default:
						System.out.println("Invalid Choice!");
					}
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}

			} while (ch != 0);

		}
	}
}
