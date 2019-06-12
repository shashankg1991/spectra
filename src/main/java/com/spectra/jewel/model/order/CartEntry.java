package com.spectra.jewel.model.order;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cartentries")
public class CartEntry extends AbstractOrderEntry {

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@ManyToOne
	private Cart cart;

}
