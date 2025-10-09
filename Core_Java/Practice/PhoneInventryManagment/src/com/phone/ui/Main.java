package com.phone.ui;

import java.util.Scanner;

import com.phone.service.PhoneService;
import com.phone.service.PhoneServiceImple;

public class Main {

	public static void main(String args[]) {

		PhoneService phoneService = new PhoneServiceImple();
  try {
	phoneService.addMobile("Poco", "POCOM7", 5, false, "SMARTPHONE", 1200);
	phoneService.addMobile("SAMSUNG", "SAM", 3, true, "FEATURE_PHONE", 1200);
	phoneService.addMobile("REDMI", "MI", 1,false, "FEATURE_PHONE", 1200);
	phoneService.addMobile("ASUS", "ASUS", 4, true, "FOLDABLE", 1200);

} catch (Exception e) {
	
	e.printStackTrace();
}

		try (Scanner sc = new Scanner(System.in)) {



//			need the do while loop for the menu
			int ch;
			do {
				System.out.println("1.add New Mobile ");
				System.out.println("2.Display all Mobile details");
				System.out.println("3.Display all Mobile details sorted by Phone_Id");
				System.out.println("4.Search the Mobile which is least expensive in the inventory");
				System.out.println("5.Remove Mobiles that are not in stock");
				System.out.println("6.Update Mobile price based on ModelName");
				System.out.println("7.Sort Mobile data as per price in ascending order");
				System.out.println("8.EXIT");
				System.out.println("Enter the Choice : ");

				ch = sc.nextInt();

				try {
//				here need switch case start
					switch (ch) {

					case 1: {
						String modelName, phoneType, brand;
						int rating;
						boolean inStock;
						double price;
//						add the mobile phone

						System.out.println("Enter the Model Name of Phone : ");
						modelName = sc.next();

						System.out.println("Enter the Brand name : ");
						brand = sc.next();

						System.out.println("Phone Type [SMARTPHONE, FEATURE_PHONE, FOLDABLE]: ");
						phoneType = sc.next();

						System.out.println("Phone inStock or Not [True,False]");
						inStock = sc.nextBoolean();

						System.out.println("Enter the Phone Price");
						price = sc.nextDouble();

						System.out.println("Enter the Rating 1-5");
						rating = sc.nextInt();

						phoneService.addMobile(modelName, brand, rating, inStock, phoneType, price);

						break;
					}

					case 2: {
//						display the mobile phone
						phoneService.displayAllMobile();
						break;
					}
					case 3: {
//						display all mobile sorted by id
						phoneService.displayAllMobileSortedById();
						break;
					}

					case 4: {
//						display least expensive mobile
						phoneService.searchLeastExpensive();
						break;

					}

					case 5: {
//						remove all out of stock phone
						phoneService.removeAllOutofStockPhone();
						break;
					}

					case 6: {
//						update the price based on the model name
						String modelName;
						double price;
						System.out.println("Enter the Model Name");
						modelName = sc.next();
						System.out.println("Enter the Price");
						price = sc.nextDouble();
						phoneService.updateMobilePriceByModelName(modelName, price);
						break;
					}
					case 7: {
//						sort the mobile phones based on the price in ascending order
						phoneService.displayAllMobileSortByPriceAscending();
						break;
					}

					case 8: {
						System.out.println("Exited Program SuccessFully");
						break;
					}

					}
//				switch case end

				} catch (Exception e) {
					sc.nextLine();
					System.err.println(e);
				}

			} while (ch != 8);

		}

	}
}
