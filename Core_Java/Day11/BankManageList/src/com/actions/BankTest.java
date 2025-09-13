package com.actions;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.core.BankAccount;
import com.bank.service.BankService;
import com.bank.service.BankServiceImpl;

public class BankTest {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			BankService bank = new BankServiceImpl();

			bank.openAccount(101, 1000, "dummy", "1254456565", 7, "SAVING");
			bank.openAccount(102, 1000, "dummy", "1254456565", 7, "SAVING");
			bank.openAccount(103, 1000, "dummy", "1254456565", 7, "CURRENT");
			bank.openAccount(104, 1000, "dummy", "1254456565", 7, "SAVING");

			for (BankAccount b : bank.accountSummary()) {
				System.out.println(b.getAccountSummary());
				System.out.println(b.getBalance());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
