package com.actions;

import java.util.Scanner;

import com.bank.accounts.BankAccount;
import com.bank.accounts.CurrentAccount;
import com.bank.accounts.SavingAccount;
import com.exceptions.BalanceOutOfBoundException;

public class TestBanking {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BankAccount[] bank = new BankAccount[100];
		int index = 0;
		int ch;
		do {
			System.out.println("\n");
			System.out.println("1. Create Saving Account : ");
			System.out.println("2. Create Current Account : ");
			System.out.println("3. View Account : ");
			System.out.println("\n");

			System.out.print("Enter the Choice : ");
			ch = sc.nextInt();

			switch (ch) {
//			for creating the saving account with default balance
			case 1: {
				System.out.println("1. Enter the Account Holder FullName  : ");
				 String name = sc.next(); // Use next() instead of nextLine() to avoid the issue
				    sc.nextLine(); 
				System.out.println("1. Enter the Mobile Number : ");
				String PhoneNumber = sc.nextLine();
//				calling SavingBank Account Constructor	
				BankAccount saving = new SavingAccount(1000, name, PhoneNumber, 7);
				bank[index] = saving;
				index++;
				System.out.println("\n\nAccount Successfully Created : ");
				System.out.println("Account Number is : " + saving.getAccountSummary());

				break;
			}
			case 2: {
				System.out.println("1. Enter the Account Holder FullName  : ");
				String name = sc.nextLine();
				sc.nextLine();
				System.out.println("1. Enter the Mobile Number : ");
				String PhoneNumber = sc.nextLine();
//				 calling CurrentBank Account Constructor	
				BankAccount current = new CurrentAccount(1000, name, PhoneNumber, 5000);
				bank[index] = current;
				index++;

				System.out.println("\n\nAccount Successfully Created : ");
				System.out.println("Account Number is : " + current.getAccountSummary());

				break;
			}

			case 3: {
				System.out.println("1. Enter Account Number : ");
				int accNo = sc.nextInt();
				boolean found = false;
				for (BankAccount acc : bank) {
					int choice;
					if (acc != null) {
						if (acc.getAccountNumber() == accNo) {
							found = true;
							if (acc instanceof SavingAccount) {
								SavingAccount savingAcc = (SavingAccount) acc;
								do {
									System.out.println("\n Account Type : Saving \n" + savingAcc.getAccountSummary());

//								here we can add all saving account related operation

									System.out.println("\n");
									System.out.println("1. Deposit Amount");
									System.out.println("2. Withdraw");
									System.out.println("3. Check InterestRate ");
									System.out.println("4. Check Balance ");
									System.out.println("5. Go back");
									System.out.println("\n");
									System.out.print("Enter the Choice : ");
									choice = sc.nextInt();
									switch (choice) {
									case 1: {

										System.out.println("Enter the amount To deposit");
										int amount = sc.nextInt();
										savingAcc.deposit(amount);
										break;
									}
									case 2: {

										System.out.println("Enter the amount To WithDraw");
										int amount = sc.nextInt();
										try {
											savingAcc.withdraw(amount);
										} catch (BalanceOutOfBoundException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}

										break;
									}
									case 3: {
										System.out.println("------------------------------------");
										System.out.println("Your Account Balace is : " + savingAcc.getBalance());
										System.out.println("------------------------------------");
										break;
									}
									case 4: {
										System.out.println("Your Account Balace is : " + savingAcc.getBalance());
										break;
									}
									default:
										System.out.println("Invalid choice ");
										break;

									}
								} while (choice != 5);

							}
							if (acc instanceof CurrentAccount) {

								CurrentAccount currentAcc = (CurrentAccount) acc;
								do {

									System.out.println("\n Account Type : Current \n" + currentAcc.getAccountSummary());

//								here we can add all saving account related operation

									System.out.println("\n");
									System.out.println("1. Deposit Amount");
									System.out.println("2. Withdraw");
									System.out.println("3. Check Balance  ");
									System.out.println("4. Check Overdraft Limit");
									System.out.println("5. Go back");
									System.out.println("\n");
									System.out.print("Enter the Choice : ");
									choice = sc.nextInt();
									switch (choice) {
									case 1: {

										System.out.println("Enter the amount To deposit");
										int amount = sc.nextInt();
										currentAcc.deposit(amount);
										break;
									}
									case 2: {

										System.out.println("Enter the amount To WithDraw");
										int amount = sc.nextInt();
										currentAcc.withdraw(amount);

										break;
									}
									case 3: {
										System.out.println("------------------------------------");
										System.out.println("Your Account Balace is : " + currentAcc.getBalance());
										System.out.println("------------------------------------");
										break;
									}
								
									case 4: {
										System.out
												.println("Your OverDraft Limit is : " + currentAcc.getOverdraftLimit());
										break;
									}
									default:
										System.out.println("Invalid choice ");
										break;

									}
								} while (choice != 5);

							}

						}
					}

				}
				if (!found) {
					System.out.println("Account Not Found");
				}

				break;
			}

			default:
				System.out.println("Invalid Input");
			}

		} while (ch != 0);

	}


}
