package com.spectra.jewel.data.ws;

import lombok.Data;

@Data
public class ProductStoneEntryWsData {
	private Long id;
	private WeightWsData weight;
	private PriceWsData rate;
	private String description;

}
