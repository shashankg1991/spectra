package com.spectra.jewel.facade.product.impl;

import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.spectra.jewel.constants.JewelApplicationConstants;
import com.spectra.jewel.converter.product.ProductToProductDataConverter;
import com.spectra.jewel.converter.product.ws.ProductToProductWsDataConverter;
import com.spectra.jewel.converter.product.ws.reverse.ProductWsDataToProductConverter;
import com.spectra.jewel.data.DBSearchPageData;
import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.data.ProductVariantData;
import com.spectra.jewel.data.ws.ProductWsData;
import com.spectra.jewel.exception.PriceException;
import com.spectra.jewel.facade.product.ProductFacade;
import com.spectra.jewel.model.enums.Currency;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.model.product.StockLevel;
import com.spectra.jewel.service.ProductPriceService;
import com.spectra.jewel.service.ProductService;
import com.spectra.jewel.service.StockLevelService;

@Component("productFacade")
public class DefaultProductFacade implements ProductFacade {
	@Resource
	ProductService productService;

	@Resource
	ProductPriceService productPriceService;

	@Resource
	StockLevelService stockLevelService;

	@Resource
	ProductToProductDataConverter productToProductDataConverter;

	@Resource
	ProductToProductWsDataConverter productToProductWsDataConverter;

	@Resource
	ProductWsDataToProductConverter productWsDataToProductConverter;

	@Override
	public ProductData getProductForCode(String productCode) {
		Product product = productService.getProductForCode(productCode);
		if (Objects.nonNull(product)) {
			ProductData productData = productToProductDataConverter
					.convert(product);
			productData.setDefaultProductVariant(getVariantProductData(
					productCode, product.getDefaultMetalPurity().toString(),
					product.getDefaultMetalColor().toString(),
					product.getDefaultProductSize().toString(),
					product.getDefaultDiamondGrade().toString()));
			return productData;
		}
		return null;
	}

	@Override
	public ProductVariantData getVariantProductData(String productCode,
			String metalPurityCode, String metalColorCode,
			String productSizeCode, String diamondGradeCode) {

		Product product = productService.getProductForCode(productCode);
		MetalPurity metalPurity = MetalPurity.valueOf(metalPurityCode);
		MetalColor metalColor = MetalColor.valueOf(metalColorCode);
		ProductSize productSize = ProductSize.valueOf(productSizeCode);
		DiamondGrade diamondGrade = DiamondGrade.valueOf(diamondGradeCode);

		// TODO: Use session currency
		ProductVariantData productVariantData = new ProductVariantData();

		productVariantData.setGrossWeight(productService.getGrossWeight(product,
				metalPurity, productSize));
		productVariantData.setDiamondWeight(
				productService.getDiamondWeight(product, diamondGrade));
		productVariantData
				.setStoneWeight(productService.getStonesWeight(product));
		productVariantData.setDiamondNumber(
				productService.getDiamondNumber(product, diamondGrade));
		productVariantData.setMetalWeightUnit(
				JewelApplicationConstants.DEFAULT_METAL_WEIGHT_UNIT
						.getSymbol());
		productVariantData.setDiamondUnit(
				JewelApplicationConstants.DEFAULT_DIAMOND_WEIGHT_UNIT
						.getSymbol());
		productVariantData.setStoneWeightUnit(
				JewelApplicationConstants.DEFAULT_STONE_WEIGHT_UNIT
						.getSymbol());

		try {
			productVariantData.setProductPrice(
					productPriceService.getPrice(product, Currency.INR,
							metalPurity, diamondGrade, productSize));
		} catch (PriceException priceException) {
			// TODO: Log
		}

		StockLevel stockLevel = stockLevelService.getStockLevel(product,
				metalPurity, metalColor, diamondGrade, productSize);
		if (Objects.nonNull(stockLevel)) {
			productVariantData.setStockLevel(stockLevel.getStatus().name());
		}

		productVariantData
				.setImages(productService.getImages(product, metalColor));

		return productVariantData;
	}

	@Override
	public ProductWsData getAdminProductForCode(String productCode) {
		Product product = productService.getProductForCode(productCode);
		if (Objects.nonNull(product)) {
			return productToProductWsDataConverter.convert(product);
		}
		return null;
	}

	@Override
	public void save(ProductWsData productWsData) {
		if (Objects.nonNull(productWsData)) {
			Product product = productWsDataToProductConverter
					.convert(productWsData);
			productService.save(product);
		}

	}

	@Override
	public DBSearchPageData<ProductWsData> findAll(Long id, String code,
			String text, int page) {
		if (Objects.isNull(id) && Objects.isNull(code)
				&& Objects.isNull(text)) {
			text = StringUtils.EMPTY;
		}
		Page<Product> searchResultPage = productService.findAll(id, code, text,
				page);
		DBSearchPageData<ProductWsData> dbSearchPageData = new DBSearchPageData<ProductWsData>();
		dbSearchPageData.setPageNumber(page);
		dbSearchPageData.setSearchId(id);
		dbSearchPageData.setSearchCode(code);
		dbSearchPageData.setSearchText(text);
		dbSearchPageData.setResults(productToProductWsDataConverter.convertAll(
				searchResultPage.get().collect(Collectors.toList())));
		dbSearchPageData.setTotalResults(searchResultPage.getTotalElements());
		dbSearchPageData.setTotalPages(searchResultPage.getTotalPages());
		return dbSearchPageData;
	}

	@Override
	public void deleteProductForCode(String productCode) {
		Product product = productService.getProductForCode(productCode);
		if (product != null) {
			productService.delete(product);
		}
	}
}
