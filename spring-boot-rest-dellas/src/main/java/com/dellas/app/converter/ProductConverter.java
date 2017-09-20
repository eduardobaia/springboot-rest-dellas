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
import com.dellas.app.dto.StockProductDTO;
import com.dellas.app.model.Product;

public class ProductConverter {

	public static Product toModel(final ProductDTO productDTO) {
		final Product product = new Product();
		product.setId(productDTO.getId());
		product.setDescription(productDTO.getDescription());
		product.setUnitaryValue(productDTO.getUnitaryValue());
		product.setExpirationDate(productDTO.getExpirationDate());
		product.setVersion(productDTO.getVersion());
		product.setQuantityProductInPurchase(productDTO.getQuantityProductInPurchase());
		product.setStockProduct(StockProductConverter.toModel(productDTO.getStockProductDTO()));
		return product;
	}

	public static ProductDTO toDTO(final Product product) {
		final ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setDescription(product.getDescription());
		productDTO.setUnitaryValue(product.getUnitaryValue());
		productDTO.setExpirationDate(product.getExpirationDate());
		productDTO.setVersion(product.getVersion());
		productDTO.setQuantityProductInPurchase(product.getQuantityProductInPurchase());
		productDTO.setStockProductDTO(StockProductConverter.toDTO(product.getStockProduct()));
		return productDTO;
	}

	public static List<ProductDTO> toListDTO(final List<Product> list) {
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
	/*
	public static Set<Product> stockProductToListProduct(final List<StockProductDTO> list) {
		final Set<Product> results = new HashSet<>();
		for (final StockProductDTO stockProduct : list) {
			results.add(toModel(stockProduct.getProductDTO()));
		}
		return results;
	}*/

	public static ProductDTO toDTO(final Map<String, String> params) throws ParseException {
		final ProductDTO retorno = new ProductDTO();
		final StockProductDTO stockProductDTO= new StockProductDTO();
		retorno.setStockProductDTO(stockProductDTO);

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
			if (entry.getKey().equalsIgnoreCase("amount")) {
				retorno.getStockProductDTO().setAmount(Integer.valueOf(entry.getValue()));
			}
			if (entry.getKey().equalsIgnoreCase("statusIndicator")) {
				retorno.getStockProductDTO().setStatusIndicator(entry.getValue());
			}
		}
		return retorno;
	}
}
