package com.spectra.jewel.repository.solr;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.spectra.jewel.solr.document.ProductDocument;

public interface SolrProductRepository
		extends
			SolrCrudRepository<ProductDocument, Long> {

	/*
	 * Facet fields are manually changed to type String in managed schema
	 * (SpectraSolr\server\solr\Product\conf\managed-schema)
	 **/
	// <field name="categoryCodes" type="string" multiValued="true"/>
	// <field name="categoryNames" type="string" multiValued="true"/>
	// <field name="code" type="string"/>

	@Facet(fields = {"categoryNames"}, minCount = 1)
	@Query(value = "*:*")
	public SolrResultPage<ProductDocument> getAllProducts(Pageable page);

	@Query(value = "*:*", filters = {"?0"})
	@Facet(fields = {"categoryNames", "priceRange"}, minCount = 1)
	public SolrResultPage<ProductDocument> getProductsForFilter(
			String filterQuery, Pageable page);

	/*
	 * _txt fields are manually added in managed schema
	 * (SpectraSolr\server\solr\Product\conf\managed-schema) to facilitate
	 * search for string fields
	 */
	// <copyField source="categoryNames" dest="categoryNames_txt"
	// maxChars="256"/>
	// <copyField source="code" dest="code_txt" maxChars="256"/>
	// <copyField source="name" dest="name_txt" maxChars="256"/>
	// <copyField source="description" dest="description_txt" maxChars="256"/>
	// <copyField source="categoryCodes" dest="categoryCodes_txt"
	// maxChars="256"/>

	@Query("id:*?0* OR code_txt:*?0* OR name_txt:*?0* OR description_txt:*?0* OR categoryNames_txt:*?0*")
	@Facet(fields = {"categoryNames", "priceRange"}, minCount = 1)
	public SolrResultPage<ProductDocument> getProductsForSearchTerm(
			String searchTerm, Pageable pageable);

	@Query("id:*?0* OR code_txt:*?0* OR name_txt:*?0* OR description_txt:*?0* OR categoryNames_txt:*?0*")
	@Facet(fields = {"categoryNames", "priceRange"}, minCount = 1)
	public SolrResultPage<ProductDocument> getProductsForSearchTermAndFilters(
			String searchTerm, String filterQuery, Pageable pageable);
}
