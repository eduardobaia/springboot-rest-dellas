package com.dellas.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dellas.app.converter.ProductConverter;
import com.dellas.app.converter.StockProductConverter;
import com.dellas.app.dto.StockProductDTO;
import com.dellas.app.model.StockProduct;
import com.dellas.app.repository.ProductRepository;
import com.dellas.app.repository.StockProductRepository;

@Transactional(readOnly = true)
@Service
public class StockProductServiceImpl implements StockProductService{

	@Autowired
	private StockProductRepository stockProductRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<StockProductDTO> findByFilter(final StockProductDTO stockStockProductDTO) {
		return StockProductConverter.toListDTO(stockProductRepository.findByFilter(StockProductConverter.toModel(stockStockProductDTO)));
	}

	@Override
	public List<StockProductDTO> findAll() {
		return StockProductConverter.toListDTO((List<StockProduct>) stockProductRepository.findAll());
	}

	@Override
	public StockProductDTO findById(final Long id) {
		return StockProductConverter.toDTO(stockProductRepository.findOne(id));
	}

	@Transactional(readOnly = false)
	@Override
	public StockProductDTO updateStockAndProduct(final StockProductDTO stockStockProductDTO) {
		final StockProduct stockProdut = StockProductConverter.toModel(stockStockProductDTO);
		stockProdut.setProduct(productRepository.save(ProductConverter.toModel(stockStockProductDTO.getProductDTO())));
		return StockProductConverter.toDTO(stockProductRepository.save(stockProdut));
	}

	@Transactional(readOnly = false)
	@Override
	public StockProductDTO persistStockAndProduct(final StockProductDTO stockStockProductDTO) {
		final StockProduct stockProdut = StockProductConverter.toModel(stockStockProductDTO);
		stockProdut.setProduct(productRepository.save(ProductConverter.toModel(stockStockProductDTO.getProductDTO())));
		return StockProductConverter.toDTO(stockProductRepository.save(stockProdut));
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteStockAndProduct(final Long idProduct) {
		productRepository.delete(idProduct);
	}
}
