package com.sms.ServiceImpl;

import static com.sms.validations.StudentValidateRules.ValidateStudentInputs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;

import com.sms.core.Course;
import com.sms.core.Student;
import com.sms.exception.StudentException;
import com.sms.services.StudentService;

public class StudentServiceImpl implements StudentService {

	ArrayList<Student> students = new ArrayList<>();;

	public StudentServiceImpl() {

//		students.add(new Student("A", "c@gmail.com", 50, Course.valueOf("COREJAVA"), LocalDate.now()));
//		students.add(new Student("b", "a@gmail.com", 90, Course.valueOf("MERN"), LocalDate.now()));
//		students.add(new Student("c", "b@gmail.com", 90, Course.valueOf("DEVOPS"), LocalDate.now()));

	}

	public void serial() {
		try {

			String fileName = "sms.ser";
//			created the file object 	
			FileOutputStream file = new FileOutputStream(fileName);
//			for object output create object output stream passed the file output stream
			ObjectOutputStream out = new ObjectOutputStream(file);

//			we will write into the file 
			out.writeObject(students);

			out.close();
			file.close();
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	public void deserial(String fileNameCustom) throws  Exception {

		

			String fileName;
			if (fileNameCustom.length() == 0) {

				fileName = "sms.ser";
			} else {
				fileName = fileNameCustom;
			}
//			created the file object 	
			FileInputStream file = new FileInputStream(fileName);
//			for object output create objectoutputstream passed the fileoutputstream
			ObjectInputStream in = new ObjectInputStream(file);
//			we will write into the file 
			students = (ArrayList<Student>) in.readObject();
//			System.out.println("From File Student" + students);

			in.close();

		} 



	public static Student findByEmail(String email, ArrayList<Student> students) throws StudentException {
//		first create object  of student initialize with email

		Student stud = new Student(email.toLowerCase().toString());
		int index = students.indexOf(stud);
		if (index == -1) {
			throw new StudentException("Student not found");
		}
		return students.get(index);

	}

	@Override
	public String admitStudent(String name, String email, int marks, String Course) throws StudentException {
		Student newStudent = ValidateStudentInputs(name, email, marks, Course, students);
		students.add(newStudent);

//		capacity need to be reduce

		return "Student Admission Done Successfully";
	}

	@Override
	public void displayAvailableSeats() {
		for (Course c : Course.values()) {
			System.out.println(c + " Capacity " + c.getCourseSeats() + " MARKS " + c.getMinMarks());
		}
	}

	@Override
	public void displayData() throws StudentException {
		if (students.isEmpty()) {
			System.out.println("No Record Found ");
			return;
		}
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Override
	public void cancelAdmission(String email) throws StudentException {
		// first find this student
		Student stud = findByEmail(email, students);
//		then update capacity
		Course course = stud.getCourse();
		course.setCourseSeats(course.getCourseSeats() + 1);
//		then delete the student
		students.remove(stud);

	}

	@Override
	public Student findStudentByEmail(String email) throws StudentException {
		Student s = findByEmail(email, students);
		return s;
	}

	@Override
	public void studentListFilterByCourse(String course) throws StudentException {
//		first get validate course
		Course validCourse = Course.valueOf(course);
//		print using loop where
		ListIterator<Student> it = students.listIterator();
		boolean isFound = false;
		while (it.hasNext()) {
			Student st = it.next();
			if (st.getCourse().toString().equals(validCourse.toString())) {
				isFound = true;
				System.out.println(st);
			}
		}

		if (!isFound) {
			System.out.println("No Record Found for " + validCourse);
		}

	}

	@Override
	public void displayStudentListSortByEmail() {
		Collections.sort(students);

	}

	@Override
	public void displayStudentListSortByName() {
		Collections.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {

				return o1.getName().compareTo(o2.getName());
			}

		});

	}

}
