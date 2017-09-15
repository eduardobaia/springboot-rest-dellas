package com.dellas.app.repository;

import java.util.List;

import com.dellas.app.model.StockProduct;

public interface StockProductRepositoryCustom {

	List<StockProduct> findByFilter(StockProduct stockProduct);
}
