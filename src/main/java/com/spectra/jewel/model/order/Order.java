package com.spectra.jewel.model.order;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends AbstractOrder {

	public List<OrderEntry> getOrderEnteries() {
		return orderEnteries;
	}

	public void setOrderEnteries(List<OrderEntry> orderEnteries) {
		this.orderEnteries = orderEnteries;
	}

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderEntry> orderEnteries;
}
