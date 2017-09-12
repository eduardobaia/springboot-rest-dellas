package com.dellas.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.dellas.app.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>, ProductRepositoryCustom{

}
