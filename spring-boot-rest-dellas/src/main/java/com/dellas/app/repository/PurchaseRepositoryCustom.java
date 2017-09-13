package com.dellas.app.repository;

import java.util.List;

import com.dellas.app.model.Purchase;

public interface PurchaseRepositoryCustom {

	List<Purchase> findByFilter(Purchase purchase);
}
