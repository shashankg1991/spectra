package com.spectra.jewel.model.collections;

import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;

@Entity
@Table(name = "collectionassignments")
public class CollectionAssignment extends AbstractEntity {

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

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public java.util.Collection<ItemCollection> getCollections() {
		return collections;
	}

	public void setCollections(java.util.Collection<ItemCollection> collections) {
		this.collections = collections;
	}

	public Collection<CollectionGroup> getCollectionGroups() {
		return collectionGroups;
	}

	public void setCollectionGroups(Collection<CollectionGroup> collectionGroups) {
		this.collectionGroups = collectionGroups;
	}

	private String code;
	private String name;
	private Date expiryDate;
	
	@ElementCollection(targetClass=ItemCollection.class)
	@JoinTable(name = "collectiongroupassignment_collection", joinColumns = @JoinColumn(name = "collectiongroupassignment_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "collection_id", referencedColumnName = "id"))
	private java.util.Collection<ItemCollection> collections;

	@ElementCollection(targetClass=CollectionGroup.class)
	@JoinTable(name = "collectiongroupassignment_collectiongroup", joinColumns = @JoinColumn(name = "collectiongroupassignment_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "collectiongroup_id", referencedColumnName = "id"))
	private Collection<CollectionGroup> collectionGroups;

}
