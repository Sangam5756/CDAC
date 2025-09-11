package com.actions;

import java.util.Scanner;

import com.bank.core.AccountType;
import com.bank.service.BankService;
import com.bank.service.BankServiceImpl;

public class BankTest {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter the Number of Accounts to Create ");

			int size = sc.nextInt();

			BankService bank = new BankServiceImpl(size);

			int ch;
			do {
				System.out.println("\n");
				System.out.println("1. Create Account : ");

				System.out.println("\n");

				System.out.print("Enter the Choice : ");
				ch = sc.nextInt();

				switch (ch) {

				case 1: {
					try {
						bank.openSavingAccount(101, 1000, "dummy", "1254456565", 7, "SAVING");
						
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}

				}

					break;

				default:
					System.out.println("Invalid Input");
				}

			} while (ch != 0);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
