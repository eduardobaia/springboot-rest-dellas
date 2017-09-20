package com.dellas.app.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

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
		stockProduct.setVersion(stockProductDTO.getVersion());
		return stockProduct;
	}

	public static StockProductDTO toDTO(final StockProduct stockProduct) {
		final StockProductDTO stockProductDTO = new StockProductDTO();
		stockProductDTO.setId(stockProduct.getId());
		stockProductDTO.setAmount(stockProduct.getAmount());
		stockProductDTO.setStatusIndicator(stockProduct.getStatusIndicator().getId());
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
}