package com.dellas.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dellas.app.converter.UserConverter;
import com.dellas.app.dto.UserDTO;
import com.dellas.app.model.User;
import com.dellas.app.repository.UserRepository;

@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	//TODO implementar regras de negocio

	@Override
	public List<UserDTO> findByFilter(final UserDTO sserDTO) {
		return null; // TODO implementar busca por filtro com criteria
	}

	@Override
	public List<UserDTO> findAll() {
		return UserConverter.toListDTO((List<User>) userRepository.findAll());
	}

	@Override
	public UserDTO findById(final Long id) {
		return UserConverter.toDTO(userRepository.findOne(id));
	}

	@Transactional(readOnly = false)
	@Override
	public UserDTO update(final UserDTO userDTO) {
		return UserConverter.toDTO(userRepository.save(UserConverter.toModel(userDTO)));
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(final Long id) {
		userRepository.delete(id);
	}

	@Transactional(readOnly = false)
	@Override
	public UserDTO persist(final UserDTO userDTO) {
		return UserConverter.toDTO(userRepository.save(UserConverter.toModel(userDTO)));
	}
}
