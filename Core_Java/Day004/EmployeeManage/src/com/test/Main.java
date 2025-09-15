package com.test;

import java.util.Scanner;

import com.org.employee.Employee;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the Organization Size : ");

//		get input from user
		Employee[] org = new Employee[sc.nextInt()];
		int index = 0;
		int ch;
		do {

			System.out.println("\n1. Add Employee");
			System.out.println("2. getDetails");
			System.out.println("3. get Total Employee Salary");
			System.out.println("4. Salary Raise");
			System.out.println("5. Max Employee Salary");
			System.out.print("Enter the Choice :");
			ch = sc.nextInt();

			switch (ch) {
			case 1 -> {
				if (index == org.length) {
					System.out.println("Organization Closed");
				} else {

					System.out.println("Enter the FullName Salary DeptId : ");
					String name = sc.next();
					double salary = sc.nextDouble();
					int deptid = sc.nextInt();
					org[index] = new Employee(name, salary, deptid);
					index++;
				}

			}
			case 2 -> {
				for (Employee e : org) {
					if (e != null) {
						System.out.println(e.toString());
					}
				}
			}
			case 3 -> {
				int sum = 0;
				for (Employee e : org) {
					if (e != null) {
						sum += e.getSalary();

					}
				}
				System.out.println("Total Organization Deduction of All Employee :" + sum);

			}
			case 4 -> {
				System.out.println("Enter the DeptId  and salary to raise : ");
				int deptid = sc.nextInt();
				double raise = sc.nextDouble();
				
				for (Employee e : org) {
					if (e != null)
						if(e.getDeptId() == deptid) {
							double incrementSal = e.getSalary() * (raise / 100);
							System.out.println(incrementSal);
							e.setSalary(e.getSalary() + incrementSal);
						}
				}
				System.out.println("Employee salaries with dept id" + deptid + "is increment by" + raise);

			}

			case 5 -> {
				double maxSal = 0;
				Employee ref = null;
				for (Employee e : org) {
					if (e != null) {
						if (e.getSalary() > maxSal) {
							maxSal = e.getSalary();
							ref = e;
						}
					}
				}

				System.out.println("Total Organization Deduction of All Employee :" + ref.toString());

			}

			default -> System.out.println("Invalid choice ");

			}

		} while (ch != 0);

	}
}
