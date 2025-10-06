package com.carrental.core;

public class ElectricCar extends Car {

	private double batteryCapacity;
	private double chargingTime;

	public ElectricCar(String modelName, CarBrand brand, double basePricePerDay, boolean available,
			double batteryCapacity, double chargingTime) {
		super(modelName, brand, basePricePerDay, available);
		this.batteryCapacity = batteryCapacity;
		this.chargingTime = chargingTime;
	}

	@Override
	public double calculateRent(int days) {
		return getBasePricePerDay() * days - (batteryCapacity * 0.5);

	}

	public double getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public double getChargingTime() {
		return chargingTime;
	}

	public void setChargingTime(double chargingTime) {
		this.chargingTime = chargingTime;
	}

	@Override
	public String toString() {
		return "ElectricCar [batteryCapacity=" + batteryCapacity + ", chargingTime=" + chargingTime + ", toString()="
				+ super.toString() + "]";
	}

}
