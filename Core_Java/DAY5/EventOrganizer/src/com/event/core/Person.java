package com.event.core;

public class Person {
	private String firstName;
	private String LastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		LastName = lastName;
	}

	@Override
	public String toString() {
		return "firstName=" + firstName + ", LastName=" + LastName;
	}

}
