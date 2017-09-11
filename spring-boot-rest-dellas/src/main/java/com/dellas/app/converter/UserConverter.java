package com.dellas.app.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.dellas.app.dto.UserDTO;
import com.dellas.app.model.User;
import com.dellas.app.model.domain.ProfileEnum;

public class UserConverter {

	public static User toModel(final UserDTO userDTO) {
		final User user = new User();
		user.setId(userDTO.getId());
		user.setLogin(userDTO.getLogin());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		if (StringUtils.isNotBlank(userDTO.getProfile())) {
			user.setProfile(ProfileEnum.from(userDTO.getProfile()));
		}
		user.setVersion(userDTO.getVersion());
		return user;
	}

	public static UserDTO toDTO(final User user) {
		final UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setLogin(user.getLogin());
		userDTO.setName(user.getName());
		userDTO.setPassword(user.getPassword());
		userDTO.setProfile(user.getProfile().getDescricao());
		userDTO.setVersion(user.getVersion());
		return userDTO;
	}

	public static List<UserDTO> toListDTO(final List<User> list) {
		final List<UserDTO> results = new ArrayList<>();
		for (final User user : list) {
			results.add(toDTO(user));
		}
		return results;
	}

	public static UserDTO toDTO(final Map<String, String> params) {
		final UserDTO retorno = new UserDTO();
		for (final Map.Entry<String, String> entry : params.entrySet()) {
			if (entry.getKey().equalsIgnoreCase("name")) {
				retorno.setName(entry.getValue());
			}
			if (entry.getKey().equalsIgnoreCase("profile")) {
				retorno.setProfile(entry.getValue());
			}
			if (entry.getKey().equalsIgnoreCase("login")) {
				retorno.setLogin(entry.getValue());
			}
			if (entry.getKey().equalsIgnoreCase("password")) {
				retorno.setPassword(entry.getValue());
			}
		}
		return retorno;
	}
}
