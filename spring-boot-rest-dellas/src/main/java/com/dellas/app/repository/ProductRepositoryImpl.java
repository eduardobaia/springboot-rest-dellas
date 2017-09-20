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

public class ProductRepositoryImpl extends AbstractRepository implements ProductRepositoryCustom{

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByFilter(final Product product) {
		final Criteria criteria = createCriteria(Product.class);

		final DetachedCriteria stockProductCriteria = DetachedCriteria.forClass(StockProduct.class);
		stockProductCriteria.setProjection(Projections.property("id"));

		if (StringUtils.isNotBlank(product.getDescription())) {
			criteria.add(Restrictions.ilike("description", product.getDescription(), MatchMode.ANYWHERE));
		}
		if (product.getUnitaryValue() != null) {
			criteria.add(Restrictions.eq("unitaryValue", product.getUnitaryValue()));
		}
		if (product.getExpirationDate() != null) {
			criteria.add(Restrictions.eq("expirationDate", product.getExpirationDate()));
		}
		if (product.getStockProduct() != null && product.getStockProduct().getAmount() != null) {
			stockProductCriteria.add(Restrictions.eq("amount", product.getStockProduct().getAmount()));
		}
		if (product.getStockProduct() != null && product.getStockProduct().getStatusIndicator() != null) {
			stockProductCriteria.add(Restrictions.eq("statusIndicator", product.getStockProduct().getStatusIndicator()));
		}
		criteria.add(Subqueries.propertyIn("stockProduct.id", stockProductCriteria));
		return criteria.list();
	}

}
