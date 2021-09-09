package com.spectra.jewel.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.spectra.jewel.constants.JewelApplicationConstants;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.model.product.ProductDiamondGradeDetail;
import com.spectra.jewel.model.product.ProductImage;
import com.spectra.jewel.model.product.ProductMetalSizeEntry;
import com.spectra.jewel.repository.ProductRepository;
import com.spectra.jewel.service.ProductService;
import com.spectra.jewel.service.UnitConversionService;

@Service("productService")
public class DefaultProductService implements ProductService {
	@Resource
	ProductRepository productRepository;

	@Resource
	UnitConversionService conversionService;

	@Override
	public Product getProductForCode(String productCode) {
		return productRepository.findByCode(productCode);
	}

	@Override
	public Double getGrossWeight(Product product, MetalPurity metalPurity,
			ProductSize productSize) {
		ProductMetalSizeEntry metalSizeEntry = product.getMetalSizeEntries()
				.stream()
				.filter(entry -> Objects.nonNull(entry.getPurity())
						&& Objects.nonNull(entry.getSize())
						&& Objects.nonNull(entry.getWeight())
						&& entry.getPurity().equals(metalPurity)
						&& entry.getSize().equals(productSize))
				.findFirst().orElse(null);

		return Objects.nonNull(metalSizeEntry)
				? conversionService.convert(metalSizeEntry.getWeight(),
						JewelApplicationConstants.DEFAULT_METAL_WEIGHT_UNIT)
				: null;
	}

	@Override
	public Double getDiamondWeight(Product product, DiamondGrade diamondGrade) {
		if (Objects.nonNull(diamondGrade)) {
			if (CollectionUtils.isNotEmpty(product.getDiamondGradeDetails())) {
				ProductDiamondGradeDetail diamondGradeDetail = product
						.getDiamondGradeDetails().stream()
						.filter(entry -> CollectionUtils
								.isNotEmpty(entry.getEntries())
								&& Objects.nonNull(entry.getGrade())
								&& entry.getGrade().equals(diamondGrade))
						.findFirst().orElse(null);

				if (Objects.nonNull(diamondGradeDetail)) {
					return diamondGradeDetail.getEntries().stream()
							.filter(entry -> Objects.nonNull(entry.getWeight()))
							.mapToDouble(entry -> conversionService.convert(
									entry.getWeight(),
									JewelApplicationConstants.DEFAULT_DIAMOND_WEIGHT_UNIT))
							.sum();
				}
			}
		}
		return null;
	}

	@Override
	public Double getDiamondNumber(Product product, DiamondGrade diamondGrade) {
		if (Objects.nonNull(diamondGrade)) {
			if (CollectionUtils.isNotEmpty(product.getDiamondGradeDetails())) {
				ProductDiamondGradeDetail diamondGradeDetail = product
						.getDiamondGradeDetails().stream()
						.filter(entry -> CollectionUtils
								.isNotEmpty(entry.getEntries())
								&& Objects.nonNull(entry.getGrade())
								&& entry.getGrade().equals(diamondGrade))
						.findFirst().orElse(null);

				if (Objects.nonNull(diamondGradeDetail)) {
					return diamondGradeDetail.getEntries().stream()
							.filter(entry -> Objects.nonNull(entry.getNumber()))
							.mapToDouble(entry -> entry.getNumber()).sum();
				}
			}
		}
		return null;
	}

	@Override
	public Double getStonesWeight(Product product) {
		if (CollectionUtils.isNotEmpty(product.getStonesEntries())) {
			return product.getStonesEntries().stream()
					.filter(entry -> Objects.nonNull(entry.getWeight()))
					.mapToDouble(entry -> conversionService.convert(
							entry.getWeight(),
							JewelApplicationConstants.DEFAULT_STONE_WEIGHT_UNIT))
					.sum();
		}
		return 0d;
	}

	@Override
	public List<String> getImages(Product product, MetalColor metalColor) {
		if (CollectionUtils.isNotEmpty(product.getImages())) {
			List<ProductImage> productImages = product.getImages().stream()
					.filter(image -> Objects.nonNull(image.getColor())
							&& metalColor.equals(image.getColor()))
					.collect(Collectors.toList());

			if (CollectionUtils.isEmpty(productImages)
					&& !metalColor.equals(product.getDefaultMetalColor())) {
				return getImages(product, product.getDefaultMetalColor());
			}

			Collections.sort(productImages,
					Comparator.comparing(ProductImage::getSequence));
			return productImages.stream().map(ProductImage::getUrl)
					.collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

}
