package com.spectra.jewel.service;

import com.spectra.jewel.data.SearchPageData;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.solr.document.ProductDocument;

public interface SolrProductService {
	SearchPageData<ProductDocument> getAllProducts();

	SearchPageData<ProductDocument> getProductsForCategory(String categoryCode);

	SearchPageData<ProductDocument> findBySearchTerm(String searchTerm);

	void addToIndex(Product product);

	void deleteAll();
}
