package com.dellas.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dellas.app.converter.ProductConverter;
import com.dellas.app.dto.ProductDTO;
import com.dellas.app.repository.ProductRepository;

@Transactional(readOnly = true)
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductDTO> findByFilter(final ProductDTO productDTO) {
		return ProductConverter.toListDTO(productRepository.findByFilter(ProductConverter.toModel(productDTO)));
	}

	@Override
	public List<ProductDTO> findAll() {
		return ProductConverter.toListDTO(productRepository.findAll());
	}

	@Override
	public ProductDTO findById(final Long id) {
		return ProductConverter.toDTO(productRepository.findOne(id));
	}

	@Transactional(readOnly = false)
	@Override
	public ProductDTO updateStockAndProduct(final ProductDTO productDTO) {
		return ProductConverter.toDTO(productRepository.save(ProductConverter.toModel(productDTO)));
	}

	@Transactional(readOnly = false)
	@Override
	public ProductDTO persistStockAndProduct(final ProductDTO productDTO) {
		return ProductConverter.toDTO(productRepository.save(ProductConverter.toModel(productDTO)));
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteStockAndProduct(final Long idProduct) {
		productRepository.delete(idProduct);
	}
}
