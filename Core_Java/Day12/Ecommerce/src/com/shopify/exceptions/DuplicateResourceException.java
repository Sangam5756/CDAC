package com.shopify.exceptions;

@SuppressWarnings("serial")
public class DuplicateResourceException extends ECommerceException {

	public DuplicateResourceException(String message) {
		super(message);
	}

}
