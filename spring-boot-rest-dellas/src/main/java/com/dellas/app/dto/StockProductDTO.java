package com.dellas.app.dto;

public class StockProductDTO extends AbstractDTO {

	private ProductDTO productDTO;
	private Integer amount;
	private String statusIndicator;

	public String getStatusIndicator() {
		return statusIndicator;
	}

	public void setStatusIndicator(final String statusIndicator) {
		this.statusIndicator = statusIndicator;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(final ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(final Integer amount) {
		this.amount = amount;
	}
}