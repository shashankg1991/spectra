package com.spectra.jewel.facade.impl;

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.constants.JewelApplicationConstants;
import com.spectra.jewel.converter.ProductToProductDataConverter;
import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.data.ProductVariantData;
import com.spectra.jewel.exception.PriceException;
import com.spectra.jewel.facade.ProductFacade;
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
			productVariantData.setExpectedDeliveryTime(
					stockLevel.getExpectedDeliveryTime());
		}

		productVariantData
				.setImages(productService.getImages(product, metalColor));

		return productVariantData;
	}

}
