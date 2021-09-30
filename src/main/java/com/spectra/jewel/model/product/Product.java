package com.spectra.jewel.model.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.collections.ItemCollection;
import com.spectra.jewel.model.enums.ProductStatus;
import com.spectra.jewel.model.enums.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "products")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractEntity {
	private String code;
	private String name;
	private String description;
	// Multiple metal entries added as there can be different types of metal in a
	// single product
	List<MetalEntry> metalEntries;
	List<Size> sizeOptions;
	// Multiple stone entries added as there can be different types of stone in a
	// single product
	List<StoneEntry> stoneEntries;
	List<Media> images;
	List<Stock> stocks;
	@Enumerated(EnumType.STRING)
	ProductStatus status;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<StoneEntry> stones = new ArrayList<StoneEntry>();

	@ManyToMany
	@ElementCollection(targetClass = ItemCollection.class)
	@JoinTable(name = "product_collections", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "collection_id", referencedColumnName = "id"))
	private Collection<ItemCollection> itemCollections;

}
