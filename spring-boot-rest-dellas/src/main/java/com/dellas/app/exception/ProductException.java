package com.dellas.app.exception;

public class ProductException extends Exception{

	private static final long serialVersionUID = 1L;

	public ProductException() {
		//Construtor padrao
	}

	public ProductException(final String message) {
		super(message);
	}

	public ProductException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ProductException(final Throwable cause) {
		super(cause);
	}
}
