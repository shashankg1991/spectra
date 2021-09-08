package com.spectra.jewel.model.product;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	@ManyToMany(mappedBy = "categories", cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	Collection<Product> products;

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

}
