package com.actions;

import java.util.Scanner;

import com.bank.core.AccountType;
import com.bank.service.BankService;
import com.bank.service.BankServiceImpl;

public class BankTest {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {


			

			BankService bank = new BankServiceImpl(3);

		
			bank.openSavingAccount(101, 1000, "dummy", "1254456565", 7, "SAVING");
			bank.openSavingAccount(101, 1000, "dummy", "1254456565", 7, "SAVING");
		
		
				

			

				
				

				

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
