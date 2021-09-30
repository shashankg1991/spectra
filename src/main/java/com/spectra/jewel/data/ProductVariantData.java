package com.spectra.jewel.data;

import java.util.Date;
import java.util.List;

public class ProductVariantData {
	Double grossWeight;
	Double diamondWeight;
	Double diamondNumber;
	Double stoneWeight;
	String stockLevel;
	Date expectedDeliveryTime;
	ProductPriceData productPrice;
	List<String> images;
	String diamondWeightUnit;
	String stoneWeightUnit;
	String metalWeightUnit;

	public Double getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
	}
	public String getStockLevel() {
		return stockLevel;
	}
	public void setStockLevel(String stockLevel) {
		this.stockLevel = stockLevel;
	}
	public Date getExpectedDeliveryTime() {
		return expectedDeliveryTime;
	}
	public void setExpectedDeliveryTime(Date expectedDeliveryTime) {
		this.expectedDeliveryTime = expectedDeliveryTime;
	}
	public ProductPriceData getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(ProductPriceData productPrice) {
		this.productPrice = productPrice;
	}
	public Double getDiamondWeight() {
		return diamondWeight;
	}
	public void setDiamondWeight(Double diamondWeight) {
		this.diamondWeight = diamondWeight;
	}
	public Double getDiamondNumber() {
		return diamondNumber;
	}
	public void setDiamondNumber(Double diamondNumber) {
		this.diamondNumber = diamondNumber;
	}
	public Double getStoneWeight() {
		return stoneWeight;
	}
	public void setStoneWeight(Double stoneWeight) {
		this.stoneWeight = stoneWeight;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public String getDiamondWeightUnit() {
		return diamondWeightUnit;
	}
	public void setDiamondUnit(String diamondWeightUnit) {
		this.diamondWeightUnit = diamondWeightUnit;
	}
	public String getStoneWeightUnit() {
		return stoneWeightUnit;
	}
	public void setStoneWeightUnit(String stoneWeightUnit) {
		this.stoneWeightUnit = stoneWeightUnit;
	}
	public String getMetalWeightUnit() {
		return metalWeightUnit;
	}
	public void setMetalWeightUnit(String metalWeightUnit) {
		this.metalWeightUnit = metalWeightUnit;
	}

}
