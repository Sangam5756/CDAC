//package com.shoe.ui;
//
//import com.shoe.services.*;
//
//public class test {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		try {
//			ShoeService service = new ShoeserviceImpl(40);
////			int ch;
////			do {
////				System.out.println("Enter the choice ");
////				System.out.println("1.");
//////			service.displayAllShoes();
//////			service.displayAllShoeSortByid();
//////			service.searchShoeById(207);
//////			service.removeNotAvailableShoe();
//////			update price
//////			service.updateShoePrice(2100, 10000);
//////			System.out.println("\n\n");
//////			service.displayAllShoes();
//////			service.sortShoeDescByPrice();
////				try {
////
////
////				} catch (Exception e) {
////
////				}
////			} while (ch != 0);
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//	}
//
//}
package com.shoe.ui;

import java.util.Scanner;

import com.shoe.services.ShoeService;
import com.shoe.services.ShoeserviceImpl;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		try {
			// Instantiate the ShoeService implementation with a size of 40.
			ShoeService service = new ShoeserviceImpl(40);
			int ch;

			do {
				System.out.println("----- Shoe Service Test Menu -----");
				System.out.println("1. Display all shoes");
				System.out.println("2. Display all shoes sorted by ID");
				System.out.println("3. Search for a shoe by ID");
				System.out.println("4. Remove unavailable shoes");
				System.out.println("5. Update shoe price");
				System.out.println("6. Sort shoes by price (descending)");
				System.out.println("0. Exit");
				System.out.print("Enter your choice: ");

				ch = scanner.nextInt();

				switch (ch) {
				case 1:
					service.displayAllShoes();
					break;
				case 2:
					service.displayAllShoeSortByid();
					break;
				case 3:
					System.out.print("Enter the Shoe ID to search for: ");
					int searchId = scanner.nextInt();
					service.searchShoeById(searchId);
					break;
				case 4:
					service.removeNotAvailableShoe();
					System.out.println("Unavailable shoes have been removed.");
					break;
				case 5:
					System.out.print("Enter the Product Id: ");
					int id = scanner.nextInt();
					System.out.print("Enter the new price: ");
					int newPrice = scanner.nextInt();
					service.updateShoePrice(id, newPrice);
					System.out.println("Shoe prices updated.");
					break;
				case 6:
					service.sortShoeDescByPrice();
					break;
				case 0:
					System.out.println("Exiting program. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 0 and 6.");
					break;
				}
				System.out.println("\n");
			} while (ch != 0);
		} catch (Exception e) {

			System.err.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		} finally {

			scanner.close();
		}
	}
}