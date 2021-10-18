package com.spectra.jewel.service.impl;

import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.spectra.jewel.constants.JewelApplicationConstants;
import com.spectra.jewel.data.ProductPriceData;
import com.spectra.jewel.exception.PriceException;
import com.spectra.jewel.model.enums.Currency;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.model.product.ProductDiamondGradeDetail;
import com.spectra.jewel.model.product.ProductMetalSizeEntry;
import com.spectra.jewel.service.MetalPriceService;
import com.spectra.jewel.service.ProductPriceService;
import com.spectra.jewel.service.UnitConversionService;
import com.spectra.jewel.util.RoundingUtil;

@Service("productPriceService")
public class DefaultProductPriceService implements ProductPriceService {

	@Resource
	MetalPriceService metalPriceService;

	@Resource
	UnitConversionService conversionService;

	@Override
	public ProductPriceData getPrice(@NonNull Product product,
			@NonNull Currency currency, @NonNull MetalPurity metalPurity,
			DiamondGrade diamondGrade, @NonNull ProductSize productSize)
			throws PriceException {

		ProductPriceData priceData = new ProductPriceData();
		priceData.setMetalPrice(RoundingUtil.round(
				getMetalPrice(product, metalPurity, productSize, currency)));
		priceData.setStonesPrice(RoundingUtil.round(getStonesPrice(product)));
		priceData.setDiamondPrice(
				RoundingUtil.round(getDiamondPrice(product, diamondGrade)));
		priceData.setLabour(RoundingUtil
				.round(getLabor(product, metalPurity, productSize, currency)));
		priceData.setTotalPrice(RoundingUtil
				.round(priceData.getMetalPrice() + priceData.getDiamondPrice()
						+ priceData.getStonesPrice() + priceData.getLabour()));
		priceData.setCurrency(currency.getSymbol());

		// TODO: Handle currency

		return priceData;
	}

	private double getLabor(Product product, MetalPurity metalPurity,
			ProductSize productSize, Currency currency) throws PriceException {
		double grossWeight = getMetalWeight(product, metalPurity, productSize,
				false);
		double netWeight = getMetalWeight(product, metalPurity, productSize,
				true);
		return conversionService.convert(product.getFixedLabor(), JewelApplicationConstants.DEFAULT_FIXED_LABOR_PRICE_UNIT) 
				+ conversionService.convert(product.getVariableLabor(),
						JewelApplicationConstants.DEFAULT_VARIABLE_LABOR_PRICE_UNIT)
						* grossWeight
				+ (netWeight * (product.getWastage() / 100)
						* metalPriceService.getMetalUnitPriceInGram(
								product.getMetalType(), currency));
	}

	private double getDiamondPrice(Product product, DiamondGrade diamondGrade)
			throws PriceException {
		if (Objects.nonNull(diamondGrade)) {
			if (CollectionUtils.isNotEmpty(product.getDiamondGradeDetails())) {
				ProductDiamondGradeDetail diamondGradeDetail = product
						.getDiamondGradeDetails().stream()
						.filter(entry -> CollectionUtils
								.isNotEmpty(entry.getEntries())
								&& Objects.nonNull(entry.getGrade())
								&& entry.getGrade().equals(diamondGrade))
						.findFirst()
						.orElseThrow(() -> new PriceException(
								"No diamond entry found for product "
										+ product.getCode()));

				return diamondGradeDetail.getEntries().stream()
						.filter(entry -> Objects.nonNull(entry.getRate())
								&& Objects.nonNull(entry.getWeight()))
						.mapToDouble(entry -> conversionService.convert(
								entry.getWeight(),
								JewelApplicationConstants.DEFAULT_DIAMOND_WEIGHT_UNIT)
								* conversionService.convert(entry.getRate(),
										JewelApplicationConstants.DEFAULT_DIAMOND_PRICE_UNIT))
						.sum();
			}
			throw new PriceException(
					"No diamond entry found for product " + product.getCode());
		}
		return 0d;
	}

	private double getStonesPrice(Product product) {
		// For stones values added are not per unit but rather lumpsum
		if (CollectionUtils.isNotEmpty(product.getStonesEntries())) {
			return product.getStonesEntries().stream()
					.filter(entry -> Objects.nonNull(entry.getWeight())
							&& Objects.nonNull(entry.getRate()))
					.mapToDouble(entry -> conversionService.convert(
							entry.getWeight(),
							JewelApplicationConstants.DEFAULT_STONE_WEIGHT_UNIT)
							* conversionService.convert(entry.getRate(),
									JewelApplicationConstants.DEFAULT_STONE_PRICE_UNIT))
					.sum();
		}
		return 0d;
	}

	private double getMetalPrice(Product product, MetalPurity metalPurity,
			ProductSize productSize, Currency currency) throws PriceException {
		if (CollectionUtils.isNotEmpty(product.getMetalSizeEntries())) {
			double metalWeight = getMetalWeight(product, metalPurity,
					productSize, true);
			return (metalWeight * metalPriceService
					.getMetalUnitPriceInGram(product.getMetalType(), currency));
		}

		throw new PriceException(
				"No gold size entry found for product " + product.getCode());
	}

	private double getMetalWeight(Product product, MetalPurity metalPurity,
			ProductSize productSize, boolean isNet) throws PriceException {
		ProductMetalSizeEntry metalSizeEntry = product.getMetalSizeEntries()
				.stream()
				.filter(entry -> Objects.nonNull(entry.getPurity())
						&& Objects.nonNull(entry.getSize())
						&& Objects.nonNull(entry.getWeight())
						&& entry.getPurity().equals(metalPurity)
						&& entry.getSize().equals(productSize))
				.findFirst()
				.orElseThrow(() -> new PriceException(
						"No gold size entry found for product "
								+ product.getCode()));

		return isNet
				? conversionService.convert(metalSizeEntry.getWeight(),
						JewelApplicationConstants.DEFAULT_METAL_WEIGHT_UNIT)
						* metalSizeEntry.getPurity().getPercentvalue()
				: conversionService.convert(metalSizeEntry.getWeight(),
						JewelApplicationConstants.DEFAULT_METAL_WEIGHT_UNIT);
	}
}
