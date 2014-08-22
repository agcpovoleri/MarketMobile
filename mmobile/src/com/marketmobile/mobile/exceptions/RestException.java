package com.marketmobile.mobile.exceptions;

public class RestException extends RuntimeException {

	public RestException() {
		
	}

	public RestException(String detailMessage) {
		super(detailMessage);
	}

	public RestException(Throwable throwable) {
		super(throwable);
	}

	public RestException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

}
