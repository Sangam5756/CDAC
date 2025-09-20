package com.sms.validations;

import java.time.LocalDate;
import java.util.ArrayList;

import com.sms.core.Course;
import com.sms.core.Student;
import com.sms.exception.StudentException;

public class StudentValidateRules {
	public static final int MAX_MARKS = 100;

	public static Student ValidateStudentInputs(String name, String email, int marks, String course,
			ArrayList<Student> students) throws StudentException {
		Course validCourse = Course.valueOf(course.toUpperCase());
		int courseCapacity = validCourse.getCourseSeats();

//		
		if (courseCapacity <= 0) {
			throw new StudentException("Admission to This " + validCourse + " is Full");
		}

//		validate email
		duplicateEmail(students, email);

//		marks check
		if (marks < validCourse.getMinMarks()) {
			throw new StudentException("Admission Rejected due to low marks !!");
		} else if (marks > MAX_MARKS) {
			throw new StudentException("Enter the valid marks");
		}

//		if right then  admit the student
		validCourse.setCourseSeats(validCourse.getCourseSeats() - 1);

//		return the student
		return new Student(name, email, marks, validCourse, LocalDate.now());
//		
	}

	public static void duplicateEmail(ArrayList<Student> students, String email) throws StudentException {
		Student studEmailExists = new Student(email);
		if (students.contains(studEmailExists)) {
			throw new StudentException("Email already Exists");
		}
	}
}
