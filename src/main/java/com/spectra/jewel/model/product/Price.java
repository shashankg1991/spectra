package com.spectra.jewel.model.product;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.enums.Currency;

@Entity
@Table(name = "prices")
public class Price extends AbstractEntity {

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Double getPriceValue() {
		return priceValue;
	}

	public void setPriceValue(Double priceValue) {
		this.priceValue = priceValue;
	}

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