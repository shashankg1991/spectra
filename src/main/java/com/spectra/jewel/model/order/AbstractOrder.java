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

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractOrder extends AbstractEntity {

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Price getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Price totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Price getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(Price shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Price getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Price basePrice) {
		this.basePrice = basePrice;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

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
