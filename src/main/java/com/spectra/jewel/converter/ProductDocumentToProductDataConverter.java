package com.spectra.jewel.converter;

import org.springframework.stereotype.Component;

import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.solr.document.ProductDocument;

@Component("productDocumentToProductDataConverter")
public class ProductDocumentToProductDataConverter extends PopulatingConverter<ProductDocument, ProductData> {

	@Override
	public ProductData convert(ProductDocument source) {
		ProductData target = new ProductData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(ProductDocument source, ProductData target) {
		target.setId(source.getId());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		target.setCategories(source.getCategoryNames());
	}
}
