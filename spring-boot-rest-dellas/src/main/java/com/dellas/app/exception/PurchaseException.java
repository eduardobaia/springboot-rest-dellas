package com.dellas.app.exception;

public class PurchaseException extends Exception{

	private static final long serialVersionUID = 1L;

	public PurchaseException() {
		//Construtor padrao
	}

	public PurchaseException(final String message) {
		super(message);
	}

	public PurchaseException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public PurchaseException(final Throwable cause) {
		super(cause);
	}
}
