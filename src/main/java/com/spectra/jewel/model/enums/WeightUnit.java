package com.spectra.jewel.model.enums;

public enum WeightUnit {
	Carat(" ct"), Gram(" gms"), Milligram(" mgms"), Ounce(" oz");

	private final String symbol;

	WeightUnit(String sybmol) {
		this.symbol = sybmol;
	}

	public String getSymbol() {
		return symbol;
	}
}
