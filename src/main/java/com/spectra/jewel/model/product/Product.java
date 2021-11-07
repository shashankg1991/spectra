package com.spectra.jewel.model.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.collections4.CollectionUtils;

import com.spectra.jewel.model.AbstractEntity;
import com.spectra.jewel.model.Price;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.MetalType;
import com.spectra.jewel.model.enums.ProductSize;

@Table(name = "products")
@Entity
public class Product extends AbstractEntity {
	private String code;
	private String name;
	private String description;
	private String manufacturer;
	private String notes;
	private Double wastage;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fixed_labor_price_id", referencedColumnName = "id")
	private Price fixedLabor;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "variable_labor_price_id", referencedColumnName = "id")
	private Price variableLabor;

	private MetalType metalType;

	private MetalColor defaultMetalColor;
	private MetalPurity defaultMetalPurity;
	private DiamondGrade defaultDiamondGrade;
	private ProductSize defaultProductSize;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<MetalColor> colors;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ProductDiamondGradeDetail> diamondGradeDetails;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ProductImage> images;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ProductStoneEntry> stonesEntries;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ProductMetalSizeEntry> metalSizeEntries;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<StockLevel> stocks;

	// Don't want to delete categories if product is deleted
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "rel_product_category", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
	private Collection<Category> categories;

	public void addDiamondGradeDetail(
			ProductDiamondGradeDetail productDiamondGradeDetail) {
		if (productDiamondGradeDetail != null) {
			if (diamondGradeDetails == null) {
				diamondGradeDetails = new ArrayList<ProductDiamondGradeDetail>();
			}
			diamondGradeDetails.add(productDiamondGradeDetail);
			productDiamondGradeDetail.setProduct(this);
		}
	}

	public void addImage(ProductImage image) {
		if (image != null) {
			if (images == null) {
				images = new ArrayList<ProductImage>();
			}
			images.add(image);
			image.setProduct(this);
		}
	}

	public void addStoneEntry(ProductStoneEntry stoneEntry) {
		if (stoneEntry != null) {
			if (stonesEntries == null) {
				stonesEntries = new ArrayList<ProductStoneEntry>();
			}
			stonesEntries.add(stoneEntry);
			stoneEntry.setProduct(this);
		}
	}

	public void addMetalSizeEntry(ProductMetalSizeEntry goldSizeEntry) {
		if (goldSizeEntry != null) {
			if (metalSizeEntries == null) {
				metalSizeEntries = new ArrayList<ProductMetalSizeEntry>();
			}
			metalSizeEntries.add(goldSizeEntry);
			goldSizeEntry.setProduct(this);
		}
	}

	public void addCategory(Category category) {
		if (category != null) {
			if (categories == null) {
				categories = new HashSet<Category>();
			}
			categories.add(category);
			//category.addProduct(this);
		}
	}

	public void addStock(StockLevel stock) {
		if (stock != null) {
			if (stocks == null) {
				stocks = new ArrayList<StockLevel>();
			}
			stocks.add(stock);
			stock.setProduct(this);
		}
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

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

	public Double getWastage() {
		return Objects.nonNull(wastage) ? wastage : 0d;
	}

	public void setWastage(Double wastage) {
		this.wastage = wastage;
	}

	public Price getFixedLabor() {
		return fixedLabor;
	}

	public void setFixedLabor(Price fixedLabor) {
		this.fixedLabor = fixedLabor;
		fixedLabor.setFixedLaborProduct(this);
	}

	public Price getVariableLabor() {
		return variableLabor;
	}

	public void setVariableLabor(Price variableLabor) {
		this.variableLabor = variableLabor;
		variableLabor.setVariableLaborProduct(this);
	}

	public List<ProductDiamondGradeDetail> getDiamondGradeDetails() {
		return diamondGradeDetails;
	}

	public void setDiamondGradeDetails(
			List<ProductDiamondGradeDetail> diamondGradeDetails) {
		if (CollectionUtils.isNotEmpty(diamondGradeDetails)) {
			for (ProductDiamondGradeDetail diamondGradeDetail : diamondGradeDetails) {
				addDiamondGradeDetail(diamondGradeDetail);
			}
		} else {
			this.diamondGradeDetails = diamondGradeDetails;
		}
	}

	public List<ProductImage> getImages() {
		return images;
	}

	public void setImages(List<ProductImage> images) {
		if (CollectionUtils.isNotEmpty(images)) {
			for (ProductImage image : images) {
				addImage(image);
			}
		} else {
			this.images = images;
		}
	}

	public List<ProductStoneEntry> getStonesEntries() {
		return stonesEntries;
	}

	public void setStonesEntries(List<ProductStoneEntry> stonesEntries) {
		if (CollectionUtils.isNotEmpty(stonesEntries)) {
			for (ProductStoneEntry stonesEntry : stonesEntries) {
				addStoneEntry(stonesEntry);
			}
		} else {
			this.stonesEntries = stonesEntries;
		}
	}

	public List<ProductMetalSizeEntry> getMetalSizeEntries() {
		return metalSizeEntries;
	}

	public void setMetalSizeEntries(
			List<ProductMetalSizeEntry> metalSizeEntries) {
		if (CollectionUtils.isNotEmpty(metalSizeEntries)) {
			for (ProductMetalSizeEntry metalSizeEntry : metalSizeEntries) {
				addMetalSizeEntry(metalSizeEntry);
			}
		} else {
			this.metalSizeEntries = metalSizeEntries;
		}
	}

	public List<StockLevel> getStocks() {
		return stocks;
	}

	public void setStocks(List<StockLevel> stocks) {
		if (CollectionUtils.isNotEmpty(stocks)) {
			for (StockLevel stock : stocks) {
				addStock(stock);
			}
		} else {
			this.stocks = stocks;
		}
	}

	public Collection<Category> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Category> categories) {
		if (CollectionUtils.isNotEmpty(categories)) {
			for (Category category : categories) {
				addCategory(category);
			}
		} else {
			this.categories = categories;
		}
	}

	public List<MetalColor> getColors() {
		return colors;
	}

	public void setColors(List<MetalColor> colors) {
		this.colors = colors;
	}

	public MetalColor getDefaultMetalColor() {
		return defaultMetalColor;
	}

	public void setDefaultMetalColor(MetalColor defaultMetalColor) {
		this.defaultMetalColor = defaultMetalColor;
	}

	public MetalPurity getDefaultMetalPurity() {
		return defaultMetalPurity;
	}

	public void setDefaultMetalPurity(MetalPurity defaultMetalPurity) {
		this.defaultMetalPurity = defaultMetalPurity;
	}

	public MetalType getMetalType() {
		return metalType;
	}

	public void setMetalType(MetalType metalType) {
		this.metalType = metalType;
	}

	public DiamondGrade getDefaultDiamondGrade() {
		return defaultDiamondGrade;
	}

	public void setDefaultDiamondGrade(DiamondGrade defaultDiamondGrade) {
		this.defaultDiamondGrade = defaultDiamondGrade;
	}

	public ProductSize getDefaultProductSize() {
		return defaultProductSize;
	}

	public void setDefaultProductSize(ProductSize defaultProductSize) {
		this.defaultProductSize = defaultProductSize;
	}

}
