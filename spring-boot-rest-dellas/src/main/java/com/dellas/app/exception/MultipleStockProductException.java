package com.dellas.app.exception;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class MultipleStockProductException extends RuntimeException{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 7139972070262446093L;

	/**
	 * Lista de excecoes
	 */
	private final Set<StockProductException> exceptions = new HashSet<StockProductException>();

	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param message mensagem de erro
	 */
	public MultipleStockProductException(final StockProductException message) {
		exceptions.add(message);
	}

	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param messageList mensagem de erro
	 */
	public MultipleStockProductException(final Collection<? extends StockProductException> messageList) {
		exceptions.addAll(messageList);
	}

	public MultipleStockProductException() {
		//Construtor padrao
	}


	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param message a mensagem de detalhe
	 */
	public void addException(final StockProductException message) {
		exceptions.add(message);
	}

	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param messageList a mensagem de detalhe
	 */
	public void addExceptionList(final Collection<? extends StockProductException> messageList) {
		exceptions.addAll(messageList);
	}

	public Set<StockProductException> getExceptions() {
		return exceptions;
	}

	public boolean contains(final StockProductException ex) {
		return (null != exceptions && !exceptions.isEmpty()) && exceptions.contains(ex);
	}
}
