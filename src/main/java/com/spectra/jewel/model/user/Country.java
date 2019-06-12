package com.spectra.jewel.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country extends AbstractEntity {

	@Column(name = "countryname")
	private String countryName;

	@Column(name = "countrycode")
	private String countryCode;

}
