package com.college.core;

public class Student extends Person {
	private int year;
	private String courseName;
	private double fees;
	private double marks;
	
	public Student(String firstName, String lastName, int year, String courseName, double fees, double marks) {
		super(firstName, lastName);
		this.year = year;
		this.courseName = courseName;
		this.fees = fees;
		this.marks = marks;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return super.toString() + "\nyear: " + year +
				"\ncourseName: " + courseName +
				"\nfees: " + fees + 
				"\nmarks: " + marks
			;
	}
	
	
	
	
}
