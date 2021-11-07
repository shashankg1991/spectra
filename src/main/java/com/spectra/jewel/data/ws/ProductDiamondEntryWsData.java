package com.spectra.jewel.data.ws;

import lombok.Data;

@Data
public class ProductDiamondEntryWsData {
	private Long id;
	private WeightWsData weight;
	private PriceWsData rate;
	private String size;
	private Integer number;
}
