package com.dellas.app.exception;

public class StockProductException extends Exception{

	private static final long serialVersionUID = 1L;

	public StockProductException() {
		//Construtor padrao
	}

	public StockProductException(final String message) {
		super(message);
	}

	public StockProductException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public StockProductException(final Throwable cause) {
		super(cause);
	}
}
