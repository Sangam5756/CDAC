package com.shopify.core;

import java.util.ArrayList;
import java.util.List;

public class Order {

//	 orderId, customer, list of ordered items.
	private int orderId;
	private Customer customer;
	private List<OrderItem> orderItems;
	public static int IncrementOrderId = 100;

	public Order(Customer customer, OrderItem OrderItem) {
		this.orderId = ++IncrementOrderId;
		this.customer = customer;
		this.orderItems = new ArrayList<>();
		this.orderItems.add(OrderItem);
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + (customer != null ? customer.getId() : "null")
				+ ", orderItems=" + orderItems + "]";
	}

}
