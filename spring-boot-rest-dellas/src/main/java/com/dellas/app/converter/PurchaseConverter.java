package com.dellas.app.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dellas.app.dto.PurchaseDTO;
import com.dellas.app.model.Purchase;

public class PurchaseConverter {

	public static Purchase toModel(final PurchaseDTO purchaseDTO) {
		final Purchase purchase = new Purchase();
		purchase.setId(purchaseDTO.getId());
		purchase.setDatePurchase(new Date());
		purchase.setDiscount(purchaseDTO.getDiscount());
		//purchase.setProducts(ProductConverter.stockProductToListProduct(purchaseDTO.getStockProductDTOs()));
		purchase.setTotalValue(purchaseDTO.getTotalValue());
		purchase.setUser(UserConverter.toModel(purchaseDTO.getUser()));
		purchase.setVersion(purchaseDTO.getVersion());
		return purchase;
	}

	public static PurchaseDTO toDTO(final Purchase purchase) {
		final PurchaseDTO purchaseDTO = new PurchaseDTO();
		purchaseDTO.setId(purchase.getId());
		purchaseDTO.setDatePurchase(purchase.getDatePurchase());
		purchaseDTO.setDiscount(purchase.getDiscount());
		//purchaseDTO.setProducts(ProductConverter.toListDTO(purchase.getProducts()));
		purchaseDTO.setTotalValue(purchase.getTotalValue());
		purchaseDTO.setUser(UserConverter.toDTO(purchase.getUser()));
		purchaseDTO.setVersion(purchase.getVersion());
		return purchaseDTO;
	}

	public static List<PurchaseDTO> toListDTO(final List<Purchase> list) {
		final List<PurchaseDTO> results = new ArrayList<>();
		for (final Purchase purchase : list) {
			results.add(toDTO(purchase));
		}
		return results;
	}
}
