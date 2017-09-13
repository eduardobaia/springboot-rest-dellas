package com.dellas.app.dto;

import java.util.Date;
import java.util.List;

import com.dellas.app.support.CustomDateDeserializer;
import com.dellas.app.support.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class PurchaseDTO extends AbstractDTO {

	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date datePurchase;
	private Double discount;
	private Double totalValue;
	private UserDTO user;
	private List<ProductDTO> products;

	public Date getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(final Date datePurchase) {
		this.datePurchase = datePurchase;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(final Double discount) {
		this.discount = discount;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(final Double totalValue) {
		this.totalValue = totalValue;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(final UserDTO user) {
		this.user = user;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(final List<ProductDTO> products) {
		this.products = products;
	}
}