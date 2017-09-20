package com.dellas.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.dellas.app.model.PurchaseProductAmount;
import com.dellas.app.model.PurchaseProductId;

public interface PurchaseProductAmountRepository extends CrudRepository<PurchaseProductAmount, PurchaseProductId>{

}
