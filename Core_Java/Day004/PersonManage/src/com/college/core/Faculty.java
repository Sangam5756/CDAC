package com.college.core;

public class Faculty extends Person {
	private int yearOfExp;
	private String sme; // Subject Matter Expertise
	
	public Faculty(String firstName, String lastName, int yearOfExp, String sme) {
		super(firstName, lastName);
		this.yearOfExp = yearOfExp;
		this.sme = sme;
	}

	public int getYearOfExp() {
		return yearOfExp;
	}

	public void setYearOfExp(int yearOfExp) {
		this.yearOfExp = yearOfExp;
	}

	public String getSme() {
		return sme;
	}

	public void setSme(String sme) {
		this.sme = sme;
	}

	@Override
	public String toString() {
		return super.toString() + "\nyearOfExp: " + yearOfExp + 
				"\nsme: " + sme ;
	}

	

}
