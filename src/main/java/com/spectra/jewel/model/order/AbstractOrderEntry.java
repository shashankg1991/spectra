package com.spectra.jewel.model.order;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.product.Price;
import com.spectra.jewel.model.product.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractOrderEntry extends AbstractEntity {

	@OneToOne(cascade = CascadeType.DETACH)
	private Product product;

	private Long quantity;

	@OneToOne(cascade = CascadeType.ALL)
	private Price basePrice;

	@OneToOne(cascade = CascadeType.ALL)
	private Price discountPrice;

	private Date shippingDate;

}
