package com.spectra.jewel.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.spectra.jewel.data.CategoryData;
import com.spectra.jewel.model.product.Category;

@Component
public class CategoryDataItemProcessor implements ItemProcessor<CategoryData, Category> {

	@Override
	public Category process(CategoryData categoryData) throws Exception {
		Category category = new Category();
		category.setCode(categoryData.getCode());
		category.setName(categoryData.getName());
		return category;
	}
}