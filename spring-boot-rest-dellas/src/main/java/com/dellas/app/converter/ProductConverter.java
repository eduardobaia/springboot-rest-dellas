package com.dellas.app.converter;

import java.util.ArrayList;
import java.util.List;

import com.dellas.app.dto.ProductDTO;
import com.dellas.app.model.Product;

public class ProductConverter {

	public static Product toModel(final ProductDTO productDTO) {
		final Product product = new Product();
		product.setId(productDTO.getId());
		product.setAmount(productDTO.getAmount());
		product.setDescription(productDTO.getDescription());
		product.setUnitaryValue(productDTO.getUnitaryValue());
		product.setVersion(productDTO.getVersion());
		return product;
	}

	public static ProductDTO toDTO(final Product product) {
		final ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setAmount(product.getAmount());
		productDTO.setDescription(product.getDescription());
		productDTO.setUnitaryValue(product.getUnitaryValue());
		productDTO.setVersion(product.getVersion());
		return productDTO;
	}

	public static List<ProductDTO> toListDTO(final List<Product> list) {
		final List<ProductDTO> results = new ArrayList<>();
		for (final Product product : list) {
			results.add(toDTO(product));
		}
		return results;
	}
}
