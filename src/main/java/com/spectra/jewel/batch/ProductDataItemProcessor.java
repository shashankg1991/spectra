package com.spectra.jewel.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.repository.CategoryRepository;

@Component
public class ProductDataItemProcessor implements ItemProcessor<ProductData, Product> {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Product process(ProductData productData) throws Exception {
		Product product = new Product();
		product.setCode(productData.getCode());
		product.setName(productData.getName());
		product.setDescription(productData.getDescription());
		/*
		 * if (StringUtils.isNotEmpty(productData.getCollectionsString())) {
		 * List<Category> categories = new ArrayList<Category>(); for (String
		 * collectionCode : productData.getCollectionsString().split(":")) {
		 * Category itemCollection =
		 * categoryRepository.findCategoryByCode(collectionCode); if (null !=
		 * itemCollection) { categories.add(itemCollection); } }
		 * product.setCategories(categories); }
		 */
		return product;
	}
}