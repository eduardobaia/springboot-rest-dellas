package com.dellas.app.repository;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.dellas.app.model.Product;

public class ProductRepositoryImpl extends AbstractRepository implements ProductRepositoryCustom{

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByFilter(final Product product) {
		final Criteria criteria = createCriteria(Product.class);

		if (StringUtils.isNotBlank(product.getDescription())) {
			criteria.add(Restrictions.ilike("description", product.getDescription(), MatchMode.ANYWHERE));
		}
		if (product.getAmount() != null) {
			criteria.add(Restrictions.eq("amount", product.getAmount()));
		}
		if (product.getUnitaryValue() != null) {
			criteria.add(Restrictions.eq("unitaryValue", product.getUnitaryValue()));
		}
		if (product.getExpirationDate() != null) {
			criteria.add(Restrictions.eq("expirationDate", product.getExpirationDate()));
		}
		return criteria.list();
	}

}
