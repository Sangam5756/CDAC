package com.carrental.core;

public class Test {

	public static void main(String[] args) {
		 

			CarService carService = new  CarServiceImpl();
			// Petrol Cars
			carService.addPetrolCar("Civic", "Honda", 2500, true, 50, 15);
			carService.addPetrolCar("Corolla", "Toyota", 2400, true, 55, 14);
			carService.addPetrolCar("Mustang", "Ford", 5000, true, 60, 10);
			carService.addPetrolCar("Altis", "Toyota", 2300, false, 50, 16);
			carService.addPetrolCar("City", "Honda", 2200, true, 45, 17);

			// Electric Cars
			carService.addEletricCar("Model 3", "Tesla", 6000, true, 75, 1.5);
			carService.addEletricCar("i3", "BMW", 5500, true, 42, 2.0);
			carService.addEletricCar("Leaf", "Nissan", 4000, false, 40, 2.5);
			carService.addEletricCar("e-Tron", "Audi", 6500, true, 95, 2.0);
			carService.addEletricCar("Mustang Mach-E", "Ford", 7000, true, 88, 2.5);

			
//			carService.displayAllCars();
//			carService.sortCarByCarIdandBasePricePerDay();
//			carService.removeNotAvailableCar();
//			carService.displayAllCars();
//			carService.searchExpensiveCar();
//			carService.updateRentByBrand("Honda", 10000.0);
//			carService.displayAllCars();
		
	}

}
