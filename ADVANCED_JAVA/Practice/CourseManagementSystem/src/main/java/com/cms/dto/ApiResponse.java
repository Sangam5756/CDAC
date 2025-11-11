package com.cms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {

//	status
	private boolean status;
//	mesg
	private String mesg;
//	data
	private Object data;
//	error
	private Object error;

}
