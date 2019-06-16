package com.spectra.jewel.model.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.collections.ItemCollection;

@Table(name = "products")
@Entity
public class Product extends AbstractEntity {
	private String code;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "description", nullable = true)
	private String description;
	private Double grossWeight;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Stone> stones = new ArrayList<Stone>();

	@ManyToMany
	@ElementCollection(targetClass = ItemCollection.class)
	@JoinTable(name = "product_collections", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "collection_id", referencedColumnName = "id"))
	private Collection<ItemCollection> itemCollections;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Stone> getStones() {
		return stones;
	}

	public void setStones(List<Stone> stones) {
		this.stones = stones;
	}

	public Collection<ItemCollection> getItemCollections() {
		return itemCollections;
	}

	public void setItemCollections(Collection<ItemCollection> itemCollections) {
		this.itemCollections = itemCollections;
	}

	public Double getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
	}

}
