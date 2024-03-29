package com.spectra.jewel.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.spectra.jewel.model.enums.Currency;
import com.spectra.jewel.model.enums.PriceUnit;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.model.product.ProductDiamondEntry;
import com.spectra.jewel.model.product.ProductStoneEntry;

@Entity
@Table(name = "prices")
public class Price extends AbstractEntity {

	private Currency currency;
	private Double priceValue;
	private PriceUnit unit;

	@OneToOne(mappedBy = "rate", cascade = {CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.MERGE})
	private ProductStoneEntry productStoneEntry;

	@OneToOne(mappedBy = "rate", cascade = {CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.MERGE})
	private ProductDiamondEntry produtDiamondEntry;
	
	@OneToOne(mappedBy = "fixedLabor", cascade = {CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.MERGE})
	private Product fixedLaborProduct;
	
	@OneToOne(mappedBy = "variableLabor", cascade = {CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.MERGE})
	private Product variableLaborProduct;
	

	public Price() {
		super();
	}

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

	public ProductStoneEntry getProductStoneEntry() {
		return productStoneEntry;
	}

	public void setProductStoneEntry(ProductStoneEntry productStoneEntry) {
		this.productStoneEntry = productStoneEntry;
	}

	public ProductDiamondEntry getProdutDiamondEntry() {
		return produtDiamondEntry;
	}

	public void setProdutDiamondEntry(ProductDiamondEntry produtDiamondEntry) {
		this.produtDiamondEntry = produtDiamondEntry;
	}
	

	public PriceUnit getUnit() {
		return unit;
	}

	public void setUnit(PriceUnit unit) {
		this.unit = unit;
	}

	public Product getFixedLaborProduct() {
		return fixedLaborProduct;
	}

	public void setFixedLaborProduct(Product product) {
		this.fixedLaborProduct = product;
	}
	
	public Product getVariableLaborProduct() {
		return variableLaborProduct;
	}

	public void setVariableLaborProduct(Product variableLaborproduct) {
		this.variableLaborProduct = variableLaborproduct;
	}

	public Price(Currency currency, Double priceValue) {
		super();
		this.currency = currency;
		this.priceValue = priceValue;
	}

}