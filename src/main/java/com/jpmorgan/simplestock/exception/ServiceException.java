package com.jpmorgan.simplestock.exception;

import com.jpmorgan.simplestock.constants.ResponseConstants;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	ResponseConstants response;
	
	public ServiceException(final ResponseConstants response) {
		super(response.getMessage());
		this.response = response;
	}
	public ResponseConstants getResponse() {
		return response;
	}
	public void setResponse(ResponseConstants response) {
		this.response = response;
	}
}
