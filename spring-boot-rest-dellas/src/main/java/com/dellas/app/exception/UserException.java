package com.dellas.app.exception;

public class UserException extends Exception{

	private static final long serialVersionUID = 1L;

	public UserException() {
		//Construtor padrao
	}

	public UserException(final String message) {
		super(message);
	}

	public UserException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public UserException(final Throwable cause) {
		super(cause);
	}
}
