package com.spectra.jewel.data;

import java.util.List;

public class SearchPageData<T> {
	List<T> results;
	List<FacetData> facets;
	int pageNumber;
	int totalPages;
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
	
	
}
