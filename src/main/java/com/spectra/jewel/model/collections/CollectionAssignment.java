package com.spectra.jewel.model.collections;

import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "collectionassignments")
public class CollectionAssignment extends AbstractEntity {

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
