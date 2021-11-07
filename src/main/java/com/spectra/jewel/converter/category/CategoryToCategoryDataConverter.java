package com.spectra.jewel.converter.category;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.CategoryData;
import com.spectra.jewel.model.product.Category;

@Component("categoryToCategoryDataConverter")
public class CategoryToCategoryDataConverter
		extends
			PopulatingConverter<Category, CategoryData> {

	@Override
	public CategoryData convert(Category source) {
		CategoryData target = new CategoryData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(Category source, CategoryData target) {
		target.setId(source.getId());
		target.setCode(source.toString());
		target.setName(source.getName());
	}

}
