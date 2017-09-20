package com.dellas.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dellas.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom{

}
