package com.spectra.jewel.data.ws;

import lombok.Data;

@Data
public class PriceWsData {
	private Long id;
	private Double val;
	private String unit;
	private String currency;
}
