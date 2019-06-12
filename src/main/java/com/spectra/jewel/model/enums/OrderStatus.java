package com.spectra.jewel.model.enums;

public enum OrderStatus {
	CREATED("Created"), CANCEL("Cancel"), PAID("Paid"), CONFIRMED("Confirmed");

	private String name;

	private OrderStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
