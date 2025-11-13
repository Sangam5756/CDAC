package com.lms.custom_exception;

public class LMSException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public LMSException(String mesg) {
		super(mesg);
	}
	
	
}
