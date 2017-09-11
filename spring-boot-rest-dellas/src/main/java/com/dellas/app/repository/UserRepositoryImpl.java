package com.dellas.app.repository;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.dellas.app.model.User;

public class UserRepositoryImpl extends AbstractRepository implements UserRepositoryCustom {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByFilter(final User user) {
		final Criteria criteria = createCriteria(User.class);

		if (StringUtils.isNotBlank(user.getName())) {
			criteria.add(Restrictions.ilike("name", user.getName(), MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(user.getLogin())) {
			criteria.add(Restrictions.eq("login", user.getLogin()).ignoreCase());
		}
		if (user.getProfile() != null) {
			criteria.add(Restrictions.eq("profile", user.getProfile()));
		}
		return criteria.list();
	}
}