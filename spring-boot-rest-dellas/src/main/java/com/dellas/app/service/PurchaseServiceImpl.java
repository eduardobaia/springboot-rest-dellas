package com.dellas.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dellas.app.converter.PurchaseConverter;
import com.dellas.app.dto.PurchaseDTO;
import com.dellas.app.model.Purchase;
import com.dellas.app.repository.PurchaseRepository;

@Transactional(readOnly = true)
@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;

	// implementar regras de negocio

	@Override
	public List<PurchaseDTO> findByFilter(final PurchaseDTO purchaseDTO) {
		return null; // TODO implementar busca por filtro com criteria
	}

	@Override
	public List<PurchaseDTO> findAll() {
		return PurchaseConverter.toListDTO((List<Purchase>) purchaseRepository.findAll());
	}

	@Override
	public PurchaseDTO findById(final Long id) {
		return PurchaseConverter.toDTO(purchaseRepository.findOne(id));
	}

	@Transactional(readOnly = false)
	@Override
	public PurchaseDTO update(final PurchaseDTO purchaseDTO) {
		return PurchaseConverter.toDTO(purchaseRepository.save(PurchaseConverter.toModel(purchaseDTO)));
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(final Long id) {
		purchaseRepository.delete(id);
	}

	@Transactional(readOnly = false)
	@Override
	public PurchaseDTO persist(final PurchaseDTO purchaseDTO) {
		return PurchaseConverter.toDTO(purchaseRepository.save(PurchaseConverter.toModel(purchaseDTO)));
	}
}
