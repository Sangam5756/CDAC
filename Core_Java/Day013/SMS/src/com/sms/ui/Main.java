package com.sms.ui;

import com.sms.ServiceImpl.StudentServiceImpl;
import com.sms.services.StudentService;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentService service = new StudentServiceImpl();
		boolean exit = false;

		while (!exit) {
			System.out.println("\n=== Student Admission System ===");
			System.out.println("1. Admit Student");
			System.out.println("2. Cancel Admission");
			System.out.println("3. Display All Students");
			System.out.println("4. Display Available Seats");
			System.out.println("5. Search Student by Email");
			System.out.println("6. Filter Students by Course");
			System.out.println("7. Sort Students by Email");
			System.out.println("8. Sort Students by Name ");
			System.out.println("9. Exit");
			System.out.print("Enter your choice (1-9): ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			try {
				switch (choice) {
				case 1:
					System.out.print("Enter Student Name: ");
					String name = scanner.nextLine();
					System.out.print("Enter Email: ");
					String email = scanner.nextLine();
					System.out.print("Enter Marks: ");
					int marks = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter Course Name: ");
					String course = scanner.nextLine().toUpperCase();

					service.admitStudent(name, email, marks, course);
					System.out.println(" Student admitted successfully!");
					break;

				case 2:
					System.out.print("Enter Email to cancel admission: ");
					String cancelEmail = scanner.nextLine();
					service.cancelAdmission(cancelEmail);
					System.out.println(" Admission cancelled.");
					break;

				case 3:
					System.out.println("\n--- All Students ---");
					service.displayData();
					break;

				case 4:
					System.out.println("\n--- Available Seats ---");
					service.displayAvailableSeats();
					break;

				case 5:
					System.out.print("Enter Email to search: ");

					System.out.println(service.findStudentByEmail(scanner.nextLine()));

					break;

				case 6:
					System.out.print("Enter Course to filter: ");
					String filterCourse = scanner.nextLine();
					service.studentListFilterByCourse(filterCourse);
					break;

				case 7:
					System.out.println("Sorted Students by Email ");

					service.displayStudentListSortByEmail();
					break;
				case 8:
					System.out.println("Sorted Students by Email ");

					service.displayStudentListSortByName();
					break;

				case 9:
					System.out.println("Exiting... ");
					exit = true;
					break;

				default:
					System.out.println(" Invalid choice. Please try again.");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		scanner.close();
	}
}
