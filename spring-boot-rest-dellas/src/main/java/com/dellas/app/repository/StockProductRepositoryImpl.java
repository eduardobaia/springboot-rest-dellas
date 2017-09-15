package com.dellas.app.repository;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import com.dellas.app.model.Product;
import com.dellas.app.model.StockProduct;

public class StockProductRepositoryImpl extends AbstractRepository implements StockProductRepositoryCustom {

	@SuppressWarnings("unchecked")
	@Override
	public List<StockProduct> findByFilter(final StockProduct stockProduct) {
		final Criteria criteria = createCriteria(StockProduct.class);

		final DetachedCriteria productCriteria = DetachedCriteria.forClass(Product.class);
		productCriteria.setProjection(Projections.property("id"));

		if (stockProduct.getAmount() != null) {
			criteria.add(Restrictions.eq("amount", stockProduct.getAmount()));
		}
		if (stockProduct.getStatusIndicator() != null) {
			criteria.add(Restrictions.eq("statusIndicator", stockProduct.getStatusIndicator()));
		}
		if (stockProduct.getProduct() != null && StringUtils.isNotBlank(stockProduct.getProduct().getDescription())) {
			productCriteria.add(
					Restrictions.ilike("description", stockProduct.getProduct().getDescription(), MatchMode.ANYWHERE));
		}
		if (stockProduct.getProduct() != null && stockProduct.getProduct().getUnitaryValue() != null) {
			productCriteria.add(Restrictions.eq("unitaryValue", stockProduct.getProduct().getUnitaryValue()));
		}
		if (stockProduct.getProduct() != null && stockProduct.getProduct().getExpirationDate() != null) {
			productCriteria.add(Restrictions.eq("expirationDate", stockProduct.getProduct().getExpirationDate()));
		}
		criteria.add(Subqueries.propertyIn("product.id", productCriteria));
		return criteria.list();
	}
}
