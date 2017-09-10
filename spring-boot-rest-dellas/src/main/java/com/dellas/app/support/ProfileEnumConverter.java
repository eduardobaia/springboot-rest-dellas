package com.dellas.app.support;

import javax.persistence.AttributeConverter;

import com.dellas.app.model.domain.ProfileEnum;

public class ProfileEnumConverter implements AttributeConverter<ProfileEnum, String>{

	@Override
	public String convertToDatabaseColumn(final ProfileEnum profileEnum) {
		return profileEnum.getId();
	}

	@Override
	public ProfileEnum convertToEntityAttribute(final String valor) {
		if (valor == null) {
			throw new IllegalArgumentException();
		}

		for (final ProfileEnum e : ProfileEnum.values()) {
			if (valor.equals(e.getId()) || valor.equals(e.getDescricao()) || valor.equals(e.name())) {
				return e;
			}
		}

		final StringBuilder msg = new StringBuilder("");
		msg.append("Cannot parse into an element of SituacaoAcaoEnum: '");
		msg.append(valor);
		msg.append("'");

		throw new IllegalArgumentException(msg.toString());
	}

}
