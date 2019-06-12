package com.spectra.jewel.model.user;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.collections.CollectionAssignment;
import com.spectra.jewel.model.enums.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

	private String firstName;

	private String lastName;

	private String email;

	@Column(unique = true)
	private String username;

	@Column(name = "mobileno")
	private String mobileNo;

	private String password;

	private boolean enabled;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address defaultAddress;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;

	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@ElementCollection(targetClass=Role.class)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;

	@ElementCollection(targetClass=CollectionAssignment.class)
	@JoinTable(name = "user_collectionassignment", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "collectionassignment_id", referencedColumnName = "id"))
	private Collection<CollectionAssignment> collectionAssignments;

	public User() {
		super();
		this.enabled = true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", firstName=").append(firstName).append(", lastName=")
				.append(lastName).append(", email=").append(email).append(", password=").append(password)
				.append(", enabled=").append(enabled).append(", roles=").append(roles).append("]");
		return builder.toString();
	}

}
