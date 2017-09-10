package com.dellas.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.dellas.app.model.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Long>{

}
