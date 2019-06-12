package com.spectra.jewel.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.enums.AddressType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address extends AbstractEntity {

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "mobileno")
	private String mobileNo;

	@Enumerated(EnumType.STRING)
	@Column(name = "addresstype")
	private AddressType addressType;

	@Column(name = "addressline1")
	private String line1;

	@Column(name = "address_line_2")
	private String line2;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@ManyToOne
	private Country country;

	private boolean active;

	@Column(name = "company")
	private String company;

	@ManyToOne
	private User user;

}
