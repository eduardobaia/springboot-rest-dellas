package com.dellas.app.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.dellas.app.model.Product;
import com.dellas.app.model.Purchase;
import com.dellas.app.model.PurchaseProductAmount;
import com.dellas.app.model.PurchaseProductId;

public class PurchaseProductAmountConverter {

	public static List<PurchaseProductAmount> toListModel(final Long idPurchase, final Set<Product> products) {
		final List<PurchaseProductAmount> listReturn = new ArrayList<>();
		for (final Product product : products) {
			listReturn.add(toModel(idPurchase, product));
		}
		return listReturn;
	}

	public static PurchaseProductAmount toModel(final Long idPurchase, final Product product) {
		final PurchaseProductAmount purchaseProductAmount = new PurchaseProductAmount();
		final PurchaseProductId purchaseProductId= new PurchaseProductId();
		final Purchase purchase= new Purchase();

		purchaseProductId.setPurchase(purchase);
		purchaseProductId.getPurchase().setId(idPurchase);
		purchaseProductId.setProduct(product);
		purchaseProductAmount.setAmount(product.getQuantityProductInPurchase());

		return purchaseProductAmount;
	}
}
