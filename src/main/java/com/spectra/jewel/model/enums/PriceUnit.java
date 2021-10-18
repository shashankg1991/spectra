package com.spectra.jewel.model.enums;

public enum PriceUnit {
	Lumpsum("N/A"), Per_Carat("/ct"), Per_Gram("/gm"), Per_Milligram(
			"/mg"), Per_Ounce("/oz");
	private final String symbol;
	private PriceUnit(String symbol) {
		this.symbol = symbol;
	}
	public String getSymbol() {
		return symbol;
	}

}
