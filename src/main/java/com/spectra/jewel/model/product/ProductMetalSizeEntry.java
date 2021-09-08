package com.spectra.jewel.model.product;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.MetalType;
import com.spectra.jewel.model.enums.ProductSize;

/**
 * Represents the metal weight for a product. The weight could vary with purity
 * and size of the item.
 * 
 * @author Shashank.Gupta
 *
 */
@Table(name = "productMetalSizeEntries")
@Entity
public class ProductMetalSizeEntry extends AbstractEntity {
	public ProductSize getSize() {
		return size;
	}

	public void setSize(ProductSize size) {
		this.size = size;
	}

	public MetalPurity getPurity() {
		return purity;
	}

	public void setPurity(MetalPurity purity) {
		this.purity = purity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	ProductSize size;
	MetalPurity purity;
	Double weight;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	Product product;

	public Double getWeight() {
		return weight;
	}

}
