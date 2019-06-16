package com.spectra.jewel.model.collections;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;

@Entity
@Table(name = "collectiongroups")
public class CollectionGroup extends AbstractEntity {

	private String code;
	private String name;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@ElementCollection(targetClass = ItemCollection.class)
	@JoinTable(name = "collectiongroup_collection", joinColumns = @JoinColumn(name = "collectiongroup_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "collection_id", referencedColumnName = "id"))
	private Collection<ItemCollection> collections;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<ItemCollection> getCollections() {
		return collections;
	}

	public void setCollections(Collection<ItemCollection> collections) {
		this.collections = collections;
	}

}
