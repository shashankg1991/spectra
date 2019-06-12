package com.spectra.jewel.model.user;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;

@Entity
@Table(name = "roles")
public class Role extends AbstractEntity {

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "roles")
	private Collection<User> users;

	private String name;

	public Role() {
		super();
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [name=").append(name).append("]").append("[id=").append(id).append("]");
		return builder.toString();
	}
}
