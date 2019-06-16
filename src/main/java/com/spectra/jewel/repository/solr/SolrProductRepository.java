package com.spectra.jewel.repository.solr;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.spectra.jewel.solr.document.ProductDocument;

public interface SolrProductRepository extends SolrCrudRepository<ProductDocument, Long> {

	@Facet(fields = { "categoryNames" }, minCount = 1)
	@Query(value = "*:*")
	public SolrResultPage<ProductDocument> getAllProducts(Pageable page);

	@Query(value = "*:*", filters = { "?0" })
	@Facet(fields = { "categoryNames" }, minCount = 1)
	public SolrResultPage<ProductDocument> getProductsForCategory(String filterQuery, Pageable page);

	@Query("id:*?0* OR name:*?0*")
	@Facet(fields = { "categoryNames" }, minCount = 1)
	public SolrResultPage<ProductDocument> getProductsForSearchTerm(String searchTerm, Pageable pageable);
}
