package com.dellas.app.dto;

public class UserDTO extends AbstractDTO {

	private String name;
	private String profile;
	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(final String profile) {
		this.profile = profile;
	}
}
