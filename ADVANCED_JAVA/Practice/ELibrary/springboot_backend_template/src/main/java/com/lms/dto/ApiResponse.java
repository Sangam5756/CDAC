package com.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {
	
	private String message;
	
	private String  status;
	
	private Object data;
	private Object error;
	
	
}
