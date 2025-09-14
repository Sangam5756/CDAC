package com.shopify.services;

import com.shopify.core.Customer;
import com.shopify.exceptions.ECommerceException;

public interface OrderService {


	void placeOrder(Customer customer, int productId, int quantity) throws ECommerceException;

	/*
	 * View Customer Orders. Display all orders of logged-in customer Cancel Order
	 * Restore product stock.
	 */
	public void DisplayOrders(Customer customer);

	public void cancelOrder(Customer customer, int orderId) throws ECommerceException;

}
