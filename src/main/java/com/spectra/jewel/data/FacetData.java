package com.spectra.jewel.data;

import java.util.List;

public class FacetData {
	String facetCode;
	String facetName;
	List<FacetEntryData> facetEntries;
	public String getFacetCode() {
		return facetCode;
	}
	public void setFacetCode(String facetCode) {
		this.facetCode = facetCode;
	}
	public String getFacetName() {
		return facetName;
	}
	public void setFacetName(String facetName) {
		this.facetName = facetName;
	}
	public List<FacetEntryData> getFacetEntries() {
		return facetEntries;
	}
	public void setFacetEntries(List<FacetEntryData> facetEntries) {
		this.facetEntries = facetEntries;
	}
	
	
}
