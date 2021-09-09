package com.spectra.jewel.model.product;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.Price;
import com.spectra.jewel.model.Weight;
import com.spectra.jewel.model.enums.DiamondSize;

/**
 * Represents a particular size of diamond in a product. This is a sub-entry for
 * diamond details which is specific to particular grade. Price differs per
 * grade which is available at the parent level
 * 
 * @author Shashank.Gupta
 *
 */
@Table(name = "ProductDiamondEntries")
@Entity
public class ProductDiamondEntry extends AbstractEntity {
	DiamondSize size;
	Integer number;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "price_id", referencedColumnName = "id")
	Price rate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "weight_id", referencedColumnName = "id")
	Weight weight;

	// Grade details shall not be deleted on entry deletion
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.MERGE})
	@JoinColumn(name = "diamond_grade_details_id")
	ProductDiamondGradeDetail diamondGradeDetails;

	public DiamondSize getSize() {
		return size;
	}

	public void setSize(DiamondSize size) {
		this.size = size;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Price getRate() {
		return rate;
	}

	public void setRate(Price rate) {
		if (rate != null) {
			this.rate = rate;
			rate.setProdutDiamondEntry(this);
		}
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		if (weight != null) {
			this.weight = weight;
			weight.setProductDiamondEntry(this);
		}
	}

	public ProductDiamondGradeDetail getDiamondGradeDetails() {
		return diamondGradeDetails;
	}

	public void setDiamondGradeDetails(
			ProductDiamondGradeDetail diamondGradeDetails) {
		this.diamondGradeDetails = diamondGradeDetails;
	}

}
