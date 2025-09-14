package com.shopify.services;

import java.util.List;

import com.shopify.core.Customer;
import com.shopify.core.Order;
import com.shopify.exceptions.ECommerceException;
import com.shopify.exceptions.DuplicateResourceException;

public interface CustomerService {

//	registercustomer logc

	public String registerCustomer(String name, String email, String password)
			throws DuplicateResourceException, ECommerceException;

	public Customer loginCustomer(String email, String password) throws ECommerceException;

	public void displayAllCustomer();

	public void AddCustomerOrder(Customer customer, Order order);

	public List<Order> DisplayAllOrdersOfCustomer(Customer cst);
}
