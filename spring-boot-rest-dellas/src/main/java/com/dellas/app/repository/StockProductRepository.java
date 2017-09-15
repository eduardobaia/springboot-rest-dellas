package com.dellas.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.dellas.app.model.StockProduct;

public interface StockProductRepository extends CrudRepository<StockProduct, Long>, StockProductRepositoryCustom{

}
