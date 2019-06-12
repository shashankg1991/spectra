package com.spectra.jewel.service;

import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.data.SearchPageData;
import com.spectra.jewel.model.product.Product;

public interface SolrProductService {
	SearchPageData<ProductData> getAllProducts();

	SearchPageData<ProductData> getProductsForCategory(String categoryName);

	SearchPageData<ProductData> findBySearchTerm(String searchTerm);

	void addToIndex(Product product);
}
