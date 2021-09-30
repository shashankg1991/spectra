package com.spectra.jewel.model.product;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.enums.StockLevelStatus;

/**
 * Represents the availability of product for a specific combination of product
 * configuration
 * 
 * @author Shashank.Gupta
 *
 */
@Table(name = "stocks")
@Entity
public class StockLevel extends AbstractEntity {
	int quantity;
	Date expectedDeliveryTime;
	StockLevelStatus status;
	ProductSize size;
	DiamondGrade diamondGrade;
	MetalColor color;
	MetalPurity purity;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	Product product;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getExpectedDeliveryTime() {
		return expectedDeliveryTime;
	}

	public void setExpectedDeliveryTime(Date expectedDeliveryTime) {
		this.expectedDeliveryTime = expectedDeliveryTime;
	}

	public StockLevelStatus getStatus() {
		return status;
	}

	public void setStatus(StockLevelStatus status) {
		this.status = status;
	}

	public ProductSize getSize() {
		return size;
	}

	public void setSize(ProductSize size) {
		this.size = size;
	}

	public DiamondGrade getDiamondGrade() {
		return diamondGrade;
	}

	public void setDiamondGrade(DiamondGrade diamondGrade) {
		this.diamondGrade = diamondGrade;
	}

	public MetalColor getColor() {
		return color;
	}

	public void setColor(MetalColor color) {
		this.color = color;
	}

	public MetalPurity getPurity() {
		return purity;
	}

	public void setPurity(MetalPurity purity) {
		this.purity = purity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
