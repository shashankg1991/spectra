package com.spectra.jewel.service;

import com.spectra.jewel.data.SearchPageData;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.solr.document.ProductDocument;

public interface SolrProductService {
	SearchPageData<ProductDocument> getAllProducts();

	SearchPageData<ProductDocument> getProductsForCategory(String categoryCode, int page);

	SearchPageData<ProductDocument> findBySearchTerm(String searchTerm, int page);

	void addToIndex(Product product);

	void deleteAll();

	SearchPageData<ProductDocument> getProductsForFilters(String filterQuery,
			int page);

	SearchPageData<ProductDocument> findBySearchTermAndFilters(
			String searchTerm, String filterQuery, int page);
}
