package com.spectra.jewel.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;

@Entity
@Table(name = "countries")
public class Country extends AbstractEntity {

	@Column(name = "countryname")
	private String countryName;

	@Column(name = "countrycode")
	private String countryCode;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
