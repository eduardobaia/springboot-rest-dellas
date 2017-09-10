package com.dellas.app.service;

import java.util.List;

import com.dellas.app.dto.PurchaseDTO;

public interface PurchaseService {

	List<PurchaseDTO> findByFilter(PurchaseDTO purchaseDTO);

	List<PurchaseDTO> findAll();

	PurchaseDTO findById(Long id);

	PurchaseDTO update(PurchaseDTO purchaseDTO);

	void delete(Long id);

	PurchaseDTO persist(PurchaseDTO purchaseDTO);
}
