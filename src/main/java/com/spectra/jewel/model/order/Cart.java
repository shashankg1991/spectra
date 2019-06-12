package com.spectra.jewel.model.order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart extends AbstractOrder {

	public List<CartEntry> getCartEnteries() {
		return cartEnteries;
	}

	public void setCartEnteries(List<CartEntry> cartEnteries) {
		this.cartEnteries = cartEnteries;
	}

	@ElementCollection(targetClass=Collection.class)
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartEntry> cartEnteries = new ArrayList<>();

}
