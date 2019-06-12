package com.spectra.jewel.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.model.product.Product;

@Component
public class ProductDataItemProcessor implements ItemProcessor<ProductData, Product> {

	@Override
	public Product process(ProductData productData) throws Exception {
		Product product = new Product();
		product.setName(productData.getName());
		product.setDescription(productData.getDescription());
		return product;
	}
}