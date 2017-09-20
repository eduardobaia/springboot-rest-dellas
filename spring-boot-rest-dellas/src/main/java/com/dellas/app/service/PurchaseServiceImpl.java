package com.dellas.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dellas.app.converter.PurchaseConverter;
import com.dellas.app.converter.PurchaseProductAmountConverter;
import com.dellas.app.dto.PurchaseDTO;
import com.dellas.app.model.Product;
import com.dellas.app.model.Purchase;
import com.dellas.app.repository.ProductRepository;
import com.dellas.app.repository.PurchaseProductAmountRepository;
import com.dellas.app.repository.PurchaseRepository;

@Transactional(readOnly = true)
@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PurchaseProductAmountRepository purchaseProductAmountRepository;

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
		final Purchase purchaseConverted = PurchaseConverter.toModel(purchaseDTO);
		purchaseConverted.setTotalValue(calculetedTotalValueWithDiscount(purchaseConverted));
		final Purchase purchaseInserted = purchaseRepository.save(purchaseConverted);
		purchaseProductAmountRepository.save(
				PurchaseProductAmountConverter.toListModel(purchaseInserted.getId(), purchaseInserted.getProducts()));
		return PurchaseConverter.toDTO(purchaseConverted);
	}

	@Transactional(readOnly = false)
	@Override
	public PurchaseDTO persist(final PurchaseDTO purchaseDTO) {
		final Purchase purchaseConverted = PurchaseConverter.toModel(purchaseDTO);
		purchaseConverted.setTotalValue(calculetedTotalValueWithDiscount(purchaseConverted));
		final Purchase purchaseInserted = purchaseRepository.save(purchaseConverted);
		purchaseProductAmountRepository.save(
				PurchaseProductAmountConverter.toListModel(purchaseInserted.getId(), purchaseInserted.getProducts()));
		return PurchaseConverter.toDTO(purchaseConverted);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(final Long id) {
		purchaseRepository.delete(id);
	}

	public Double calculetedTotalValueWithDiscount(final Purchase purchase) {
		Double totalValue = 0.0;
		final List<Product> listProduct = (List<Product>) productRepository
				.findAll(getListIdsProducts(purchase.getProducts()));
		for (final Product product : listProduct) {
			totalValue = totalValue + (product.getUnitaryValue() * product.getQuantityProductInPurchase());
		}
		return totalValue - purchase.getDiscount();
	}

	public List<Long> getListIdsProducts(final Set<Product> products) {
		final List<Long> results = new ArrayList<>();
		for (final Product product : products) {
			results.add(product.getId());
		}
		return results;
	}
}
