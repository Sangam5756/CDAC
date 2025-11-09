package com.inventory.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

	private LocalDate timestamp;
	private String msg;
	private boolean status;
	private Object data;
	private Object error;
	
	public ApiResponse(String msg, Boolean status) {
		this.timestamp = LocalDate.now();
		this.msg = msg;
		this.status = status;
		
	}

}
