package com.dellas.app.exception;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class MultipleProductException extends RuntimeException{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 7139972070262446093L;

	/**
	 * Lista de excecoes
	 */
	private final Set<ProductException> exceptions = new HashSet<ProductException>();

	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param message mensagem de erro
	 */
	public MultipleProductException(final ProductException message) {
		exceptions.add(message);
	}

	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param messageList mensagem de erro
	 */
	public MultipleProductException(final Collection<? extends ProductException> messageList) {
		exceptions.addAll(messageList);
	}

	public MultipleProductException() {
		//Construtor padrao
	}


	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param message a mensagem de detalhe
	 */
	public void addException(final ProductException message) {
		exceptions.add(message);
	}

	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param messageList a mensagem de detalhe
	 */
	public void addExceptionList(final Collection<? extends ProductException> messageList) {
		exceptions.addAll(messageList);
	}

	public Set<ProductException> getExceptions() {
		return exceptions;
	}

	public boolean contains(final ProductException ex) {
		return (null != exceptions && !exceptions.isEmpty()) && exceptions.contains(ex);
	}
}
