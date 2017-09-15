package com.dellas.app.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.dellas.app.model.Purchase;

public class PurchaseRepositoryImpl extends AbstractRepository implements PurchaseRepositoryCustom{

	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> findByFilter(final Purchase purchase) {
		final Criteria criteria = createCriteria(Purchase.class);

		if (purchase.getDatePurchase() != null) {
			criteria.add(Restrictions.eq("datePurchase", purchase.getDatePurchase()));
		}
		if (purchase.getDiscount() != null) {
			criteria.add(Restrictions.eq("discount", purchase.getDiscount()));
		}
		if (purchase.getTotalValue() != null) {
			criteria.add(Restrictions.eq("totalValue", purchase.getTotalValue()));
		}
		if (purchase.getUser() != null && purchase.getUser().getId() != null) {
			criteria.add(Restrictions.eq("user.id", purchase.getUser().getId()));
		}
		return criteria.list();
	}
}
