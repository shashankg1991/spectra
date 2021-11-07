package com.spectra.jewel.converter.product.ws;

import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.ProductWsData;
import com.spectra.jewel.facade.category.CategoryFacade;
import com.spectra.jewel.facade.generic.PriceFacade;
import com.spectra.jewel.facade.product.ProductDiamondGradeDetailFacade;
import com.spectra.jewel.facade.product.ProductImageFacade;
import com.spectra.jewel.facade.product.ProductMetalSizeEntryFacade;
import com.spectra.jewel.facade.product.ProductStoneEntryFacade;
import com.spectra.jewel.facade.product.StockLevelFacade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.product.Product;

@Component
public class ProductToProductWsDataConverter
		extends
			PopulatingConverter<Product, ProductWsData> {

	@Resource
	PriceFacade priceFacade;

	@Resource
	CategoryFacade categoryFacade;

	@Resource
	ProductMetalSizeEntryFacade productMetalSizeEntryFacade;

	@Resource
	StockLevelFacade stockLevelFacade;

	@Resource
	ProductImageFacade productImageFacade;

	@Resource
	ProductDiamondGradeDetailFacade productDiamondGradeDetailFacade;

	@Resource
	ProductStoneEntryFacade productStoneEntryFacade;

	@Override
	public ProductWsData convert(Product source) {
		ProductWsData target = new ProductWsData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(Product source, ProductWsData target) {
		target.setId(source.getId());
		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		target.setManufacturer(source.getManufacturer());
		target.setNotes(source.getNotes());
		target.setWastage(source.getWastage());
		target.setFixedLabor(
				priceFacade.getPriceWsData(source.getFixedLabor()));
		target.setVariableLabor(
				priceFacade.getPriceWsData(source.getVariableLabor()));
		target.setCategories(categoryFacade.getCategoriesWsData(source));
		if (Objects.nonNull(source.getMetalType())) {
			target.setMetalType(source.getMetalType().name());
		}
		if (Objects.nonNull(source.getColors())) {
			target.setMetalColors(source.getColors().stream()
					.map(MetalColor::name).collect(Collectors.toSet()));
		}
		target.setMetalEntries(productMetalSizeEntryFacade
				.getProductMetalSizeEntriesWsData(source));
		target.setStoneEntries(productStoneEntryFacade.getStoneEntriesWsData(source));
		target.setDiamondGradeDetails(productDiamondGradeDetailFacade
				.getProductDiamondGradeDetailsWsData(source));
		target.setStocks(stockLevelFacade.getStockLevelsWsData(source));
		target.setImages(productImageFacade.getImagesWsData(source));
		target.setDefaultDiamondGrade(
				source.getDefaultDiamondGrade().getName());
		target.setDefaultMetalColor(source.getDefaultMetalColor().name());
		target.setDefaultMetalPurity(source.getDefaultMetalPurity().name());
		target.setDefaultSize(source.getDefaultProductSize().name());
	}

}
