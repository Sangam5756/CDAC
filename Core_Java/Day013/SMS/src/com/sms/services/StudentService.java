package com.sms.services;

import com.sms.core.Student;
import com.sms.exception.StudentException;

public interface StudentService {
	public String admitStudent(String name, String email, int marks, String Course) throws StudentException;

	public Student findStudentByEmail(String email) throws StudentException;

	void displayAvailableSeats();

	public void displayData() throws StudentException;

	public void cancelAdmission(String email) throws StudentException;

	public void studentListFilterByCourse(String course)throws StudentException;
	public void displayStudentListSortByEmail();
	public void displayStudentListSortByName();
}
