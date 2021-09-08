package com.spectra.jewel.data;

import java.util.Date;
import java.util.List;

public class ProductVariantData {
	Double grossWeight;
	Double diamondWeight;
	Double diamondNumber;
	Double stonesWeight;
	String stockLevel;
	Date expectedDeliveryTime;
	PriceData productPrice;
	List<String> images;

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
	public PriceData getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(PriceData productPrice) {
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
	public Double getStonesWeight() {
		return stonesWeight;
	}
	public void setStonesWeight(Double stonesWeight) {
		this.stonesWeight = stonesWeight;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}

}
