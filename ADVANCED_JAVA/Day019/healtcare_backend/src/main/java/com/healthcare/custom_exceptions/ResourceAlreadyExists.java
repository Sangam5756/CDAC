package com.healthcare.custom_exceptions;

public class ResourceAlreadyExists extends RuntimeException {
	public ResourceAlreadyExists(String errMesg) {
		super(errMesg);
	}
}
