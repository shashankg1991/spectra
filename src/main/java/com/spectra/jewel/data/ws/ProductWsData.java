package com.spectra.jewel.data.ws;

import java.util.Collection;

import lombok.Data;

@Data
public class ProductWsData {
	private Long id;
	private String code;
	private String name;
	private String description;
	private String manufacturer;
	private String notes;
	private Collection<CategoryWsData> categories;
	private Double wastage;
	private PriceWsData fixedLabor;
	private PriceWsData variableLabor;
	private String metalType;
	private Collection<String> metalColors;
	private Collection<ProductMetalSizeEntryWsData> metalEntries;
	private Collection<ProductStoneEntryWsData> stoneEntries;
	private Collection<ProductDiamondGradeDetailWsData> diamondGradeDetails;
	private Collection<ImageWsData> images;
	private Collection<StockLevelWsData> stocks;
	private String defaultMetalColor;
	private String defaultMetalPurity;
	private String defaultSize;
	private String defaultDiamondGrade;
}
