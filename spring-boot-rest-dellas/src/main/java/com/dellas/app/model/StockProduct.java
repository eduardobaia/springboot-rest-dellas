package com.dellas.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.dellas.app.model.domain.SituationObjectEnum;
import com.dellas.app.support.SituationObjectEnumConverter;

@Entity
@Table(name = "STOCK_PRODUCT")
public class StockProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_STOCK_PRODUCT", precision = 12, scale = 0)
	private Long id;

	@Column(name = "AMOUNT_STOCK_PRODUCT", nullable = false)
	private Integer amount;

	@Convert(converter = SituationObjectEnumConverter.class)
	@Column(name = "STATUS_STOCK_PRODUCT", nullable = false, length = 1)
	private SituationObjectEnum statusIndicator;

	@Version
	@Column(name = "VERSION_STOCK_PRODUCT", nullable = false)
	private Integer version;

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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(final Integer amount) {
		this.amount = amount;
	}

	public SituationObjectEnum getStatusIndicator() {
		return statusIndicator;
	}

	public void setStatusIndicator(final SituationObjectEnum statusIndicator) {
		this.statusIndicator = statusIndicator;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getAmount()).append(getVersion()).append(getStatusIndicator()).toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		final StockProduct rhs = (StockProduct) obj;
		return new EqualsBuilder().append(getAmount(), rhs.getAmount()).append(getVersion(), rhs.getVersion())
				.append(getStatusIndicator(), rhs.getStatusIndicator()).isEquals();
	}
}
