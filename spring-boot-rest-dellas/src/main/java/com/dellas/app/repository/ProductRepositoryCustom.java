package com.dellas.app.repository;

import java.util.Set;

import com.dellas.app.model.Product;

public interface ProductRepositoryCustom {

	Set<Product> findByFilter(Product product);
}
