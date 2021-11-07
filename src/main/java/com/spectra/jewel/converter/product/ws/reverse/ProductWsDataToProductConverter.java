package com.spectra.jewel.converter.product.ws.reverse;

import java.util.ArrayList;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.converter.generic.ws.reverse.PriceWsDataToPriceConverter;
import com.spectra.jewel.data.ws.CategoryWsData;
import com.spectra.jewel.data.ws.ProductWsData;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.MetalType;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.product.Category;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.service.CategoryService;

@Component
public class ProductWsDataToProductConverter
		extends
			PopulatingConverter<ProductWsData, Product> {

	@Resource
	CategoryService categoryService;

	@Resource
	PriceWsDataToPriceConverter priceWsDataToPriceConverter;

	@Resource
	ProductMetalSizeEntryWsDataToProductMetalSizeEntryConverter productMetalSizeEntryWsDataToProductMetalSizeEntryConverter;

	@Resource
	ProductStoneEntryWsDataToProductStoneEntryConverter productStoneEntryWsDataToProductStoneEntryConverter;

	@Resource
	ProductImageWsDataToProductImageConverter productImageWsDataToProductImageConverter;

	@Resource
	StockLevelWsDataToStockLevelConverter stockLevelWsDataToStockLevelConverter;

	@Resource
	ProductDiamondGradeDetailWsDataToProductDiamondGradeDetailConverter productDiamondGradeDetailWsDataToProductDiamondGradeDetailConverter;

	@Override
	public Product convert(final ProductWsData source) {
		Product target = new Product();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(final ProductWsData source, Product target) {
		target.setId(source.getId());
		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		target.setManufacturer(source.getManufacturer());
		target.setNotes(source.getNotes());

		if (CollectionUtils.isNotEmpty(source.getCategories())) {
			ArrayList<Category> categories = new ArrayList<Category>();
			for (CategoryWsData category : source.getCategories()) {
				categories.add(
						categoryService.getCategoryForCode(category.getCode()));
			}
			target.setCategories(categories);
		}

		target.setWastage(source.getWastage());
		if (Objects.nonNull(source.getFixedLabor())) {
			target.setFixedLabor(priceWsDataToPriceConverter
					.convert(source.getFixedLabor()));
		}
		if (Objects.nonNull(source.getVariableLabor())) {
			target.setVariableLabor(priceWsDataToPriceConverter
					.convert(source.getVariableLabor()));
		}
		if (StringUtils.isNotEmpty(source.getMetalType())) {
			target.setMetalType(MetalType.valueOf(source.getMetalType()));
		}
		if (CollectionUtils.isNotEmpty(source.getMetalColors())) {
			ArrayList<MetalColor> colors = new ArrayList<MetalColor>();
			for (String color : source.getMetalColors()) {
				colors.add(MetalColor.valueOf(color));
			}
			target.setColors(colors);
		}
		if (CollectionUtils.isNotEmpty(source.getMetalEntries())) {
			target.setMetalSizeEntries(
					productMetalSizeEntryWsDataToProductMetalSizeEntryConverter
							.convertAll(source.getMetalEntries()));
		}
		if (CollectionUtils.isNotEmpty(source.getStoneEntries())) {
			target.setStonesEntries(
					productStoneEntryWsDataToProductStoneEntryConverter
							.convertAll(source.getStoneEntries()));
		}
		if (CollectionUtils.isNotEmpty(source.getImages())) {
			target.setImages(productImageWsDataToProductImageConverter
					.convertAll(source.getImages()));
		}
		if (CollectionUtils.isNotEmpty(source.getStocks())) {
			target.setStocks(stockLevelWsDataToStockLevelConverter
					.convertAll(source.getStocks()));
		}
		if (CollectionUtils.isNotEmpty(source.getDiamondGradeDetails())) {
			target.setDiamondGradeDetails(
					productDiamondGradeDetailWsDataToProductDiamondGradeDetailConverter
							.convertAll(source.getDiamondGradeDetails()));
		}
		if (Objects.nonNull(source.getDefaultMetalColor())) {
			target.setDefaultMetalColor(
					MetalColor.valueOf(source.getDefaultMetalColor()));
		}
		if (Objects.nonNull(source.getDefaultMetalPurity())) {
			target.setDefaultMetalPurity(
					MetalPurity.valueOf(source.getDefaultMetalPurity()));
		}
		if (Objects.nonNull(source.getDefaultSize())) {
			target.setDefaultProductSize(
					ProductSize.valueOf(source.getDefaultSize()));
		}
		if (Objects.nonNull(source.getDefaultDiamondGrade())) {
			target.setDefaultDiamondGrade(
					DiamondGrade.valueOf(source.getDefaultDiamondGrade()));
		}
	}
}
