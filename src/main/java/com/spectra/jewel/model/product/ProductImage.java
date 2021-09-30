package com.spectra.jewel.model.product;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.enums.MetalColor;

/**
 * A product could be available in different gold colors. An image corresponds
 * to particular color of gold
 * 
 * @author Shashank.Gupta
 *
 */
@Table(name = "productImages")
@Entity
public class ProductImage extends AbstractEntity {
	private String url;
	private Integer sequence;
	private MetalColor color;

	// Product shall not be deleted on deleting image
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "product_id")
	private Product product;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public MetalColor getColor() {
		return color;
	}

	public void setColor(MetalColor color) {
		this.color = color;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
