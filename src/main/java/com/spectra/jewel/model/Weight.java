package com.spectra.jewel.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.spectra.jewel.model.enums.WeightUnit;

@Entity
@Table(name = "weights")
public class Weight extends AbstractEntity {
	private Double weightValue;
	private WeightUnit unit;

	public Double getWeightValue() {
		return weightValue;
	}
	public void setWeightValue(Double weightValue) {
		this.weightValue = weightValue;
	}
	public WeightUnit getUnit() {
		return unit;
	}
	public void setUnit(WeightUnit unit) {
		this.unit = unit;
	}

}
