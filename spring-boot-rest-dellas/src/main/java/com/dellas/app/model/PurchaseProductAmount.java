package com.dellas.app.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PURCHASE_PRODUCT_AMOUNT")
public class PurchaseProductAmount {

	@Id
	@EmbeddedId
	private PurchaseProductId id;

	@Column(name = "AMOUNT_PURCHASE_PRODUCT", nullable = false)
	private Integer amount;

	public PurchaseProductId getId() {
		return id;
	}

	public void setId(final PurchaseProductId id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(final Integer amount) {
		this.amount = amount;
	}
}