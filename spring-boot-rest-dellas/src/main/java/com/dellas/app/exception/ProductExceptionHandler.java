package com.dellas.app.exception;

import java.util.ArrayList;
import java.util.List;

public class ProductExceptionHandler {

	public static List<String> getExcetionError(final Exception e){
		final List<String> exceptions= new ArrayList<>();
		if (e instanceof MultipleProductException) {
			final MultipleProductException me = (MultipleProductException) e;
			for (final ProductException exception : me.getExceptions()) {
				exceptions.add(exception.getMessage());
			}
		}else if (e instanceof ProductException){
			final ProductException exception = (ProductException) e;
			exceptions.add(exception.getMessage());
		}else{
			exceptions.add("erro generico");
		}
		return exceptions;
	}
}
