package com.dellas.app.service;

import java.util.List;

import com.dellas.app.dto.StockProductDTO;

public interface StockProductService {

	List<StockProductDTO> findByFilter(StockProductDTO stockStockProductDTO);

	List<StockProductDTO> findAll();

	StockProductDTO findById(Long id);

	StockProductDTO updateStockAndProduct(StockProductDTO stockStockProductDTO);

	StockProductDTO persistStockAndProduct(StockProductDTO stockStockProductDTO);

	void deleteStockAndProduct(Long idProduct);
}
