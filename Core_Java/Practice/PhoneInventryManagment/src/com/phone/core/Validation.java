package com.phone.core;

import com.phone.exception.InvalidModelName;
import com.phone.exception.InvalidRatingException;
import com.phone.exception.PhoneException;

public class Validation {

		
	
	public static void validateRating(int rating)throws PhoneException{
		if(rating <1 || rating > 5) {
			throw new InvalidRatingException("Rating Should be in range between 1 to 5");
		}
	}

	public static void validateModelName(String ModelName)throws PhoneException{
		if(ModelName.length() <2 || ModelName.length() > 15) {
			throw new InvalidModelName("Model name should be 2 to 15 characters in length");
		}
	}
	
	public static Phone ValidatePhoneData(String modelName, String brand, int rating, boolean inStock, String phoneType,
			double price) throws  Exception,PhoneException {
			
//		validate rating
		validateRating(rating);
		
//		validate name
		validateModelName(modelName);
		
//		validate type
		
		PhoneType validType = PhoneType.valueOf(phoneType.toUpperCase());
		
		
		
		return new Phone(modelName, brand, rating, inStock, validType, price);
	}
	
}
