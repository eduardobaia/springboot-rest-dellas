package com.dellas.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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

	@ManyToOne
	@JoinColumn(name = "ID_PROFILE", referencedColumnName = "ID_PROFILE")
	private Profile profile;

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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(final Profile profile) {
		this.profile = profile;
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
