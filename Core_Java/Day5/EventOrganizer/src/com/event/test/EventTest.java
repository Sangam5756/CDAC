package com.event.test;

import java.util.Scanner;

import com.event.core.Faculty;
import com.event.core.Person;
import com.event.core.Student;

public class EventTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Person[] person = new Person[100];
		int index = 0;
		int ch;
		do {
			System.out.println("\n");
			System.out.println("1. Register Student : ");
			System.out.println("2. Register Faculty ");
			System.out.println("3. Display All Participants Details : ");
			System.out.println("4. Search Participant : ");
			System.out.println("5. Evaluate Student : ");
			System.out.println("6. Submit FeedBack : ");
			System.out.println("\n");
			System.out.print("Enter the Choice : ");
			ch = sc.nextInt();

			switch (ch) {
//				for creating the saving account with default balance
			case 1: {
				System.out.println("Enter the FirstName : ");
				String firstName = sc.nextLine();
				sc.nextLine();
				System.out.println("Enter the Last Name : ");
				String lastName = sc.nextLine();

				Person p = new Student(firstName, lastName);
				person[index] = p;
				index++;

				break;
			}
			case 2: {

				System.out.println("Enter the FacultyName: ");
				String facName = sc.nextLine();

				sc.nextLine();

				System.out.println("Enter the FirstName : ");
				String firstName = sc.nextLine();

				System.out.println("Enter the Last Name : ");
				String lastName = sc.nextLine();

				Person p = new Faculty(firstName, lastName, facName);
				person[index] = p;
				index++;

				break;
			}

			case 3: {
				System.out.println("All Participants Details : ");
				for (Person p : person) {
					if (p != null)
						System.out.println(p.toString());
				}
				break;
			}
			case 4: {
				System.out.println("Enter the Id to Search : ");
				int sid = sc.nextInt();
				boolean found = false;
				for (Person p : person) {
					if (p != null) {
						if (p instanceof Student) {
							Student s = (Student) p;
							if (s.getId() == sid) {
								found = true;
								System.out.println(p.toString());
							}
						} else if (p instanceof Faculty) {
							Faculty f = (Faculty) p;
							if (f.getId() == sid) {
								found = true;
								System.out.println(p.toString());
							}

						}
					}
				}
				if (!found) {
					System.out.println("Participants not Found ");
				}
				break;
			}
			case 5: {
				System.out.println("Enter the Student INdo: ");
				int sid = sc.nextInt();
				boolean found = false;
				for (Person p : person) {
					
					if (p != null) {
						if (p instanceof Student) {
							Student s = (Student) p;
							if (s.getId() == sid) {
								found = true;
								System.out.println(p.toString());
							}
						} else if (p instanceof Faculty) {
							Faculty f = (Faculty) p;
							if (f.getId() == sid) {
								found = true;
								System.out.println(p.toString());
							}

						}
					}
				}
				if (!found) {
					System.out.println("Participants not Found ");
				}
				break;
			}
			case 6:{
				
				System.out.println("Enter the Student No ");
				break;
				
			}

			default:
				System.out.println("Invalid Input");
			}

		} while (ch != 0);

	}

}
