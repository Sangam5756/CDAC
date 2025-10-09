package com.carrental.core;

public class Validation {

//	product validation

	void validateCarPriceAnd(double price) throws CarException{
		if (price < 0) {
			throw new CarException("Price Can Not Be Negative");
		}
	}
	
	


}
