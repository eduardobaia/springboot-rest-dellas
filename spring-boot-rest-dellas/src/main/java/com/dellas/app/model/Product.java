package com.dellas.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PRODUCT", precision = 12, scale = 0)
	private Long id;

	@Column(name = "DESCRIPTION_PRODUCT", nullable = false, length = 200)
	private String description;

	@Column(name = "VALUE_PRODUCT", nullable = false, length = 200)
	private Double unitaryValue;

	@Version
	@Column(name = "VERSION_PRODUCT", nullable = false)
	private Integer version;

	@Column(name = "DATE_EXPIRATION", nullable = false)
	private Date expirationDate;

	@OneToMany(targetEntity=com.dellas.app.model.StockProduct.class, cascade={CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy="product")
	private Set<StockProduct> stockProducts;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(final Integer version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
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

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(final Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Set<StockProduct> getStockProducts() {
		return stockProducts;
	}

	public void setStockProducts(final Set<StockProduct> stockProducts) {
		this.stockProducts = stockProducts;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDescription()).append(getUnitaryValue()).append(getVersion()).toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		final Product rhs = (Product) obj;
		return new EqualsBuilder().append(getDescription(), rhs.getDescription()).append(getUnitaryValue(), rhs.getUnitaryValue())
				.append(getVersion(), rhs.getVersion()).isEquals();
	}
}
