package com.b3t3.loanAdminManagement.Exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiError {
	
	private String errorCode;
	private String message;
	public ApiError(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	

}
