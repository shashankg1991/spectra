package com.spectra.jewel.converter;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.spectra.jewel.model.Product;
import com.spectra.jewel.solr.document.ProductDocument;

@Component("productToProductDocumentConverter")
public class ProductToProductDocumentConverter extends PopulatingConverter<Product, ProductDocument> {

	@Override
	public ProductDocument convert(Product source) {
		ProductDocument target = new ProductDocument();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(Product source, ProductDocument target) {
		String[] dummyCategories = { "Ring", "Earing", "Pendant" };
		target.setId(source.getId());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		target.setCategoryNames(Arrays.asList(dummyCategories[(int)( Math.random() * 3)]));
	}
}
