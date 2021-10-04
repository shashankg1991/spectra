package com.spectra.jewel.data.ws;

import lombok.Data;

@Data
public class ProductWsData {
	private String code;
	private String name;
	private String description;
	private String manufacturer;
	private String notes;
	private Double wastage;
	private Double fixedLabor;
	private Double variableLabor;
	private String metalType;
}
