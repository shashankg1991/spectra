package com.spectra.jewel.model.collections;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "collections")
public class ItemCollection extends AbstractEntity {
	private String code;
	private String name;

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
