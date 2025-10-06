package com.carrental.core;

public abstract class Car {
		
	private int cardId;
	private String modelName;
	private CarBrand brand;
	private double basePricePerDay;
	private boolean available;
	static int idCounter = 101;
	
	public Car(String modelName, CarBrand brand, double basePricePerDay, boolean available) {
		super();
		this.cardId = idCounter++;
		this.modelName = modelName;
		this.brand = brand;
		this.basePricePerDay = basePricePerDay;
		this.available = available;
	}
	
	public abstract double calculateRent(int days);
	
	
	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public CarBrand getBrand() {
		return brand;
	}


	public void setBrand(CarBrand brand) {
		this.brand = brand;
	}


	public double getBasePricePerDay() {
		return basePricePerDay;
	}


	public void setBasePricePerDay(double basePricePerDay) {
		this.basePricePerDay = basePricePerDay;
	}


	public boolean isAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}


	public int getCardId() {
		return cardId;
	}


	@Override
	public String toString() {
		return "Car [cardId=" + cardId + ", modelName=" + modelName + ", brand=" + brand + ", basePricePerDay="
				+ basePricePerDay + ", available=" + available + "]";
	}
	
	
	
	
	
}
