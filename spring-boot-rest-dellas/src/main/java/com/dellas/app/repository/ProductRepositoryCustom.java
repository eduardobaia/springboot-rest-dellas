package com.dellas.app.repository;

import java.util.List;

import com.dellas.app.model.Product;

public interface ProductRepositoryCustom {

	List<Product> findByFilter(Product product);
}
