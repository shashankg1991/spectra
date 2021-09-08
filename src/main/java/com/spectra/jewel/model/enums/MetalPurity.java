package com.spectra.jewel.model.enums;

public enum MetalPurity {

	NINE_KARAT("9K", .375), FOURTEEN_KARAT("14K", .585), EIGHTEEN_KARAT("18K", .75), TWENTY_TWO_KARAT("22K", .916);

	private final String name;
	private final double percentValue;

	MetalPurity(String name, double percentValue) {
		this.name = name;
		this.percentValue = percentValue;
	}

	public String getName() {
		return this.name;
	}

	public double getPercentvalue() {
		return percentValue;
	}

}
