package com.spectra.jewel.model.enums;

public enum ProductSize {
	UNIVERSAL("Universal"), RING_6("IN 6"), RING_7("IN 7"), RING_8("IN 8"), RING_9("IN 9"), RING_10("IN 10"),
	RING_11("IN 11"), RING_12("IN 12"), RING_13("IN 13"), RING_14("IN 14"), RING_15("IN 15"), RING_16("IN 16"),
	RING_17("IN 17"), RING_18("IN 18"), RING_19("IN 19"), RING_20("IN 20"), RING_21("IN 21"), RING_22("IN 22"),
	RING_23("IN 23"), RING_24("IN 24"), RING_25("IN 25"), RING_26("IN 26"), RING_27("IN 27"), RING_28("IN 28"),
	RING_29("IN 29"), RING_30("IN 30");

	private final String name;

	ProductSize(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
