package com.cms.tester;

import java.util.Scanner;

public class cms {

	public static void main(String args[]) {

		int capacity;

		System.out.println("Enter the Number Of Customer : ");
		int ch;

		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("Enter the Choice : ");
				ch = sc.nextInt();

			} while (ch != 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
