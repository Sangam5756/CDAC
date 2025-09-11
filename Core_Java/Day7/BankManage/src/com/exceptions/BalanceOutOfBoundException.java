package com.exceptions;

@SuppressWarnings("serial")
public class BalanceOutOfBoundException extends Exception {
	public BalanceOutOfBoundException(String message) {
		super(message);
	}
}
