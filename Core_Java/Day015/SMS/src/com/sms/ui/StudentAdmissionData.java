package com.sms.ui;

import java.util.Scanner;

import com.sms.ServiceImpl.StudentServiceImpl;
import com.sms.services.StudentService;

public class StudentAdmissionData {
	public static void main(String[] args) {
		try {
			StudentService service = new StudentServiceImpl();
//			to print all capacities

			service.admitStudent("D", "d@gmail.com", 90, "mern");

			service.displayData();
//			service.displayAvailableSeats();
			Scanner sc = new Scanner(System.in);
			System.out.println("find user by the email ");
			System.out.println(service.findStudentByEmail(sc.next()));

			service.studentListFilterByCourse("MERN");
			System.out.println("\n\n After cancel");

			service.displayData();
			service.displayAvailableSeats();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
