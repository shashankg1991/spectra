package com.spectra.jewel.model.order;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.Price;
import com.spectra.jewel.model.product.Product;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractOrderEntry extends AbstractEntity {

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Price getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Price basePrice) {
		this.basePrice = basePrice;
	}

	public Price getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Price discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	@OneToOne(cascade = CascadeType.DETACH)
	private Product product;

	private Long quantity;

	@OneToOne(cascade = CascadeType.ALL)
	private Price basePrice;

	@OneToOne(cascade = CascadeType.ALL)
	private Price discountPrice;

	private Date shippingDate;

}
