package com.spectra.jewel.batch;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.model.collections.ItemCollection;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.repository.ItemCollectionRepository;

@Component
public class ProductDataItemProcessor implements ItemProcessor<ProductData, Product> {

	@Autowired
	ItemCollectionRepository itemCollectionRepository;

	@Override
	public Product process(ProductData productData) throws Exception {
		Product product = new Product();
		product.setCode(productData.getCode());
		product.setName(productData.getName());
		product.setDescription(productData.getDescription());
		if (StringUtils.isNotEmpty(productData.getCollectionsString())) {
			List<ItemCollection> itemCollections = new ArrayList<ItemCollection>();
			for (String collectionCode : productData.getCollectionsString().split(":")) {
				ItemCollection itemCollection = itemCollectionRepository.findItemCollectionByCode(collectionCode);
				if (null != itemCollection) {
					itemCollections.add(itemCollection);
				}
			}
			product.setItemCollections(itemCollections);
		}
		return product;
	}
}