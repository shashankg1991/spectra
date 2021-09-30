package com.spectra.jewel.model.collections;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.enums.CollectionType;

@Entity
@Table(name = "collections")
public class ItemCollection extends AbstractEntity {
	private String code;
	private String name;
	private CollectionType type;

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

}
