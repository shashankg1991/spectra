package com.spectra.jewel.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spectra.jewel.model.product.Category;
import com.spectra.jewel.repository.CategoryRepository;

@Component
public class CategoryDBWriter implements ItemWriter<Category> {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void write(List<? extends Category> categories) throws Exception {
		categoryRepository.saveAll(categories);
	}
}