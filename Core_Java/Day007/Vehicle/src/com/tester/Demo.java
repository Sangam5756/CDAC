package com.tester;

import java.util.Scanner;
import static com.validations.ValidateSpeedRules.*;

public class Demo {

	public static void main(String[] args)
	 /*throws SpeedOutOfRangeException*/  {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!exit) {
				System.out.println("1. Validate Speed 0. Exit");
				System.out.println("Enter option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter vehicle speed");
						validateSpeed(sc.nextInt());
						break;
					case 0:
						exit = true;
						break;
					}
				}
					catch (Exception e) {
					//to 
				    sc.nextLine();
					e.printStackTrace();
				}
				System.out.println("while loop continues.....");
			}
		} // sc.close()

		System.out.println("main over....");
}
}
	
