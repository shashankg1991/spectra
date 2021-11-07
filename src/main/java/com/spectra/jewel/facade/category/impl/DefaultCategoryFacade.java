package com.spectra.jewel.facade.category.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.category.CategoryToCategoryDataConverter;
import com.spectra.jewel.converter.category.ws.CategoryToCategoryWsDataConverter;
import com.spectra.jewel.data.CategoryData;
import com.spectra.jewel.data.ws.CategoryWsData;
import com.spectra.jewel.facade.category.CategoryFacade;
import com.spectra.jewel.model.product.Category;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.service.CategoryService;

@Component("categoryFacade")
public class DefaultCategoryFacade implements CategoryFacade {

	@Resource
	CategoryToCategoryDataConverter categoryToCategoryDataConverter;

	@Resource
	CategoryToCategoryWsDataConverter categoryToCategoryWsDataConverter;

	@Resource
	CategoryService categoryService;

	@Override
	public CategoryData getCategoryForCode(String categoryCode) {
		final Category category = categoryService
				.getCategoryForCode(categoryCode);
		if (Objects.nonNull(category)) {
			return categoryToCategoryDataConverter.convert(category);
		}
		return null;
	}

	@Override
	public Collection<CategoryData> getAllCategories() {
		return categoryToCategoryDataConverter
				.convertAll(categoryService.getAllCategories());
	}

	@Override
	public Collection<CategoryWsData> getAllWsCategories() {
		return categoryToCategoryWsDataConverter
				.convertAll(categoryService.getAllCategories());
	}

	@Override
	public Collection<CategoryWsData> getCategoriesWsData(Product product) {
		return Objects.nonNull(product)
				&& CollectionUtils.isNotEmpty(product.getCategories())
						? categoryToCategoryWsDataConverter
								.convertAll(product.getCategories())
						: Collections.emptyList();
	}
}
