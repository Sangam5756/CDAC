package com.shopify.core;

public class OrderItem {
//	OrderItem → product, quantity.

	private Product product;
	private int quantity;

	public OrderItem(Product product, int quantity) {

		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [" + product.toString() + ", quantity=" + quantity + "]";
	}
}
