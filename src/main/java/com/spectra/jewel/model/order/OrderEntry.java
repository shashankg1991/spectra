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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orderentries")
public class OrderEntry extends AbstractOrderEntry {

	@Column(name = "order_status")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Order order;

}
