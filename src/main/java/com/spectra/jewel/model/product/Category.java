package com.spectra.jewel.model.product;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;

/**
 * Categorizes a product. The categories could be nested that helps in
 * navigating the user on the site. Could also be used to restict access to user
 * to particular categories.
 * 
 * @author Shashank.Gupta
 *
 */
@Table(name = "categories")
@Entity
public class Category extends AbstractEntity {
	String code;
	String name;
	String description;

	// Product shall not be deleted if category is deleted
	@ManyToMany(mappedBy = "categories", cascade = CascadeType.MERGE)
	Collection<Product> products;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.MERGE}, mappedBy = "superCategories")
	private Set<Category> subCategories = new HashSet<>();

	@JoinTable(name = "rel_category_category", joinColumns = {
			@JoinColumn(name = "supercategory_id", referencedColumnName = "id")}, inverseJoinColumns = {
					@JoinColumn(name = "subcategory_id", referencedColumnName = "id")})
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.MERGE})
	private Set<Category> superCategories = new HashSet<>();

	public void addProduct(Product product) {
		if (product != null) {
			if (products == null) {
				products = new HashSet<Product>();
			}
			products.add(product);
		}
	}

	public void addSuperCategory(Category superCategory) {
		superCategories.add(superCategory);
		// this.getSubCategories().add(superCategory);
	}

	public void removeSuperCategory(Category superCategory) {
		superCategories.remove(superCategory);
		// this.getSubCategories().remove(this);
	}

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

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProduct(Collection<Product> products) {
		this.products = products;
	}

	public Set<Category> getSubCategories() {
		return subCategories;
	}

	public Set<Category> getSuperCategories() {
		return superCategories;
	}

}
