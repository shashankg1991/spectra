package com.spectra.jewel.model.enums;

public enum ShippingMethod {
	NORMAL("NORMAL") , QUICK("QUICK");
	
	private String name;

	ShippingMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
