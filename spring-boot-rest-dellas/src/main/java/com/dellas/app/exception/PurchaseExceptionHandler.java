package com.dellas.app.exception;

import java.util.ArrayList;
import java.util.List;

public class PurchaseExceptionHandler {

	public static List<String> getExcetionError(final Exception e){
		final List<String> exceptions= new ArrayList<>();
		if (e instanceof MultiplePurchaseException) {
			final MultiplePurchaseException me = (MultiplePurchaseException) e;
			for (final PurchaseException exception : me.getExceptions()) {
				exceptions.add(exception.getMessage());
			}
		}else if (e instanceof PurchaseException){
			final PurchaseException exception = (PurchaseException) e;
			exceptions.add(exception.getMessage());
		}else{
			exceptions.add("erro generico");
		}
		return exceptions;
	}
}
