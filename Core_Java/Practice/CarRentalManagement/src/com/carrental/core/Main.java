package com.carrental.core;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		try (Scanner sc = new Scanner(System.in)) {

			CarService carService = new CarServiceImpl();

//				first show the menu
			int ch;
			do {

				System.out.println("1.Add Petrol Car");
				System.out.println("2.Add Electric Car");
				System.out.println("3.Display All Cars");
				System.out.println("4.SortCarByPriceId");
				System.out.println("5.Search Most Expensive Car");
				System.out.println("6.Remove unavailable cars");
				System.out.println("7.Update rent by Brand");
				System.out.println("8. Exit");
				System.out.println("\n Enter the choice : ");

				ch = sc.nextInt();

				try {

					switch (ch) {

					case 1: {

//						add the electric car
						String modelName, brand;
						double basePricePerDay, fuelTankCapacity, mileage;
//					boolean available;

						System.out.println("Enter the Model Name : ");
						modelName = sc.next();

						System.out.println("Enter the Brand Name :");
						brand = sc.next();

						System.out.println("Enter the Base Price Per Day:");
						basePricePerDay = sc.nextDouble();

						System.out.println("Available Or Not true/false");

						boolean inStock = sc.nextBoolean();

						System.out.println("Enter the FuleTankCapacity :");
						fuelTankCapacity = sc.nextDouble();

						System.out.println("Enter the Mileage :");
						mileage = sc.nextDouble();

//						add petrol car
						carService.addPetrolCar(modelName, brand, basePricePerDay, inStock, fuelTankCapacity, mileage);
						break;

					}
					case 2: {

						String modelName, brand;

						double basePricePerDay, batteryCapacity, chargingTime;

						System.out.println("Enter the Model Name : ");
						modelName = sc.next();

						System.out.println("Enter the Brand Name :");
						brand = sc.next();

						System.out.println("Enter the Base Price Per Day:");
						basePricePerDay = sc.nextDouble();

						System.out.println("Enter the BatteryCapacity :");
						batteryCapacity = sc.nextDouble();

						System.out.println("Available Or Not true/false");

						boolean inStock = sc.nextBoolean();

						System.out.println("Enter the ChargingTime:");
						chargingTime = sc.nextDouble();

						carService.addEletricCar(modelName, brand, basePricePerDay, inStock, batteryCapacity,
								chargingTime);
						break;

					}

					case 3: {

						carService.displayAllCars();
						break;
					}

					case 4: {
						carService.sortCarByCarIdandBasePricePerDay();
						break;

					}
					case 5: {
						carService.searchExpensiveCar();
						break;
					}

					case 6: {
						carService.removeNotAvailableCar();
						break;
					}

					case 7: {
						String brand;
						System.out.println("Enter the Brand names : ");
						brand = sc.next();
						double price;
						System.out.println("Enter the new Base Price : ");
						price = sc.nextDouble();
						carService.updateRentByBrand(brand, price);
						break;
					}
					case 8: {
							carService.calculateRent(4);
					}

					case 9: {
						break;
					}

					}

				} catch (Exception e) {
					System.out.println(e);
				}
			} while (ch != 0);

		}
	}
}
