package com.actions;

import com.bank.accounts.*;

public class TestBanking {
	public static void main(String[] args) {
		SavingAccount ba = new SavingAccount(200,"Kirtesh", "1234567890", 7);
		System.out.print(ba.getAccountSummary());
		ba.applyInterest();
		System.out.print(ba.getAccountSummary());
		
		System.out.println();
		CurrentAccount ca = new CurrentAccount(300,"Kirtesh", "1234567890", 100);
		System.out.print(ca.getAccountSummary());

	}
}
