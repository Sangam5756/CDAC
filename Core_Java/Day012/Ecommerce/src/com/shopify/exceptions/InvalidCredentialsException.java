package com.shopify.exceptions;

@SuppressWarnings("serial")
public class InvalidCredentialsException extends ECommerceException {

	public InvalidCredentialsException(String message) {
		super(message);
	}

}
