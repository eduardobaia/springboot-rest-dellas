package com.dellas.app.exception;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class MultipleUserException extends RuntimeException{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 7139972070262446093L;

	/**
	 * Lista de excecoes
	 */
	private final Set<UserException> exceptions = new HashSet<UserException>();

	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param message mensagem de erro
	 */
	public MultipleUserException(final UserException message) {
		exceptions.add(message);
	}

	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param messageList mensagem de erro
	 */
	public MultipleUserException(final Collection<? extends UserException> messageList) {
		exceptions.addAll(messageList);
	}

	public MultipleUserException() {
		//Construtor padrao
	}


	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param message a mensagem de detalhe
	 */
	public void addException(final UserException message) {
		exceptions.add(message);
	}

	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param messageList a mensagem de detalhe
	 */
	public void addExceptionList(final Collection<? extends UserException> messageList) {
		exceptions.addAll(messageList);
	}

	public Set<UserException> getExceptions() {
		return exceptions;
	}

	public boolean contains(final UserException ex) {
		return (null != exceptions && !exceptions.isEmpty()) && exceptions.contains(ex);
	}
}
