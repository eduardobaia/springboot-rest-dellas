package com.dellas.app.exception;

import java.util.ArrayList;
import java.util.List;

public class StockProductExceptionHandler {

	public static List<String> getExcetionError(final Exception e){
		final List<String> exceptions= new ArrayList<>();
		if (e instanceof MultipleStockProductException) {
			final MultipleStockProductException me = (MultipleStockProductException) e;
			for (final StockProductException exception : me.getExceptions()) {
				exceptions.add(exception.getMessage());
			}
		}else if (e instanceof StockProductException){
			final StockProductException exception = (StockProductException) e;
			exceptions.add(exception.getMessage());
		}else{
			exceptions.add("erro generico");
		}
		return exceptions;
	}
}
