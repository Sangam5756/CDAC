package com.shopify.services;

import java.util.List;

import com.shopify.core.Customer;

public class Validation {

	public static boolean emailExist(String email, List<Customer> customers) {

		/*
		 * check the email is present or not to check that we need to override the
		 * equals method of Object class if we dont then we get fully qualify classname
		 * with hashcode
		 */
//		equals method need argument customer class object
		Customer emailObject = new Customer(email);
		for (Customer cust : customers) {
			if (cust.equals(emailObject)) {
				return true;
			}
		}

		return false;
	}

}
