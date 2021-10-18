package com.spectra.jewel.model.product;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.Weight;
import com.spectra.jewel.model.enums.MetalPurity;
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
	ProductSize size;
	MetalPurity purity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "weight_id", referencedColumnName = "id")
	Weight weight;

	@ManyToOne
	@JoinColumn(name = "product_id")
	Product product;

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

	public void setWeight(Weight weight) {
		if (weight != null) {
			this.weight = weight;
			weight.setProductMetalSizeEntry(this);
		}
	}

	public Weight getWeight() {
		return weight;
	}

}
