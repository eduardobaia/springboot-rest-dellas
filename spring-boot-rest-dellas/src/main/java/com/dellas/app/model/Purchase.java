package com.dellas.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PURCHASE")
public class Purchase implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PURCHASE", precision = 12, scale = 0)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_PURCHASE", nullable = false)
	private Date datePurchase;

	@Column(name = "DISCOUNT_PURCHASE", nullable = false)
	private Double discount;

	@Column(name = "TOTAL_VALUE_PURCHASE", nullable = false)
	private Double totalValue;

	@ManyToOne
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
	private User user;

	@ManyToMany
	@JoinTable(name = "PURCHASE_PRODUCT",
	joinColumns = {@JoinColumn(name = "ID_PURCHASE", referencedColumnName = "ID_PURCHASE")},
	inverseJoinColumns = @JoinColumn(name = "ID_PRODUCT", referencedColumnName = "ID_PRODUCT") )
	private Set<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(final Set<Product> products) {
		this.products = products;
	}

}
