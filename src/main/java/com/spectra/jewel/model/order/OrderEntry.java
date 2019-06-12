package com.spectra.jewel.model.order;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spectra.jewel.model.enums.OrderStatus;

@Entity
@Table(name = "orderentries")
public class OrderEntry extends AbstractOrderEntry {

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Column(name = "order_status")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Order order;

}
