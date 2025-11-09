package com.healthcare.exception_handler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.healthcare.custom_exceptions.AuthenticationException;
import com.healthcare.custom_exceptions.ResourceNotFoundException;
import com.healthcare.dto.ApiResponse;

@RestControllerAdvice // To declare a spring bean containing global exception handling logic . SC is
						// offering global exc handling advice via this bean -> to all the rest
						// controllers in this app.
//try block - rest controller methods
//catch block - exc handler
public class GlobalExceptionHandler {

	// add exception handling method - to handle ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), "Failed"));
	}

	// add exception handling method - to handle auth exc

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<?> handleAuthenticationException(AuthenticationException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(e.getMessage(), "Failed"));
	}

	// catch all - handle ANY unchecked exception
	@ExceptionHandler(RuntimeException.class)
	//@ResponseStatus
	public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), "Failed"));
	}
	
	// add exception handling method - to handleP.L validation failure - for req body (JSON payload)

		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
			System.out.println("in handle @Valid ");
			//1. get list of rejected fields
			List<FieldError> fieldErrors = e.getFieldErrors();
			//2. Covert it to Map <Key - field Name , Value - err mesg>
			Map<String, String> errorFieldMap = fieldErrors.stream() //Stream<FieldError>
			.collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));//f -> f.getField(), f -> f.getDefaultMessage()
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorFieldMap);
		}

}
