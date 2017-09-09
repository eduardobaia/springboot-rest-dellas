package com.dellas.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.dellas.app.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
