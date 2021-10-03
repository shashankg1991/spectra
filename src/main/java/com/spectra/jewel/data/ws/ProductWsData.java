package com.spectra.jewel.data.ws;

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

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Double getWastage() {
		return wastage;
	}
	public void setWastage(Double wastage) {
		this.wastage = wastage;
	}
	public Double getFixedLabor() {
		return fixedLabor;
	}
	public void setFixedLabor(Double fixedLabor) {
		this.fixedLabor = fixedLabor;
	}
	public Double getVariableLabor() {
		return variableLabor;
	}
	public void setVariableLabor(Double variableLabor) {
		this.variableLabor = variableLabor;
	}
	public String getMetalType() {
		return metalType;
	}
	public void setMetalType(String metalType) {
		this.metalType = metalType;
	}

}
