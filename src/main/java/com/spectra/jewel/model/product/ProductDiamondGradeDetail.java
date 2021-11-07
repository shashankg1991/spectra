package com.spectra.jewel.model.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections4.CollectionUtils;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.enums.DiamondGrade;

/**
 * Stores the details of diamonds for a product for a particular grade/quality
 * An item could have diamond of different sizes and each size diamond would be
 * a product diamond entry
 * 
 * @author Shashank.Gupta
 *
 */
@Table(name = "productDiamondGradeDetails")
@Entity
public class ProductDiamondGradeDetail extends AbstractEntity {

	DiamondGrade grade;

	@OneToMany(mappedBy = "diamondGradeDetails", cascade = CascadeType.ALL)
	List<ProductDiamondEntry> entries;

	public DiamondGrade getGrade() {
		return grade;
	}

	public void setGrade(DiamondGrade grade) {
		this.grade = grade;
	}

	public List<ProductDiamondEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<ProductDiamondEntry> entries) {
		if (CollectionUtils.isNotEmpty(entries)) {
			for (ProductDiamondEntry entry : entries) {
				addDiamondEntry(entry);
			}
		} else {
			this.entries = entries;
		}
	}

	public void addDiamondEntry(ProductDiamondEntry entry) {
		if (entry != null) {
			if (entries == null) {
				entries = new ArrayList<ProductDiamondEntry>();
			}
			entries.add(entry);
			entry.setDiamondGradeDetails(this);
		}
	}

	// Don't delete product if grade details are deleted
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.MERGE})
	@JoinColumn(name = "product_id")
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
