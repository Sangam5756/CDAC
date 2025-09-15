package com.shopify.core;

public class Product {

//Product → productId, name, category(enum), price, stock.
//id - system generated
	private int productId;
	private String name;
	private Category category;
	private double price;
	private int stock;

	public static int incrementProductId = 0;

	public Product(String name, Category category, double price, int stock) {
		this.productId = ++incrementProductId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}
	

	public Product(int productId) {
		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return name;
	}

	public void setProductName(String name) {
		this.name = name;
	}

	public Category getProductCategory() {
		return category;
	}

	public void setProductCategory(Category category) {
		this.category = category;
	}

	public double getProductPrice() {
		return price;
	}

	public void setProductPrice(double price) {
		this.price = price;
	}

	public int getProductStock() {
		return stock;
	}

	public void setProductStock(int stock) {
		this.stock = stock;
	}
	
	

	@Override
	public boolean equals(Object obj) {
//		check the object that we received is type Of product
		if (obj instanceof Product) {
//			if yes then downcast to Product
			Product prd = (Product) obj;
//			it will return true if product is same otherwise false
			return this.productId == prd.productId;

		}

		return false;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", stock=" + stock + "]";
	}

}
