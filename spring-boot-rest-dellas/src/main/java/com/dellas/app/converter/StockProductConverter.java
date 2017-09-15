package com.dellas.app.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.dellas.app.dto.ProductDTO;
import com.dellas.app.dto.StockProductDTO;
import com.dellas.app.model.StockProduct;
import com.dellas.app.model.domain.SituationObjectEnum;

public class StockProductConverter {

	public static StockProduct toModel(final StockProductDTO stockProductDTO) {
		final StockProduct stockProduct = new StockProduct();
		stockProduct.setId(stockProductDTO.getId());
		stockProduct.setAmount(stockProductDTO.getAmount());
		if(StringUtils.isNotBlank(stockProductDTO.getStatusIndicator())) {
			stockProduct.setStatusIndicator(SituationObjectEnum.from(stockProductDTO.getStatusIndicator()));
		}
		stockProduct.setProduct(ProductConverter.toModel(stockProductDTO.getProductDTO()));
		stockProduct.setVersion(stockProductDTO.getVersion());
		return stockProduct;
	}

	public static StockProductDTO toDTO(final StockProduct stockProduct) {
		final StockProductDTO stockProductDTO = new StockProductDTO();
		stockProductDTO.setId(stockProduct.getId());
		stockProductDTO.setAmount(stockProduct.getAmount());
		stockProductDTO.setStatusIndicator(stockProduct.getStatusIndicator().getId());
		stockProductDTO.setProductDTO(ProductConverter.toDTO(stockProduct.getProduct()));
		stockProductDTO.setVersion(stockProduct.getVersion());
		return stockProductDTO;
	}

	public static List<StockProductDTO> toListDTO(final List<StockProduct> list) {
		final List<StockProductDTO> results = new ArrayList<>();
		for (final StockProduct product : list) {
			results.add(toDTO(product));
		}
		return results;
	}

	public static Set<StockProduct> toListModel(final List<StockProductDTO> list) {
		final Set<StockProduct> results = new HashSet<>();
		for (final StockProductDTO product : list) {
			results.add(toModel(product));
		}
		return results;
	}

	public static StockProductDTO toDTO(final Map<String, String> params) throws ParseException {
		final StockProductDTO stockProductDTO = new StockProductDTO();
		final ProductDTO productDTO= new ProductDTO();
		stockProductDTO.setProductDTO(productDTO);
		for (final Map.Entry<String, String> entry : params.entrySet()) {
			if (entry.getKey().equalsIgnoreCase("amount")) {
				stockProductDTO.setAmount(Integer.valueOf(entry.getValue()));
			}
			if (entry.getKey().equalsIgnoreCase("statusIndicator")) {
				stockProductDTO.setStatusIndicator(entry.getValue());
			}
			if (entry.getKey().equalsIgnoreCase("description")) {
				stockProductDTO.getProductDTO().setDescription(entry.getValue());
			}
			if (entry.getKey().equalsIgnoreCase("unitaryValue")) {
				stockProductDTO.getProductDTO().setUnitaryValue(Double.valueOf(entry.getValue()));
			}
			if (entry.getKey().equalsIgnoreCase("expirationDate")) {
				final Date dateConverted= new SimpleDateFormat("dd/MM/yyyy").parse(entry.getValue());
				stockProductDTO.getProductDTO().setExpirationDate(dateConverted);
			}
		}
		return stockProductDTO;
	}
}
