package com.hashset.core;

public class Product {
	private int id;
	private String name;
	private Category category;
	private int stock;
	private double price;

	public Product(int id, String name, Category category, int stock, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.stock = stock;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", stock=" + stock + ", price="
				+ price + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Product) {
			Product pd = (Product) obj;
			return (id == pd.id) && (this.category.equals(pd.category));
		}

		return false;

	}

	@Override
	public int hashCode() {
		return (id * 29) + category.hashCode();
	}

}
