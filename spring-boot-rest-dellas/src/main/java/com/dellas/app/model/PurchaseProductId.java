package com.dellas.app.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PurchaseProductId implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "ID_PURCHASE", referencedColumnName="ID_PURCHASE", nullable = false)
	private Purchase purchase;

	@ManyToOne
	@JoinColumn(name = "ID_PRODUCT", referencedColumnName="ID_PRODUCT", nullable = false)
	private Product product;

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(final Purchase purchase) {
		this.purchase = purchase;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}
}