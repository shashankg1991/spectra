package com.spectra.jewel.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.stereotype.Service;

import com.spectra.jewel.converter.search.ProductToProductDocumentConverter;
import com.spectra.jewel.converter.search.SolrResultPageToSearchPageConverter;
import com.spectra.jewel.data.SolrSearchPageData;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.repository.solr.SolrProductRepository;
import com.spectra.jewel.service.SolrProductService;
import com.spectra.jewel.solr.document.ProductDocument;

@Service("solrProductService")
@SuppressWarnings("deprecation")
public class DefaultSolrProductService implements SolrProductService {

	private static final int DEFAULT_PAGE_SIZE = 12;

	@Autowired
	SolrProductRepository solrProductRepository;

	@Resource
	SolrResultPageToSearchPageConverter solrResultPageToSearchPageConverter;

	@Resource
	ProductToProductDocumentConverter productToProductDocumentConverter;

	@Override
	public SolrSearchPageData<ProductDocument> getAllProducts() {
		SolrResultPage<ProductDocument> result = solrProductRepository
				.getAllProducts(new PageRequest(0, DEFAULT_PAGE_SIZE));
		return solrResultPageToSearchPageConverter.convert(result);

	}

	@Override
	public SolrSearchPageData<ProductDocument> getProductsForCategory(
			String categoryCode, int page) {
		String filterQuery = "categoryCodes:" + categoryCode;
		return getProductsForFilters(filterQuery, page);
	}

	@Override
	public SolrSearchPageData<ProductDocument> getProductsForFilters(
			String filterQuery, int page) {
		SolrResultPage<ProductDocument> result = solrProductRepository
				.getProductsForFilter(prepareFilterQuery(filterQuery),
						new PageRequest(page, DEFAULT_PAGE_SIZE));
		SolrSearchPageData<ProductDocument> searchPageData = new SolrSearchPageData<ProductDocument>();
		searchPageData.setFilterQuery(filterQuery);
		solrResultPageToSearchPageConverter.populate(result, searchPageData);
		return searchPageData;
	}

	@Override
	public SolrSearchPageData<ProductDocument> findBySearchTerm(String searchTerm,
			int page) {
		SolrResultPage<ProductDocument> result = solrProductRepository
				.getProductsForSearchTerm(searchTerm,
						new PageRequest(page, DEFAULT_PAGE_SIZE));
		return solrResultPageToSearchPageConverter.convert(result);
	}

	@Override
	public SolrSearchPageData<ProductDocument> findBySearchTermAndFilters(
			String searchTerm, String filterQuery, int page) {
		SolrResultPage<ProductDocument> result = solrProductRepository
				.getProductsForSearchTermAndFilters(searchTerm,
						prepareFilterQuery(filterQuery),
						new PageRequest(page, DEFAULT_PAGE_SIZE));
		SolrSearchPageData<ProductDocument> searchPageData = new SolrSearchPageData<ProductDocument>();
		searchPageData.setFilterQuery(filterQuery);
		solrResultPageToSearchPageConverter.populate(result, searchPageData);
		return searchPageData;
	}

	private String prepareFilterQuery(String filterQuery) {
		return filterQuery.replaceAll(" AND", "\" AND").replaceAll(":", ":\"")
				.concat("\"");
	}

	@Override
	public void addToIndex(Product product) {
		solrProductRepository
				.save(productToProductDocumentConverter.convert(product));
	}

	public void deleteAll() {
		solrProductRepository.deleteAll();
	}
}
