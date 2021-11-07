package com.spectra.jewel.service;

import com.spectra.jewel.data.SolrSearchPageData;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.solr.document.ProductDocument;

public interface SolrProductService {
	SolrSearchPageData<ProductDocument> getAllProducts();

	SolrSearchPageData<ProductDocument> getProductsForCategory(String categoryCode, int page);

	SolrSearchPageData<ProductDocument> findBySearchTerm(String searchTerm, int page);

	void addToIndex(Product product);

	void deleteAll();

	SolrSearchPageData<ProductDocument> getProductsForFilters(String filterQuery,
			int page);

	SolrSearchPageData<ProductDocument> findBySearchTermAndFilters(
			String searchTerm, String filterQuery, int page);
}
