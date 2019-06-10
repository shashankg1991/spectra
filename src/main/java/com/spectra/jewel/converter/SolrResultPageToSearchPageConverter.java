package com.spectra.jewel.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.query.Field;
import org.springframework.data.solr.core.query.result.FacetEntry;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.stereotype.Component;

import com.spectra.jewel.data.FacetData;
import com.spectra.jewel.data.FacetEntryData;
import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.data.SearchPageData;
import com.spectra.jewel.solr.document.ProductDocument;
import com.spectra.jewel.util.StringUtil;

@Component("solrResultPageToSearchPageConverter")
public class SolrResultPageToSearchPageConverter
		extends PopulatingConverter<SolrResultPage<ProductDocument>, SearchPageData<ProductData>> {

	@Resource
	ProductDocumentToProductDataConverter productDocumentToProductDataConverter;

	@Override
	public SearchPageData<ProductData> convert(SolrResultPage<ProductDocument> source) {
		SearchPageData<ProductData> target = new SearchPageData<ProductData>();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(SolrResultPage<ProductDocument> source, SearchPageData<ProductData> target) {
		target.setResults(productDocumentToProductDataConverter.convertAll(source.getContent()));
		Map<String, List<FacetEntryData>> fieldFacetEntriesMap = new HashMap<>();
		for (Page<? extends FacetEntry> page : source.getAllFacets()) {
			for (FacetEntry facetEntry : page.getContent()) {
				String facetName = ((Field) facetEntry.getKey()).getName();
				List<FacetEntryData> entries = fieldFacetEntriesMap.get(facetName);
				FacetEntryData facetEntryData = new FacetEntryData();
				facetEntryData.setName(StringUtils.capitalize(facetEntry.getValue()));
				facetEntryData.setCount(facetEntry.getValueCount());
				if (CollectionUtils.isEmpty(entries)) {
					entries = new ArrayList<>();
				}
				entries.add(facetEntryData);
				fieldFacetEntriesMap.put(facetName, entries);
			}
		}

		List<FacetData> facets = new ArrayList<>();
		for (String facetName : fieldFacetEntriesMap.keySet()) {
			FacetData facetData = new FacetData();
			facetData.setFacetName(StringUtils.capitalize(StringUtil.splitCamelCase(facetName)));
			facetData.setFacetCode(facetName);
			facetData.setFacetEntries(fieldFacetEntriesMap.get(facetName));
			facets.add(facetData);
		}
		target.setFacets(facets);
	}

}
