package com.shopify.exceptions;

@SuppressWarnings("serial")
public class OutOfStockException extends ECommerceException {

	public OutOfStockException(String message) {
		super(message);
	}

}
