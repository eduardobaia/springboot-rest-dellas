package com.dellas.app.dto;

import java.util.Date;

import com.dellas.app.support.CustomDateDeserializer;
import com.dellas.app.support.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ProductDTO extends AbstractDTO {

	private String description;
	private Double unitaryValue;
	private Integer amount;
	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date expirationDate;

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(final Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Double getUnitaryValue() {
		return unitaryValue;
	}

	public void setUnitaryValue(final Double unitaryValue) {
		this.unitaryValue = unitaryValue;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(final Integer amount) {
		this.amount = amount;
	}
}
