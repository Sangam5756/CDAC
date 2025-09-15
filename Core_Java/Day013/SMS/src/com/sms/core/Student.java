package com.sms.core;

import java.time.LocalDate;

public class Student implements Comparable<Student> {
	private int id;
	private String name;
	private String email;
	private int marks;
	private Course course;
	private LocalDate admissionDate;
	private static int autoIncId;

	static {
		autoIncId = 0;
	}

	public Student(String name, String email, int marks, Course course, LocalDate admissionDate) {
		this.id = ++autoIncId;
		this.name = name;
		this.email = email;
		this.marks = marks;
		this.course = course;
		this.admissionDate = admissionDate;
	}

	public Student(String email) {
		this.email = email;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Student) {
			Student stud = (Student) o;
			return this.email.equals(stud.email);
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student Details: \nAdmissions ID: " + id + "\n | name: " + name + "\n | email: " + email
				+ "\n | marks: " + marks + "\n | course: " + course + "\n | admissionDate: " + admissionDate;
	}

	@Override
	public int compareTo(Student o) {

		return this.email.compareTo(o.email);
	}

}
