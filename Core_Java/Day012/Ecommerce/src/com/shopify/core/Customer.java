package com.shopify.core;

import java.util.ArrayList;
import java.util.List;

public class Customer {
//		id, name, email, password, list of orders.
	private int id;
	private String name, email, password;
	private List<Order> orders;
	public static int incrementId;

	static {
		incrementId = 0;
	}

	public Customer(String name, String email, String password) {
		this.id = ++incrementId;
		this.name = name;
		this.email = email;
		this.password = password;
//		as customer is new so initialize empty list
		this.orders = new ArrayList<>();
	}

	@Override
	public boolean equals(Object obj) {
// check the object is instance of Customer to safely downcasting
		if (obj instanceof Customer) {
//			downcast to Customer
			Customer cust = (Customer) obj;
			return this.email.equals(cust.email);
		}
		return false;
	}

	public Customer(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrder() {
		return orders;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}

	@Override
	public String toString() {
		return "Customer id=" + id + ", name=" + name + ", email=" + email;
	}

}
