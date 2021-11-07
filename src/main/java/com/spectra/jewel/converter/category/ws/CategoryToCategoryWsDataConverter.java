package com.spectra.jewel.converter.category.ws;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.CategoryWsData;
import com.spectra.jewel.model.product.Category;

@Component("categoryToCategoryWsDataConverter")
public class CategoryToCategoryWsDataConverter
		extends
			PopulatingConverter<Category, CategoryWsData> {

	@Override
	public CategoryWsData convert(Category source) {
		CategoryWsData target = new CategoryWsData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(Category source, CategoryWsData target) {
		target.setId(source.getId());
		target.setCode(source.getCode());
		target.setName(source.getName());
	}

}
