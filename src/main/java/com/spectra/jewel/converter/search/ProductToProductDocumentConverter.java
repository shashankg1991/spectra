package com.spectra.jewel.converter.search;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ProductPriceData;
import com.spectra.jewel.exception.PriceException;
import com.spectra.jewel.model.enums.Currency;
import com.spectra.jewel.model.product.Category;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.service.ProductPriceService;
import com.spectra.jewel.solr.document.ProductDocument;

@Component("productToProductDocumentConverter")
public class ProductToProductDocumentConverter
		extends
			PopulatingConverter<Product, ProductDocument> {

	@Resource
	ProductPriceService productPriceService;

	@Override
	public ProductDocument convert(Product source) {
		ProductDocument target = new ProductDocument();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(Product source, ProductDocument target) {
		target.setId(source.getId());
		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		setPrice(source, target);
		setImages(source, target);
		setCategoryCodes(source, target);
		setCategoryNames(source, target);
		if (Objects.nonNull(target.getPriceValue())) {
			Double price = target.getPriceValue();
			if (price <= 10000) {
				target.setPriceRange("INR 0 - 10,000");

			} else if (price <= 20000) {
				target.setPriceRange("INR 10000 - 20,000");

			} else if (price <= 50000) {
				target.setPriceRange("INR 2,0000 - 50,000");

			} else if (price <= 100000) {
				target.setPriceRange("INR 5,0000 - 1,00,000");

			} else {
				target.setPriceRange("INR 1,00,000 above");
			}
		}
	}

	private void setPrice(Product source, ProductDocument target) {
		try {
			ProductPriceData priceData = productPriceService.getPrice(source,
					Currency.INR, source.getDefaultMetalPurity(),
					source.getDefaultDiamondGrade(),
					source.getDefaultProductSize());
			target.setPriceValue(priceData.getTotalPrice());
			target.setFormattedPrice(
					priceData.getCurrency() + priceData.getTotalPrice());
		} catch (PriceException e) {
			// TODO: handle exception
		}
	}

	private void setImages(Product source, ProductDocument target) {
		if (CollectionUtils.isNotEmpty(source.getImages())) {
			target.setImage(source.getImages().get(0).getUrl());
		}
	}

	private void setCategoryNames(Product source, ProductDocument target) {
		Set<String> categoryNames = new HashSet<String>();
		getCategoryNames(source.getCategories(), categoryNames);
		target.setCategoryNames(categoryNames);
	}

	private void setCategoryCodes(Product source, ProductDocument target) {
		Set<String> categoryCodes = new HashSet<String>();
		getCategoryCodes(source.getCategories(), categoryCodes);
		target.setCategoryCodes(categoryCodes);
	}
	void getCategoryCodes(Collection<Category> categories,
			Collection<String> categoryCodes) {
		if (CollectionUtils.isEmpty(categories))
			return;

		for (Category category : categories) {
			categoryCodes.add(category.getCode());
			getCategoryCodes(category.getSuperCategories(), categoryCodes);
		}
	}

	void getCategoryNames(Collection<Category> categories,
			Collection<String> categoryNames) {
		if (CollectionUtils.isEmpty(categories))
			return;

		for (Category category : categories) {
			categoryNames.add(category.getName());
			getCategoryNames(category.getSuperCategories(), categoryNames);
		}
	}
}
