package com.shopify.services;

import static com.shopify.services.Validation.*;

import java.util.ArrayList;
import java.util.List;

import com.shopify.core.Customer;
import com.shopify.core.Order;
import com.shopify.exceptions.ECommerceException;
import com.shopify.exceptions.DuplicateResourceException;
import com.shopify.exceptions.InvalidCredentialsException;
import com.shopify.exceptions.ResourceNotFoundException;

public class CustomerServiceImpl implements CustomerService {

	private List<Customer> customers;

	public CustomerServiceImpl() {
		this.customers = new ArrayList<>();
		this.customers.add(new Customer("Sangam", "sangam@gmail.com", "123"));
	}

	@Override
	public String registerCustomer(String name, String email, String password)
			throws DuplicateResourceException, ECommerceException {
		boolean isExist = emailExist(email, customers);
		if (isExist)
			throw new DuplicateResourceException("Email is already present please login");

//		check the email is exist

//		if all pass then add customer to list
		customers.add(new Customer(name, email, password));

		return "user registered successfully";
	}

	@Override
	public Customer loginCustomer(String email, String password) throws ECommerceException {

		boolean isExist = emailExist(email, customers);
		if (!isExist)
			throw new ResourceNotFoundException("Account doesn't exist");

		/*
		 * then find the user then check for password in list we first need the index of
		 * customer where its present then we can get referece of user then we can use
		 * that to check the user passowrd matches or not
		 */
		int index = customers.indexOf(new Customer(email));
//		then get the complete user

		Customer cst = customers.get(index);
		if (!cst.getPassword().equals(password)) {
			throw new InvalidCredentialsException("Invalid Credentials");
		}

//		then now this line execute when upper all things are working fine

		System.out.println(cst);
		return cst;
	}

	@Override
	public void displayAllCustomer() {

		for (Customer cust : customers) {
			System.out.println(cust);
		}

	}

	@Override
	public void AddCustomerOrder(Customer customer, Order order) {

		customer.addOrder(order);

	}

	public List<Order> DisplayAllOrdersOfCustomer(Customer cst) {


		return cst.getOrder();

	}

}
