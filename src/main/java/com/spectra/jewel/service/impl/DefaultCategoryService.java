package com.spectra.jewel.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spectra.jewel.model.product.Category;
import com.spectra.jewel.repository.CategoryRepository;
import com.spectra.jewel.service.CategoryService;

@Service("categoryService")
public class DefaultCategoryService implements CategoryService {

	@Resource
	CategoryRepository categoryRepository;

	@Override
	public Category getCategoryForCode(String categoryCode) {
		return categoryRepository.findCategoryByCode(categoryCode);
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Collection<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

}
