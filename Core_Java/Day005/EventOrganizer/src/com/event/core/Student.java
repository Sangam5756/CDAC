package com.event.core;

public class Student extends Person {
	private int id;

	private char grade;
	public static int idCount;

	static {
		idCount = 100;
	}

	
	public Student(String firstName, String lastName) {
		super(firstName, lastName);
		id = idCount++;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public char getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "id" + id + " " + "grade=" + grade + super.toString();
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	

}
