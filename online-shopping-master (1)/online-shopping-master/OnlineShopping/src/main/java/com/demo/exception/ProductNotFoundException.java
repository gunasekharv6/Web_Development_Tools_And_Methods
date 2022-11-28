package com.demo.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public ProductNotFoundException() {
		this("Product is not available!");
	}
	
	public ProductNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;	
	}
	
	public ProductNotFoundException(String message, Throwable cause)
	{
		super(message,cause);
	}

	public String getMessage() {
		return message;
	}
}
