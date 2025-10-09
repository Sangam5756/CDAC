package com.carrental.core;

import java.util.HashMap;

public class CarServiceImpl implements CarService {

	HashMap<Integer, Car> cars = new HashMap<>();

	@Override
	public void addPetrolCar(String modelName, String brand, double basePricePerDay, boolean available,
			double fuelTankCapacity, double mileage) {

		CarBrand validBrand = CarBrand.valueOf(brand.toUpperCase());

		Car newPetrolCar = new PetrolCar(modelName, validBrand, basePricePerDay, available, fuelTankCapacity, mileage);

		cars.put(newPetrolCar.getCardId(), newPetrolCar);

	}

	@Override
	public void addEletricCar(String modelName, String brand, double basePricePerDay, boolean available,
			double batteryCapacity, double chargingTime) {
		CarBrand validBrand = CarBrand.valueOf(brand.toUpperCase());

		Car newElectricCar = new ElectricCar(modelName, validBrand, basePricePerDay, available, batteryCapacity,
				chargingTime);
		cars.put(newElectricCar.getCardId(), newElectricCar);

	};

	@Override
	public void displayAllCars() {
		cars.forEach((k, v) -> System.out.println(k + " " + v));
	}

	@Override
	public void sortCarByCarIdandBasePricePerDay() {
		// TODO Auto-generated method stub
		cars.values().stream().sorted((o1, o2) -> {
			int compareId = Double.compare(o1.getBasePricePerDay(), o2.getBasePricePerDay());
			;
//			we the price is equalsort based on id
			if (compareId != 0)
				return compareId;
			return Integer.compare(o1.getCardId(), o2.getCardId());

		}).forEach(car -> System.out.println(car));

	}

	@Override
	public void searchExpensiveCar() {
		// TODO Auto-generated method stub
		cars.values().stream().max((o1, o2) -> Double.compare(o1.getBasePricePerDay(), o2.getBasePricePerDay()))
				.ifPresent(p -> System.out.println(p));

	}

	@Override
	public void removeNotAvailableCar() {
		// TODO Auto-generated method stub

		cars.entrySet().removeIf(car -> !car.getValue().isAvailable());

	}

	@Override
	public void updateRentByBrand(String brand, Double newPrice) {
		// TODO Auto-generated method stub
//		we can use the filter to search the all cars by brand name
		cars.values().stream().filter((p) -> p.getBrand().equals(brand)).forEach(p -> p.setBasePricePerDay(newPrice));
	}

	@Override
	public void calculateRent(int days) {
		for (Car car : cars.values()) {
			System.out.println(car.calculateRent(5));
		}

	}

}
