package com.spectra.jewel.model.product;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.Price;

/**
 * Represents a a stone other than diamond within a product like ruby, sapphire,
 * etc.
 * 
 * @author Shashank.Gupta
 *
 */
@Table(name = "productStoneEntries")
@Entity
public class ProductStoneEntry extends AbstractEntity {
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Price getRate() {
		return rate;
	}

	public void setRate(Price rate) {
		this.rate = rate;
		rate.setProductStoneEntry(this);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "price_id", referencedColumnName = "id")
	Price rate;

	Double weight;

	// Product shall not be deleted on deleting stone entry
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.MERGE})
	@JoinColumn(name = "product_id")
	Product product;

}
