package com.spectra.jewel.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.spectra.jewel.model.enums.WeightUnit;
import com.spectra.jewel.model.product.ProductDiamondEntry;
import com.spectra.jewel.model.product.ProductMetalSizeEntry;
import com.spectra.jewel.model.product.ProductStoneEntry;

@Entity
@Table(name = "weights")
public class Weight extends AbstractEntity {
	private Double weightValue;
	private WeightUnit unit;

	@OneToOne(mappedBy = "weight", cascade = {CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.MERGE})
	private ProductStoneEntry productStoneEntry;

	@OneToOne(mappedBy = "weight", cascade = {CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.MERGE})
	private ProductDiamondEntry productDiamondEntry;

	@OneToOne(mappedBy = "weight", cascade = {CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.MERGE})
	private ProductMetalSizeEntry productMetalSizeEntry;

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
	public ProductStoneEntry getProductStoneEntry() {
		return productStoneEntry;
	}
	public void setProductStoneEntry(ProductStoneEntry productStoneEntry) {
		this.productStoneEntry = productStoneEntry;
	}
	public ProductDiamondEntry getProductDiamondEntry() {
		return productDiamondEntry;
	}
	public void setProductDiamondEntry(ProductDiamondEntry productDiamondEntry) {
		this.productDiamondEntry = productDiamondEntry;
	}
	public ProductMetalSizeEntry getProductMetalSizeEntry() {
		return productMetalSizeEntry;
	}
	public void setProductMetalSizeEntry(
			ProductMetalSizeEntry productMetalSizeEntry) {
		this.productMetalSizeEntry = productMetalSizeEntry;
	}
	

}
