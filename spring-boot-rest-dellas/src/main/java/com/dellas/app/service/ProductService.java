package com.dellas.app.service;

import java.util.List;

import com.dellas.app.dto.ProductDTO;

public interface ProductService {

	List<ProductDTO> findByFilter(ProductDTO productDTO);

	List<ProductDTO> findAll();

	ProductDTO findById(Long id);

	ProductDTO update(ProductDTO productDTO);

	void delete(Long id);

	ProductDTO persist(ProductDTO productDTO);
}
