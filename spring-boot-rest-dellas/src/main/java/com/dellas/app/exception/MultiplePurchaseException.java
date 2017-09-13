package com.dellas.app.exception;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class MultiplePurchaseException extends RuntimeException{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 7139972070262446093L;

	/**
	 * Lista de excecoes
	 */
	private final Set<PurchaseException> exceptions = new HashSet<PurchaseException>();

	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param message mensagem de erro
	 */
	public MultiplePurchaseException(final PurchaseException message) {
		exceptions.add(message);
	}

	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param messageList mensagem de erro
	 */
	public MultiplePurchaseException(final Collection<? extends PurchaseException> messageList) {
		exceptions.addAll(messageList);
	}

	public MultiplePurchaseException() {
		//Construtor padrao
	}


	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param message a mensagem de detalhe
	 */
	public void addException(final PurchaseException message) {
		exceptions.add(message);
	}

	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param messageList a mensagem de detalhe
	 */
	public void addExceptionList(final Collection<? extends PurchaseException> messageList) {
		exceptions.addAll(messageList);
	}

	public Set<PurchaseException> getExceptions() {
		return exceptions;
	}

	public boolean contains(final PurchaseException ex) {
		return (null != exceptions && !exceptions.isEmpty()) && exceptions.contains(ex);
	}
}
