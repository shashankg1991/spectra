package com.spectra.jewel.model.product;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.enums.Currency;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "prices")
public class Price extends AbstractEntity {

	private Currency currency;

	private Double priceValue;

	public Price() {
		super();
	}

	public Price(Currency currency, Double priceValue) {
		super();
		this.currency = currency;
		this.priceValue = priceValue;
	}

}