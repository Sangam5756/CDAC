package com.event.core;

public class Faculty extends Person {

	private int facultyId;
	public static int idIncrement;
	String comment;
	String facName;

	static {
		idIncrement = 1000;
	}


	public Faculty(String firstName, String lastName, String facName) {
		super(firstName, lastName);
		this.setFacultyId(++idIncrement);
		this.facName = facName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

}
