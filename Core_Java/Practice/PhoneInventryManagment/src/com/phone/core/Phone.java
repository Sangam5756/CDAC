package com.phone.core;

public class Phone implements Comparable<Phone> {
	int phone_id;
	String ModelName, Brand;
	int rating;
	boolean inStock;
	PhoneType phoneType;
	double Price;
	static int idCounter = 101;

	public Phone( String modelName, String brand, int rating, boolean inStock, PhoneType phoneType,
			double price) {
		
		this.phone_id = idCounter++;
		ModelName = modelName;
		Brand = brand;
		this.rating = rating;
		this.inStock = inStock;
		this.phoneType = phoneType;
		Price = price;
	}

	public int getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}

	public String getModelName() {
		return ModelName;
	}

	public void setModelName(String modelName) {
		ModelName = modelName;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Phone [phone_id=" + phone_id + ", ModelName=" + ModelName + ", Brand=" + Brand + ", rating=" + rating
				+ ", inStock=" + inStock + ", phoneType=" + phoneType + ", Price=" + Price + "]";
	}
	
//	this abstract method from the comparable to implement the natural order sorting
	public int compareTo(Phone obj) {
		return Integer.compare(phone_id, obj.getPhone_id());
		
	}

}
