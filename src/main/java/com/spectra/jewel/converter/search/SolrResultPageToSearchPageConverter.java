package com.spectra.jewel.converter.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.query.Field;
import org.springframework.data.solr.core.query.result.FacetEntry;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.FacetData;
import com.spectra.jewel.data.FacetEntryData;
import com.spectra.jewel.data.SolrSearchPageData;
import com.spectra.jewel.solr.document.ProductDocument;
import com.spectra.jewel.util.StringUtil;

@Component("solrResultPageToSearchPageConverter")
public class SolrResultPageToSearchPageConverter
		extends
			PopulatingConverter<SolrResultPage<ProductDocument>, SolrSearchPageData<ProductDocument>> {

	@Override
	public SolrSearchPageData<ProductDocument> convert(
			SolrResultPage<ProductDocument> source) {
		SolrSearchPageData<ProductDocument> target = new SolrSearchPageData<ProductDocument>();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(SolrResultPage<ProductDocument> source,
			SolrSearchPageData<ProductDocument> target) {
		target.setResults(source.getContent());

		Map<String, List<String>> currentSelectedFacetValues = getCurrentQueryFilters(
				target);

		Map<String, List<FacetEntryData>> fieldFacetEntriesMap = new HashMap<>();
		for (Page<? extends FacetEntry> page : source.getAllFacets()) {
			for (FacetEntry facetEntry : page.getContent()) {
				String facetName = ((Field) facetEntry.getKey()).getName();
				String facetEntryValue = facetEntry.getValue();
				List<FacetEntryData> entries = fieldFacetEntriesMap
						.get(facetName);
				if (CollectionUtils.isEmpty(entries)) {
					entries = new ArrayList<>();
				}

				FacetEntryData facetEntryData = new FacetEntryData();

				// Is facet value selected?
				if (currentSelectedFacetValues.containsKey(facetName)) {
					List<String> facetSelectedValues = currentSelectedFacetValues
							.get(facetName);
					facetEntryData.setSelected(
							facetSelectedValues.contains(facetEntryValue));
				}

				// Set selection/un-selection query
				String currentfilterQuery = StringUtils.isNotEmpty(
						target.getFilterQuery()) ? target.getFilterQuery() : "";

				String facetEntryQuery = facetName + ":" + facetEntryValue;

				if (!facetEntryData.getSelected()) {
					facetEntryData.setQuery(currentfilterQuery
							.concat(StringUtils.isBlank(currentfilterQuery)
									? facetEntryQuery
									: " AND " + facetEntryQuery));
				} else {
					facetEntryData.setQuery(currentfilterQuery
							.replaceAll("AND " + facetEntryQuery, "")
							.replace(facetEntryQuery, "")
							.replaceAll("  ", " "));
				}

				facetEntryData.setName(StringUtils.capitalize(facetEntryValue));
				facetEntryData.setCount(facetEntry.getValueCount());

				entries.add(facetEntryData);
				fieldFacetEntriesMap.put(facetName, entries);
			}
		}

		List<FacetData> facets = new ArrayList<>();
		for (String facetName : fieldFacetEntriesMap.keySet()) {
			FacetData facetData = new FacetData();
			facetData.setFacetName(StringUtils
					.capitalize(StringUtil.splitCamelCase(facetName)));
			facetData.setFacetCode(facetName);
			facetData.setFacetEntries(fieldFacetEntriesMap.get(facetName));
			facets.add(facetData);
		}
		target.setFacets(facets);

		target.setTotalPages(source.getTotalPages());
		target.setPageNumber(source.getPageable().getPageNumber());
		target.setTotalResults((int) source.getTotalElements());
	}

	private Map<String, List<String>> getCurrentQueryFilters(
			SolrSearchPageData<ProductDocument> target) {
		String[] currentQueryfilters = StringUtils
				.isNotEmpty(target.getFilterQuery())
						? target.getFilterQuery().split("AND")
						: null;

		Map<String, List<String>> currentSelectedFacetValues = new HashMap<String, List<String>>();
		if (Objects.nonNull(currentQueryfilters)
				&& currentQueryfilters.length > 0) {
			for (String filter : currentQueryfilters) {
				String[] filterNameAndValue = filter.trim().split(":");
				if (currentSelectedFacetValues
						.containsKey(filterNameAndValue[0])) {
					currentSelectedFacetValues.get(filterNameAndValue[0])
							.add(filterNameAndValue[1]);
				} else {
					currentSelectedFacetValues.put(filterNameAndValue[0],
							new ArrayList<String>(
									List.of(filterNameAndValue[1])));
				}
			}
		}
		return currentSelectedFacetValues;
	}

}
