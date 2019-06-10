package com.spectra.jewel.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.stereotype.Service;

import com.spectra.jewel.converter.ProductToProductDocumentConverter;
import com.spectra.jewel.converter.SolrResultPageToSearchPageConverter;
import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.data.SearchPageData;
import com.spectra.jewel.model.Product;
import com.spectra.jewel.repository.SolrProductRepository;
import com.spectra.jewel.service.SolrProductService;
import com.spectra.jewel.solr.document.ProductDocument;

@Service("solrProductService")
public class DefaultSolrProductService implements SolrProductService {

	@Autowired
	SolrProductRepository solrProductRepository;

	@Resource
	SolrResultPageToSearchPageConverter solrResultPageToSearchPageConverter;

	@Resource
	ProductToProductDocumentConverter productToProductDocumentConverter;

	@Override
	public SearchPageData<ProductData> getAllProducts() {
		SolrResultPage<ProductDocument> result = solrProductRepository.getAllProducts(new PageRequest(0, 10));
		return solrResultPageToSearchPageConverter.convert(result);

	}

	@Override
	public SearchPageData<ProductData> getProductsForCategory(String categoryName) {
		SolrResultPage<ProductDocument> result = solrProductRepository
				.getProductsForCategory("categoryNames:" + categoryName, new PageRequest(0, 10));
		return solrResultPageToSearchPageConverter.convert(result);
	}

	@Override
	public SearchPageData<ProductData> findBySearchTerm(String searchTerm) {
		SolrResultPage<ProductDocument> result = solrProductRepository.getProductsForSearchTerm(searchTerm,
				new PageRequest(0, 10));
		return solrResultPageToSearchPageConverter.convert(result);
	}

	@Override
	public void addToIndex(Product product) {
		solrProductRepository.save(productToProductDocumentConverter.convert(product));
	}
}
