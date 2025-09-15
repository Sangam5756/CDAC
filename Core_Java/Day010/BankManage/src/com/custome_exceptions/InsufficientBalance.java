package com.custome_exceptions;

@SuppressWarnings("serial")
public class InsufficientBalance extends BaseException {
	
	public InsufficientBalance(String message) {
		super(message);
	}
}
