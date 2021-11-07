package com.spectra.jewel.data.ws;

import lombok.Data;

@Data
public class ProductMetalSizeEntryWsData {
	private Long id;
	private WeightWsData weight;
	private String size;
	private String metalPurity;

}
