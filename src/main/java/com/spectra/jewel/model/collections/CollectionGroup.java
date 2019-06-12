package com.spectra.jewel.model.collections;

import java.util.Collection;

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
@Table(name = "collectiongroups")
public class CollectionGroup extends AbstractEntity {
	private String code;
	private String name;

	@ElementCollection(targetClass=ItemCollection.class)
	@JoinTable(name = "collectiongroup_collection", joinColumns = @JoinColumn(name = "collectiongroup_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "collection_id", referencedColumnName = "id"))
	private Collection<ItemCollection> collections;

}
