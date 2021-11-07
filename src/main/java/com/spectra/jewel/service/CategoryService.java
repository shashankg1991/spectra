package com.spectra.jewel.service;

import java.util.Collection;

import com.spectra.jewel.model.product.Category;

public interface CategoryService {
	Category getCategoryForCode(String categoryCode);

	Category save(Category category);

	Collection<Category> getAllCategories();

}
