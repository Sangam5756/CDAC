package com.cdac.custom_exception;

public class ResourceAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExists(String mesg) {
		super(mesg);
	}

}
