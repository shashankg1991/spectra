package com.spectra.jewel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "products")
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "description", nullable = true)
	private String description;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Stone> stones = new ArrayList<Stone>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public List<Stone> getStones() {
		return stones;
	}

	public void setStones(List<Stone> stones) {
		this.stones = stones;
	}

}
