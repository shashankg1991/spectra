package com.spectra.jewel.model.enums;

public enum DiamondGrade {
	
	SI_IJ("SI-IJ"), SI_GH("SI-GH"), VS_GH("VS-GH"), VVS_GH("VS-EF");

	private final String name;

	DiamondGrade(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
}
