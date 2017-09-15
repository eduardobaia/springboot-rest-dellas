package com.dellas.app.model.domain;

public enum SituationObjectEnum {

	ATIVO("A", "Ativo"),

	INATIVO("I", "Inativo");

	/**
	 * Id.
	 */
	private String id;

	private String descricao;

	/**
	 * Construtor padrao.
	 *
	 * @param newId O identificador desta Enumeracao
	 */
	private SituationObjectEnum(final String newId, final String newDescricao) {
		this.id = newId;
		this.descricao = newDescricao;
	}

	public String getDescricao() {
		return descricao;
	}

	/**
	 * Retorna o identificador desta Enumeracao.
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Obtem uma instancia desta classe a partir do valor de um outro objeto.
	 *
	 * @param valor
	 *          O valor a partir do qual se obtera a instancia desta classe.
	 * @return  Uma instancia desta classe correspondente ao valor passado
	 *          como parametro ou excecao caso o parametro passado for
	 *          <code>null</code> ou nao estiver dentro dos valores
	 *          possiveis da enumeracao.
	 */
	public static SituationObjectEnum from(final String valor) {
		if (valor == null) {
			throw new IllegalArgumentException();
		}

		for (final SituationObjectEnum e : SituationObjectEnum.values()) {
			if (valor.equals(e.id) || valor.equals(e.getDescricao()) || valor.equals(e.name())) {
				return e;
			}
		}

		final StringBuilder msg = new StringBuilder("");
		msg.append("Cannot parse into an element of SituationObjectEnum: '");
		msg.append(valor);
		msg.append("'");

		throw new IllegalArgumentException(msg.toString());
	}
}
