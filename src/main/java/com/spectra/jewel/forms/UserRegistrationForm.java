package com.spectra.jewel.forms;

import java.io.Serializable;
import java.util.Collection;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.spectra.jewel.model.user.Role;

public class UserRegistrationForm implements Serializable {
	private static final long serialVersionUID = 4617181253350256012L;

	@NotEmpty(message = "Please enter first name")
	private String firstName;

	@NotEmpty(message = "Please enter last name")
	private String lastName;

	@NotEmpty(message = "Please enter email")
	@Email(message = "Please enter valid email")
	private String email;

	@NotEmpty(message = "Please enter username")
	private String username;

	@NotEmpty(message = "Please enter password")
	private String password;

	private Collection<Role> roles;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}
