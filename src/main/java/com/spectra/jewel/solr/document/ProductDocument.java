package com.spectra.jewel.solr.document;

import java.util.Collection;

import javax.persistence.Id;

import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "Product")
public class ProductDocument {
	@Id
	@Indexed(name = "id")
	private Long id;

	@Indexed(name = "code")
	private String code;

	@Indexed(name = "name")
	private String name;

	@Indexed(name = "description")
	private String description;

	@Indexed(name = "categoryCodes")
	private Collection<String> categoryCodes;

	@Indexed(name = "categoryNames", type = "string")
	private Collection<String> categoryNames;

	@Indexed(name = "priceValue")
	private Double priceValue;

	@Indexed(name = "formattedPrice")
	private String formattedPrice;

	@Indexed(name = "image")
	private String image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Collection<String> getCategoryCodes() {
		return categoryCodes;
	}

	public void setCategoryCodes(Collection<String> categoryCodes) {
		this.categoryCodes = categoryCodes;
	}

	public Collection<String> getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(Collection<String> categoryNames) {
		this.categoryNames = categoryNames;
	}

	public Double getPriceValue() {
		return priceValue;
	}

	public void setPriceValue(Double priceValue) {
		this.priceValue = priceValue;
	}

	public String getFormattedPrice() {
		return formattedPrice;
	}

	public void setFormattedPrice(String formattedPrice) {
		this.formattedPrice = formattedPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
