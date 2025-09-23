package com.shoe.core;

public class Shoe implements Comparable<Shoe> {
			
	int shoeId,ratings;
	String name,brand;
	double price;
	boolean available;
	ShoeType shoetype;
//	need constructor to initilize //	need constructor to initilize 
	public Shoe(int shoeId, int ratings, String name, String brand, double price, boolean available,
			ShoeType shoetype) {
		
		this.shoeId = shoeId;
		this.ratings = ratings;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.available = available;
		this.shoetype = shoetype;
	}
	@Override
	public String toString() {
		return "Shoe [shoeId=" + shoeId + ", ratings=" + ratings + ", name=" + name + ", brand=" + brand + ", price="
				+ price + ", available=" + available + ", shoetype=" + shoetype + "]";
	}
	public int getShoeId() {
		return shoeId;
	}
	public void setShoeId(int shoeId) {
		this.shoeId = shoeId;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public boolean setPrice(double price) {
		this.price = price;
		return true;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public ShoeType getShoetype() {
		return shoetype;
	}
	public void setShoetype(ShoeType shoetype) {
		this.shoetype = shoetype;
	}
	@Override
	public int compareTo(Shoe o) {
		
		return ((Integer)this.shoeId).compareTo(o.shoeId);
		
	}
	
	

		
	
}
