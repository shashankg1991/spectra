package com.spectra.jewel.data;

import java.util.List;

public class SearchPageData<T> {
	String filterQuery;
	List<T> results;
	List<FacetData> facets;
	int pageNumber;
	int totalPages;
	int totalResults;

	public String getFilterQuery() {
		return filterQuery;
	}
	public void setFilterQuery(String filterQuery) {
		this.filterQuery = filterQuery;
	}
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
	public List<FacetData> getFacets() {
		return facets;
	}
	public void setFacets(List<FacetData> facets) {
		this.facets = facets;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

}
