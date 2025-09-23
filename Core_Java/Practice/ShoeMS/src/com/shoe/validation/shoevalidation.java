package com.shoe.validation;

import com.shoe.core.ShoeType;
import com.shoe.exception.InvalidDataException;

public class shoevalidation {

	public static void validateName(String name) throws InvalidDataException  {
			int length = name.length();
			
			if(length < 3 || length > 20) {
					throw new InvalidDataException("Min Name Length 3 and Max 20 required");
			}
			
	}
	
	public static void ValidateshoeType(String shoeType) throws InvalidDataException {
			ShoeType validType = ShoeType.valueOf(shoeType);
				
			
			
	}
}
