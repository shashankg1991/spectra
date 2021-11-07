package com.spectra.jewel.data.ws;

import java.util.Collection;

import lombok.Data;

@Data
public class ProductDiamondGradeDetailWsData {
	private Long id;
	private String grade;
	private Collection<ProductDiamondEntryWsData> entries;
}
