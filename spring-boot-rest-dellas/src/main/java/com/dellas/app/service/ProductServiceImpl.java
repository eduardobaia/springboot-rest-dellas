package com.dellas.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dellas.app.converter.ProductConverter;
import com.dellas.app.dto.ProductDTO;
import com.dellas.app.model.Product;
import com.dellas.app.repository.ProductRepository;

@Transactional(readOnly = true)
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	// TODO implementar regras de negocio

	@Override
	public List<ProductDTO> findByFilter(final ProductDTO productDTO) {
		return null; // TODO implementar busca por filtro com criteria
	}

	@Override
	public List<ProductDTO> findAll() {
		return ProductConverter.toListDTO((List<Product>) productRepository.findAll());
	}

	@Override
	public ProductDTO findById(final Long id) {
		return ProductConverter.toDTO(productRepository.findOne(id));
	}

	@Override
	public ProductDTO update(final ProductDTO productDTO) {
		return ProductConverter.toDTO(productRepository.save(ProductConverter.toModel(productDTO)));
	}

	@Override
	public void delete(final Long id) {
		productRepository.delete(id);
	}

	@Override
	public ProductDTO persist(final ProductDTO productDTO) {
		return ProductConverter.toDTO(productRepository.save(ProductConverter.toModel(productDTO)));
	}

}
