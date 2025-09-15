package com.custome_exceptions;

@SuppressWarnings("serial")
public class AccountNotFoundException extends BaseException{
	public AccountNotFoundException(String message) {
		super(message);
	}
}
