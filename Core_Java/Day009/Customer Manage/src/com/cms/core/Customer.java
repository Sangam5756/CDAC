package com.cms.core;

import java.time.LocalDate;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private double registerationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int AutoIncrementedId;

	static {
		AutoIncrementedId = 1;
	}

	public Customer(String firstName, String lastName, String email, String password, double registerationAmount,
			LocalDate dob, ServicePlan plan) {
		this.id = AutoIncrementedId++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.registerationAmount = registerationAmount;
		this.dob = dob;
		this.email = email;
		this.plan = plan;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Customer) {

			return this.email == ((Customer) obj).email;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Customer Details:  \nid=" + id + ",\nfirstName=" + firstName + ",\nlastName=" + lastName + ",\nEmail="
				+ email + ",\npassword=" + password + ",\nregisterationAmount=" + registerationAmount + ",\ndob=" + dob
				+ ",\nplan=" + plan;
	}

}
