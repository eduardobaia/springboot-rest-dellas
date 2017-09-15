package com.dellas.app.support;

import javax.persistence.AttributeConverter;

import com.dellas.app.model.domain.SituationObjectEnum;

public class SituationObjectEnumConverter implements AttributeConverter<SituationObjectEnum, String>{

	@Override
	public String convertToDatabaseColumn(final SituationObjectEnum arg0) {
		return arg0.getId();
	}

	@Override
	public SituationObjectEnum convertToEntityAttribute(final String valor) {
		if (valor == null) {
			throw new IllegalArgumentException();
		}

		for (final SituationObjectEnum e : SituationObjectEnum.values()) {
			if (valor.equals(e.getId()) || valor.equals(e.getDescricao()) || valor.equals(e.name())) {
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
