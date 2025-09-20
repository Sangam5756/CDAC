package com.sms.core;

public enum Course {
	COREJAVA(10, 35), DBT(15, 40), PYTHON(10, 60), MERN(40, 70), WEBJAVA(5, 99), DEVOPS(2, 60);

	private int courseSeats;
	private int minMarks;

	Course(int courseSeats, int minMarks) {
		this.courseSeats = courseSeats;
		this.setMinMarks(minMarks);
	}

	public int getCourseSeats() {
		return courseSeats;
	}

	public void setCourseSeats(int courseSeats) {
		this.courseSeats = courseSeats;
	}

	public int getMinMarks() {
		return minMarks;
	}

	public void setMinMarks(int minMarks) {
		this.minMarks = minMarks;
	}
}
