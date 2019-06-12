package com.spectra.jewel.model.order;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cartentries")
public class CartEntry extends AbstractOrderEntry {

	@ManyToOne
	private Cart cart;

}
