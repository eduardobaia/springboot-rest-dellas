package com.dellas.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "AMOUNT_PRODUCT", nullable = false)
	private Integer amount;

	@Version
	@Column(name = "VERSION_PRODUCT", nullable = false)
	private Integer version;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(final Integer version) {
		this.version = version;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(final Integer amount) {
		this.amount = amount;
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDescription()).append(getUnitaryValue()).append(getAmount())
				.toHashCode();
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
		return new EqualsBuilder().append(getDescription(), rhs.getDescription())
				.append(getUnitaryValue(), rhs.getUnitaryValue()).append(getAmount(), rhs.getAmount()).isEquals();
	}
}
