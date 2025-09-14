package com.shopify.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends ECommerceException {

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
