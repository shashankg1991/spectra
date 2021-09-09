package com.spectra.jewel.model.enums;

public enum Currency {
	INR("INR "), USD("$ "), CAD("C$ ");

	private final String symbol;

	Currency(String sybmol) {
		this.symbol = sybmol;
	}

	public String getSymbol() {
		return symbol;
	}
}
