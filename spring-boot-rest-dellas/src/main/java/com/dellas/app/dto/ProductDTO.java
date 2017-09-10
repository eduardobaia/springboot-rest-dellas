package com.dellas.app.dto;

public class ProductDTO extends AbstractDTO{

	private String description;
	private Double unitaryValue;
	private Integer amount;

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
