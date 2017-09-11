package com.dellas.app.repository;

import java.util.List;

import com.dellas.app.model.User;

public interface UserRepositoryCustom {

	List<User> findByFilter(User user);
}
