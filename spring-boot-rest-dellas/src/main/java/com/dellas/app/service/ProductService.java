package com.dellas.app.service;

import java.util.List;

import com.dellas.app.dto.ProductDTO;

public interface ProductService {

	List<ProductDTO> findByFilter(ProductDTO productDTO);

	List<ProductDTO> findAll();

	ProductDTO findById(Long id);

	ProductDTO updateStockAndProduct(ProductDTO productDTO);

	ProductDTO persistStockAndProduct(ProductDTO productDTO);

	void deleteStockAndProduct(Long idProduct);
}
