
package com.carrental.core;

public interface CarService {

	public void addPetrolCar(String modelName, String brand, double basePricePerDay, boolean available,
			double fuelTankCapacity, double mileage);

	public void addEletricCar(String modelName, String brand, double basePricePerDay, boolean available,
			double batteryCapacity, double chargingTime);
	public void displayAllCars();
	public void sortCarByCarIdandBasePricePerDay();
	public void searchExpensiveCar();
	public void removeNotAvailableCar();
	public void updateRentByBrand(String brand,Double newPrice);
	
	public void calculateRent(int days);

}
