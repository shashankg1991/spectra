package com.spectra.jewel.model.order;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.enums.OrderStatus;
import com.spectra.jewel.model.enums.PaymentMethod;
import com.spectra.jewel.model.enums.ShippingMethod;
import com.spectra.jewel.model.product.Price;
import com.spectra.jewel.model.user.Address;
import com.spectra.jewel.model.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractOrder extends AbstractEntity {

	@SequenceGenerator(name = "codeGenerator")
	private String code;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Price totalPrice;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Price shippingPrice;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = "user")
	private Address shippingAddress;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = "user")
	private Address billingAddress;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JsonIgnoreProperties(value = { "roles", "listOfAddress" })
	private User user;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Price basePrice;

	private PaymentMethod paymentMethod;

	private Date deliveryDate;

	private OrderStatus status;

	private ShippingMethod shippingMethod;


}
