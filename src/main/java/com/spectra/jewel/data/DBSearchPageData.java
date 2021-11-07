package com.spectra.jewel.data;

import java.util.List;

import lombok.Data;

@Data
public class DBSearchPageData<T> {
	List<T> results;
	Long searchId;
	String searchCode;
	String searchText;
	int pageNumber;
	int totalPages;
	long totalResults;
}
