package com.spectra.jewel.data;

import java.util.List;

public class ProductData {
	private String code;
	private String name;
	private String description;
	private String manufacturer;
	String metalType;
	List<String> categories;
	List<DiamondGradeData> diamondGradeOptions;
	List<MetalPurityData> metalPurityOptions;
	List<ProductSizeData> sizeOptions;
	List<String> colorOptions;
	String defaultMetalColor;
	String defaultMetalPurity;
	String defaultDiamondGrade;
	String defaultProductSize;
	ProductVariantData defaultProductVariant;

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

	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public List<DiamondGradeData> getDiamondGradeOptions() {
		return diamondGradeOptions;
	}
	public void setDiamondGradeOptions(
			List<DiamondGradeData> diamondGradeOptions) {
		this.diamondGradeOptions = diamondGradeOptions;
	}
	public List<MetalPurityData> getMetalPurityOptions() {
		return metalPurityOptions;
	}
	public void setMetalPurityOptions(
			List<MetalPurityData> metalPurityOptions) {
		this.metalPurityOptions = metalPurityOptions;
	}
	public List<ProductSizeData> getSizeOptions() {
		return sizeOptions;
	}
	public void setSizeOptions(List<ProductSizeData> sizeOptions) {
		this.sizeOptions = sizeOptions;
	}

	public List<String> getColorOptions() {
		return colorOptions;
	}
	public void setColorOptions(List<String> colorOptions) {
		this.colorOptions = colorOptions;
	}
	public String getDefaultMetalColor() {
		return defaultMetalColor;
	}
	public void setDefaultMetalColor(String defaultMetalColor) {
		this.defaultMetalColor = defaultMetalColor;
	}
	public String getDefaultMetalPurity() {
		return defaultMetalPurity;
	}
	public void setDefaultMetalPurity(String defaultMetalPurity) {
		this.defaultMetalPurity = defaultMetalPurity;
	}
	public String getMetalType() {
		return metalType;
	}
	public void setMetalType(String defaultMetalType) {
		this.metalType = defaultMetalType;
	}
	public String getDefaultDiamondGrade() {
		return defaultDiamondGrade;
	}
	public void setDefaultDiamondGrade(String defaultDiamondGrade) {
		this.defaultDiamondGrade = defaultDiamondGrade;
	}
	public String getDefaultProductSize() {
		return defaultProductSize;
	}
	public void setDefaultProductSize(String defaultProductSize) {
		this.defaultProductSize = defaultProductSize;
	}
	public ProductVariantData getDefaultProductVariant() {
		return defaultProductVariant;
	}
	public void setDefaultProductVariant(ProductVariantData defaultProductVariant) {
		this.defaultProductVariant = defaultProductVariant;
	}
	
}
