package com.spectra.jewel.converter;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.model.product.ProductDiamondGradeDetail;
import com.spectra.jewel.model.product.ProductMetalSizeEntry;
import com.spectra.jewel.service.ProductService;

@Component("productToProductDataConverter")
public class ProductToProductDataConverter
		extends
			PopulatingConverter<Product, ProductData> {

	@Resource
	DiamondGradeToDiamondGradeDataConverter diamondGradeToDiamondGradeDataConverter;

	@Resource
	ProductSizeToProductSizeDataConverter productSizeToProductSizeDataConverter;

	@Resource
	MetalPurityToMetalPurityDataConverter metalPurityToMetalPurityDataConverter;

	@Resource
	ProductService productService;

	@Override
	public ProductData convert(Product source) {
		ProductData target = new ProductData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(Product source, ProductData target) {
		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		target.setManufacturer(source.getManufacturer());
		if (Objects.nonNull(source.getDiamondGradeDetails())) {
			Set<DiamondGrade> productDiamondGradeOptions = source
					.getDiamondGradeDetails().stream()
					.map(ProductDiamondGradeDetail::getGrade)
					.collect(Collectors.toSet());
			target.setDiamondGradeOptions(
					diamondGradeToDiamondGradeDataConverter
							.convertAll(productDiamondGradeOptions));
		}

		if (Objects.nonNull(source.getMetalSizeEntries())) {
			Set<MetalPurity> goldPurityOptions = source.getMetalSizeEntries()
					.stream()
					.filter(entry -> Objects.nonNull(entry.getPurity()))
					.map(ProductMetalSizeEntry::getPurity)
					.collect(Collectors.toSet());
			target.setMetalPurityOptions(metalPurityToMetalPurityDataConverter
					.convertAll(goldPurityOptions));

			Set<ProductSize> productSizeOptions = source.getMetalSizeEntries()
					.stream().filter(entry -> Objects.nonNull(entry.getSize()))
					.map(ProductMetalSizeEntry::getSize)
					.collect(Collectors.toSet());
			target.setSizeOptions(productSizeToProductSizeDataConverter
					.convertAll(productSizeOptions));
		}

		if (Objects.nonNull(source.getColors())) {
			target.setColorOptions(source.getColors().stream()
					.map(MetalColor::toString).collect(Collectors.toList()));
		}

		target.setMetalType(source.getMetalType().toString());

		// Default variant
		target.setDefaultMetalColor(source.getDefaultMetalColor().toString());
		target.setDefaultMetalPurity(source.getDefaultMetalPurity().toString());
		target.setDefaultDiamondGrade(
				source.getDefaultDiamondGrade().toString());
		target.setDefaultProductSize(source.getDefaultProductSize().toString());
	}

}
