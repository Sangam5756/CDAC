package com.exceptions;

@SuppressWarnings("serial")
public class SpeedOutOfRangeException extends Exception {
	public SpeedOutOfRangeException(String errorMesg) {
		super(errorMesg);
	}
}