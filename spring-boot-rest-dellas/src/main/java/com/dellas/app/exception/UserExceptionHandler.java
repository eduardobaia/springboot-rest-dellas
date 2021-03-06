package com.dellas.app.exception;

import java.util.ArrayList;
import java.util.List;


public class UserExceptionHandler {

	public static List<String> getExcetionError(final Exception e){
		final List<String> exceptions= new ArrayList<>();
		if (e instanceof MultipleUserException) {
			final MultipleUserException me = (MultipleUserException) e;
			for (final UserException exception : me.getExceptions()) {
				exceptions.add(exception.getMessage());
			}
		}else if (e instanceof UserException){
			final UserException exception = (UserException) e;
			exceptions.add(exception.getMessage());
		}else{
			exceptions.add("erro generico");
		}
		return exceptions;
	}
}
