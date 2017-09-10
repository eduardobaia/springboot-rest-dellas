package com.dellas.app.service;

import java.util.List;

import com.dellas.app.dto.UserDTO;

public interface UserService {

	List<UserDTO> findByFilter(UserDTO userDTO);

	List<UserDTO> findAll();

	UserDTO findById(Long id);

	UserDTO update(UserDTO userDTO);

	void delete(Long id);

	UserDTO persist(UserDTO userDTO);
}
