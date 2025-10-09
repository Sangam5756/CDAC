package com.carrental.core;

public class PetrolCar extends Car {
	double fuelTankCapacity;
	double mileage;

	public PetrolCar(String modelName, CarBrand brand, double basePricePerDay, boolean available, double fuelTankCapacity,
			double mileage) {
		super(modelName, brand, basePricePerDay, available);
		this.fuelTankCapacity = fuelTankCapacity;
		this.mileage = mileage;
	}

	public double getFuelTankCapacity() {
		return fuelTankCapacity;
	}

	public void setFuelTankCapacity(double fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}

	public double getMileage() {
		return mileage;
	}
	

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

		

	@Override
	public String toString() {
		return "PetrolCar [fuelTankCapacity=" + fuelTankCapacity + ", mileage=" + mileage + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public double calculateRent(int days) {
		
		return getBasePricePerDay() * days + (fuelTankCapacity*0.2);
	}
	
	
	

}
