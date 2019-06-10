package com.spectra.jewel.solr.document;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "Product")
public class ProductDocument {
	@Id
	@Indexed(name = "id", type = "long")
	private Long id;

	@Indexed(name = "name", type = "text")
	private String name;

	@Indexed(name = "description", type = "text")
	private String description;

	@Indexed(name = "categoryNames", type = "text")
	private List<String> categoryNames;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<String> getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(List<String> categoryNames) {
		this.categoryNames = categoryNames;
	}

	
}
