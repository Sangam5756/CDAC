package com.lms.custom_exception;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lms.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
		
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException e){
		
		List<FieldError> fieldErrors = e.getFieldErrors();
			
		Map<String, String> errors = fieldErrors.stream().
		collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("validation error","failed",null,errors));
	}
	
	@ExceptionHandler(LMSException.class)
	public ResponseEntity<?> handlerLmsException(LMSException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse("something went wrong", "failed",null,e.getMessage()));
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handlerRuntimeException(RuntimeException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("internal server error", "failed",null,e.getMessage()));
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlerException(Exception e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("internal server error", "failed",null,e.getMessage()));
	}
}
