package com.cms.tester;

import java.time.LocalDate;

import com.cms.core.Customer;
import com.cms.core.ServicePlan;

public class Main {

	public static void main(String[] args) {
		Customer c1 = new Customer("K", "A", "k@gmail.com", "Kirtesh", 1000, LocalDate.parse("2002-10-02"),
				ServicePlan.SILVER);
		Customer c2 = new Customer("K", "A", "k@gmail.com", "Kirtesh", 1000, LocalDate.parse("2002-10-02"),
				ServicePlan.SILVER);
		Customer c3 = new Customer("K", "A", "ka@gmail.com", "Kirtesh", 1000, LocalDate.parse("2002-10-02"),
				ServicePlan.SILVER);

		String result = c1.toString();
		String result2 = c2.toString();
		System.out.print(result);
		System.out.print(result2);

		
		System.out.println("\n\nBoth Are Equal = " + c3.equals(c3));
	}

}
