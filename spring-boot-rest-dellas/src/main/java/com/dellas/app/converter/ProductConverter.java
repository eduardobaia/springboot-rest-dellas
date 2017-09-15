package com.dellas.app.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dellas.app.dto.ProductDTO;
import com.dellas.app.model.Product;

public class ProductConverter {

	public static Product toModel(final ProductDTO productDTO) {
		final Product product = new Product();
		product.setId(productDTO.getId());
		product.setDescription(productDTO.getDescription());
		product.setUnitaryValue(productDTO.getUnitaryValue());
		product.setExpirationDate(productDTO.getExpirationDate());
		product.setVersion(productDTO.getVersion());
		return product;
	}

	public static ProductDTO toDTO(final Product product) {
		final ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setDescription(product.getDescription());
		productDTO.setUnitaryValue(product.getUnitaryValue());
		productDTO.setExpirationDate(product.getExpirationDate());
		productDTO.setVersion(product.getVersion());
		return productDTO;
	}

	public static List<ProductDTO> toListDTO(final Set<Product> list) {
		final List<ProductDTO> results = new ArrayList<>();
		for (final Product product : list) {
			results.add(toDTO(product));
		}
		return results;
	}

	public static Set<Product> toListModel(final List<ProductDTO> list) {
		final Set<Product> results = new HashSet<>();
		for (final ProductDTO product : list) {
			results.add(toModel(product));
		}
		return results;
	}

	public static ProductDTO toDTO(final Map<String, String> params) throws ParseException {
		final ProductDTO retorno = new ProductDTO();
		for (final Map.Entry<String, String> entry : params.entrySet()) {
			if (entry.getKey().equalsIgnoreCase("description")) {
				retorno.setDescription(entry.getValue());
			}
			if (entry.getKey().equalsIgnoreCase("unitaryValue")) {
				retorno.setUnitaryValue(Double.valueOf(entry.getValue()));
			}
			if (entry.getKey().equalsIgnoreCase("expirationDate")) {
				final Date dateConverted= new SimpleDateFormat("dd/MM/yyyy").parse(entry.getValue());
				retorno.setExpirationDate(dateConverted);
			}
		}
		return retorno;
	}
}
