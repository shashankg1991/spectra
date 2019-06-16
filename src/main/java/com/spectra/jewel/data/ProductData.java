package com.spectra.jewel.data;

import java.util.List;

public class ProductData {
	Long id;
	String code;
	Double grossWeight;
	String name;
	String description;
	List<String> categories;
	List<String> collections;
	String categoriesString;
	String collectionsString;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
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

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getCollections() {
		return collections;
	}

	public void setCollections(List<String> collections) {
		this.collections = collections;
	}

	public String getCategoriesString() {
		return categoriesString;
	}

	public void setCategoriesString(String categoriesString) {
		this.categoriesString = categoriesString;
	}

	public String getCollectionsString() {
		return collectionsString;
	}

	public void setCollectionsString(String collectionsString) {
		this.collectionsString = collectionsString;
	}

}
