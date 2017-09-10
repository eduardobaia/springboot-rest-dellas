package com.dellas.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.dellas.app.model.domain.ProfileEnum;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USER", precision = 12, scale = 0)
	private Long id;

	@Column(name = "NAME_USER", nullable = false, length = 200)
	private String name;

	@Column(name = "LOGIN_USER", nullable = false, length = 50)
	private String login;

	@Column(name = "PASSWORD_USER", nullable = false, length = 100)
	private String password;

	@Version
	@Column(name = "VERSION_USER", nullable = false)
	private Integer version;

	@Enumerated(EnumType.STRING)
	@Type(type = "org.hibernate.type.EnumType", parameters = {
			@Parameter(name = "enumClass", value = "com.dellas.app.model.domain") })
	@Column(name = "PROFILE_USER", nullable = false, length = 1)
	private ProfileEnum profile;

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(final ProfileEnum profile) {
		this.profile = profile;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(final Integer version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

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

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getName()).append(getLogin()).append(getPassword()).toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		final User rhs = (User) obj;
		return new EqualsBuilder().append(getName(), rhs.getName()).append(getLogin(), rhs.getLogin())
				.append(getPassword(), rhs.getPassword()).isEquals();
	}
}
